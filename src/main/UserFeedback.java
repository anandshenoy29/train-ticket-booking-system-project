import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class UserFeedback extends JFrame
{
    String username;
    JComboBox<String> NavigationComboBox, BookingComboBox, SupportComboBox, PerformanceComboBox;
    JButton NextButton, SendButton, BackButton;

    UserFeedback(String username)
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

        JLabel Label1=new JLabel("|| Feedback ||");
        Label1.setBounds(492, 185, 250, 30);
        Label1.setFont(new Font("Georgia", Font.BOLD, 35));
        Label1.setForeground(Color.YELLOW);
        add(Label1);

        JTextArea TextArea1=new JTextArea();
        TextArea1.setBounds(264, 250, 700, 135);
        TextArea1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        TextArea1.setBackground(Color.LIGHT_GRAY);
        TextArea1.setForeground(Color.BLACK);
        TextArea1.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
        TextArea1.setLineWrap(true);
        TextArea1.setWrapStyleWord(true);
        TextArea1.append(" Dear "+username+",");
        TextArea1.append("\n Thank you for using our service! We value your feedback as it         helps us to improve our services and enhance your experience.        Kindly take a few moments to share your thoughts with us.");
        add(TextArea1);
        TextArea1.setEditable(false);

        JLabel NavigationLabel1=new JLabel("How would you rate the navigation");
        NavigationLabel1.setBounds(262, 420, 500, 30);
        NavigationLabel1.setFont(new Font("Georgia", Font.BOLD, 22));
        NavigationLabel1.setForeground(Color.WHITE);
        add(NavigationLabel1);

        JLabel NavigationLabel2=new JLabel("experience throughout the application?");
        NavigationLabel2.setBounds(262, 450, 500, 30);
        NavigationLabel2.setFont(new Font("Georgia", Font.BOLD, 22));
        NavigationLabel2.setForeground(Color.WHITE);
        add(NavigationLabel2);

        String[] NavigationComboBoxElements={
                "Very Easy",
                "Easy",
                "Neutral",
                "Difficult",
                "Very Difficult"
        };

        NavigationComboBox=new JComboBox<>(NavigationComboBoxElements);
        NavigationComboBox.setBounds(762, 425, 200, 30);
        NavigationComboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
        NavigationComboBox.setForeground(Color.BLACK);
        add(NavigationComboBox);
        NavigationComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel BookingLabel1=new JLabel("How satisfied are you with the");
        BookingLabel1.setBounds(262, 420, 500, 30);
        BookingLabel1.setFont(new Font("Georgia", Font.BOLD, 22));
        BookingLabel1.setForeground(Color.WHITE);
        add(BookingLabel1);
        BookingLabel1.setVisible(false);

        JLabel BookingLabel2=new JLabel("booking process of the application?");
        BookingLabel2.setBounds(262, 450, 500, 30);
        BookingLabel2.setFont(new Font("Georgia", Font.BOLD, 22));
        BookingLabel2.setForeground(Color.WHITE);
        add(BookingLabel2);
        BookingLabel2.setVisible(false);

        String[] BookingComboBoxElements={
                "Very Satisfied",
                "Satisfied",
                "Neutral",
                "Dissatisfied",
                "Very Dissatisfied"
        };

        BookingComboBox=new JComboBox<>(BookingComboBoxElements);
        BookingComboBox.setBounds(762, 425, 200, 30);
        BookingComboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
        BookingComboBox.setForeground(Color.BLACK);
        add(BookingComboBox);
        BookingComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        BookingComboBox.setVisible(false);

        JLabel SupportLabel1=new JLabel("How would you rate the customer");
        SupportLabel1.setBounds(262, 420, 500, 30);
        SupportLabel1.setFont(new Font("Georgia", Font.BOLD, 22));
        SupportLabel1.setForeground(Color.WHITE);
        add(SupportLabel1);
        SupportLabel1.setVisible(false);

        JLabel SupportLabel2=new JLabel("support assistance by the application?");
        SupportLabel2.setBounds(262, 450, 500, 30);
        SupportLabel2.setFont(new Font("Georgia", Font.BOLD, 22));
        SupportLabel2.setForeground(Color.WHITE);
        add(SupportLabel2);
        SupportLabel2.setVisible(false);

        String[] SupportComboBoxElements={
                "Excellent",
                "Good",
                "Average",
                "Poor",
                "Very Poor"
        };

        SupportComboBox=new JComboBox<>(SupportComboBoxElements);
        SupportComboBox.setBounds(762, 425, 200, 30);
        SupportComboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
        SupportComboBox.setForeground(Color.BLACK);
        add(SupportComboBox);
        SupportComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        SupportComboBox.setVisible(false);

        JLabel PerformanceLabel1=new JLabel("How would you rate the overall");
        PerformanceLabel1.setBounds(262, 420, 500, 30);
        PerformanceLabel1.setFont(new Font("Georgia", Font.BOLD, 22));
        PerformanceLabel1.setForeground(Color.WHITE);
        add(PerformanceLabel1);
        PerformanceLabel1.setVisible(false);

        JLabel PerformanceLabel2=new JLabel("performance of the application?");
        PerformanceLabel2.setBounds(262, 450, 500, 30);
        PerformanceLabel2.setFont(new Font("Georgia", Font.BOLD, 22));
        PerformanceLabel2.setForeground(Color.WHITE);
        add(PerformanceLabel2);
        PerformanceLabel2.setVisible(false);

        String[] PerformanceComboBoxElements={
                "Excellent",
                "Good",
                "Average",
                "Poor",
                "Very Poor"
        };

        PerformanceComboBox=new JComboBox<>(PerformanceComboBoxElements);
        PerformanceComboBox.setBounds(762, 425, 200, 30);
        PerformanceComboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
        PerformanceComboBox.setForeground(Color.BLACK);
        add(PerformanceComboBox);
        PerformanceComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        PerformanceComboBox.setVisible(false);

        ImageIcon ImageIcon3 = new ImageIcon("assets/next.png");
        Image Image2=ImageIcon3.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon4=new ImageIcon(Image2);

        NextButton =new JButton(ImageIcon4);
        NextButton.setBounds(585, 520, 60, 60);
        NextButton.setFont(new Font("Georgia", Font.BOLD,20));
        NextButton.setBackground(Color.BLUE);
        NextButton.setForeground(Color.WHITE);
        NextButton.setOpaque(false);
        NextButton.setBorderPainted(false);
        add(NextButton);
        NextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        NextButton.addActionListener(_ ->
        {
            if(NavigationComboBox.isVisible())
            {
                NavigationLabel1.setVisible(false);
                NavigationLabel2.setVisible(false);
                NavigationComboBox.setVisible(false);
                BookingLabel1.setVisible(true);
                BookingLabel2.setVisible(true);
                BookingComboBox.setVisible(true);
            }
            else if(BookingComboBox.isVisible())
            {
                BookingLabel1.setVisible(false);
                BookingLabel2.setVisible(false);
                BookingComboBox.setVisible(false);
                SupportLabel1.setVisible(true);
                SupportLabel2.setVisible(true);
                SupportComboBox.setVisible(true);
            }
            else if(SupportComboBox.isVisible())
            {
                SupportLabel1.setVisible(false);
                SupportLabel2.setVisible(false);
                SupportComboBox.setVisible(false);
                PerformanceLabel1.setVisible(true);
                PerformanceLabel2.setVisible(true);
                PerformanceComboBox.setVisible(true);
                NextButton.setVisible(false);
                SendButton.setVisible(true);
            }
        });

        ImageIcon ImageIcon5 = new ImageIcon("assets/send.png");
        Image Image3=ImageIcon5.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon6=new ImageIcon(Image3);

        SendButton =new JButton(ImageIcon6);
        SendButton.setBounds(585, 520, 60, 60);
        SendButton.setFont(new Font("Georgia", Font.BOLD,20));
        SendButton.setBackground(Color.BLUE);
        SendButton.setForeground(Color.WHITE);
        SendButton.setOpaque(false);
        SendButton.setBorderPainted(false);
        add(SendButton);
        SendButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        SendButton.setVisible(false);

        SendButton.addActionListener(_ ->
        {
            String s1=(String) NavigationComboBox.getSelectedItem();
            String s2=(String) BookingComboBox.getSelectedItem();
            String s3=(String) SupportComboBox.getSelectedItem();
            String s4=(String) PerformanceComboBox.getSelectedItem();

            DateTimeFormatter DateFormat=DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDateTime Date= LocalDateTime.now();
            DateTimeFormatter TimeFormat=DateTimeFormatter.ofPattern("HH:mm");
            LocalDateTime Time=LocalDateTime.now();
            String dateandtime=DateFormat.format(Date)+" "+TimeFormat.format(Time);

            try
            {
                Database Data=new Database();
                String Query1="select * from feedbacks where Username='"+username+"'";
                ResultSet Resultset1=Data.DatabaseStatement.executeQuery(Query1);
                if(Resultset1.next())
                {
                    String Query2 = "delete from feedbacks where Username='" + username + "'";
                    Data.DatabaseStatement.executeUpdate(Query2);
                }
                String Query3="insert into feedbacks values('"+username+"','"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+dateandtime+"')";
                Data.DatabaseStatement.executeUpdate(Query3);
                String Query4="select * from registration where Username='"+username+"'";
                ResultSet ResultSet2=Data.DatabaseStatement.executeQuery(Query4);
                if(ResultSet2.next())
                {
                    String mn = ResultSet2.getString("MobileNo");
                    String Query5="insert into notification values('"+mn+"','"+dateandtime+"','Dear User! Thank you for your valuable feedback! We appreciate your input and will use it to improve our services. Regards, Team TrainEase.')";
                    Data.DatabaseStatement.executeUpdate(Query5);
                }
                JOptionPane.showMessageDialog(new JFrame(),"Thanks for your valuable feedback!");
                setVisible(false);
                new UserMain(username);
            }
            catch(HeadlessException | SQLException e)
            {
                System.out.println("Error!");
            }
        });

        ImageIcon ImageIcon7 = new ImageIcon("assets/back.png");
        Image Image4=ImageIcon7.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon8=new ImageIcon(Image4);

        BackButton =new JButton(ImageIcon8);
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
        new UserFeedback("");
    }
}
