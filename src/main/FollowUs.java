import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FollowUs extends JFrame
{
    String username,source;
    JButton BackButton;

    FollowUs(String username,String source)
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

        JLabel Label1=new JLabel("|| Follow Us ||");
        Label1.setBounds(490, 185, 300, 30);
        Label1.setFont(new Font("Georgia", Font.BOLD, 35));
        Label1.setForeground(Color.YELLOW);
        add(Label1);

        ImageIcon ImageIcon3 = new ImageIcon("assets/linkedin.png");
        Image Image2=ImageIcon3.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon4=new ImageIcon(Image2);
        JLabel ImageLabel2=new JLabel(ImageIcon4);
        ImageLabel2.setBounds(360, 260, 70, 70);
        add(ImageLabel2);

        JLabel Label2=new JLabel("LinkedIn       -");
        Label2.setBounds(435, 275, 300, 40);
        Label2.setFont(new Font("Georgia", Font.BOLD, 30));
        Label2.setForeground(Color.WHITE);
        add(Label2);

        JLabel Label3=new JLabel("    /traineaseindia");
        Label3.setBounds(655, 277, 200, 40);
        Label3.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Label3.setForeground(Color.WHITE);
        add(Label3);

        ImageIcon ImageIcon5 = new ImageIcon("assets/facebook.png");
        Image Image3=ImageIcon5.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon6=new ImageIcon(Image3);
        JLabel ImageLabel3=new JLabel(ImageIcon6);
        ImageLabel3.setBounds(360, 335, 70, 70);
        add(ImageLabel3);

        JLabel Label4=new JLabel("Facebook       -");
        Label4.setBounds(435, 350, 300, 40);
        Label4.setFont(new Font("Georgia", Font.BOLD, 30));
        Label4.setForeground(Color.WHITE);
        add(Label4);

        JLabel Label5=new JLabel("    /traineaseindia");
        Label5.setBounds(655, 352, 200, 40);
        Label5.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Label5.setForeground(Color.WHITE);
        add(Label5);

        ImageIcon ImageIcon7 = new ImageIcon("assets/x.png");
        Image Image4=ImageIcon7.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon8=new ImageIcon(Image4);
        JLabel ImageLabel4=new JLabel(ImageIcon8);
        ImageLabel4.setBounds(355, 405, 80, 80);
        add(ImageLabel4);

        JLabel Label6=new JLabel("Twitter/X      -");
        Label6.setBounds(435, 425, 300, 40);
        Label6.setFont(new Font("Georgia", Font.BOLD, 30));
        Label6.setForeground(Color.WHITE);
        add(Label6);

        JLabel Label7=new JLabel("    @traineaseindia");
        Label7.setBounds(655, 427, 200, 40);
        Label7.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Label7.setForeground(Color.WHITE);
        add(Label7);

        ImageIcon ImageIcon9 = new ImageIcon("assets/instagram.png");
        Image Image5=ImageIcon9.getImage().getScaledInstance(80, 50, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon10=new ImageIcon(Image5);
        JLabel ImageLabel5=new JLabel(ImageIcon10);
        ImageLabel5.setBounds(350, 490, 90, 60);
        add(ImageLabel5);

        JLabel Label8=new JLabel("Instagram     -");
        Label8.setBounds(435, 500, 300, 40);
        Label8.setFont(new Font("Georgia", Font.BOLD, 30));
        Label8.setForeground(Color.WHITE);
        add(Label8);

        JLabel Label9=new JLabel("    @traineaseindia");
        Label9.setBounds(655, 502, 200, 40);
        Label9.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Label9.setForeground(Color.WHITE);
        add(Label9);

        ImageIcon ImageIcon11 = new ImageIcon("assets/back.png");
        Image Image6=ImageIcon11.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon12=new ImageIcon(Image6);

        BackButton =new JButton(ImageIcon12);
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
        new FollowUs("","");
    }
}
