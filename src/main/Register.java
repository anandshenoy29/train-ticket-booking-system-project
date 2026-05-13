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

public class Register extends JFrame
{
    String username, otpcode;
    JTextField FirstNameTextField, LastNameTextField, MobileNoLabelTextField, MobileNoTextField, MobileNoOTPTextField, UsernameTextField, PasswordTextField, ConfirmPasswordTextField;
    JButton MobileNoSendOTPButton, MobileNoVerifyButton, SubmitButton, BackButton;

    Register(String username)
    {
        this.username=username;
        setTitle("TrainEase");
        setSize(730,730);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        ImageIcon ImageIcon1 = new ImageIcon("assets/trainease_2.png");
        Image Image1=ImageIcon1.getImage().getScaledInstance(240, 240, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon2=new ImageIcon(Image1);
        JLabel ImageLabel1=new JLabel(ImageIcon2);
        ImageLabel1.setBounds(277, 15, 160, 160);
        add(ImageLabel1);

        JLabel Label1=new JLabel("Create a new TrainEase Account!");
        Label1.setBounds(240, 185, 400, 30);
        Label1.setFont(new Font("Arial", Font.PLAIN, 16));
        Label1.setForeground(Color.BLACK);
        add(Label1);

        JLabel FirstNameLabel=new JLabel("First Name :");
        FirstNameLabel.setBounds(182, 245, 150, 30);
        FirstNameLabel.setFont(new Font("Georgia", Font.PLAIN, 22));
        FirstNameLabel.setForeground(Color.BLACK);
        add(FirstNameLabel);

        FirstNameTextField =new JTextField();
        FirstNameTextField.setBounds(332, 245, 200, 30);
        FirstNameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        FirstNameTextField.setForeground(Color.BLACK);
        add(FirstNameTextField);

        FirstNameTextField.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent ke)
            {
                char c=ke.getKeyChar();
                if(!Character.isAlphabetic(c))
                {
                    ke.consume();
                }
                else if(Character.isAlphabetic(c))
                {
                    String s=FirstNameTextField.getText();
                    if(s.isEmpty())
                    {
                        ke.setKeyChar(Character.toUpperCase(c));
                    }
                    else
                    {
                        ke.setKeyChar(Character.toLowerCase(c));
                    }
                    if(s.length()>15)
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

        FirstNameTextField.addActionListener(_ -> LastNameTextField.requestFocus());

        JLabel LastNameLabel=new JLabel("Last Name :");
        LastNameLabel.setBounds(182, 295, 150, 30);
        LastNameLabel.setFont(new Font("Georgia", Font.PLAIN, 22));
        LastNameLabel.setForeground(Color.BLACK);
        add(LastNameLabel);

        LastNameTextField =new JTextField();
        LastNameTextField.setBounds(332, 295, 200, 30);
        LastNameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        LastNameTextField.setForeground(Color.BLACK);
        add(LastNameTextField);

        LastNameTextField.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent ke)
            {
                char c=ke.getKeyChar();
                if(!Character.isAlphabetic(c))
                {
                    ke.consume();
                }
                else if(Character.isAlphabetic(c))
                {
                    String s=LastNameTextField.getText();
                    if(s.isEmpty())
                    {
                        ke.setKeyChar(Character.toUpperCase(c));
                    }
                    else
                    {
                        ke.setKeyChar(Character.toLowerCase(c));
                    }
                    if(s.length()>15)
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

        LastNameTextField.addActionListener(_ -> MobileNoTextField.requestFocus());

        JLabel MobileNoLabel=new JLabel("Mobile No. :");
        MobileNoLabel.setBounds(182, 345, 150, 30);
        MobileNoLabel.setFont(new Font("Georgia", Font.PLAIN, 22));
        MobileNoLabel.setForeground(Color.BLACK);
        add(MobileNoLabel);

        MobileNoLabelTextField =new JTextField();
        MobileNoLabelTextField.setBounds(332, 345, 34, 30);
        MobileNoLabelTextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        MobileNoLabelTextField.setForeground(Color.BLACK);
        add(MobileNoLabelTextField);
        MobileNoLabelTextField.setText("+91");
        MobileNoLabelTextField.setEditable(false);

        MobileNoTextField =new JTextField();
        MobileNoTextField.setBounds(372, 345, 160, 30);
        MobileNoTextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        MobileNoTextField.setForeground(Color.BLACK);
        add(MobileNoTextField);

        JLabel MobileNoErrorLabel=new JLabel("Invalid Mobile Number!");
        MobileNoErrorLabel.setBounds(332, 380, 200, 30);
        MobileNoErrorLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        MobileNoErrorLabel.setForeground(Color.RED);
        add(MobileNoErrorLabel);
        MobileNoErrorLabel.setVisible(false);

        MobileNoSendOTPButton =new JButton("Send OTP");
        MobileNoSendOTPButton.setBounds(542, 345, 90, 30);
        MobileNoSendOTPButton.setFont(new Font("Georgia", Font.PLAIN,11));
        MobileNoSendOTPButton.setBackground(Color.YELLOW);
        MobileNoSendOTPButton.setForeground(Color.BLACK);
        add(MobileNoSendOTPButton);
        MobileNoSendOTPButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        MobileNoSendOTPButton.setVisible(false);

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
                String s=MobileNoTextField.getText();
                if(s.matches("^[6-9][0-9]{9,}+$"))
                {
                    MobileNoErrorLabel.setVisible(false);
                }
                if(!s.matches("^[6-9][0-9]{9,}+$"))
                {
                    MobileNoErrorLabel.setVisible(true);
                }
                if(s.isEmpty())
                {
                    MobileNoErrorLabel.setVisible(false);
                }
            }
        });

        MobileNoTextField.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent fe)
            {
                MobileNoSendOTPButton.setVisible(true);
                if(!MobileNoTextField.isEditable())
                {
                    MobileNoSendOTPButton.setVisible(false);
                }
            }
            @Override
            public void focusLost(FocusEvent fe)
            {
                String s=MobileNoTextField.getText();
                if(s.isEmpty())
                {
                    MobileNoErrorLabel.setVisible(false);
                }
            }
        });

        MobileNoTextField.addActionListener(_ -> MobileNoSendOTPButton.doClick());

        JLabel MobileNoOTPLabel=new JLabel("Enter OTP :");
        MobileNoOTPLabel.setBounds(332, 380, 100, 30);
        MobileNoOTPLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
        MobileNoOTPLabel.setForeground(Color.BLACK);
        add(MobileNoOTPLabel);
        MobileNoOTPLabel.setVisible(false);

        MobileNoOTPTextField =new JTextField();
        MobileNoOTPTextField.setBounds(432, 380, 100, 30);
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

        MobileNoVerifyButton =new JButton("Verify");
        MobileNoVerifyButton.setBounds(542, 380, 75, 30);
        MobileNoVerifyButton.setFont(new Font("Georgia", Font.PLAIN,11));
        MobileNoVerifyButton.setBackground(Color.GREEN);
        MobileNoVerifyButton.setForeground(Color.BLACK);
        add(MobileNoVerifyButton);
        MobileNoVerifyButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        MobileNoVerifyButton.setVisible(false);

        MobileNoSendOTPButton.addActionListener(_ ->
        {
            String mn=MobileNoTextField.getText();
            if(mn.isEmpty())
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please provide the mobile number!");
                MobileNoTextField.requestFocus();
            }
            else if(MobileNoErrorLabel.isVisible())
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please provide valid mobile number!");
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
                        JOptionPane.showMessageDialog(new JFrame(),"Mobile number already registered with an account!");
                        MobileNoTextField.requestFocus();
                    }
                    else
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
                        MobileNoSendOTPButton.setVisible(false);
                        MobileNoOTPLabel.setVisible(true);
                        MobileNoOTPTextField.setVisible(true);
                        MobileNoVerifyButton.setVisible(true);
                        MobileNoOTPTextField.requestFocus();
                    }
                }
                catch(HeadlessException | SQLException e)
                {
                    System.out.println("Error!");
                }
            }
        });

        MobileNoOTPTextField.addActionListener(_ -> MobileNoVerifyButton.doClick());

        JLabel MobileNoVerifyLabel=new JLabel("Mobile number verified!");
        MobileNoVerifyLabel.setBounds(332, 380, 300, 30);
        MobileNoVerifyLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        MobileNoVerifyLabel.setForeground(new Color(1,48,10));
        add(MobileNoVerifyLabel);
        MobileNoVerifyLabel.setVisible(false);

        MobileNoVerifyButton.addActionListener(_ ->
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
                MobileNoOTPLabel.setVisible(false);
                MobileNoOTPTextField.setVisible(false);
                MobileNoVerifyButton.setVisible(false);
                MobileNoVerifyLabel.setVisible(true);
                UsernameTextField.requestFocus();
            }
            else
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please provide valid OTP!");
                MobileNoOTPTextField.setText("");
                MobileNoOTPTextField.requestFocus();
            }
        });

        JLabel UsernameLabel=new JLabel("Username :");
        UsernameLabel.setBounds(182, 420, 150, 30);
        UsernameLabel.setFont(new Font("Georgia", Font.PLAIN, 22));
        UsernameLabel.setForeground(Color.BLACK);
        add(UsernameLabel);

        UsernameTextField =new JTextField();
        UsernameTextField.setBounds(332, 420, 200, 30);
        UsernameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        UsernameTextField.setForeground(Color.BLACK);
        add(UsernameTextField);

        JLabel UsernameInfoLabel1=new JLabel("Note: Username can consist of");
        UsernameInfoLabel1.setBounds(332, 445, 220, 30);
        UsernameInfoLabel1.setFont(new Font("Arial", Font.PLAIN, 11));
        UsernameInfoLabel1.setForeground(Color.BLACK);
        add(UsernameInfoLabel1);

        JLabel UsernameInfoLabel2=new JLabel("lowercase letters and numbers!");
        UsernameInfoLabel2.setBounds(332, 455, 220, 30);
        UsernameInfoLabel2.setFont(new Font("Arial", Font.PLAIN, 11));
        UsernameInfoLabel2.setForeground(Color.BLACK);
        add(UsernameInfoLabel2);

        JLabel UsernameErrorLabel1=new JLabel("Invalid Username!");
        UsernameErrorLabel1.setBounds(332, 450, 150, 30);
        UsernameErrorLabel1.setFont(new Font("Arial", Font.PLAIN, 16));
        UsernameErrorLabel1.setForeground(Color.RED);
        add(UsernameErrorLabel1);
        UsernameErrorLabel1.setVisible(false);

        JLabel UsernameErrorLabel2=new JLabel("Username must contain at least 8 characters!");
        UsernameErrorLabel2.setBounds(332, 450, 250, 30);
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

        UsernameTextField.addActionListener(_ -> PasswordTextField.requestFocus());

        JLabel PasswordLabel=new JLabel("Password :");
        PasswordLabel.setBounds(182, 480, 150, 30);
        PasswordLabel.setFont(new Font("Georgia", Font.PLAIN, 22));
        PasswordLabel.setForeground(Color.BLACK);
        add(PasswordLabel);

        PasswordTextField =new JTextField();
        PasswordTextField.setBounds(332, 480, 200, 30);
        PasswordTextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        PasswordTextField.setForeground(Color.BLACK);
        add(PasswordTextField);

        JLabel PasswordInfoLabel1=new JLabel("Note: Password should consist of");
        PasswordInfoLabel1.setBounds(332, 505, 220, 30);
        PasswordInfoLabel1.setFont(new Font("Arial", Font.PLAIN, 11));
        PasswordInfoLabel1.setForeground(Color.BLACK);
        add(PasswordInfoLabel1);

        JLabel PasswordInfoLabel2=new JLabel("uppercase and lowercase letters,");
        PasswordInfoLabel2.setBounds(332, 515, 220, 30);
        PasswordInfoLabel2.setFont(new Font("Arial", Font.PLAIN, 11));
        PasswordInfoLabel2.setForeground(Color.BLACK);
        add(PasswordInfoLabel2);

        JLabel PasswordInfoLabel3=new JLabel("numbers and special characters i.e. !@#$_");
        PasswordInfoLabel3.setBounds(332, 525, 220, 30);
        PasswordInfoLabel3.setFont(new Font("Arial", Font.PLAIN, 11));
        PasswordInfoLabel3.setForeground(Color.BLACK);
        add(PasswordInfoLabel3);

        JLabel PasswordErrorLabel1=new JLabel("Invalid Password!");
        PasswordErrorLabel1.setBounds(332, 510, 150, 30);
        PasswordErrorLabel1.setFont(new Font("Arial", Font.PLAIN, 16));
        PasswordErrorLabel1.setForeground(Color.RED);
        add(PasswordErrorLabel1);
        PasswordErrorLabel1.setVisible(false);

        JLabel PasswordErrorLabel2=new JLabel("Password must contain at least 8 characters!");
        PasswordErrorLabel2.setBounds(332, 510, 250, 30);
        PasswordErrorLabel2.setFont(new Font("Arial", Font.PLAIN, 11));
        PasswordErrorLabel2.setForeground(Color.RED);
        add(PasswordErrorLabel2);
        PasswordErrorLabel2.setVisible(false);

        JLabel ConfirmPasswordLabel1=new JLabel("Confirm");
        ConfirmPasswordLabel1.setBounds(182, 520, 150, 30);
        ConfirmPasswordLabel1.setFont(new Font("Georgia", Font.PLAIN, 22));
        ConfirmPasswordLabel1.setForeground(Color.BLACK);
        add(ConfirmPasswordLabel1);

        JLabel ConfirmPasswordLabel2=new JLabel("Password :");
        ConfirmPasswordLabel2.setBounds(182, 550, 150, 30);
        ConfirmPasswordLabel2.setFont(new Font("Georgia", Font.PLAIN, 22));
        ConfirmPasswordLabel2.setForeground(Color.BLACK);
        add(ConfirmPasswordLabel2);

        ConfirmPasswordTextField =new JTextField();
        ConfirmPasswordTextField.setBounds(332, 550, 200, 30);
        ConfirmPasswordTextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        ConfirmPasswordTextField.setForeground(Color.BLACK);
        add(ConfirmPasswordTextField);

        JLabel ConfirmPasswordErrorLabel=new JLabel("Password doesn't match!");
        ConfirmPasswordErrorLabel.setBounds(332, 580, 200, 30);
        ConfirmPasswordErrorLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        ConfirmPasswordErrorLabel.setForeground(Color.RED);
        add(ConfirmPasswordErrorLabel);
        ConfirmPasswordErrorLabel.setVisible(false);

        PasswordTextField.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent ke)
            {
                String s=PasswordTextField.getText();
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
                String s1=PasswordTextField.getText();
                String s2=ConfirmPasswordTextField.getText();
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
                    ConfirmPasswordErrorLabel.setVisible(false);
                }
                if(!s1.equals(s2))
                {
                    ConfirmPasswordErrorLabel.setVisible(true);
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

        PasswordTextField.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent fe)
            {

            }
            @Override
            public void focusLost(FocusEvent fe)
            {
                String s=PasswordTextField.getText();
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

        PasswordTextField.addActionListener(_ -> ConfirmPasswordTextField.requestFocus());

        ConfirmPasswordTextField.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent ke)
            {
                String s=ConfirmPasswordTextField.getText();
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
                String s1=PasswordTextField.getText();
                String s2=ConfirmPasswordTextField.getText();
                if(s2.equals(s1))
                {
                    ConfirmPasswordErrorLabel.setVisible(false);
                }
                if(!s2.equals(s1))
                {
                    ConfirmPasswordErrorLabel.setVisible(true);
                }
                if(s2.isEmpty())
                {
                    ConfirmPasswordErrorLabel.setVisible(false);
                }
            }
        });

        ConfirmPasswordTextField.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent fe)
            {

            }
            @Override
            public void focusLost(FocusEvent fe)
            {
                String s=ConfirmPasswordTextField.getText();
                if(s.isEmpty())
                {
                    ConfirmPasswordErrorLabel.setVisible(false);
                }
            }
        });

        ConfirmPasswordTextField.addActionListener(_ -> SubmitButton.doClick());

        SubmitButton =new JButton("SUBMIT");
        SubmitButton.setBounds(297, 640, 120, 30);
        SubmitButton.setFont(new Font("Georgia", Font.BOLD,15));
        SubmitButton.setBackground(Color.BLUE);
        SubmitButton.setForeground(Color.WHITE);
        add(SubmitButton);
        SubmitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        SubmitButton.addActionListener(_ ->
        {
            String fn= FirstNameTextField.getText();
            String ln= LastNameTextField.getText();
            String mn= MobileNoTextField.getText();
            String un= UsernameTextField.getText();
            String pw= PasswordTextField.getText();
            String cpw= ConfirmPasswordTextField.getText();

            if(fn.isEmpty() || ln.isEmpty() || mn.isEmpty() || un.isEmpty() || pw.isEmpty() || cpw.isEmpty())
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please fill the details!");
            }
            else if(!MobileNoVerifyLabel.isVisible())
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please verify the mobile number!");
            }
            else if(UsernameErrorLabel1.isVisible() || UsernameErrorLabel2.isVisible())
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please provide valid username!");
                UsernameTextField.requestFocus();
            }
            else if(PasswordErrorLabel1.isVisible() || PasswordErrorLabel2.isVisible() || ConfirmPasswordErrorLabel.isVisible())
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please provide valid password!");
            }
            else
            {
                try
                {
                    Database Data=new Database();
                    String Query1="select * from registration where Username='"+un+"'";
                    ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query1);
                    if(Resultset.next())
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

                        String Query2="insert into registration values('"+fn+"','"+ln+"','"+mn+"','"+un+"','"+pw+"','"+dateandtime+"')";
                        Data.DatabaseStatement.executeUpdate(Query2);
                        String n=fn+" "+ln;
                        Random random=new Random();
                        String pin=String.valueOf(random.nextInt(1001,9999));
                        String no=String.valueOf(random.nextInt(10000001,99999999));
                        String amt=String.valueOf(random.nextInt(10000,100000));
                        String bal="INR "+amt+".00";
                        String Query3="insert into account values('"+n+"','"+mn+"','"+pin+"','"+no+"','"+bal+"')";
                        Data.DatabaseStatement.executeUpdate(Query3);
                        JOptionPane.showMessageDialog(new JFrame(),"TrainEase Account created successfully!");

                        String Query4="insert into notification values('"+mn+"','"+dateandtime+"','Welcome to TrainEase! Your account has been successfully created. Start exploring and plan your journeys today! Regards, Team TrainEase.')";
                        Data.DatabaseStatement.executeUpdate(Query4);
                        setVisible(false);
                        new Login(username);
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
        BackButton.setBackground(Color.LIGHT_GRAY);
        BackButton.setForeground(Color.WHITE);
        add(BackButton);
        BackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        BackButton.addActionListener(_ ->
        {
            setVisible(false);
            new Main(username);
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        FirstNameTextField.requestFocusInWindow();
    }

    public static void main(String[] args)
    {
        new Register("");
    }
}
