import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame
{
    String username;
    JComboBox<String> LoginAsComboBox;
    JTextField UsernameTextField;
    JPasswordField PasswordTextField;
    JButton ForgotUsernameButton, ForgotPasswordButton, LoginButton, RegisterButton, BackButton;

    Login(String username)
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

        JLabel Label1=new JLabel("Login using TrainEase Account credentials!");
        Label1.setBounds(207, 185, 400, 30);
        Label1.setFont(new Font("Arial", Font.PLAIN, 16));
        Label1.setForeground(Color.BLACK);
        add(Label1);

        JLabel LoginAsLabel=new JLabel("Login As :");
        LoginAsLabel.setBounds(253, 245, 100, 30);
        LoginAsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        LoginAsLabel.setForeground(Color.BLACK);
        add(LoginAsLabel);

        String[] LoginAsComboBoxElements={
                "User",
                "Admin"
        };

        LoginAsComboBox =new JComboBox<>(LoginAsComboBoxElements);
        LoginAsComboBox.setBounds(353, 245, 100, 30);
        LoginAsComboBox.setFont(new Font("Times New Roman", Font.BOLD, 18));
        LoginAsComboBox.setForeground(Color.BLACK);
        add(LoginAsComboBox);
        LoginAsComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel UsernameLabel=new JLabel("Username :");
        UsernameLabel.setBounds(191, 295, 100, 30);
        UsernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        UsernameLabel.setForeground(Color.BLACK);
        add(UsernameLabel);

        UsernameTextField =new JTextField();
        UsernameTextField.setBounds(323, 295, 200, 30);
        UsernameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        UsernameTextField.setForeground(Color.BLACK);
        add(UsernameTextField);

        UsernameTextField.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent ke)
            {
                char c=ke.getKeyChar();
                String s=UsernameTextField.getText();
                if(s.isEmpty())
                {
                    if(!Character.isLowerCase(c))
                    {
                        ke.consume();
                    }
                }
                else if(!Character.isLowerCase(c) && !Character.isDigit(c))
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

        UsernameTextField.addActionListener(_ -> PasswordTextField.requestFocus());

        ForgotUsernameButton =new JButton("Forgot Username?");
        ForgotUsernameButton.setBounds(383, 320, 160, 30);
        ForgotUsernameButton.setFont(new Font("Arial", Font.PLAIN,14));
        ForgotUsernameButton.setBackground(Color.YELLOW);
        ForgotUsernameButton.setForeground(Color.BLACK);
        ForgotUsernameButton.setOpaque(false);
        ForgotUsernameButton.setBorderPainted(false);
        ForgotUsernameButton.setContentAreaFilled(false);
        add(ForgotUsernameButton);
        ForgotUsernameButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        ForgotUsernameButton.addActionListener(_ ->
        {
            setVisible(false);
            new ForgotUsername(username);
        });

        JLabel PasswordLabel=new JLabel("Password :");
        PasswordLabel.setBounds(191, 355, 100, 30);
        PasswordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        PasswordLabel.setForeground(Color.BLACK);
        add(PasswordLabel);

        PasswordTextField =new JPasswordField();
        PasswordTextField.setBounds(323, 355, 200, 30);
        PasswordTextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
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

        PasswordTextField.addActionListener(_ -> LoginButton.doClick());

        ForgotPasswordButton =new JButton("Forgot Password?");
        ForgotPasswordButton.setBounds(383, 380, 160, 30);
        ForgotPasswordButton.setFont(new Font("Arial", Font.PLAIN,14));
        ForgotPasswordButton.setBackground(Color.YELLOW);
        ForgotPasswordButton.setForeground(Color.BLACK);
        ForgotPasswordButton.setOpaque(false);
        ForgotPasswordButton.setBorderPainted(false);
        ForgotPasswordButton.setContentAreaFilled(false);
        add(ForgotPasswordButton);
        ForgotPasswordButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        ForgotPasswordButton.addActionListener(_ ->
        {
            setVisible(false);
            new ForgotPassword(username);
        });

        LoginButton =new JButton("LOGIN");
        LoginButton.setBounds(283, 425, 150, 30);
        LoginButton.setFont(new Font("Georgia", Font.BOLD,15));
        LoginButton.setBackground(new Color(1,48,10));
        LoginButton.setForeground(Color.WHITE);
        add(LoginButton);
        LoginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel Label2=new JLabel("----------------- OR -----------------");
        Label2.setBounds(257, 485, 400, 30);
        Label2.setFont(new Font("Arial", Font.PLAIN, 16));
        Label2.setForeground(Color.BLACK);
        add(Label2);

        JLabel Label3=new JLabel("Don't have an account?");
        Label3.setBounds(280, 545, 400, 30);
        Label3.setFont(new Font("Arial", Font.PLAIN, 16));
        Label3.setForeground(Color.BLACK);
        add(Label3);

        RegisterButton =new JButton("REGISTER");
        RegisterButton.setBounds(283, 585, 150, 30);
        RegisterButton.setFont(new Font("Georgia", Font.BOLD,15));
        RegisterButton.setBackground(Color.BLUE);
        RegisterButton.setForeground(Color.WHITE);
        add(RegisterButton);
        RegisterButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        LoginAsComboBox.addActionListener(_ ->
        {
            if(Objects.equals(LoginAsComboBox.getSelectedItem(), "Admin"))
            {
                ForgotUsernameButton.setVisible(false);
                ForgotPasswordButton.setVisible(false);
                Label2.setVisible(false);
                Label3.setVisible(false);
                RegisterButton.setVisible(false);
                UsernameTextField.setText("");
                PasswordTextField.setText("");
                UsernameTextField.requestFocus();
            }
            else if(Objects.equals(LoginAsComboBox.getSelectedItem(),"User" ))
            {
                ForgotUsernameButton.setVisible(true);
                ForgotPasswordButton.setVisible(true);
                Label2.setVisible(true);
                Label3.setVisible(true);
                RegisterButton.setVisible(true);
                UsernameTextField.setText("");
                PasswordTextField.setText("");
                UsernameTextField.requestFocus();
            }
        });

        LoginButton.addActionListener(_ ->
        {
            String un = UsernameTextField.getText();
            char[] c = PasswordTextField.getPassword();
            String pw = new String(c);

            if(un.isEmpty() || pw.isEmpty())
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please provide the login credentials!");
            }
            else if(Objects.equals(LoginAsComboBox.getSelectedItem(), "Admin"))
            {
                try
                {
                    Database Data=new Database();
                    String Query="select * from administration where Username='"+un+"' and Password='"+pw+"'";
                    ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query);
                    if(Resultset.next())
                    {
                        setVisible(false);
                        new AdminMain(un);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JFrame(),"Please provide valid login credentials!");
                        PasswordTextField.setText("");
                    }
                }
                catch(HeadlessException | SQLException e)
                {
                    System.out.println("Error!");
                }
            }
            else if(Objects.equals(LoginAsComboBox.getSelectedItem(), "User"))
            {
                try
                {
                    Database Data=new Database();
                    String Query1="select * from registration where Username='"+un+"' and Password='"+pw+"'";
                    ResultSet Resultset1=Data.DatabaseStatement.executeQuery(Query1);
                    if(Resultset1.next())
                    {
                        String Query2 = "select * from warnings where Username='"+un+"'";
                        ResultSet Resultset2 = Data.DatabaseStatement.executeQuery(Query2);
                        if (Resultset2.next())
                        {
                            JOptionPane.showMessageDialog(new JFrame(), "Dear '" + un + "' !\nYour account doesn't seems to follow our community standards, so please be responsible while using the service.\nThank You.\n\nTeam TrainEase.");
                            String Query3="delete from warnings where Username='"+un+"'";
                            Data.DatabaseStatement.executeUpdate(Query3);
                        }
                        setVisible(false);
                        new UserMain(un);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JFrame(),"Please provide valid login credentials!");
                        PasswordTextField.setText("");
                    }
                }
                catch(HeadlessException | SQLException e)
                {
                    System.out.println("Error!");
                }
            }
        });

        RegisterButton.addActionListener(_ ->
        {
            setVisible(false);
            new Register(username);
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

        UsernameTextField.requestFocusInWindow();
    }

    public static void main(String[] args)
    {
        new Login("");
    }
}
