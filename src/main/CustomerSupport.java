import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CustomerSupport extends JFrame
{
    String username,source;
    JButton BackButton;

    CustomerSupport(String username,String source)
    {
        this.username=username;
        this.source=source;
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

        JLabel Label1=new JLabel("|| Contact Us ||");
        Label1.setBounds(480, 185, 300, 30);
        Label1.setFont(new Font("Georgia", Font.BOLD, 35));
        Label1.setForeground(Color.YELLOW);
        add(Label1);

        JLabel Label2=new JLabel("| For Ticket Booking related queries |");
        Label2.setBounds(326, 275, 600, 40);
        Label2.setFont(new Font("Georgia", Font.BOLD, 30));
        Label2.setForeground(Color.YELLOW);
        add(Label2);

        JLabel Label3=new JLabel("Contact Number :");
        Label3.setBounds(270, 350, 300, 30);
        Label3.setFont(new Font("Georgia", Font.BOLD, 25));
        Label3.setForeground(Color.WHITE);
        add(Label3);

        JLabel Label4=new JLabel("1800 111 1111 / 1800 222 2222");
        Label4.setBounds(630, 350, 600, 30);
        Label4.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Label4.setForeground(Color.WHITE);
        add(Label4);

        JLabel Label5=new JLabel("Contact Email Address :");
        Label5.setBounds(270, 400, 400, 30);
        Label5.setFont(new Font("Georgia", Font.BOLD, 25));
        Label5.setForeground(Color.WHITE);
        add(Label5);

        JLabel Label6=new JLabel("ticketbookingsupport@trainease.com");
        Label6.setBounds(630, 400, 500, 30);
        Label6.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Label6.setForeground(Color.WHITE);
        add(Label6);

        JLabel Label7=new JLabel("| For Account related queries |");
        Label7.setBounds(380, 475, 500, 40);
        Label7.setFont(new Font("Georgia", Font.BOLD, 30));
        Label7.setForeground(Color.YELLOW);
        add(Label7);

        JLabel Label8=new JLabel("Contact Number :");
        Label8.setBounds(270, 550, 300, 30);
        Label8.setFont(new Font("Georgia", Font.BOLD, 25));
        Label8.setForeground(Color.WHITE);
        add(Label8);

        JLabel Label9=new JLabel("1800 333 3333 / 1800 444 4444");
        Label9.setBounds(630, 550, 600, 30);
        Label9.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Label9.setForeground(Color.WHITE);
        add(Label9);

        JLabel Label10=new JLabel("Contact Email Address :");
        Label10.setBounds(270, 600, 400, 30);
        Label10.setFont(new Font("Georgia", Font.BOLD, 25));
        Label10.setForeground(Color.WHITE);
        add(Label10);

        JLabel Label11=new JLabel("accountsupport@trainease.com");
        Label11.setBounds(630, 600, 500, 30);
        Label11.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Label11.setForeground(Color.WHITE);
        add(Label11);

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
            switch (source) {
                case "Main" -> new Main(username);
                case "UserMain" -> new UserMain(username);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        requestFocusInWindow();
    }
    
    public static void main(String[] args)
    {
        new CustomerSupport("","");
    }
}