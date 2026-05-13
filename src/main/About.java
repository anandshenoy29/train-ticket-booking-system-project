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

public class About extends JFrame
{
    String username,source;
    JButton BackButton;

    About(String username,String source)
    {
        this.username=username;
        this.source=source;
        setTitle("TrainEase");
        setSize(1245,730);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLUE);
        setLayout(null);

        ImageIcon ImageIcon1=new ImageIcon("assets/trainease_1.png");
        Image Image1=ImageIcon1.getImage().getScaledInstance(240, 240, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon2=new ImageIcon(Image1);
        JLabel ImageLabel1=new JLabel(ImageIcon2);
        ImageLabel1.setBounds(535, 15, 160, 160);
        add(ImageLabel1);

        JLabel Label1=new JLabel("|| About Us ||");
        Label1.setBounds(495, 185, 250, 30);
        Label1.setFont(new Font("Georgia", Font.BOLD, 35));
        Label1.setForeground(Color.YELLOW);
        add(Label1);

        JTextArea TextArea1=new JTextArea();
        TextArea1.setBounds(264, 260, 700, 75);
        TextArea1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        TextArea1.setBackground(Color.LIGHT_GRAY);
        TextArea1.setForeground(Color.BLACK);
        TextArea1.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
        TextArea1.setLineWrap(true);
        TextArea1.setWrapStyleWord(true);
        TextArea1.append(" TrainEase is a train ticket booking application where one can          search and book Mumbai Suburban local train tickets.");
        add(TextArea1);
        TextArea1.setEditable(false);

        JTextArea TextArea2=new JTextArea();
        TextArea2.setBounds(264, 340, 700, 250);
        TextArea2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        TextArea2.setBackground(Color.LIGHT_GRAY);
        TextArea2.setForeground(Color.BLACK);
        TextArea2.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
        TextArea2.setLineWrap(true);
        TextArea2.setWrapStyleWord(true);
        TextArea2.append("\t               ---------- Disclaimer ----------");
        TextArea2.append("\n\n This app is designed for educational purposes only. ");
        TextArea2.append("This app doesn't               guarantee the correctness of the data. The data may reflect real-time                 information but should not be used for actual travel planning. ");
        TextArea2.append("This app is        not connected to any actual railway or transport operator and does not             process any real transactions.");
        TextArea2.append("\n Please review the terms carefully before using the app.");
        TextArea2.append("\n Thank you for understanding.");
        add(TextArea2);
        TextArea2.setEditable(false);

        JLabel Label2=new JLabel("Copyright © 2025 - All Rights Reserved");
        Label2.setBounds(428, 600, 400, 30);
        Label2.setFont(new Font("Times New Roman", Font.BOLD, 22));
        Label2.setForeground(Color.WHITE);
        add(Label2);

        JLabel Label3=new JLabel("Version : 1.0.1");
        Label3.setBounds(528, 630, 300, 30);
        Label3.setFont(new Font("Times New Roman", Font.BOLD, 22));
        Label3.setForeground(Color.WHITE);
        add(Label3);

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
        new About("","");
    }
}
