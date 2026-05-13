import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AdminDetails extends JFrame
{
    String username;
    JButton BackButton;

    AdminDetails(String username)
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

        JLabel Label1=new JLabel("|| Admin Information ||");
        Label1.setBounds(400, 185, 450, 50);
        Label1.setFont(new Font("Georgia", Font.BOLD, 35));
        Label1.setForeground(Color.YELLOW);
        add(Label1);

        JLabel Label2=new JLabel();
        Label2.setBounds(285, 260, 660, 270);
        Label2.setFont(new Font("Georgia", Font.BOLD, 35));
        Label2.setForeground(Color.YELLOW);
        Label2.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
        add(Label2);

        JLabel NameLabel1=new JLabel("Admin Name     :");
        NameLabel1.setBounds(325, 300, 250, 50);
        NameLabel1.setFont(new Font("Georgia", Font.PLAIN, 32));
        NameLabel1.setForeground(Color.WHITE);
        add(NameLabel1);

        JLabel NameLabel2=new JLabel();
        NameLabel2.setBounds(595, 300, 400, 50);
        NameLabel2.setFont(new Font("Georgia", Font.PLAIN, 32));
        NameLabel2.setForeground(Color.CYAN);
        add(NameLabel2);

        JLabel UsernameLabel1=new JLabel("Username          :");
        UsernameLabel1.setBounds(325, 370, 250, 50);
        UsernameLabel1.setFont(new Font("Georgia", Font.PLAIN, 32));
        UsernameLabel1.setForeground(Color.WHITE);
        add(UsernameLabel1);

        JLabel UsernameLabel2=new JLabel();
        UsernameLabel2.setBounds(595, 370, 400, 50);
        UsernameLabel2.setFont(new Font("Georgia", Font.PLAIN, 32));
        UsernameLabel2.setForeground(Color.CYAN);
        add(UsernameLabel2);

        JLabel DesignationLabel1=new JLabel("Designation       :");
        DesignationLabel1.setBounds(325, 440, 250, 50);
        DesignationLabel1.setFont(new Font("Georgia", Font.PLAIN, 32));
        DesignationLabel1.setForeground(Color.WHITE);
        add(DesignationLabel1);

        JLabel DesignationLabel2=new JLabel();
        DesignationLabel2.setBounds(595, 440, 350, 50);
        DesignationLabel2.setFont(new Font("Georgia", Font.PLAIN, 32));
        DesignationLabel2.setForeground(Color.CYAN);
        add(DesignationLabel2);

        try
        {
            Database Data=new Database();
            String Query1="select * from administration where Username='"+username+"'";
            ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query1);
            Resultset.next();
            String an=Resultset.getString("AdminName");
            String un=Resultset.getString("Username");
            String dn=Resultset.getString("Designation");

            NameLabel2.setText(an);
            UsernameLabel2.setText(un);
            DesignationLabel2.setText(dn);
        }
        catch(SQLException e)
        {
            System.out.println("Error!");
        }

        ImageIcon ImageIcon3=new ImageIcon("assets/back.png");
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
            new AdminMain(username);
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        requestFocusInWindow();
    }

    public static void main(String[] args)
    {
        new AdminDetails("");
    }
}
