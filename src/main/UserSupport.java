import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class UserSupport extends JFrame
{
    String username;
    JButton DeleteAccountButton,BackButton;
    
    UserSupport(String username)
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

        JLabel Label1=new JLabel("|| Some Frequently Asked Questions ||");
        Label1.setBounds(270, 185, 700, 50);
        Label1.setFont(new Font("Georgia", Font.BOLD, 35));
        Label1.setForeground(Color.YELLOW);
        add(Label1);

        JLabel Question1Label=new JLabel(" ✔ How to check trains?");
        Question1Label.setBounds(70, 265, 500, 40);
        Question1Label.setFont(new Font("Georgia", Font.BOLD, 22));
        Question1Label.setForeground(Color.WHITE);
        Question1Label.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        add(Question1Label);

        JTextArea Question1TextArea=new JTextArea();
        Question1TextArea.setBounds(70, 315, 500, 125);
        Question1TextArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        Question1TextArea.setBackground(Color.BLUE);
        Question1TextArea.setForeground(Color.WHITE);
        Question1TextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        Question1TextArea.setLineWrap(true);
        Question1TextArea.setWrapStyleWord(true);
        Question1TextArea.append(" 1. Go to the main page.\n 2. Click on 'Search Trains' in the menu bar.\n 3. Click on your respective journey line.\n 4. Choose the Source and Destination stations.\n 5. Click on 'Search'.");
        add(Question1TextArea);
        Question1TextArea.setEditable(false);

        JLabel Question2Label=new JLabel(" ✔ How to book tickets?");
        Question2Label.setBounds(660, 265, 500, 40);
        Question2Label.setFont(new Font("Georgia", Font.BOLD, 22));
        Question2Label.setForeground(Color.WHITE);
        Question2Label.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        add(Question2Label);

        JTextArea Question2TextArea=new JTextArea();
        Question2TextArea.setBounds(660, 315, 500, 150);
        Question2TextArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        Question2TextArea.setBackground(Color.BLUE);
        Question2TextArea.setForeground(Color.WHITE);
        Question2TextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        Question2TextArea.setLineWrap(true);
        Question2TextArea.setWrapStyleWord(true);
        Question2TextArea.append(" 1. Go to the main page.\n 2. Click on 'Book Tickets' in the menu bar.\n 3. Click on your respective journey line.\n 4. Provide the Source and Destination stations,type of ticket,        and other details to generate the ticket fare.\n 5. Click on 'Book' and proceed to the payment process.");
        add(Question2TextArea);
        Question2TextArea.setEditable(false);

        JLabel Question3Label=new JLabel(" ✔ How to view generated digital tickets?");
        Question3Label.setBounds(70, 450, 500, 40);
        Question3Label.setFont(new Font("Georgia", Font.BOLD, 22));
        Question3Label.setForeground(Color.WHITE);
        Question3Label.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        add(Question3Label);

        JTextArea Question3TextArea=new JTextArea();
        Question3TextArea.setBounds(70, 500, 500, 125);
        Question3TextArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        Question3TextArea.setBackground(Color.BLUE);
        Question3TextArea.setForeground(Color.WHITE);
        Question3TextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        Question3TextArea.setLineWrap(true);
        Question3TextArea.setWrapStyleWord(true);
        Question3TextArea.append(" 1. Go to the main page.\n 2. Click on 'My Profile' in the menu bar.\n 3. Click on 'My Bookings' section.\n 4. Click on the view button beside your respective ticket data       to view the generated digital ticket.");
        add(Question3TextArea);
        Question3TextArea.setEditable(false);

        JLabel Question4Label=new JLabel(" ✔ How to change account password?");
        Question4Label.setBounds(660, 475, 500, 40);
        Question4Label.setFont(new Font("Georgia", Font.BOLD, 22));
        Question4Label.setForeground(Color.WHITE);
        Question4Label.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        add(Question4Label);

        JTextArea Question4TextArea=new JTextArea();
        Question4TextArea.setBounds(660, 525, 500, 150);
        Question4TextArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        Question4TextArea.setBackground(Color.BLUE);
        Question4TextArea.setForeground(Color.WHITE);
        Question4TextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        Question4TextArea.setLineWrap(true);
        Question4TextArea.setWrapStyleWord(true);
        Question4TextArea.append(" 1. Go to the main page.\n 2. Click on 'My Profile' in the menu bar.\n 3. Click on 'Change Password' section.\n 4. Enter your current password to proceed.\n 5. Enter your new password and confirm it.\n 6. Click on 'Change'.");
        add(Question4TextArea);
        Question4TextArea.setEditable(false);

        ImageIcon ImageIcon3 = new ImageIcon("assets/delete_account.png");
        Image Image2=ImageIcon3.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon4=new ImageIcon(Image2);

        DeleteAccountButton =new JButton(ImageIcon4);
        DeleteAccountButton.setBounds(1165, 5, 60, 60);
        DeleteAccountButton.setFont(new Font("Georgia", Font.BOLD,20));
        DeleteAccountButton.setBackground(Color.BLUE);
        DeleteAccountButton.setForeground(Color.WHITE);
        DeleteAccountButton.setOpaque(false);
        DeleteAccountButton.setBorderPainted(false);
        add(DeleteAccountButton);
        DeleteAccountButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        DeleteAccountButton.addActionListener(_ ->
        {
            setVisible(false);
            new UserDeleteAccount(username);
        });

        ImageIcon ImageIcon5 = new ImageIcon("assets/back.png");
        Image Image3=ImageIcon5.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon6=new ImageIcon(Image3);

        BackButton =new JButton(ImageIcon6);
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
        new UserSupport("");
    }
}
