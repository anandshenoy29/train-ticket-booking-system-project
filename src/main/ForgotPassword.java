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

public class ForgotPassword extends JFrame
{
    String username, mn, otpcode;
    JTextField MobileNoLabelTextField, MobileNoTextField, MobileNoOTPTextField, PasswordTextField1, PasswordTextField2;
    JButton MobileNoRequestOTPButton, MobileNoSubmitButton, ResetButton, BackButton;
    
    ForgotPassword(String username)
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

        JLabel Label1=new JLabel("|| Forgot Password ||");
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

        JLabel PasswordLabel1=new JLabel("New Password :");
        PasswordLabel1.setBounds(53, 245, 200, 30);
        PasswordLabel1.setFont(new Font("Georgia", Font.PLAIN, 22));
        PasswordLabel1.setForeground(Color.WHITE);
        add(PasswordLabel1);
        PasswordLabel1.setVisible(false);

        PasswordTextField1 =new JTextField();
        PasswordTextField1.setBounds(263, 245, 200, 30);
        PasswordTextField1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        PasswordTextField1.setForeground(Color.BLACK);
        add(PasswordTextField1);
        PasswordTextField1.setVisible(false);

        JLabel PasswordInfoLabel1=new JLabel("Note: Password should consist of");
        PasswordInfoLabel1.setBounds(263, 270, 220, 30);
        PasswordInfoLabel1.setFont(new Font("Arial", Font.PLAIN, 11));
        PasswordInfoLabel1.setForeground(Color.WHITE);
        add(PasswordInfoLabel1);
        PasswordInfoLabel1.setVisible(false);

        JLabel PasswordInfoLabel2=new JLabel("uppercase and lowercase letters,");
        PasswordInfoLabel2.setBounds(263, 280, 220, 30);
        PasswordInfoLabel2.setFont(new Font("Arial", Font.PLAIN, 11));
        PasswordInfoLabel2.setForeground(Color.WHITE);
        add(PasswordInfoLabel2);
        PasswordInfoLabel2.setVisible(false);

        JLabel PasswordInfoLabel3=new JLabel("numbers and special characters i.e. !@#$_");
        PasswordInfoLabel3.setBounds(263, 290, 220, 30);
        PasswordInfoLabel3.setFont(new Font("Arial", Font.PLAIN, 11));
        PasswordInfoLabel3.setForeground(Color.WHITE);
        add(PasswordInfoLabel3);
        PasswordInfoLabel3.setVisible(false);

        JLabel PasswordErrorLabel1=new JLabel("Invalid Password!");
        PasswordErrorLabel1.setBounds(263, 275, 150, 30);
        PasswordErrorLabel1.setFont(new Font("Arial", Font.PLAIN, 16));
        PasswordErrorLabel1.setForeground(Color.RED);
        add(PasswordErrorLabel1);
        PasswordErrorLabel1.setVisible(false);

        JLabel PasswordErrorLabel2=new JLabel("Password must contain at least 8 characters!");
        PasswordErrorLabel2.setBounds(263, 275, 250, 30);
        PasswordErrorLabel2.setFont(new Font("Arial", Font.PLAIN, 11));
        PasswordErrorLabel2.setForeground(Color.RED);
        add(PasswordErrorLabel2);
        PasswordErrorLabel2.setVisible(false);

        JLabel PasswordLabel2=new JLabel("Confirm Password :");
        PasswordLabel2.setBounds(53, 315, 200, 30);
        PasswordLabel2.setFont(new Font("Georgia", Font.PLAIN, 22));
        PasswordLabel2.setForeground(Color.WHITE);
        add(PasswordLabel2);
        PasswordLabel2.setVisible(false);

        PasswordTextField2 =new JTextField();
        PasswordTextField2.setBounds(263, 315, 200, 30);
        PasswordTextField2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        PasswordTextField2.setForeground(Color.BLACK);
        add(PasswordTextField2);
        PasswordTextField2.setVisible(false);

        JLabel PasswordErrorLabel3=new JLabel("Password doesn't match!");
        PasswordErrorLabel3.setBounds(263, 345, 200, 30);
        PasswordErrorLabel3.setFont(new Font("Arial", Font.PLAIN, 16));
        PasswordErrorLabel3.setForeground(Color.RED);
        add(PasswordErrorLabel3);
        PasswordErrorLabel3.setVisible(false);

