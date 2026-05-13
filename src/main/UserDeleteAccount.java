import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UserDeleteAccount extends JFrame
{
    String username, pw, mobilenumber, mn, otpcode;
    JPasswordField PasswordTextField;
    JComboBox<String> ReasonComboBox;
    JTextField MobileNoOTPTextField;
    JButton ProceedButton,SubmitButton,DeleteButton,BackButton;

    UserDeleteAccount(String username)
    {
        this.username=username;
        setTitle("TrainEase");
        setSize(1245,730);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLUE);
        setLayout(null);

        ImageIcon ImageIcon1 = new ImageIcon("assets/trainease_1.png");
        Image Image1=ImageIcon1.getImage().getScaledInstance(240, 240, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon2=new ImageIcon(Image1);
        JLabel ImageLabel1=new JLabel(ImageIcon2);
        ImageLabel1.setBounds(535, 15, 160, 160);
        add(ImageLabel1);

        JLabel Label1=new JLabel("|| TrainEase Account Deletion ||");
        Label1.setBounds(327, 190, 700, 50);
        Label1.setFont(new Font("Georgia", Font.BOLD, 35));
        Label1.setForeground(Color.YELLOW);
        add(Label1);

        JLabel PasswordLabel=new JLabel("Enter Password :");
        PasswordLabel.setBounds(380, 300, 270, 30);
        PasswordLabel.setFont(new Font("Georgia", Font.PLAIN, 32));
        PasswordLabel.setForeground(Color.WHITE);
        add(PasswordLabel);

        PasswordTextField =new JPasswordField();
        PasswordTextField.setBounds(650, 300, 200, 30);
        PasswordTextField.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        PasswordTextField.setForeground(Color.BLACK);
        add(PasswordTextField);

        PasswordTextField.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent ke)
            {
                char[] c = PasswordTextField.getPassword();
                String s = new String(c);
                char key=ke.getKeyChar();
                String allowedcharacters="abcdefghijklmnopqrstuvwxyzABCDEFGIJKLMNOPQRSTUVWXYZ0123456789!@#$_";
                if(allowedcharacters.indexOf(key) == -1)
                {
                    ke.consume();
                }
                if(s.length()>15)
                {
                    ke.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent ke)
            {

            }
            @Override
            public void keyReleased(KeyEvent ke)
            {

            }
        });

        PasswordTextField.addActionListener(_ -> ProceedButton.doClick());

        ProceedButton=new JButton("Proceed");
        ProceedButton.setBounds(553, 400, 125, 40);
        ProceedButton.setFont(new Font("Georgia", Font.BOLD,20));
        ProceedButton.setBackground(Color.GREEN);
        ProceedButton.setForeground(Color.BLACK);
        add(ProceedButton);
        ProceedButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel Label2=new JLabel("( OTP has been sent on your mobile no. +91");
        Label2.setBounds(308, 350, 450, 30);
        Label2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        Label2.setForeground(Color.WHITE);
        add(Label2);
        Label2.setVisible(false);

        JLabel Label3=new JLabel();
        Label3.setBounds(758, 350, 450, 30);
        Label3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        Label3.setForeground(Color.WHITE);
        add(Label3);
        Label3.setVisible(false);

        JLabel MobileNoOTPLabel=new JLabel("Enter OTP :");
        MobileNoOTPLabel.setBounds(465, 400, 180, 30);
        MobileNoOTPLabel.setFont(new Font("Georgia", Font.PLAIN, 32));
        MobileNoOTPLabel.setForeground(Color.WHITE);
        add(MobileNoOTPLabel);
        MobileNoOTPLabel.setVisible(false);

        MobileNoOTPTextField =new JTextField();
        MobileNoOTPTextField.setBounds(665, 400, 100, 30);
        MobileNoOTPTextField.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        MobileNoOTPTextField.setForeground(Color.BLACK);
        add(MobileNoOTPTextField);
        MobileNoOTPTextField.setVisible(false);

        MobileNoOTPTextField.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent ke)
            {
                char c=ke.getKeyChar();
                if(!Character.isDigit(c))
                {
                    ke.consume();
                }
                else if(Character.isDigit(c))
                {
                    String s=MobileNoOTPTextField.getText();
                    if(s.length()>3)
                    {
                        ke.consume();
                    }
                }
            }
            @Override
            public void keyPressed(KeyEvent ke)
            {

            }
            @Override
            public void keyReleased(KeyEvent ke)
            {

            }
        });

        SubmitButton=new JButton("Submit");
        SubmitButton.setBounds(553, 470, 125, 40);
        SubmitButton.setFont(new Font("Georgia", Font.BOLD,20));
        SubmitButton.setBackground(Color.ORANGE);
        SubmitButton.setForeground(Color.BLACK);
        add(SubmitButton);
        SubmitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        SubmitButton.setVisible(false);

        ProceedButton.addActionListener(_ ->
        {
            char[] c = PasswordTextField.getPassword();
            pw = new String(c);

            if(pw.isEmpty())
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please provide the password!");
                PasswordTextField.requestFocus();
            }
            else
            {
                try
                {
                    Database Data=new Database();
                    String Query="select * from registration where Username='"+username+"' and Password='"+pw+"'";
                    ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query);
                    if(Resultset.next())
                    {
                        mobilenumber=Resultset.getString("MobileNo");
                        mn=mobilenumber.substring(0,5);
                        Label3.setText(mn+"XXXXX )");
                        Random random=new Random();
                        otpcode=String.valueOf(random.nextInt(1001,9999));
                        try
                        {
                            String Query2="insert into otp values('"+mobilenumber+"','"+otpcode+"')";
                            Data.DatabaseStatement.executeUpdate(Query2);
                        }
                        catch(SQLException e)
                        {
                            System.out.println("Error!");
                        }
                        PasswordTextField.setEditable(false);
                        ProceedButton.setVisible(false);
                        Label2.setVisible(true);
                        Label3.setVisible(true);
                        MobileNoOTPLabel.setVisible(true);
                        MobileNoOTPTextField.setVisible(true);
                        SubmitButton.setVisible(true);
                        MobileNoOTPTextField.requestFocus();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JFrame(),"Please provide correct password!");
                        PasswordTextField.setText("");
                        PasswordTextField.requestFocus();
                    }
                }
                catch(HeadlessException | SQLException e)
                {
                    System.out.println("Error!");
                }
            }
        });

        MobileNoOTPTextField.addActionListener(_ -> SubmitButton.doClick());

        JLabel Label4=new JLabel("We're sorry to see you go!");
        Label4.setBounds(390, 276, 450, 64);
        Label4.setFont(new Font("Georgia", Font.PLAIN, 32));
        Label4.setForeground(Color.WHITE);
        Label4.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
        Label4.setVerticalAlignment(SwingConstants.CENTER);
        Label4.setHorizontalAlignment(SwingConstants.CENTER);
        add(Label4);
        Label4.setVisible(false);

        JLabel ReasonLabel=new JLabel("Leave a reason behind deleting :");
        ReasonLabel.setBounds(150, 385, 480, 40);
        ReasonLabel.setFont(new Font("Georgia", Font.PLAIN, 32));
        ReasonLabel.setForeground(Color.WHITE);
        add(ReasonLabel);
        ReasonLabel.setVisible(false);

        String[] ReasonComboBoxElements={
                "I faced some issues while booking tickets",
                "I no longer needed this account",
                "I have switched to another platform",
                "I faced some other issues"
        };

        ReasonComboBox=new JComboBox<>(ReasonComboBoxElements);
        ReasonComboBox.setBounds(630, 387, 450, 40);
        ReasonComboBox.setFont(new Font("Times New Roman", Font.BOLD, 24));
        ReasonComboBox.setForeground(Color.BLACK);
        add(ReasonComboBox);
        ReasonComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ReasonComboBox.setVisible(false);

        DeleteButton=new JButton("Delete Account");
        DeleteButton.setBounds(515, 465, 200, 40);
        DeleteButton.setFont(new Font("Georgia", Font.BOLD,20));
        DeleteButton.setBackground(Color.RED);
        DeleteButton.setForeground(Color.WHITE);
        add(DeleteButton);
        DeleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        DeleteButton.setVisible(false);

        JTextArea TextArea1=new JTextArea();
        TextArea1.setBounds(265, 535, 700, 150);
        TextArea1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        TextArea1.setBackground(Color.LIGHT_GRAY);
        TextArea1.setForeground(Color.BLACK);
        TextArea1.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
        TextArea1.setLineWrap(true);
        TextArea1.setWrapStyleWord(true);
        TextArea1.append("\t               ---------- Disclaimer ----------");
        TextArea1.append("\n\n Deleting the Account is PERMANENT and there is no way to recover it!\n So, please reconsider before proceeding. Thank You for using our service.\n Regards, Team TrainEase.");
        add(TextArea1);
        TextArea1.setEditable(false);
        TextArea1.setVisible(false);

        SubmitButton.addActionListener(_ ->
        {
            String otp=MobileNoOTPTextField.getText();
            if(otp.isEmpty())
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please provide the OTP!");
                MobileNoOTPTextField.requestFocus();
            }
            else if(Objects.equals(otp, otpcode))
            {
                try
                {
                    Database Data=new Database();
                    String Query="truncate table otp";
                    Data.DatabaseStatement.executeUpdate(Query);
                }
                catch(SQLException e)
                {
                    System.out.println("Error!");
                }
                PasswordLabel.setVisible(false);
                PasswordTextField.setVisible(false);
                ProceedButton.setVisible(false);
                Label2.setVisible(false);
                Label3.setVisible(false);
                MobileNoOTPLabel.setVisible(false);
                MobileNoOTPTextField.setVisible(false);
                SubmitButton.setVisible(false);
                Label4.setVisible(true);
                ReasonLabel.setVisible(true);
                ReasonComboBox.setVisible(true);
                DeleteButton.setVisible(true);
                TextArea1.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please provide valid OTP!");
                MobileNoOTPTextField.setText("");
                MobileNoOTPTextField.requestFocus();
            }
        });

        DeleteButton.addActionListener(_ ->
        {
            String s4=(String) ReasonComboBox.getSelectedItem();
            try
            {
                Database Data=new Database();
                String Query="select * from registration where Username='"+username+"'";
                ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query);
                if(Resultset.next())
                {
                    String s1 = Resultset.getString("FirstName");
                    String s2 = Resultset.getString("LastName");
                    String s3 = Resultset.getString("MobileNo");
                    try
                    {
                        DateTimeFormatter DateFormat=DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDateTime Date= LocalDateTime.now();
                        DateTimeFormatter TimeFormat=DateTimeFormatter.ofPattern("HH:mm");
                        LocalDateTime Time=LocalDateTime.now();
                        String dateandtime=DateFormat.format(Date)+" "+TimeFormat.format(Time);

                        String Query1 = "insert into deactivation values('"+s1+"','"+s2+"','"+s3+"','"+username+"','"+s4+"','"+dateandtime+"')";
                        Data.DatabaseStatement.executeUpdate(Query1);
                        String Query2 = "delete from registration where Username='"+username+"'";
                        Data.DatabaseStatement.executeUpdate(Query2);
                        String Query3 = "delete from account where UPI_No='"+s3+"'";
                        Data.DatabaseStatement.executeUpdate(Query3);
                        String Query4 = "delete from bookings where Username='"+username+"'";
                        Data.DatabaseStatement.executeUpdate(Query4);
                        String Query5 = "delete from feedbacks where Username='"+username+"'";
                        Data.DatabaseStatement.executeUpdate(Query5);
                        String Query6 = "delete from warnings where Username='"+username+"'";
                        Data.DatabaseStatement.executeUpdate(Query6);
                        String Query7="insert into notification values('"+s3+"','"+dateandtime+"','Dear User! We are sorry to see you go! Your account has been successfully deleted. Regards, Team TrainEase.')";
                        Data.DatabaseStatement.executeUpdate(Query7);
                        JOptionPane.showMessageDialog(new JFrame(), "TrainEase Account deleted successfully!");
                        String Query8 = "delete from notification where Mobile_No='"+s3+"'";
                        Data.DatabaseStatement.executeUpdate(Query8);
                        setVisible(false);
                        new Main(username);
                    }
                    catch(HeadlessException | SQLException e)
                    {
                        System.out.println("Error!");
                    }
                }
            }
            catch(SQLException e)
            {
                System.out.println("Error!");
            }
        });

        ImageIcon ImageIcon3 = new ImageIcon("assets/back.png");
        Image Image2=ImageIcon3.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon4=new ImageIcon(Image2);

        BackButton =new JButton(ImageIcon4);
        BackButton.setBounds(5, 5, 60, 40);
        BackButton.setFont(new Font("Georgia", Font.BOLD,20));
        BackButton.setBackground(Color.BLUE);
        BackButton.setForeground(Color.WHITE);
        add(BackButton);
        BackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        BackButton.addActionListener(_ ->
        {
            setVisible(false);
            new UserSupport(username);
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        PasswordTextField.requestFocusInWindow();
    }

    public static void main(String[] args)
    {
        new UserDeleteAccount("");
    }
}
