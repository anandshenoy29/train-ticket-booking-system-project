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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserChangePassword extends JFrame
{
    String username,pw;
    JPasswordField PasswordTextField;
    JTextField NewPasswordTextField, ConfirmPasswordTextField;
    JButton ProceedButton, ChangeButton, BackButton;

    UserChangePassword(String username)
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

        JLabel Label1=new JLabel("|| Change Password ||");
        Label1.setBounds(419, 190, 400, 50);
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

        JLabel NewPasswordLabel=new JLabel("New Password :");
        NewPasswordLabel.setBounds(360, 300, 310, 30);
        NewPasswordLabel.setFont(new Font("Georgia", Font.PLAIN, 32));
        NewPasswordLabel.setForeground(Color.WHITE);
        add(NewPasswordLabel);
        NewPasswordLabel.setVisible(false);

        NewPasswordTextField =new JTextField();
        NewPasswordTextField.setBounds(670, 300, 200, 30);
        NewPasswordTextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        NewPasswordTextField.setForeground(Color.BLACK);
        add(NewPasswordTextField);
        NewPasswordTextField.setVisible(false);

        JLabel PasswordInfoLabel1=new JLabel("Note: Password should consist of");
        PasswordInfoLabel1.setBounds(670, 325, 220, 30);
        PasswordInfoLabel1.setFont(new Font("Arial", Font.PLAIN, 11));
        PasswordInfoLabel1.setForeground(Color.WHITE);
        add(PasswordInfoLabel1);
        PasswordInfoLabel1.setVisible(false);

        JLabel PasswordInfoLabel2=new JLabel("uppercase and lowercase letters,");
        PasswordInfoLabel2.setBounds(670, 335, 220, 30);
        PasswordInfoLabel2.setFont(new Font("Arial", Font.PLAIN, 11));
        PasswordInfoLabel2.setForeground(Color.WHITE);
        add(PasswordInfoLabel2);
        PasswordInfoLabel2.setVisible(false);

        JLabel PasswordInfoLabel3=new JLabel("numbers and special characters i.e. !@#$_");
        PasswordInfoLabel3.setBounds(670, 345, 220, 30);
        PasswordInfoLabel3.setFont(new Font("Arial", Font.PLAIN, 11));
        PasswordInfoLabel3.setForeground(Color.WHITE);
        add(PasswordInfoLabel3);
        PasswordInfoLabel3.setVisible(false);

        JLabel PasswordErrorLabel1=new JLabel("Invalid Password!");
        PasswordErrorLabel1.setBounds(670, 330, 150, 30);
        PasswordErrorLabel1.setFont(new Font("Arial", Font.PLAIN, 16));
        PasswordErrorLabel1.setForeground(Color.RED);
        add(PasswordErrorLabel1);
        PasswordErrorLabel1.setVisible(false);

        JLabel PasswordErrorLabel2=new JLabel("Password must contain at least 8 characters!");
        PasswordErrorLabel2.setBounds(670, 330, 250, 30);
        PasswordErrorLabel2.setFont(new Font("Arial", Font.PLAIN, 11));
        PasswordErrorLabel2.setForeground(Color.RED);
        add(PasswordErrorLabel2);
        PasswordErrorLabel2.setVisible(false);

        JLabel ConfirmPasswordLabel=new JLabel("Confirm Password :");
        ConfirmPasswordLabel.setBounds(360, 370, 310, 30);
        ConfirmPasswordLabel.setFont(new Font("Georgia", Font.PLAIN, 32));
        ConfirmPasswordLabel.setForeground(Color.WHITE);
        add(ConfirmPasswordLabel);
        ConfirmPasswordLabel.setVisible(false);

        ConfirmPasswordTextField =new JTextField();
        ConfirmPasswordTextField.setBounds(670, 370, 200, 30);
        ConfirmPasswordTextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        ConfirmPasswordTextField.setForeground(Color.BLACK);
        add(ConfirmPasswordTextField);
        ConfirmPasswordTextField.setVisible(false);

        JLabel PasswordErrorLabel3=new JLabel("Password doesn't match!");
        PasswordErrorLabel3.setBounds(670, 400, 200, 30);
        PasswordErrorLabel3.setFont(new Font("Arial", Font.PLAIN, 16));
        PasswordErrorLabel3.setForeground(Color.RED);
        add(PasswordErrorLabel3);
        PasswordErrorLabel3.setVisible(false);

        NewPasswordTextField.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent ke)
            {
                String s=NewPasswordTextField.getText();
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
                String s1=NewPasswordTextField.getText();
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

        NewPasswordTextField.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent fe)
            {

            }
            @Override
            public void focusLost(FocusEvent fe)
            {
                String s=NewPasswordTextField.getText();
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

        NewPasswordTextField.addActionListener(_ -> ConfirmPasswordTextField.requestFocus());

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
                String s1=NewPasswordTextField.getText();
                String s2=ConfirmPasswordTextField.getText();
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
                    PasswordErrorLabel3.setVisible(false);
                }
            }
        });

        ConfirmPasswordTextField.addActionListener(_ -> ChangeButton.doClick());

        ChangeButton=new JButton("Change");
        ChangeButton.setBounds(553, 470, 125, 40);
        ChangeButton.setFont(new Font("Georgia", Font.BOLD,20));
        ChangeButton.setBackground(Color.MAGENTA);
        ChangeButton.setForeground(Color.BLACK);
        add(ChangeButton);
        ChangeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ChangeButton.setVisible(false);

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
                        PasswordLabel.setVisible(false);
                        PasswordTextField.setVisible(false);
                        ProceedButton.setVisible(false);
                        NewPasswordLabel.setVisible(true);
                        NewPasswordTextField.setVisible(true);
                        ConfirmPasswordLabel.setVisible(true);
                        ConfirmPasswordTextField.setVisible(true);
                        ChangeButton.setVisible(true);
                        NewPasswordTextField.requestFocus();
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

        ChangeButton.addActionListener(_ ->
        {
            String pw1 = NewPasswordTextField.getText();
            String pw2 = ConfirmPasswordTextField.getText();

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
                    String Query1="select * from registration where Username='"+username+"' and Password='"+pw+"'";
                    ResultSet Resultset1=Data.DatabaseStatement.executeQuery(Query1);
                    if(Resultset1.next())
                    {
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

                            String Query2 = "update registration set Password='"+pw1+"' where Username='"+username+"'";
                            Data.DatabaseStatement.executeUpdate(Query2);
                            JOptionPane.showMessageDialog(new JFrame(), "TrainEase Account password resetted successfully!");
                            String Query3="select * from registration where Username='"+username+"'";
                            ResultSet Resultset2=Data.DatabaseStatement.executeQuery(Query3);
                            if(Resultset2.next())
                            {
                                String mn = Resultset2.getString("MobileNo");
                                String Query4="insert into notification values('"+mn+"','"+dateandtime+"','Dear User! You have successfully resetted your account password. If this was not you then please secure your account immediately! Regards, Team TrainEase.')";
                                Data.DatabaseStatement.executeUpdate(Query4);
                            }
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
            new UserMain(username);
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        PasswordTextField.requestFocusInWindow();
    }

    public static void main(String[] args)
    {
        new UserChangePassword("");
    }
}