        PasswordTextField1.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent ke)
            {
                String s=PasswordTextField1.getText();
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
                String s1=PasswordTextField1.getText();
                String s2=PasswordTextField2.getText();
                if(s1.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$_])[A-Za-z0-9!@#$_]+$"))
                {
                    PasswordErrorLabel1.setVisible(false);
                    PasswordErrorLabel2.setVisible(false);
                    PasswordInfoLabel1.setVisible(false);
                    PasswordInfoLabel2.setVisible(false);
                    PasswordInfoLabel3.setVisible(false);
                }
                if(!s1.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$_])[A-Za-z0-9!@#$_]+$"))
                {
                    PasswordErrorLabel1.setVisible(true);
                    PasswordErrorLabel2.setVisible(false);
                    PasswordInfoLabel1.setVisible(false);
                    PasswordInfoLabel2.setVisible(false);
                    PasswordInfoLabel3.setVisible(false);
                }
                else if(s1.length() < 8)
                {
                    PasswordErrorLabel1.setVisible(false);
                    PasswordErrorLabel2.setVisible(true);
                    PasswordInfoLabel1.setVisible(false);
                    PasswordInfoLabel2.setVisible(false);
                    PasswordInfoLabel3.setVisible(false);
                }
                if(s1.equals(s2))
                {
                    PasswordErrorLabel3.setVisible(false);
                }
                if(!s1.equals(s2))
                {
                    PasswordErrorLabel3.setVisible(true);
                }
                if(s1.isEmpty())
                {
                    PasswordErrorLabel1.setVisible(false);
                    PasswordErrorLabel2.setVisible(false);
                    PasswordInfoLabel1.setVisible(true);
                    PasswordInfoLabel2.setVisible(true);
                    PasswordInfoLabel3.setVisible(true);
                }
            }
        });

        PasswordTextField1.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent fe)
            {

            }
            @Override
            public void focusLost(FocusEvent fe)
            {
                String s=PasswordTextField1.getText();
                if(s.isEmpty())
                {
                    PasswordErrorLabel1.setVisible(false);
                    PasswordErrorLabel2.setVisible(false);
                    PasswordInfoLabel1.setVisible(true);
                    PasswordInfoLabel2.setVisible(true);
                    PasswordInfoLabel3.setVisible(true);
                }
            }
        });

        PasswordTextField1.addActionListener(_ -> PasswordTextField2.requestFocus());

        PasswordTextField2.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent ke)
            {
                String s=PasswordTextField2.getText();
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
                String s1=PasswordTextField1.getText();
                String s2=PasswordTextField2.getText();
                if(s2.equals(s1))
                {
                    PasswordErrorLabel3.setVisible(false);
                }
                if(!s2.equals(s1))
                {
                    PasswordErrorLabel3.setVisible(true);
                }
                if(s2.isEmpty())
                {
                    PasswordErrorLabel3.setVisible(false);
                }
            }
        });

        PasswordTextField2.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent fe)
            {

            }
            @Override
            public void focusLost(FocusEvent fe)
            {
                String s=PasswordTextField2.getText();
                if(s.isEmpty())
                {
                    PasswordErrorLabel3.setVisible(false);
                }
            }
        });

        PasswordTextField2.addActionListener(_ -> ResetButton.doClick());

        ResetButton =new JButton("Reset");
        ResetButton.setBounds(183, 403, 150, 30);
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
                PasswordLabel1.setVisible(true);
                PasswordTextField1.setVisible(true);
                PasswordInfoLabel1.setVisible(true);
                PasswordInfoLabel2.setVisible(true);
                PasswordInfoLabel3.setVisible(true);
                PasswordLabel2.setVisible(true);
                PasswordTextField2.setVisible(true);
                ResetButton.setVisible(true);
                PasswordTextField1.requestFocus();
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
            String pw1 = PasswordTextField1.getText();
            String pw2 = PasswordTextField2.getText();

            if(pw1.isEmpty() || pw2.isEmpty())
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please provide the new password!");
            }
            else if(PasswordErrorLabel1.isVisible() || PasswordErrorLabel2.isVisible() || PasswordErrorLabel3.isVisible())
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please provide valid password!");
            }
            else
            {
                try
                {
                    Database Data=new Database();
                    String Query1="select Password from registration where MobileNo='"+mn+"'";
                    ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query1);
                    if(Resultset.next())
                    {
                        String pw=Resultset.getString("Password");
                        if(pw1.equals(pw))
                        {
                            JOptionPane.showMessageDialog(new JFrame(), "Provided new password is as same as the previous password!");
                        }
                        else
                        {
                            DateTimeFormatter DateFormat=DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDateTime Date= LocalDateTime.now();
                            DateTimeFormatter TimeFormat=DateTimeFormatter.ofPattern("HH:mm");
                            LocalDateTime Time=LocalDateTime.now();
                            String dateandtime=DateFormat.format(Date)+" "+TimeFormat.format(Time);

                            String Query2 = "update registration set Password='"+pw1+"' where MobileNo='"+mn+"'";
                            Data.DatabaseStatement.executeUpdate(Query2);
                            JOptionPane.showMessageDialog(new JFrame(), "TrainEase Account password resetted successfully!");
                            String Query3="insert into notification values('"+mn+"','"+dateandtime+"','Dear User! You have successfully resetted your account password. If this was not you then please secure your account immediately! Regards, Team TrainEase.')";
                            Data.DatabaseStatement.executeUpdate(Query3);
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
            new Login(username);
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        MobileNoTextField.requestFocusInWindow();
    }

    public static void main(String[] args)
    {
        new ForgotPassword("");
    }
}
