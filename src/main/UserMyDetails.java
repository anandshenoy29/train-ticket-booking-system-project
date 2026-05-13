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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UserMyDetails extends JFrame
{
    String username, fn, ln, mn, un, otpcode;
    JTextField FirstNameTextField, LastNameTextField, MobileNoTextField1, MobileNoTextField2, MobileNoOTPTextField, UsernameTextField;
    JButton MobileNoSendOTPButton, MobileNoVerifyButton, EditButton, SaveButton, BackButton;

    UserMyDetails(String username)
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

        JLabel Label1=new JLabel("|| TrainEase Account Information ||");
        Label1.setBounds(292, 180, 700, 50);
        Label1.setFont(new Font("Georgia", Font.BOLD, 35));
        Label1.setForeground(Color.YELLOW);
        add(Label1);

        JLabel Label2=new JLabel();
        Label2.setBounds(285, 260, 660, 350);
        Label2.setFont(new Font("Georgia", Font.BOLD, 35));
        Label2.setForeground(Color.YELLOW);
        Label2.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
        add(Label2);

        JLabel FirstNameLabel1=new JLabel("First Name   :");
        FirstNameLabel1.setBounds(375, 290, 250, 48);
        FirstNameLabel1.setFont(new Font("Georgia", Font.PLAIN, 32));
        FirstNameLabel1.setForeground(Color.WHITE);
        add(FirstNameLabel1);

        JLabel FirstNameLabel2=new JLabel();
        FirstNameLabel2.setBounds(600, 290, 320, 48);
        FirstNameLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        FirstNameLabel2.setForeground(Color.CYAN);
        add(FirstNameLabel2);

        FirstNameTextField =new JTextField();
        FirstNameTextField.setBounds(600, 290, 320, 48);
        FirstNameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        FirstNameTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        FirstNameTextField.setBackground(Color.BLUE);
        FirstNameTextField.setForeground(Color.CYAN);
        add(FirstNameTextField);
        FirstNameTextField.setVisible(false);

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

        JLabel LastNameLabel1=new JLabel("Last Name    :");
        LastNameLabel1.setBounds(375, 340, 250, 48);
        LastNameLabel1.setFont(new Font("Georgia", Font.PLAIN, 32));
        LastNameLabel1.setForeground(Color.WHITE);
        add(LastNameLabel1);

        JLabel LastNameLabel2=new JLabel();
        LastNameLabel2.setBounds(600, 340, 320, 48);
        LastNameLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        LastNameLabel2.setForeground(Color.CYAN);
        add(LastNameLabel2);

        LastNameTextField =new JTextField();
        LastNameTextField.setBounds(600, 340, 320, 48);
        LastNameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        LastNameTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        LastNameTextField.setBackground(Color.BLUE);
        LastNameTextField.setForeground(Color.CYAN);
        add(LastNameTextField);
        LastNameTextField.setVisible(false);

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

        LastNameTextField.addActionListener(_ -> MobileNoTextField2.requestFocus());

        JLabel MobileNoLabel1=new JLabel("Mobile no.    :");
        MobileNoLabel1.setBounds(375, 390, 250, 48);
        MobileNoLabel1.setFont(new Font("Georgia", Font.PLAIN, 32));
        MobileNoLabel1.setForeground(Color.WHITE);
        add(MobileNoLabel1);

        JLabel MobileNoLabel2=new JLabel("+91");
        MobileNoLabel2.setBounds(600, 390, 54, 48);
        MobileNoLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        MobileNoLabel2.setForeground(Color.CYAN);
        add(MobileNoLabel2);

        JLabel MobileNoLabel3=new JLabel();
        MobileNoLabel3.setBounds(660, 390, 260, 48);
        MobileNoLabel3.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        MobileNoLabel3.setForeground(Color.CYAN);
        add(MobileNoLabel3);

        MobileNoTextField1 =new JTextField("+91");
        MobileNoTextField1.setBounds(600, 390, 56, 48);
        MobileNoTextField1.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        MobileNoTextField1.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        MobileNoTextField1.setBackground(Color.BLUE);
        MobileNoTextField1.setForeground(Color.CYAN);
        add(MobileNoTextField1);
        MobileNoTextField1.setEditable(false);
        MobileNoTextField1.setVisible(false);

        MobileNoTextField2 =new JTextField();
        MobileNoTextField2.setBounds(660, 390, 167, 48);
        MobileNoTextField2.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        MobileNoTextField2.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        MobileNoTextField2.setBackground(Color.BLUE);
        MobileNoTextField2.setForeground(Color.CYAN);
        add(MobileNoTextField2);
        MobileNoTextField2.setVisible(false);

        JLabel MobileNoErrorLabel=new JLabel("Invalid Mobile Number!");
        MobileNoErrorLabel.setBounds(600, 440, 300, 38);
        MobileNoErrorLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        MobileNoErrorLabel.setForeground(Color.RED);
        add(MobileNoErrorLabel);
        MobileNoErrorLabel.setVisible(false);

        JLabel MobileNoVerifyLabel=new JLabel("Please verify the mobile number!");
        MobileNoVerifyLabel.setBounds(600, 440, 320, 38);
        MobileNoVerifyLabel.setFont(new Font("Arial", Font.PLAIN, 21));
        MobileNoVerifyLabel.setForeground(Color.YELLOW);
        add(MobileNoVerifyLabel);
        MobileNoVerifyLabel.setVisible(false);

        MobileNoSendOTPButton =new JButton("Send OTP");
        MobileNoSendOTPButton.setBounds(831, 397, 89, 32);
        MobileNoSendOTPButton.setFont(new Font("Georgia", Font.PLAIN,11));
        MobileNoSendOTPButton.setBackground(Color.YELLOW);
        MobileNoSendOTPButton.setForeground(Color.BLACK);
        add(MobileNoSendOTPButton);
        MobileNoSendOTPButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        MobileNoSendOTPButton.setVisible(false);

        MobileNoTextField2.addKeyListener(new KeyListener()
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
                    String s=MobileNoTextField2.getText();
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
                String s=MobileNoTextField2.getText();
                if(s.matches("^[6-9][0-9]{9,}+$"))
                {
                    MobileNoErrorLabel.setVisible(false);
                    if(s.equals(mn))
                    {
                        MobileNoSendOTPButton.setVisible(false);
                        MobileNoVerifyLabel.setVisible(false);
                    }
                    if(!s.equals(mn))
                    {
                        MobileNoSendOTPButton.setVisible(true);
                        MobileNoVerifyLabel.setVisible(true);
                        MobileNoTextField2.addActionListener(_ -> MobileNoSendOTPButton.doClick());
                        if(!MobileNoTextField2.isEditable())
                        {
                            MobileNoSendOTPButton.setVisible(false);
                            MobileNoVerifyLabel.setVisible(false);
                        }
                    }
                }
                if(!s.matches("^[6-9][0-9]{9,}+$"))
                {
                    MobileNoErrorLabel.setVisible(true);
                    MobileNoSendOTPButton.setVisible(false);
                    MobileNoVerifyLabel.setVisible(false);
                    MobileNoTextField2.addActionListener(_ -> UsernameTextField.requestFocus());
                }
                if(s.isEmpty())
                {
                    MobileNoErrorLabel.setVisible(false);
                }
            }
        });

        MobileNoTextField2.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent fe)
            {

            }
            @Override
            public void focusLost(FocusEvent fe)
            {
                String s=MobileNoTextField2.getText();
                if(s.isEmpty())
                {
                    MobileNoErrorLabel.setVisible(false);
                }
            }
        });

        MobileNoTextField2.addActionListener(_ -> UsernameTextField.requestFocus());

        JLabel MobileNoOTPLabel=new JLabel("Enter OTP :");
        MobileNoOTPLabel.setBounds(600, 440, 130, 38);
        MobileNoOTPLabel.setFont(new Font("Georgia", Font.PLAIN, 22));
        MobileNoOTPLabel.setForeground(Color.WHITE);
        add(MobileNoOTPLabel);
        MobileNoOTPLabel.setVisible(false);

        MobileNoOTPTextField =new JTextField();
        MobileNoOTPTextField.setBounds(730, 440, 97, 38);
        MobileNoOTPTextField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        MobileNoOTPTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        MobileNoOTPTextField.setBackground(Color.BLUE);
        MobileNoOTPTextField.setForeground(Color.CYAN);
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

        MobileNoOTPTextField.addActionListener(_ -> MobileNoVerifyButton.doClick());

        MobileNoVerifyButton =new JButton("Verify");
        MobileNoVerifyButton.setBounds(839, 445, 71, 28);
        MobileNoVerifyButton.setFont(new Font("Georgia", Font.PLAIN,11));
        MobileNoVerifyButton.setBackground(Color.GREEN);
        MobileNoVerifyButton.setForeground(Color.BLACK);
        add(MobileNoVerifyButton);
        MobileNoVerifyButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        MobileNoVerifyButton.setVisible(false);

        MobileNoSendOTPButton.addActionListener(_ ->
        {
            String s=MobileNoTextField2.getText();
            try
            {
                Database Data=new Database();
                String Query="select * from registration where MobileNo='"+s+"'";
                ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query);
                if(Resultset.next())
                {
                    JOptionPane.showMessageDialog(new JFrame(),"Mobile number already registered with an account!");
                    MobileNoTextField2.requestFocus();
                }
                else
                {
                    Random random=new Random();
                    otpcode=String.valueOf(random.nextInt(1001,9999));
                    try
                    {
                        String Query2="insert into otp values('"+s+"','"+otpcode+"')";
                        Data.DatabaseStatement.executeUpdate(Query2);
                        JOptionPane.showMessageDialog(new JFrame(),"OTP sent successfully!");
                    }
                    catch(HeadlessException | SQLException e)
                    {
                        System.out.println("Error!");
                    }
                    MobileNoTextField2.setEditable(false);
                    MobileNoSendOTPButton.setVisible(false);
                    MobileNoVerifyLabel.setVisible(false);
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
        });

        JLabel MobileNoVerifiedLabel=new JLabel("Mobile number verified!");
        MobileNoVerifiedLabel.setBounds(600, 440, 300, 30);
        MobileNoVerifiedLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        MobileNoVerifiedLabel.setForeground(Color.GREEN);
        add(MobileNoVerifiedLabel);
        MobileNoVerifiedLabel.setVisible(false);

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
                MobileNoVerifiedLabel.setVisible(true);
                UsernameTextField.requestFocus();
            }
            else
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please provide valid OTP!");
                MobileNoOTPTextField.setText("");
                MobileNoOTPTextField.requestFocus();
            }
        });

        JLabel UsernameLabel1=new JLabel("Username     :");
        UsernameLabel1.setBounds(375, 440, 250, 48);
        UsernameLabel1.setFont(new Font("Georgia", Font.PLAIN, 32));
        UsernameLabel1.setForeground(Color.WHITE);
        add(UsernameLabel1);

        JLabel UsernameLabel2=new JLabel();
        UsernameLabel2.setBounds(600, 440, 320, 50);
        UsernameLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        UsernameLabel2.setForeground(Color.CYAN);
        add(UsernameLabel2);

        UsernameTextField =new JTextField();
        UsernameTextField.setBounds(600, 490, 320, 48);
        UsernameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        UsernameTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        UsernameTextField.setBackground(Color.BLUE);
        UsernameTextField.setForeground(Color.CYAN);
        add(UsernameTextField);
        UsernameTextField.setVisible(false);

        JLabel UsernameInfoLabel1=new JLabel("Note: Username can consist of");
        UsernameInfoLabel1.setBounds(600, 535, 220, 30);
        UsernameInfoLabel1.setFont(new Font("Arial", Font.PLAIN, 16));
        UsernameInfoLabel1.setForeground(Color.WHITE);
        add(UsernameInfoLabel1);
        UsernameInfoLabel1.setVisible(false);

        JLabel UsernameInfoLabel2=new JLabel("lowercase letters and numbers!");
        UsernameInfoLabel2.setBounds(600, 555, 225, 30);
        UsernameInfoLabel2.setFont(new Font("Arial", Font.PLAIN, 16));
        UsernameInfoLabel2.setForeground(Color.WHITE);
        add(UsernameInfoLabel2);
        UsernameInfoLabel2.setVisible(false);

        JLabel UsernameErrorLabel1=new JLabel("Invalid Username!");
        UsernameErrorLabel1.setBounds(600, 540, 300, 38);
        UsernameErrorLabel1.setFont(new Font("Arial", Font.PLAIN, 22));
        UsernameErrorLabel1.setForeground(Color.RED);
        add(UsernameErrorLabel1);
        UsernameErrorLabel1.setVisible(false);

        JLabel UsernameErrorLabel2=new JLabel("Username must contain at least 8 characters!");
        UsernameErrorLabel2.setBounds(600, 540, 500, 38);
        UsernameErrorLabel2.setFont(new Font("Arial", Font.PLAIN, 16));
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
                    if(s.equals(un))
                    {
                        UsernameInfoLabel1.setVisible(false);
                        UsernameInfoLabel2.setVisible(false);
                    }
                    if(!s.equals(un))
                    {
                        UsernameInfoLabel1.setVisible(true);
                        UsernameInfoLabel2.setVisible(true);
                    }
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

        UsernameTextField.addActionListener(_ -> SaveButton.doClick());

        try
        {
            Database Data=new Database();
            String Query1="select * from registration where Username='"+username+"'";
            ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query1);
            Resultset.next();
            fn=Resultset.getString("FirstName");
            ln=Resultset.getString("LastName");
            mn=Resultset.getString("MobileNo");
            un=Resultset.getString("Username");

            FirstNameLabel2.setText(fn);
            FirstNameTextField.setText(fn);
            LastNameLabel2.setText(ln);
            LastNameTextField.setText(ln);
            MobileNoLabel3.setText(mn);
            MobileNoTextField2.setText(mn);
            UsernameLabel2.setText(un);
            UsernameTextField.setText(un);

            if(mn.matches("^[6-9][0-9]{9,}+$"))
            {
                MobileNoErrorLabel.setVisible(false);
                MobileNoSendOTPButton.setVisible(false);
                MobileNoVerifyLabel.setVisible(false);
            }
            if(un.matches("^[a-z][a-z0-9]+$"))
            {
                UsernameErrorLabel1.setVisible(false);
                UsernameErrorLabel2.setVisible(false);
                UsernameInfoLabel1.setVisible(false);
                UsernameInfoLabel2.setVisible(false);
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error!");
        }

        ImageIcon ImageIcon3 = new ImageIcon("assets/edit.png");
        Image Image2=ImageIcon3.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon4=new ImageIcon(Image2);

        EditButton =new JButton(ImageIcon4);
        EditButton.setBounds(587, 620, 60, 60);
        EditButton.setFont(new Font("Georgia", Font.BOLD,20));
        EditButton.setBackground(Color.BLUE);
        EditButton.setForeground(Color.WHITE);
        EditButton.setOpaque(false);
        EditButton.setBorderPainted(false);
        add(EditButton);
        EditButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        ImageIcon ImageIcon5 = new ImageIcon("assets/save.png");
        Image Image3=ImageIcon5.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon6=new ImageIcon(Image3);

        SaveButton =new JButton(ImageIcon6);
        SaveButton.setBounds(587, 620, 60, 60);
        SaveButton.setFont(new Font("Georgia", Font.BOLD,20));
        SaveButton.setBackground(Color.BLUE);
        SaveButton.setForeground(Color.WHITE);
        SaveButton.setOpaque(false);
        SaveButton.setBorderPainted(false);
        add(SaveButton);
        SaveButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        SaveButton.setVisible(false);

        EditButton.addActionListener(_ ->
        {
            FirstNameLabel2.setVisible(false);
            FirstNameTextField.setVisible(true);
            LastNameLabel2.setVisible(false);
            LastNameTextField.setVisible(true);
            MobileNoLabel2.setVisible(false);
            MobileNoLabel3.setVisible(false);
            MobileNoTextField1.setVisible(true);
            MobileNoTextField2.setVisible(true);
            UsernameLabel1.setBounds(375, 490, 250, 48);
            UsernameLabel2.setVisible(false);
            UsernameTextField.setVisible(true);
            EditButton.setVisible(false);
            SaveButton.setVisible(true);
            FirstNameTextField.requestFocus();
        });

        SaveButton.addActionListener(_ ->
        {
            String s1= FirstNameTextField.getText();
            String s2= LastNameTextField.getText();
            String s3= MobileNoTextField2.getText();
            String s4= UsernameTextField.getText();

            DateTimeFormatter DateFormat=DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDateTime Date= LocalDateTime.now();
            DateTimeFormatter TimeFormat=DateTimeFormatter.ofPattern("HH:mm");
            LocalDateTime Time=LocalDateTime.now();
            String dateandtime=DateFormat.format(Date)+" "+TimeFormat.format(Time);

            if(s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty())
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please fill the details!");
            }
            else if(MobileNoErrorLabel.isVisible())
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please provide valid mobile number!");
                MobileNoTextField2.requestFocus();
            }
            else if(MobileNoVerifyLabel.isVisible())
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please verify the mobile number!");
                MobileNoTextField2.requestFocus();
            }
            else if(!s3.equals(mn) && !MobileNoVerifiedLabel.isVisible())
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please verify the mobile number!");
                MobileNoOTPTextField.requestFocus();
            }
            else if(UsernameErrorLabel1.isVisible() || UsernameErrorLabel2.isVisible())
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please provide valid username!");
                UsernameTextField.requestFocus();
            }
            else if(!s3.equals(mn))
            {
                Database Data = new Database();
                try
                {
                    String Query1 = "select * from registration where MobileNo='" + s3 + "'";
                    ResultSet Resultset = Data.DatabaseStatement.executeQuery(Query1);
                    if (Resultset.next())
                    {
                        JOptionPane.showMessageDialog(new JFrame(), "Mobile number already registered with an account!");
                        MobileNoTextField2.requestFocus();
                    }
                    else
                    {
                        String Query2 = "update registration set FirstName='" + s1 + "', LastName='" + s2 + "', MobileNo='" + s3 + "', Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query2);
                        String n1 = s1 + " " + s2;
                        String Query3 = "update account set UPI_Name='" + n1 + "', UPI_No='" + s3 + "' where UPI_No='" + mn + "'";
                        Data.DatabaseStatement.executeUpdate(Query3);
                        String Query4 = "insert into notification values('" + mn + "','" + dateandtime + "','Dear User! You have successfully updated your account details. If this was not you then please report the support team immediately! Regards, Team TrainEase.')";
                        Data.DatabaseStatement.executeUpdate(Query4);
                        JOptionPane.showMessageDialog(new JFrame(), "TrainEase Account details updated successfully!");
                        String Query5 = "delete from notification where Mobile_No='" + mn + "'";
                        Data.DatabaseStatement.executeUpdate(Query5);
                        setVisible(false);
                        new UserMain(s4);
                    }
                }
                catch (HeadlessException | SQLException e)
                {
                    System.out.println("Error!");
                }
            }
            else if(!s4.equals(un))
            {
                Database Data = new Database();
                try
                {
                    String Query1 = "select * from registration where Username='" + s4 + "'";
                    ResultSet Resultset = Data.DatabaseStatement.executeQuery(Query1);
                    if (Resultset.next())
                    {
                        JOptionPane.showMessageDialog(new JFrame(), "Username already exists!");
                        UsernameTextField.requestFocus();
                    }
                    else
                    {
                        String Query2 = "update registration set FirstName='" + s1 + "', LastName='" + s2 + "', MobileNo='" + s3 + "', Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query2);
                        String Query3 = "update bookings set Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query3);
                        String Query4 = "update feedbacks set Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query4);
                        String Query5 = "update warnings set Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query5);
                        String Query6 = "insert into notification values('" + mn + "','" + dateandtime + "','Dear User! You have successfully updated your account details. If this was not you then please report the support team immediately! Regards, Team TrainEase.')";
                        Data.DatabaseStatement.executeUpdate(Query6);
                        JOptionPane.showMessageDialog(new JFrame(), "TrainEase Account details updated successfully!");
                        setVisible(false);
                        new UserMain(s4);
                    }
                }
                catch (HeadlessException | SQLException e)
                {
                    System.out.println("Error!");
                }
            }
            else
            {
                try
                {
                    Database Data = new Database();
                    if(!s1.equals(fn) && s2.equals(ln) && s3.equals(mn) && s4.equals(un))
                    {
                        try
                        {
                            String Query1 = "update registration set FirstName='" + s1 + "', LastName='" + s2 + "', MobileNo='" + s3 + "', Username='" + s4 + "' where Username='" + un + "'";
                            Data.DatabaseStatement.executeUpdate(Query1);
                            String n = s1 + " " + s2;
                            String Query2 = "update account set UPI_Name='" + n + "', UPI_No='" + s3 + "' where UPI_No='" + mn + "'";
                            Data.DatabaseStatement.executeUpdate(Query2);
                            String Query3 = "insert into notification values('" + mn + "','" + dateandtime + "','Dear User! You have successfully updated your account details. If this was not you then please report the support team immediately! Regards, Team TrainEase.')";
                            Data.DatabaseStatement.executeUpdate(Query3);
                            JOptionPane.showMessageDialog(new JFrame(), "TrainEase Account details updated successfully!");
                            setVisible(false);
                            new UserMain(s4);
                        }
                        catch (HeadlessException | SQLException e)
                        {
                            System.out.println("Error!");
                        }
                    }
                    else if(s1.equals(fn) && !s2.equals(ln) && s3.equals(mn) && s4.equals(un))
                    {
                        try
                        {
                            String Query1 = "update registration set FirstName='" + s1 + "', LastName='" + s2 + "', MobileNo='" + s3 + "', Username='" + s4 + "' where Username='" + un + "'";
                            Data.DatabaseStatement.executeUpdate(Query1);
                            String n = s1 + " " + s2;
                            String Query2 = "update account set UPI_Name='" + n + "', UPI_No='" + s3 + "' where UPI_No='" + mn + "'";
                            Data.DatabaseStatement.executeUpdate(Query2);
                            String Query3 = "insert into notification values('" + mn + "','" + dateandtime + "','Dear User! You have successfully updated your account details. If this was not you then please report the support team immediately! Regards, Team TrainEase.')";
                            Data.DatabaseStatement.executeUpdate(Query3);
                            JOptionPane.showMessageDialog(new JFrame(), "TrainEase Account details updated successfully!");
                            setVisible(false);
                            new UserMain(s4);
                        }
                        catch (HeadlessException | SQLException e)
                        {
                            System.out.println("Error!");
                        }
                    }
                    else if(s1.equals(fn) && s2.equals(ln) && !s3.equals(mn) && s4.equals(un))
                    {
                        String Query1 = "update registration set FirstName='" + s1 + "', LastName='" + s2 + "', MobileNo='" + s3 + "', Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query1);
                        String n1 = s1 + " " + s2;
                        String Query2 = "update account set UPI_Name='" + n1 + "', UPI_No='" + s3 + "' where UPI_No='" + mn + "'";
                        Data.DatabaseStatement.executeUpdate(Query2);
                        String Query3 = "insert into notification values('" + mn + "','" + dateandtime + "','Dear User! You have successfully updated your account details. If this was not you then please report the support team immediately! Regards, Team TrainEase.')";
                        Data.DatabaseStatement.executeUpdate(Query3);
                        JOptionPane.showMessageDialog(new JFrame(), "TrainEase Account details updated successfully!");
                        String Query4 = "delete from notification where Mobile_No='" + mn + "'";
                        Data.DatabaseStatement.executeUpdate(Query4);
                        setVisible(false);
                        new UserMain(s4);
                    }
                    else if(s1.equals(fn) && s2.equals(ln) && s3.equals(mn) && !s4.equals(un))
                    {
                        String Query2 = "update registration set FirstName='" + s1 + "', LastName='" + s2 + "', MobileNo='" + s3 + "', Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query2);
                        String Query3 = "update bookings set Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query3);
                        String Query4 = "update feedbacks set Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query4);
                        String Query5 = "update warnings set Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query5);
                        String Query6 = "insert into notification values('" + mn + "','" + dateandtime + "','Dear User! You have successfully updated your account details. If this was not you then please report the support team immediately! Regards, Team TrainEase.')";
                        Data.DatabaseStatement.executeUpdate(Query6);
                        JOptionPane.showMessageDialog(new JFrame(), "TrainEase Account details updated successfully!");
                        setVisible(false);
                        new UserMain(s4);
                    }
                    else if(!s1.equals(fn) && !s2.equals(ln) && s3.equals(mn) && s4.equals(un))
                    {
                        try
                        {
                            String Query1 = "update registration set FirstName='" + s1 + "', LastName='" + s2 + "', MobileNo='" + s3 + "', Username='" + s4 + "' where Username='" + un + "'";
                            Data.DatabaseStatement.executeUpdate(Query1);
                            String n = s1 + " " + s2;
                            String Query2 = "update account set UPI_Name='" + n + "', UPI_No='" + s3 + "' where UPI_No='" + mn + "'";
                            Data.DatabaseStatement.executeUpdate(Query2);
                            String Query3 = "insert into notification values('" + mn + "','" + dateandtime + "','Dear User! You have successfully updated your account details. If this was not you then please report the support team immediately! Regards, Team TrainEase.')";
                            Data.DatabaseStatement.executeUpdate(Query3);
                            JOptionPane.showMessageDialog(new JFrame(), "TrainEase Account details updated successfully!");
                            setVisible(false);
                            new UserMain(s4);
                        }
                        catch (HeadlessException | SQLException e)
                        {
                            System.out.println("Error!");
                        }
                    }
                    else if(s1.equals(fn) && !s2.equals(ln) && !s3.equals(mn) && s4.equals(un))
                    {
                        String Query1 = "update registration set FirstName='" + s1 + "', LastName='" + s2 + "', MobileNo='" + s3 + "', Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query1);
                        String n1 = s1 + " " + s2;
                        String Query2 = "update account set UPI_Name='" + n1 + "', UPI_No='" + s3 + "' where UPI_No='" + mn + "'";
                        Data.DatabaseStatement.executeUpdate(Query2);
                        String Query3 = "insert into notification values('" + mn + "','" + dateandtime + "','Dear User! You have successfully updated your account details. If this was not you then please report the support team immediately! Regards, Team TrainEase.')";
                        Data.DatabaseStatement.executeUpdate(Query3);
                        JOptionPane.showMessageDialog(new JFrame(), "TrainEase Account details updated successfully!");
                        String Query4 = "delete from notification where Mobile_No='" + mn + "'";
                        Data.DatabaseStatement.executeUpdate(Query4);
                        setVisible(false);
                        new UserMain(s4);
                    }
                    else if(s1.equals(fn) && s2.equals(ln) && !s3.equals(mn) && !s4.equals(un))
                    {
                        String Query1 = "update registration set FirstName='" + s1 + "', LastName='" + s2 + "', MobileNo='" + s3 + "', Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query1);
                        String n1 = s1 + " " + s2;
                        String Query2 = "update account set UPI_Name='" + n1 + "', UPI_No='" + s3 + "' where UPI_No='" + mn + "'";
                        Data.DatabaseStatement.executeUpdate(Query2);
                        String Query3 = "update bookings set Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query3);
                        String Query4 = "update feedbacks set Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query4);
                        String Query5 = "update warnings set Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query5);
                        String Query6 = "insert into notification values('" + mn + "','" + dateandtime + "','Dear User! You have successfully updated your account details. If this was not you then please report the support team immediately! Regards, Team TrainEase.')";
                        Data.DatabaseStatement.executeUpdate(Query6);
                        JOptionPane.showMessageDialog(new JFrame(), "TrainEase Account details updated successfully!");
                        String Query7 = "delete from notification where Mobile_No='" + mn + "'";
                        Data.DatabaseStatement.executeUpdate(Query7);
                        setVisible(false);
                        new UserMain(s4);
                    }
                    else if(!s1.equals(fn) && !s2.equals(ln) && !s3.equals(mn) && s4.equals(un))
                    {
                        String Query1 = "update registration set FirstName='" + s1 + "', LastName='" + s2 + "', MobileNo='" + s3 + "', Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query1);
                        String n1 = s1 + " " + s2;
                        String Query2 = "update account set UPI_Name='" + n1 + "', UPI_No='" + s3 + "' where UPI_No='" + mn + "'";
                        Data.DatabaseStatement.executeUpdate(Query2);
                        String Query3 = "insert into notification values('" + mn + "','" + dateandtime + "','Dear User! You have successfully updated your account details. If this was not you then please report the support team immediately! Regards, Team TrainEase.')";
                        Data.DatabaseStatement.executeUpdate(Query3);
                        JOptionPane.showMessageDialog(new JFrame(), "TrainEase Account details updated successfully!");
                        String Query4 = "delete from notification where Mobile_No='" + mn + "'";
                        Data.DatabaseStatement.executeUpdate(Query4);
                        setVisible(false);
                        new UserMain(s4);
                    }
                    else if(s1.equals(fn) && !s2.equals(ln) && !s3.equals(mn) && !s4.equals(un))
                    {
                        String Query1 = "update registration set FirstName='" + s1 + "', LastName='" + s2 + "', MobileNo='" + s3 + "', Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query1);
                        String n1 = s1 + " " + s2;
                        String Query2 = "update account set UPI_Name='" + n1 + "', UPI_No='" + s3 + "' where UPI_No='" + mn + "'";
                        Data.DatabaseStatement.executeUpdate(Query2);
                        String Query3 = "update bookings set Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query3);
                        String Query4 = "update feedbacks set Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query4);
                        String Query5 = "update warnings set Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query5);
                        String Query6 = "insert into notification values('" + mn + "','" + dateandtime + "','Dear User! You have successfully updated your account details. If this was not you then please report the support team immediately! Regards, Team TrainEase.')";
                        Data.DatabaseStatement.executeUpdate(Query6);
                        JOptionPane.showMessageDialog(new JFrame(), "TrainEase Account details updated successfully!");
                        String Query7 = "delete from notification where Mobile_No='" + mn + "'";
                        Data.DatabaseStatement.executeUpdate(Query7);
                        setVisible(false);
                        new UserMain(s4);
                    }
                    else if(!s1.equals(fn) && !s2.equals(ln) && !s3.equals(mn) && !s4.equals(un))
                    {
                        String Query1 = "update registration set FirstName='" + s1 + "', LastName='" + s2 + "', MobileNo='" + s3 + "', Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query1);
                        String n1 = s1 + " " + s2;
                        String Query2 = "update account set UPI_Name='" + n1 + "', UPI_No='" + s3 + "' where UPI_No='" + mn + "'";
                        Data.DatabaseStatement.executeUpdate(Query2);
                        String Query3 = "update bookings set Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query3);
                        String Query4 = "update feedbacks set Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query4);
                        String Query5 = "update warnings set Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query5);
                        String Query6 = "insert into notification values('" + mn + "','" + dateandtime + "','Dear User! You have successfully updated your account details. If this was not you then please report the support team immediately! Regards, Team TrainEase.')";
                        Data.DatabaseStatement.executeUpdate(Query6);
                        JOptionPane.showMessageDialog(new JFrame(), "TrainEase Account details updated successfully!");
                        String Query7 = "delete from notification where Mobile_No='" + mn + "'";
                        Data.DatabaseStatement.executeUpdate(Query7);
                        setVisible(false);
                        new UserMain(s4);
                    }
                    else if(s1.equals(fn) && s2.equals(ln) && s3.equals(mn) && s4.equals(un))
                    {
                        String Query1 = "update registration set FirstName='" + s1 + "', LastName='" + s2 + "', MobileNo='" + s3 + "', Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query1);
                        String n1 = s1 + " " + s2;
                        String Query2 = "update account set UPI_Name='" + n1 + "', UPI_No='" + s3 + "' where UPI_No='" + mn + "'";
                        Data.DatabaseStatement.executeUpdate(Query2);
                        String Query3 = "update bookings set Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query3);
                        String Query4 = "update feedbacks set Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query4);
                        String Query5 = "update warnings set Username='" + s4 + "' where Username='" + un + "'";
                        Data.DatabaseStatement.executeUpdate(Query5);
                        String Query6 = "insert into notification values('" + mn + "','" + dateandtime + "','Dear User! You have successfully updated your account details. If this was not you then please report the support team immediately! Regards, Team TrainEase.')";
                        Data.DatabaseStatement.executeUpdate(Query6);
                        JOptionPane.showMessageDialog(new JFrame(), "TrainEase Account details updated successfully!");
                        String Query7 = "delete from notification where Mobile_No='" + mn + "'";
                        Data.DatabaseStatement.executeUpdate(Query7);
                        setVisible(false);
                        new UserMain(s4);
                    }
                }
                catch (HeadlessException | SQLException e)
                {
                    System.out.println("Error!");
                }
            }
        });

        ImageIcon ImageIcon7 = new ImageIcon("assets/back.png");
        Image Image4=ImageIcon7.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon8=new ImageIcon(Image4);

        BackButton =new JButton(ImageIcon8);
        BackButton.setBounds(5, 5, 60, 40);
        BackButton.setFont(new Font("Georgia", Font.BOLD,20));
        BackButton.setBackground(Color.BLUE);
        BackButton.setForeground(Color.WHITE);
        add(BackButton);
        BackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        BackButton.addActionListener(_ ->
        {
            setVisible(false);
            new UserMain(username);
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        requestFocusInWindow();
    }

    public static void main(String[] args)
    {
        new UserMyDetails("");
    }
}
