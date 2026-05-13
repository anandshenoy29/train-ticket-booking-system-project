import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Payment extends JFrame
{
    String username,linename,teno,route,tickettype,classtype,totalmembers,totalticketfare,dateandtime;
    JTextField UPINumberTextField;
    JButton ProceedButton,BackButton;

    Payment(String username,String linename,String teno,String route,String tickettype,String classtype,String totalmembers,String totalticketfare,String dateandtime)
    {
        this.username=username;
        this.linename=linename;
        this.teno=teno;
        this.route=route;
        this.tickettype=tickettype;
        this.classtype=classtype;
        this.totalmembers=totalmembers;
        this.totalticketfare=totalticketfare;
        this.dateandtime=dateandtime;
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

        JLabel Label1=new JLabel("|| Payment Interface ||");
        Label1.setBounds(410, 180, 500, 50);
        Label1.setFont(new Font("Georgia", Font.BOLD, 35));
        Label1.setForeground(Color.YELLOW);
        add(Label1);

        JLabel Label2=new JLabel();
        Label2.setBounds(260, 265, 710, 390);
        Label2.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        add(Label2);

        JLabel Label3=new JLabel();
        Label3.setBounds(260, 335, 710, 320);
        Label3.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        add(Label3);

        JLabel Label4=new JLabel("Pay via UPI");
        Label4.setBounds(522, 275, 270, 50);
        Label4.setFont(new Font("Georgia", Font.BOLD, 32));
        Label4.setForeground(Color.CYAN);
        add(Label4);

        JLabel UPINumberLabel=new JLabel("Enter UPI No. :");
        UPINumberLabel.setBounds(408, 370, 200, 30);
        UPINumberLabel.setFont(new Font("Georgia", Font.PLAIN, 28));
        UPINumberLabel.setForeground(Color.WHITE);
        add(UPINumberLabel);

        UPINumberTextField=new JTextField();
        UPINumberTextField.setBounds(622, 370, 200, 30);
        UPINumberTextField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        UPINumberTextField.setForeground(Color.BLACK);
        add(UPINumberTextField);

        UPINumberTextField.addActionListener(_ -> ProceedButton.doClick());

        UPINumberTextField.addKeyListener(new KeyListener()
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
                    String s=UPINumberTextField.getText();
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

            }
        });

        ProceedButton=new JButton("Proceed to Pay ₹"+totalticketfare);
        ProceedButton.setBounds(490, 450, 250, 40);
        ProceedButton.setFont(new Font("Times New Roman", Font.BOLD,24));
        ProceedButton.setBackground(Color.GREEN);
        ProceedButton.setForeground(Color.BLACK);
        add(ProceedButton);
        ProceedButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        ProceedButton.addActionListener(_ ->
        {
            String upino= UPINumberTextField.getText();

            if(upino.isEmpty())
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please provide the UPI number!");
                UPINumberTextField.requestFocus();
            }
            else
            {
                setVisible(false);
                new UPIApp(username,linename,teno,route,tickettype,classtype,totalmembers,totalticketfare,dateandtime,upino);
            }
        });

        ImageIcon ImageIcon3 = new ImageIcon("assets/upi_apps.png");
        Image Image2=ImageIcon3.getImage().getScaledInstance(250, 137, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon4=new ImageIcon(Image2);
        JLabel ImageLabel2=new JLabel(ImageIcon4);
        ImageLabel2.setBounds(260, 500, 710, 137);
        ImageLabel2.setHorizontalAlignment(JLabel.CENTER);
        add(ImageLabel2);

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
            new UserBookTickets(username,linename);
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        UPINumberTextField.requestFocusInWindow();
    }

    public static void main(String[] args)
    {
        new Payment("","","","","","","","","");
    }
}
