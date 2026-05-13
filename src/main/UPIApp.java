import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.border.Border;

public class UPIApp extends JFrame
{
    float floattotalticketfare,floataccountbalance,floatrevisedaccountbalance;
    String username,linename,teno,route,tickettype,classtype,totalmembers,totalticketfare,dateandtime,upino,upipin,accountbalance,stringrevisedaccountbalance;
    JPasswordField UPIPINTextField1,UPIPINTextField2,UPIPINTextField3,UPIPINTextField4;
    JButton PayButton,SubmitButton,BackButton;

    UPIApp(String username,String linename,String teno,String route,String tickettype,String classtype,String totalmembers,String totalticketfare,String dateandtime, String upino)
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
        this.upino=upino;
        setTitle("UPI Application");
        setSize(500,700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        JLabel Label1=new JLabel("|| UPI App Interface ||");
        Label1.setBounds(100, 0, 300, 50);
        Label1.setFont(new Font("Georgia", Font.BOLD, 25));
        Label1.setForeground(Color.BLACK);
        add(Label1);

        JLabel Label2=new JLabel();
        Label2.setBounds(0, 0, 484, 50);
        Label2.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        add(Label2);

        ImageIcon ImageIcon1 = new ImageIcon("assets/trainease_2.png");
        Image Image1=ImageIcon1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon2=new ImageIcon(Image1);
        JLabel ImageLabel1=new JLabel(ImageIcon2);
        ImageLabel1.setBounds(180, 120, 120, 120);
        add(ImageLabel1);

        JLabel Label3=new JLabel("Paying TrainEase");
        Label3.setBounds(0, 230, 484, 50);
        Label3.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Label3.setHorizontalAlignment(JLabel.CENTER);
        Label3.setForeground(Color.BLACK);
        add(Label3);

        JLabel Label4=new JLabel("Banking name: TRAINEASE");
        Label4.setBounds(0, 260, 484, 50);
        Label4.setFont(new Font("Times New Roman", Font.BOLD, 20));
        Label4.setHorizontalAlignment(JLabel.CENTER);
        Label4.setForeground(Color.BLACK);
        add(Label4);

        JLabel Label5=new JLabel("₹"+totalticketfare);
        Label5.setBounds(0, 330, 484, 50);
        Label5.setFont(new Font("Times New Roman", Font.BOLD, 50));
        Label5.setHorizontalAlignment(JLabel.CENTER);
        Label5.setForeground(Color.BLACK);
        add(Label5);

        PayButton=new JButton("Pay ₹"+totalticketfare);
        PayButton.setBounds(50, 480, 384, 40);
        PayButton.setFont(new Font("Times New Roman", Font.BOLD,20));
        PayButton.setHorizontalAlignment(JButton.CENTER);
        PayButton.setBackground(Color.BLUE);
        PayButton.setForeground(Color.WHITE);
        add(PayButton);
        PayButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Border Border1=PayButton.getBorder();

        PayButton.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent me)
            {

            }
            @Override
            public void mousePressed(MouseEvent me)
            {

            }
            @Override
            public void mouseReleased(MouseEvent me)
            {

            }
            @Override
            public void mouseEntered(MouseEvent me)
            {
                PayButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
            }
            @Override
            public void mouseExited(MouseEvent me)
            {
                PayButton.setBorder(Border1);
            }
        });

        ImageIcon ImageIcon3 = new ImageIcon("assets/upi.png");
        Image Image2=ImageIcon3.getImage().getScaledInstance(250, 89, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon4=new ImageIcon(Image2);
        JLabel ImageLabel2=new JLabel(ImageIcon4);
        ImageLabel2.setBounds(0, 530, 484, 89);
        ImageLabel2.setHorizontalAlignment(JLabel.CENTER);
        add(ImageLabel2);

        JLabel Label6=new JLabel("ABCD Bank");
        Label6.setBounds(10, 60, 200, 30);
        Label6.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Label6.setForeground(Color.BLACK);
        add(Label6);
        Label6.setVisible(false);

        JLabel Label7=new JLabel();
        Label7.setBounds(10, 85, 200, 30);
        Label7.setFont(new Font("Times New Roman", Font.BOLD, 27));
        Label7.setForeground(Color.BLACK);
        add(Label7);
        Label7.setVisible(false);

        ImageIcon ImageIcon5 = new ImageIcon("assets/upi.png");
        Image Image3=ImageIcon5.getImage().getScaledInstance(250, 89, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon6=new ImageIcon(Image3);
        JLabel ImageLabel3=new JLabel(ImageIcon6);
        ImageLabel3.setBounds(270, 40, 250, 89);
        add(ImageLabel3);
        ImageLabel3.setVisible(false);

        JLabel Label8=new JLabel();
        Label8.setBounds(0, 125, 484, 65);
        Label8.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        add(Label8);
        Label8.setVisible(false);

        JLabel Label9=new JLabel("To:");
        Label9.setBounds(10, 130, 200, 30);
        Label9.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        Label9.setForeground(Color.BLACK);
        add(Label9);
        Label9.setVisible(false);

        JLabel Label10=new JLabel("Sending:");
        Label10.setBounds(10, 155, 200, 30);
        Label10.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        Label10.setForeground(Color.BLACK);
        add(Label10);
        Label10.setVisible(false);

        JLabel Label11=new JLabel("TRAINEASE");
        Label11.setBounds(325, 130, 200, 30);
        Label11.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Label11.setForeground(Color.BLACK);
        add(Label11);
        Label11.setVisible(false);

        JLabel Label12=new JLabel("₹"+totalticketfare+".00");
        Label12.setBounds(325, 155, 200, 30);
        Label12.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Label12.setForeground(Color.BLACK);
        add(Label12);
        Label12.setVisible(false);

        JLabel Label13=new JLabel("Enter 4-DIGIT UPI PIN");
        Label13.setBounds(0, 230, 484, 30);
        Label13.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Label13.setHorizontalAlignment(JLabel.CENTER);
        Label13.setForeground(Color.BLACK);
        add(Label13);
        Label13.setVisible(false);

        UPIPINTextField1=new JPasswordField();
        UPIPINTextField1.setBounds(105, 305, 50, 50);
        UPIPINTextField1.setFont(new Font("Times New Roman", Font.PLAIN, 35));
        UPIPINTextField1.setForeground(Color.BLACK);
        UPIPINTextField1.setHorizontalAlignment(JPasswordField.CENTER);
        add(UPIPINTextField1);
        UPIPINTextField1.setVisible(false);

        UPIPINTextField1.addKeyListener(new KeyListener()
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
                    String s = new String(UPIPINTextField1.getPassword());
                    if(!s.isEmpty())
                    {
                        ke.consume();
                    }
                }
            }
            @Override
            public void keyPressed(KeyEvent ke)
            {
                char c=ke.getKeyChar();
                if(Character.isDigit(c))
                {
                    UPIPINTextField2.requestFocus();
                }
            }
            @Override
            public void keyReleased(KeyEvent ke)
            {

            }
        });

        UPIPINTextField2=new JPasswordField();
        UPIPINTextField2.setBounds(180, 305, 50, 50);
        UPIPINTextField2.setFont(new Font("Times New Roman", Font.PLAIN, 35));
        UPIPINTextField2.setForeground(Color.BLACK);
        UPIPINTextField2.setHorizontalAlignment(JPasswordField.CENTER);
        add(UPIPINTextField2);
        UPIPINTextField2.setVisible(false);

        UPIPINTextField2.addKeyListener(new KeyListener()
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
                    String s = new String(UPIPINTextField2.getPassword());
                    if(!s.isEmpty())
                    {
                        ke.consume();
                    }
                }
            }
            @Override
            public void keyPressed(KeyEvent ke)
            {
                String s = new String(UPIPINTextField2.getPassword());
                if(s.isEmpty())
                {
                    char c=ke.getKeyChar();
                    if(c == KeyEvent.VK_BACK_SPACE)
                    {
                        UPIPINTextField1.requestFocus();
                    }
                }
                char c=ke.getKeyChar();
                if(Character.isDigit(c))
                {
                    UPIPINTextField3.requestFocus();
                }
            }
            @Override
            public void keyReleased(KeyEvent ke)
            {

            }
        });

        UPIPINTextField3=new JPasswordField();
        UPIPINTextField3.setBounds(255, 305, 50, 50);
        UPIPINTextField3.setFont(new Font("Times New Roman", Font.PLAIN, 35));
        UPIPINTextField3.setForeground(Color.BLACK);
        UPIPINTextField3.setHorizontalAlignment(JPasswordField.CENTER);
        add(UPIPINTextField3);
        UPIPINTextField3.setVisible(false);

        UPIPINTextField3.addKeyListener(new KeyListener()
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
                    String s = new String(UPIPINTextField3.getPassword());
                    if(!s.isEmpty())
                    {
                        ke.consume();
                    }
                }
            }
            @Override
            public void keyPressed(KeyEvent ke)
            {
                String s = new String(UPIPINTextField3.getPassword());
                if(s.isEmpty())
                {
                    char c=ke.getKeyChar();
                    if(c == KeyEvent.VK_BACK_SPACE)
                    {
                        UPIPINTextField2.requestFocus();
                    }
                }
                char c=ke.getKeyChar();
                if(Character.isDigit(c))
                {
                    UPIPINTextField4.requestFocus();
                }
            }
            @Override
            public void keyReleased(KeyEvent ke)
            {

            }
        });

        UPIPINTextField4=new JPasswordField();
        UPIPINTextField4.setBounds(330, 305, 50, 50);
        UPIPINTextField4.setFont(new Font("Times New Roman", Font.PLAIN, 35));
        UPIPINTextField4.setForeground(Color.BLACK);
        UPIPINTextField4.setHorizontalAlignment(JPasswordField.CENTER);
        add(UPIPINTextField4);
        UPIPINTextField4.setVisible(false);

        UPIPINTextField4.addKeyListener(new KeyListener()
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
                    String s = new String(UPIPINTextField4.getPassword());
                    if(!s.isEmpty())
                    {
                        ke.consume();
                    }
                }
            }
            @Override
            public void keyPressed(KeyEvent ke)
            {
                String s = new String(UPIPINTextField4.getPassword());
                if(s.isEmpty())
                {
                    char c=ke.getKeyChar();
                    if(c == KeyEvent.VK_BACK_SPACE)
                    {
                        UPIPINTextField3.requestFocus();
                    }
                }
            }
            @Override
            public void keyReleased(KeyEvent ke)
            {

            }
        });

        UPIPINTextField4.addActionListener(_ -> SubmitButton.doClick());

        ImageIcon ImageIcon7 = new ImageIcon("assets/upi_tick.png");
        Image Image4=ImageIcon7.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon8=new ImageIcon(Image4);

        SubmitButton =new JButton(ImageIcon8);
        SubmitButton.setBounds(202, 530, 80, 80);
        SubmitButton.setFont(new Font("Georgia", Font.BOLD,20));
        SubmitButton.setBackground(Color.LIGHT_GRAY);
        SubmitButton.setForeground(Color.WHITE);
        SubmitButton.setOpaque(false);
        SubmitButton.setBorderPainted(false);
        add(SubmitButton);
        SubmitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        SubmitButton.setVisible(false);

        PayButton.addActionListener(_ ->
        {
            try
            {
                Database Data=new Database();
                String Query="select * from account where UPI_No='"+upino+"'";
                ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query);
                if(Resultset.next())
                {
                    upipin=Resultset.getString("UPI_PIN");
                    String s1=Resultset.getString("Account_No").substring(4);
                    Label7.setText("XXXX"+s1);
                    accountbalance=Resultset.getString("Account_Balance").substring(4);
                }
                ImageLabel1.setVisible(false);
                Label3.setVisible(false);
                Label4.setVisible(false);
                Label5.setVisible(false);
                PayButton.setVisible(false);
                ImageLabel2.setVisible(false);
                Label6.setVisible(true);
                Label7.setVisible(true);
                ImageLabel3.setVisible(true);
                Label8.setVisible(true);
                Label9.setVisible(true);
                Label10.setVisible(true);
                Label11.setVisible(true);
                Label12.setVisible(true);
                Label13.setVisible(true);
                UPIPINTextField1.setVisible(true);
                UPIPINTextField2.setVisible(true);
                UPIPINTextField3.setVisible(true);
                UPIPINTextField4.setVisible(true);
                SubmitButton.setVisible(true);
                UPIPINTextField1.requestFocus();
            }
            catch(SQLException e)
            {
                System.out.println("Error!");
            }
        });

        SubmitButton.addActionListener(_ ->
        {
            String pin1 = new String(UPIPINTextField1.getPassword());
            String pin2 = new String(UPIPINTextField2.getPassword());
            String pin3 = new String(UPIPINTextField3.getPassword());
            String pin4 = new String(UPIPINTextField4.getPassword());
            String pin=pin1+pin2+pin3+pin4;

            if(pin1.isEmpty() || pin2.isEmpty() || pin3.isEmpty() || pin4.isEmpty())
            {
                JOptionPane.showMessageDialog(new JFrame(),"Please provide the UPI PIN!");
                UPIPINTextField1.setText("");
                UPIPINTextField2.setText("");
                UPIPINTextField3.setText("");
                UPIPINTextField4.setText("");
                UPIPINTextField1.requestFocus();
            }
            else if(upipin.equals(pin))
            {
                floataccountbalance=Float.parseFloat(accountbalance);
                floattotalticketfare=Float.parseFloat(totalticketfare);
                floatrevisedaccountbalance=floataccountbalance-floattotalticketfare;
                String amt=String.valueOf(floatrevisedaccountbalance);
                stringrevisedaccountbalance="INR "+amt+"0";
                String s="Rs.";
                try
                {
                    Database Data=new Database();
                    String Query1="update account set Account_Balance='"+stringrevisedaccountbalance+"' where UPI_No='"+upino+"'";
                    Data.DatabaseStatement.executeUpdate(Query1);
                    String Query2="insert into bookings values('"+teno+"','"+route+"','"+tickettype+"','"+classtype+"','"+totalmembers+"','"+s+totalticketfare+"','"+dateandtime+"','"+username+"')";
                    Data.DatabaseStatement.executeUpdate(Query2);
                    setVisible(false);
                    new Ticket(teno,route,tickettype,classtype,totalmembers,dateandtime,s+totalticketfare,username);

                    String Query3="select * from registration where Username='"+username+"'";
                    ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query3);
                    if(Resultset.next())
                    {
                        String mn = Resultset.getString("MobileNo");
                        String Query4="insert into notification values('"+mn+"','"+dateandtime+"','Dear User! You have successfully booked the ticket. Visit the booking history to know more! Regards, Team TrainEase.')";
                        Data.DatabaseStatement.executeUpdate(Query4);
                    }
                    JOptionPane.showMessageDialog(new JFrame(), "Ticket Booked Successfully!");
                }
                catch(HeadlessException | SQLException e)
                {
                    System.out.println("Error!");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(new JFrame(),"Incorrect UPI PIN!");
                UPIPINTextField1.setText("");
                UPIPINTextField2.setText("");
                UPIPINTextField3.setText("");
                UPIPINTextField4.setText("");
                UPIPINTextField1.requestFocus();
            }
        });

        ImageIcon ImageIcon9 = new ImageIcon("assets/back.png");
        Image Image5=ImageIcon9.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon10=new ImageIcon(Image5);

        BackButton =new JButton(ImageIcon10);
        BackButton.setBounds(5, 5, 60, 40);
        BackButton.setFont(new Font("Georgia", Font.BOLD,20));
        BackButton.setBackground(Color.LIGHT_GRAY);
        BackButton.setForeground(Color.WHITE);
        add(BackButton);
        BackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        BackButton.addActionListener(_ ->
        {
            setVisible(false);
            new Payment(username,linename,teno,route,tickettype,classtype,totalmembers,totalticketfare,dateandtime);
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        requestFocusInWindow();
    }

    public static void main(String[] args)
    {
        new UPIApp("","","","","","","","","","");
    }
}
