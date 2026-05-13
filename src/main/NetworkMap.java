import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class NetworkMap extends JFrame
{
    String username,source;
    JButton ZoomInButton, ZoomOutButton, ResetButton, BackButton;
    
    NetworkMap(String username,String source)
    {
        this.username=username;
        this.source=source;
        setTitle("TrainEase");
        setSize(730,730);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLUE);
        setLayout(null);

        ImageIcon ImageIcon1 = new ImageIcon("assets/network_map.png");
        Image Image1=ImageIcon1.getImage().getScaledInstance(488, 678, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon2=new ImageIcon(Image1);
        JLabel ImageLabel1=new JLabel(ImageIcon2);
        ImageLabel1.setBounds(115, 5, 488, 678);
        add(ImageLabel1);

        JScrollPane ImageScrollPane=new JScrollPane(ImageLabel1);
        ImageScrollPane.setBounds(115, 5, 488, 678);
        add(ImageScrollPane);

        ImageIcon ImageIcon3 = new ImageIcon("assets/zoom_in.png");
        Image Image2=ImageIcon3.getImage().getScaledInstance(40, 30, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon4=new ImageIcon(Image2);

        ZoomInButton = new  JButton(ImageIcon4);
        ZoomInButton.setBounds(634, 518, 50, 40);
        ZoomInButton.setFont(new Font("Georgia", Font.BOLD,20));
        ZoomInButton.setBackground(Color.BLUE);
        ZoomInButton.setForeground(Color.WHITE);
        add(ZoomInButton);
        ZoomInButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        ImageIcon ImageIcon5 = new ImageIcon("assets/zoom_out.png");
        Image Image3=ImageIcon5.getImage().getScaledInstance(40, 30, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon6=new ImageIcon(Image3);

        ZoomOutButton = new JButton(ImageIcon6);
        ZoomOutButton.setBounds(634, 568, 50, 40);
        ZoomOutButton.setFont(new Font("Georgia", Font.BOLD,20));
        ZoomOutButton.setBackground(Color.BLUE);
        ZoomOutButton.setForeground(Color.WHITE);
        add(ZoomOutButton);
        ZoomOutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        ImageIcon ImageIcon7 = new ImageIcon("assets/reset.png");
        Image Image4=ImageIcon7.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon8=new ImageIcon(Image4);

        ResetButton = new JButton(ImageIcon8);
        ResetButton.setBounds(634, 618, 50, 40);
        ResetButton.setFont(new Font("Georgia", Font.BOLD,20));
        ResetButton.setBackground(Color.BLUE);
        ResetButton.setForeground(Color.WHITE);
        add(ResetButton);
        ResetButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        ZoomInButton.addActionListener(_ ->
        {
            int x = ImageLabel1.getWidth()+144;
            int y = ImageLabel1.getHeight()+200;
            if(x<=1930 && y<=2678)
            {
                ImageIcon ZoomImageIcon1 = new ImageIcon("assets/network_map.png");
                Image ZoomImage1=ZoomImageIcon1.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
                ImageIcon ZoomImageIcon2=new ImageIcon(ZoomImage1);
                ImageLabel1.setIcon(ZoomImageIcon2);
            }
        });

        ZoomOutButton.addActionListener(_ ->
        {
            int x = ImageLabel1.getWidth()-144;
            int y = ImageLabel1.getHeight()-200;
            if(x>=488 && y>=678)
            {
                ImageIcon ZoomImageIcon1 = new ImageIcon("assets/network_map.png");
                Image ZoomImage1=ZoomImageIcon1.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
                ImageIcon ZoomImageIcon2=new ImageIcon(ZoomImage1);
                ImageLabel1.setIcon(ZoomImageIcon2);
            }
        });

        ResetButton.addActionListener(_ ->
        {
            ImageIcon ResetImageIcon1 = new ImageIcon("assets/network_map.png");
            Image ResetImage1=ResetImageIcon1.getImage().getScaledInstance(488, 678, Image.SCALE_DEFAULT);
            ImageIcon ResetImageIcon2=new ImageIcon(ResetImage1);
            ImageLabel1.setIcon(ResetImageIcon2);
        });

        ImageIcon ImageIcon9 = new ImageIcon("assets/back.png");
        Image Image5=ImageIcon9.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon10=new ImageIcon(Image5);

        BackButton =new JButton(ImageIcon10);
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
        new NetworkMap("","");
    }
}
