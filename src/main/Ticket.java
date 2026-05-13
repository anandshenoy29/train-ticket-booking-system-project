import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Ticket extends JFrame
{
    String teno,route,tickettype,classtype,totalmembers,dateandtime,totalticketfare,username;
    JButton BackButton;

    Ticket(String teno,String route,String tickettype,String classtype,String totalmembers,String dateandtime,String totalticketfare,String username)
    {
        this.teno=teno;
        this.route=route;
        this.tickettype=tickettype;
        this.classtype=classtype;
        this.totalmembers=totalmembers;
        this.dateandtime=dateandtime;
        this.totalticketfare=totalticketfare;
        this.username=username;
        setTitle("TrainEase");
        setSize(730,730);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLUE);
        setLayout(null);

        ImageIcon ImageIcon1 = new ImageIcon("assets/trainease_1.png");
        Image Image1=ImageIcon1.getImage().getScaledInstance(240, 240, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon2=new ImageIcon(Image1);
        JLabel ImageLabel1=new JLabel(ImageIcon2);
        ImageLabel1.setBounds(277, 15, 160, 160);
        add(ImageLabel1);

        JLabel Label1=new JLabel("😊 HAPPY JOURNEY 😊");
        Label1.setBounds(132, 175, 450, 50);
        Label1.setFont(new Font("Georgia", Font.BOLD, 35));
        Label1.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        Label1.setHorizontalAlignment(SwingConstants.CENTER);
        Label1.setForeground(Color.GREEN);
        add(Label1);

        JLabel Label2=new JLabel();
        Label2.setBounds(8, 230, 700, 400);
        Label2.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        add(Label2);

        JLabel Label3=new JLabel("JOURNEY TICKET");
        Label3.setBounds(222, 240, 450, 50);
        Label3.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Label3.setForeground(Color.WHITE);
        add(Label3);

        JLabel Label4=new JLabel();
        Label4.setBounds(28, 295, 660, 320);
        Label4.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        add(Label4);

        JLabel Label5=new JLabel("<html>TE No. : <font color='white'>"+teno+"</font></html>");
        Label5.setBounds(28, 307, 660, 50);
        Label5.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Label5.setHorizontalAlignment(SwingConstants.CENTER);
        Label5.setForeground(Color.CYAN);
        add(Label5);

        JLabel Label6=new JLabel("<html>Journey Route : <font color='white'>"+route+"</font></html>");
        Label6.setBounds(28, 357, 660, 50);
        Label6.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Label6.setHorizontalAlignment(SwingConstants.CENTER);
        Label6.setForeground(Color.CYAN);
        add(Label6);

        JLabel Label7=new JLabel("<html>Ticket Type : <font color='white'>"+tickettype+"</font></html>");
        Label7.setBounds(78, 407, 560, 50);
        Label7.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Label7.setHorizontalAlignment(SwingConstants.LEFT);
        Label7.setForeground(Color.CYAN);
        add(Label7);

        JLabel Label8=new JLabel("<html>Class Type : <font color='white'>"+classtype+"</font></html>");
        Label8.setBounds(78, 407, 560, 50);
        Label8.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Label8.setHorizontalAlignment(SwingConstants.RIGHT);
        Label8.setForeground(Color.CYAN);
        add(Label8);

        JLabel Label9=new JLabel("<html>Total Members : <font color='white'>"+totalmembers+"</font></html>");
        Label9.setBounds(78, 457, 560, 50);
        Label9.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Label9.setHorizontalAlignment(SwingConstants.LEFT);
        Label9.setForeground(Color.CYAN);
        add(Label9);

        JLabel Label10=new JLabel(dateandtime);
        Label10.setBounds(78, 457, 560, 50);
        Label10.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Label10.setHorizontalAlignment(SwingConstants.RIGHT);
        Label10.setForeground(Color.CYAN);
        add(Label10);

        String revisedticketfare="₹"+totalticketfare.substring(3)+"/-";

        JLabel Label11=new JLabel("<html>Total Ticket Fare : <font color='white'>"+revisedticketfare+"</font></html>");
        Label11.setBounds(28, 507, 660, 50);
        Label11.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Label11.setHorizontalAlignment(SwingConstants.CENTER);
        Label11.setForeground(Color.CYAN);
        add(Label11);

        JLabel Label12=new JLabel("( Journey should commence within 1 hour )");
        Label12.setBounds(28, 557, 660, 50);
        Label12.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        Label12.setHorizontalAlignment(SwingConstants.CENTER);
        Label12.setForeground(Color.RED);
        add(Label12);

        ImageIcon ImageIcon3 = new ImageIcon("assets/back.png");
        Image Image3=ImageIcon3.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon4=new ImageIcon(Image3);

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
            new UserMyBookings(username);
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        requestFocusInWindow();
    }

    public static void main(String[] args)
    {
        new Ticket("","","","","","","","");
    }
}
