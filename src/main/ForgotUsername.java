import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ForgotUsername extends JFrame
{
    String username, mn, otpcode;
    JTextField MobileNoLabelTextField, MobileNoTextField, MobileNoOTPTextField, UsernameTextField;
    JButton MobileNoRequestOTPButton, MobileNoSubmitButton, ResetButton, BackButton;
    
    ForgotUsername(String username)
    {
        this.username=username;
        setTitle("TrainEase");
        setSize(530,530);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLUE);
        setLayout(null);

        ImageIcon ImageIcon1 = new ImageIcon("assets/trainease_1.png");
        Image Image1=ImageIcon1.getImage().getScaledInstance(240, 240, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon2=new ImageIcon(Image1);
        JLabel ImageLabel1=new JLabel(ImageIcon2);
        ImageLabel1.setBounds(177, 15, 160, 160);
        add(ImageLabel1);

        JLabel Label1=new JLabel("|| Forgot Username ||");
        Label1.setBounds(120, 185, 300, 30);
        Label1.setFont(new Font("Georgia", Font.BOLD, 25));
        Label1.setForeground(Color.YELLOW);
        add(Label1);

        JLabel MobileNoLabel=new JLabel("Enter Mobile No. :");
        MobileNoLabel.setBounds(58, 245, 200, 30);
        MobileNoLabel.setFont(new Font("Georgia", Font.PLAIN, 22));
        MobileNoLabel.setForeground(Color.WHITE);
        add(MobileNoLabel);

        MobileNoLabelTextField =new JTextField();
        MobileNoLabelTextField.setBounds(258, 245, 34, 30);
        MobileNoLabelTextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        MobileNoLabelTextField.setForeground(Color.BLACK);
        add(MobileNoLabelTextField);
        MobileNoLabelTextField.setText("+91");
        MobileNoLabelTextField.setEditable(false);

        MobileNoTextField =new JTextField();
        MobileNoTextField.setBounds(298, 245, 160, 30);
        MobileNoTextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        MobileNoTextField.setForeground(Color.BLACK);
        add(MobileNoTextField);

        MobileNoTextField.addKeyListener(new KeyListener()
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
                    String s=MobileNoTextField.getText();
                    if(s.length()>9)
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

        MobileNoTextField.addActionListener(_ -> MobileNoRequestOTPButton.doClick());

        MobileNoRequestOTPButton =new JButton("Request OTP");
        MobileNoRequestOTPButton.setBounds(183, 315, 150, 30);
        MobileNoRequestOTPButton.setFont(new Font("Georgia", Font.BOLD,15));
        MobileNoRequestOTPButton.setBackground(Color.YELLOW);
        MobileNoRequestOTPButton.setForeground(Color.BLACK);
        add(MobileNoRequestOTPButton);
        MobileNoRequestOTPButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel MobileNoOTPLabel=new JLabel("Enter OTP :");
        MobileNoOTPLabel.setBounds(140, 315, 135, 30);
        MobileNoOTPLabel.setFont(new Font("Georgia", Font.PLAIN, 22));
        MobileNoOTPLabel.setForeground(Color.WHITE);
        add(MobileNoOTPLabel);
        MobileNoOTPLabel.setVisible(false);

        MobileNoOTPTextField =new JTextField();
        MobileNoOTPTextField.setBounds(275, 315, 100, 30);
        MobileNoOTPTextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
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

        MobileNoSubmitButton =new JButton("Submit");
        MobileNoSubmitButton.setBounds(183, 385, 150, 30);
        MobileNoSubmitButton.setFont(new Font("Georgia", Font.BOLD,15));
        MobileNoSubmitButton.setBackground(Color.GREEN);
        MobileNoSubmitButton.setForeground(Color.BLACK);
        add(MobileNoSubmitButton);
        MobileNoSubmitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        MobileNoSubmitButton.setVisible(false);

        MobileNoRequestOTPButton.addActionListener(_ ->
        {
            mn=MobileNoTextField.getText();
            if(mn.isEmpty())
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please provide the registered mobile number!");
                MobileNoTextField.requestFocus();
            }
            else
            {
                try
                {
                    Database Data=new Database();
                    String Query="select * from registration where MobileNo='"+mn+"'";
                    ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query);
                    if(Resultset.next())
                    {
                        Random random=new Random();
                        otpcode=String.valueOf(random.nextInt(1001,9999));
                        try
                        {
                            String Query2="insert into otp values('"+mn+"','"+otpcode+"')";
                            Data.DatabaseStatement.executeUpdate(Query2);
                            JOptionPane.showMessageDialog(new JFrame(),"OTP sent successfully!");
                        }
                        catch(HeadlessException | SQLException e)
                        {
                            System.out.println("Error!");
                        }
                        MobileNoTextField.setEditable(false);
                        MobileNoRequestOTPButton.setVisible(false);
                        MobileNoOTPLabel.setVisible(true);
                        MobileNoOTPTextField.setVisible(true);
                        MobileNoSubmitButton.setVisible(true);
                        MobileNoOTPTextField.requestFocus();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JFrame(),"No account has been registered with this Mobile number!");
                        MobileNoTextField.setText("");
                        MobileNoTextField.requestFocus();
                    }
                }
                catch(HeadlessException | SQLException e)
                {
                    System.out.println("Error!");
                }
            }
        });

        MobileNoOTPTextField.addActionListener(_ -> MobileNoSubmitButton.doClick());

        JLabel UsernameLabel=new JLabel("New Username :");
        UsernameLabel.setBounds(68, 245, 200, 30);
        UsernameLabel.setFont(new Font("Georgia", Font.PLAIN, 22));
        UsernameLabel.setForeground(Color.WHITE);
        add(UsernameLabel);
        UsernameLabel.setVisible(false);

        UsernameTextField =new JTextField();
        UsernameTextField.setBounds(248, 245, 200, 30);
        UsernameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        UsernameTextField.setForeground(Color.BLACK);
        add(UsernameTextField);
        UsernameTextField.setVisible(false);

        JLabel UsernameInfoLabel1=new JLabel("Note: Username can consist of");
        UsernameInfoLabel1.setBounds(248, 270, 220, 30);
        UsernameInfoLabel1.setFont(new Font("Arial", Font.PLAIN, 11));
        UsernameInfoLabel1.setForeground(Color.WHITE);
        add(UsernameInfoLabel1);
        UsernameInfoLabel1.setVisible(false);

        JLabel UsernameInfoLabel2=new JLabel("lowercase letters and numbers!");
        UsernameInfoLabel2.setBounds(248, 280, 220, 30);
        UsernameInfoLabel2.setFont(new Font("Arial", Font.PLAIN, 11));
        UsernameInfoLabel2.setForeground(Color.WHITE);
        add(UsernameInfoLabel2);
        UsernameInfoLabel2.setVisible(false);

        JLabel UsernameErrorLabel1=new JLabel("Invalid Username!");
        UsernameErrorLabel1.setBounds(248, 275, 150, 30);
        UsernameErrorLabel1.setFont(new Font("Arial", Font.PLAIN, 16));
        UsernameErrorLabel1.setForeground(Color.RED);
        add(UsernameErrorLabel1);
        UsernameErrorLabel1.setVisible(false);

        JLabel UsernameErrorLabel2=new JLabel("Username must contain at least 8 characters!");
        UsernameErrorLabel2.setBounds(248, 275, 250, 30);
        UsernameErrorLabel2.setFont(new Font("Arial", Font.PLAIN, 11));
        UsernameErrorLabel2.setForeground(Color.RED);
        add(UsernameErrorLabel2);
        UsernameErrorLabel2.setVisible(false);

        UsernameTextField.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent ke)
            {
                String s=UsernameTextField.getText();
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
                String s=UsernameTextField.getText();
                if(s.matches("^[a-z][a-z0-9]+$"))
                {
                    UsernameErrorLabel1.setVisible(false);
                    UsernameErrorLabel2.setVisible(false);
                    UsernameInfoLabel1.setVisible(false);
                    UsernameInfoLabel2.setVisible(false);
                }
                if(!s.matches("^[a-z][a-z0-9]+$"))
                {
                    UsernameErrorLabel1.setVisible(true);
                    UsernameErrorLabel2.setVisible(false);
                    UsernameInfoLabel1.setVisible(false);
                    UsernameInfoLabel2.setVisible(false);
                }
                else if(s.length() < 8)
                {
                    UsernameErrorLabel1.setVisible(false);
                    UsernameErrorLabel2.setVisible(true);
                    UsernameInfoLabel1.setVisible(false);
                    UsernameInfoLabel2.setVisible(false);
                }
                if(s.isEmpty())
                {
                    UsernameErrorLabel1.setVisible(false);
                    UsernameErrorLabel2.setVisible(false);
                    UsernameInfoLabel1.setVisible(true);
                    UsernameInfoLabel2.setVisible(true);
                }
            }
        });

        UsernameTextField.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent fe)
            {

            }
            @Override
            public void focusLost(FocusEvent fe)
            {
                String s=UsernameTextField.getText();
                if(s.isEmpty())
                {
                    UsernameErrorLabel1.setVisible(false);
                    UsernameErrorLabel2.setVisible(false);
                    UsernameInfoLabel1.setVisible(true);
                    UsernameInfoLabel2.setVisible(true);
                }
            }
        });

        UsernameTextField.addActionListener(_ -> ResetButton.doClick());

        ResetButton =new JButton("Reset");
        ResetButton.setBounds(183, 315, 150, 30);
        ResetButton.setFont(new Font("Georgia", Font.BOLD,15));
        ResetButton.setBackground(Color.MAGENTA);
        ResetButton.setForeground(Color.BLACK);
        add(ResetButton);
        ResetButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ResetButton.setVisible(false);

        MobileNoSubmitButton.addActionListener(_ ->
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
                MobileNoLabel.setVisible(false);
                MobileNoLabelTextField.setVisible(false);
                MobileNoTextField.setVisible(false);
                MobileNoOTPLabel.setVisible(false);
                MobileNoOTPTextField.setVisible(false);
                MobileNoSubmitButton.setVisible(false);
                UsernameLabel.setVisible(true);
                UsernameTextField.setVisible(true);
                UsernameInfoLabel1.setVisible(true);
                UsernameInfoLabel2.setVisible(true);
                ResetButton.setVisible(true);
                UsernameTextField.requestFocus();
            }
            else
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please provide valid OTP!");
                MobileNoOTPTextField.setText("");
                MobileNoOTPTextField.requestFocus();
            }
        });

        ResetButton.addActionListener(_ ->
        {
            String un = UsernameTextField.getText();

            if(un.isEmpty())
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please provide the new username!");
                UsernameTextField.requestFocus();
            }
            else if(UsernameErrorLabel1.isVisible() || UsernameErrorLabel2.isVisible())
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please provide valid username!");
                UsernameTextField.requestFocus();
            }
            else
            {
                try
                {
                    Database Data=new Database();
                    String Query1="select Username from registration where MobileNo='"+mn+"'";
                    ResultSet ResultSet1=Data.DatabaseStatement.executeQuery(Query1);
                    if(ResultSet1.next())
                    {
                        String u=ResultSet1.getString("Username");
                        String Query2="select * from registration where Username='"+un+"'";
                        ResultSet ResultSet2=Data.DatabaseStatement.executeQuery(Query2);
                        if(un.equals(u))
                        {
                            JOptionPane.showMessageDialog(new JFrame(), "Provided new username is as same as the previous username!");
                            UsernameTextField.requestFocus();
                        }
                        else if(ResultSet2.next())
                        {
                            JOptionPane.showMessageDialog(new JFrame(),"Username already exists!");
                            UsernameTextField.requestFocus();
                        }
                        else
                        {
                            DateTimeFormatter DateFormat=DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDateTime Date= LocalDateTime.now();
                            DateTimeFormatter TimeFormat=DateTimeFormatter.ofPattern("HH:mm");
                            LocalDateTime Time=LocalDateTime.now();
                            String dateandtime=DateFormat.format(Date)+" "+TimeFormat.format(Time);

                            String Query3 = "update registration set Username='"+un+"' where MobileNo='"+mn+"'";
                            Data.DatabaseStatement.executeUpdate(Query3);
                            String Query4 = "update bookings set Username='"+un+"' where Username='"+u+"'";
                            Data.DatabaseStatement.executeUpdate(Query4);
                            String Query5 = "update feedbacks set Username='"+un+"' where Username='"+u+"'";
                            Data.DatabaseStatement.executeUpdate(Query5);
                            String Query6 = "update warnings set Username='"+un+"' where Username='"+u+"'";
                            Data.DatabaseStatement.executeUpdate(Query6);
                            JOptionPane.showMessageDialog(new JFrame(), "TrainEase Account username resetted successfully!");
                            String Query7="insert into notification values('"+mn+"','"+dateandtime+"','Dear User! You have successfully resetted your account username. If this was not you then please secure your account immediately! Regards, Team TrainEase.')";
                            Data.DatabaseStatement.executeUpdate(Query7);
                            setVisible(false);
                            new Login(username);
                        }
                    }
                }
                catch(HeadlessException | SQLException e)
                {
                    System.out.println("Error!");
                }
            }
        });

        ImageIcon ImageIcon3 = new ImageIcon("assets/back.png");
        Image Image2=ImageIcon3.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon4=new ImageIcon(Image2);

        BackButton = new JButton(ImageIcon4);
        BackButton.setBounds(5, 5, 60, 40);
        BackButton.setFont(new Font("Georgia", Font.BOLD,20));
        BackButton.setBackground(Color.BLUE);
        BackButton.setForeground(Color.WHITE);
        add(BackButton);
        BackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        BackButton.addActionListener(_ ->
        {
            setVisible(false);
            new Login(username);
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        MobileNoTextField.requestFocusInWindow();
    }

    public static void main(String[] args)
    {
        new ForgotUsername("");
    }
}
