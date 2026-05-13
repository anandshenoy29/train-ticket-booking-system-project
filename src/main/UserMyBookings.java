import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class UserMyBookings extends JFrame
{
    String username;
    JButton ViewButton1,ViewButton2,ViewButton3,ViewButton4,ViewButton5,ViewButton6,ViewButton7,ViewButton8,ViewButton9,ViewButton10,PrintButton,BackButton;
    
    UserMyBookings(String username)
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

        JLabel Label1=new JLabel("|| Ticket Booking History ||");
        Label1.setBounds(371, 170, 500, 50);
        Label1.setFont(new Font("Georgia", Font.BOLD, 35));
        Label1.setForeground(Color.YELLOW);
        add(Label1);

        JLabel Label2=new JLabel("✔  Recent Bookings  ✔");
        Label2.setBounds(470, 230, 300, 40);
        Label2.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Label2.setForeground(Color.WHITE);
        add(Label2);

        JTable BookingTable=new JTable();
        BookingTable.setBounds(32, 290, 1100, 334);
        BookingTable.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        BookingTable.setBackground(Color.WHITE);
        BookingTable.setForeground(Color.BLACK);
        BookingTable.setRowHeight(30);
        add(BookingTable);
        BookingTable.setEnabled(false);

        JTableHeader BookingTableHeader=BookingTable.getTableHeader();
        BookingTableHeader.setFont(new Font("Georgia", Font.BOLD, 15));
        BookingTableHeader.setPreferredSize(new Dimension(0,30));
        BookingTableHeader.setBackground(Color.BLACK);
        BookingTableHeader.setForeground(Color.WHITE);
        BookingTableHeader.setEnabled(false);

        DefaultTableCellRenderer BookingTableCell=new DefaultTableCellRenderer();
        BookingTableCell.setHorizontalAlignment(JLabel.CENTER);

        JScrollPane BookingTableScrollPane=new JScrollPane(BookingTable);
        BookingTableScrollPane.setBounds(32, 290, 1100, 334);
        add(BookingTableScrollPane);

        try
        {
            Database Data=new Database();
            String Query="select TE_No,Route,TicketType,ClassType,TotalMembers,TotalTicketFare,TicketDateTime from bookings where Username='"+username+"' order by TE_NO desc limit 10";
            ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query);
            BookingTable.setModel(buildTableModel(Resultset));
            BookingTable.getColumnModel().getColumn(0).setCellRenderer(BookingTableCell);
            BookingTable.getColumnModel().getColumn(1).setCellRenderer(BookingTableCell);
            BookingTable.getColumnModel().getColumn(2).setCellRenderer(BookingTableCell);
            BookingTable.getColumnModel().getColumn(3).setCellRenderer(BookingTableCell);
            BookingTable.getColumnModel().getColumn(4).setCellRenderer(BookingTableCell);
            BookingTable.getColumnModel().getColumn(5).setCellRenderer(BookingTableCell);
            BookingTable.getColumnModel().getColumn(6).setCellRenderer(BookingTableCell);
            BookingTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            BookingTable.getColumnModel().getColumn(1).setPreferredWidth(120);
            BookingTable.getColumnModel().getColumn(2).setPreferredWidth(5);
            BookingTable.getColumnModel().getColumn(3).setPreferredWidth(5);
            BookingTable.getColumnModel().getColumn(4).setPreferredWidth(5);
            BookingTable.getColumnModel().getColumn(5).setPreferredWidth(15);
            BookingTable.getColumnModel().getColumn(6).setPreferredWidth(25);
        }
        catch(SQLException e)
        {
            System.out.println("Error!");
        }

        ImageIcon ImageIcon3 = new ImageIcon("assets/view.png");
        Image Image2=ImageIcon3.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon4=new ImageIcon(Image2);

        ViewButton1=new JButton(ImageIcon4);
        ViewButton1.setBounds(1142, 320, 55, 30);
        ViewButton1.setFont(new Font("Georgia", Font.BOLD,20));
        ViewButton1.setBackground(Color.BLUE);
        ViewButton1.setForeground(Color.WHITE);
        ViewButton1.setOpaque(false);
        ViewButton1.setBorderPainted(false);
        add(ViewButton1);
        ViewButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ViewButton1.setVisible(false);

        ViewButton1.addActionListener(_ ->
        {
            String s1= (String) BookingTable.getValueAt(0,0);
            String s2= (String) BookingTable.getValueAt(0,1);
            String s3= (String) BookingTable.getValueAt(0,2);
            String s4= (String) BookingTable.getValueAt(0,3);
            String s5= (String) BookingTable.getValueAt(0,4);
            String s6= (String) BookingTable.getValueAt(0,5);
            String s7= (String) BookingTable.getValueAt(0,6);

            setVisible(false);
            new Ticket(s1,s2,s3,s4,s5,s7,s6,username);
        });

        ImageIcon ImageIcon5 = new ImageIcon("assets/view.png");
        Image Image3=ImageIcon5.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon6=new ImageIcon(Image3);

        ViewButton2=new JButton(ImageIcon6);
        ViewButton2.setBounds(1142, 350, 55, 30);
        ViewButton2.setFont(new Font("Georgia", Font.BOLD,20));
        ViewButton2.setBackground(Color.BLUE);
        ViewButton2.setForeground(Color.WHITE);
        ViewButton2.setOpaque(false);
        ViewButton2.setBorderPainted(false);
        add(ViewButton2);
        ViewButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ViewButton2.setVisible(false);

        ViewButton2.addActionListener(_ ->
        {
            String s1= (String) BookingTable.getValueAt(1,0);
            String s2= (String) BookingTable.getValueAt(1,1);
            String s3= (String) BookingTable.getValueAt(1,2);
            String s4= (String) BookingTable.getValueAt(1,3);
            String s5= (String) BookingTable.getValueAt(1,4);
            String s6= (String) BookingTable.getValueAt(1,5);
            String s7= (String) BookingTable.getValueAt(1,6);

            setVisible(false);
            new Ticket(s1,s2,s3,s4,s5,s7,s6,username);
        });

        ImageIcon ImageIcon7 = new ImageIcon("assets/view.png");
        Image Image4=ImageIcon7.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon8=new ImageIcon(Image4);

        ViewButton3=new JButton(ImageIcon8);
        ViewButton3.setBounds(1142, 380, 55, 30);
        ViewButton3.setFont(new Font("Georgia", Font.BOLD,20));
        ViewButton3.setBackground(Color.BLUE);
        ViewButton3.setForeground(Color.WHITE);
        ViewButton3.setOpaque(false);
        ViewButton3.setBorderPainted(false);
        add(ViewButton3);
        ViewButton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ViewButton3.setVisible(false);

        ViewButton3.addActionListener(_ ->
        {
            String s1= (String) BookingTable.getValueAt(2,0);
            String s2= (String) BookingTable.getValueAt(2,1);
            String s3= (String) BookingTable.getValueAt(2,2);
            String s4= (String) BookingTable.getValueAt(2,3);
            String s5= (String) BookingTable.getValueAt(2,4);
            String s6= (String) BookingTable.getValueAt(2,5);
            String s7= (String) BookingTable.getValueAt(2,6);

            setVisible(false);
            new Ticket(s1,s2,s3,s4,s5,s7,s6,username);
        });

        ImageIcon ImageIcon9 = new ImageIcon("assets/view.png");
        Image Image5=ImageIcon9.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon10=new ImageIcon(Image5);

        ViewButton4=new JButton(ImageIcon10);
        ViewButton4.setBounds(1142, 410, 55, 30);
        ViewButton4.setFont(new Font("Georgia", Font.BOLD,20));
        ViewButton4.setBackground(Color.BLUE);
        ViewButton4.setForeground(Color.WHITE);
        ViewButton4.setOpaque(false);
        ViewButton4.setBorderPainted(false);
        add(ViewButton4);
        ViewButton4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ViewButton4.setVisible(false);

        ViewButton4.addActionListener(_ ->
        {
            String s1= (String) BookingTable.getValueAt(3,0);
            String s2= (String) BookingTable.getValueAt(3,1);
            String s3= (String) BookingTable.getValueAt(3,2);
            String s4= (String) BookingTable.getValueAt(3,3);
            String s5= (String) BookingTable.getValueAt(3,4);
            String s6= (String) BookingTable.getValueAt(3,5);
            String s7= (String) BookingTable.getValueAt(3,6);

            setVisible(false);
            new Ticket(s1,s2,s3,s4,s5,s7,s6,username);
        });

        ImageIcon ImageIcon11 = new ImageIcon("assets/view.png");
        Image Image6=ImageIcon11.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon12=new ImageIcon(Image6);

        ViewButton5=new JButton(ImageIcon12);
        ViewButton5.setBounds(1142, 440, 55, 30);
        ViewButton5.setFont(new Font("Georgia", Font.BOLD,20));
        ViewButton5.setBackground(Color.BLUE);
        ViewButton5.setForeground(Color.WHITE);
        ViewButton5.setOpaque(false);
        ViewButton5.setBorderPainted(false);
        add(ViewButton5);
        ViewButton5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ViewButton5.setVisible(false);

        ViewButton5.addActionListener(_ ->
        {
            String s1= (String) BookingTable.getValueAt(4,0);
            String s2= (String) BookingTable.getValueAt(4,1);
            String s3= (String) BookingTable.getValueAt(4,2);
            String s4= (String) BookingTable.getValueAt(4,3);
            String s5= (String) BookingTable.getValueAt(4,4);
            String s6= (String) BookingTable.getValueAt(4,5);
            String s7= (String) BookingTable.getValueAt(4,6);

            setVisible(false);
            new Ticket(s1,s2,s3,s4,s5,s7,s6,username);
        });

        ImageIcon ImageIcon13 = new ImageIcon("assets/view.png");
        Image Image7=ImageIcon13.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon14=new ImageIcon(Image7);

        ViewButton6=new JButton(ImageIcon14);
        ViewButton6.setBounds(1142, 470, 55, 30);
        ViewButton6.setFont(new Font("Georgia", Font.BOLD,20));
        ViewButton6.setBackground(Color.BLUE);
        ViewButton6.setForeground(Color.WHITE);
        ViewButton6.setOpaque(false);
        ViewButton6.setBorderPainted(false);
        add(ViewButton6);
        ViewButton6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ViewButton6.setVisible(false);

        ViewButton6.addActionListener(_ ->
        {
            String s1= (String) BookingTable.getValueAt(5,0);
            String s2= (String) BookingTable.getValueAt(5,1);
            String s3= (String) BookingTable.getValueAt(5,2);
            String s4= (String) BookingTable.getValueAt(5,3);
            String s5= (String) BookingTable.getValueAt(5,4);
            String s6= (String) BookingTable.getValueAt(5,5);
            String s7= (String) BookingTable.getValueAt(5,6);

            setVisible(false);
            new Ticket(s1,s2,s3,s4,s5,s7,s6,username);
        });

        ImageIcon ImageIcon15 = new ImageIcon("assets/view.png");
        Image Image8=ImageIcon15.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon16=new ImageIcon(Image8);

        ViewButton7=new JButton(ImageIcon16);
        ViewButton7.setBounds(1142, 500, 55, 30);
        ViewButton7.setFont(new Font("Georgia", Font.BOLD,20));
        ViewButton7.setBackground(Color.BLUE);
        ViewButton7.setForeground(Color.WHITE);
        ViewButton7.setOpaque(false);
        ViewButton7.setBorderPainted(false);
        add(ViewButton7);
        ViewButton7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ViewButton7.setVisible(false);

        ViewButton7.addActionListener(_ ->
        {
            String s1= (String) BookingTable.getValueAt(6,0);
            String s2= (String) BookingTable.getValueAt(6,1);
            String s3= (String) BookingTable.getValueAt(6,2);
            String s4= (String) BookingTable.getValueAt(6,3);
            String s5= (String) BookingTable.getValueAt(6,4);
            String s6= (String) BookingTable.getValueAt(6,5);
            String s7= (String) BookingTable.getValueAt(6,6);

            setVisible(false);
            new Ticket(s1,s2,s3,s4,s5,s7,s6,username);
        });

        ImageIcon ImageIcon17 = new ImageIcon("assets/view.png");
        Image Image9=ImageIcon17.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon18=new ImageIcon(Image9);

        ViewButton8=new JButton(ImageIcon18);
        ViewButton8.setBounds(1142, 530, 55, 30);
        ViewButton8.setFont(new Font("Georgia", Font.BOLD,20));
        ViewButton8.setBackground(Color.BLUE);
        ViewButton8.setForeground(Color.WHITE);
        ViewButton8.setOpaque(false);
        ViewButton8.setBorderPainted(false);
        add(ViewButton8);
        ViewButton8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ViewButton8.setVisible(false);

        ViewButton8.addActionListener(_ ->
        {
            String s1= (String) BookingTable.getValueAt(7,0);
            String s2= (String) BookingTable.getValueAt(7,1);
            String s3= (String) BookingTable.getValueAt(7,2);
            String s4= (String) BookingTable.getValueAt(7,3);
            String s5= (String) BookingTable.getValueAt(7,4);
            String s6= (String) BookingTable.getValueAt(7,5);
            String s7= (String) BookingTable.getValueAt(7,6);

            setVisible(false);
            new Ticket(s1,s2,s3,s4,s5,s7,s6,username);
        });

        ImageIcon ImageIcon19 = new ImageIcon("assets/view.png");
        Image Image10=ImageIcon19.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon20=new ImageIcon(Image10);

        ViewButton9=new JButton(ImageIcon20);
        ViewButton9.setBounds(1142, 560, 55, 30);
        ViewButton9.setFont(new Font("Georgia", Font.BOLD,20));
        ViewButton9.setBackground(Color.BLUE);
        ViewButton9.setForeground(Color.WHITE);
        ViewButton9.setOpaque(false);
        ViewButton9.setBorderPainted(false);
        add(ViewButton9);
        ViewButton9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ViewButton9.setVisible(false);

        ViewButton9.addActionListener(_ ->
        {
            String s1= (String) BookingTable.getValueAt(8,0);
            String s2= (String) BookingTable.getValueAt(8,1);
            String s3= (String) BookingTable.getValueAt(8,2);
            String s4= (String) BookingTable.getValueAt(8,3);
            String s5= (String) BookingTable.getValueAt(8,4);
            String s6= (String) BookingTable.getValueAt(8,5);
            String s7= (String) BookingTable.getValueAt(8,6);

            setVisible(false);
            new Ticket(s1,s2,s3,s4,s5,s7,s6,username);
        });

        ImageIcon ImageIcon21 = new ImageIcon("assets/view.png");
        Image Image11=ImageIcon21.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon22=new ImageIcon(Image11);

        ViewButton10=new JButton(ImageIcon22);
        ViewButton10.setBounds(1142, 590, 55, 30);
        ViewButton10.setFont(new Font("Georgia", Font.BOLD,20));
        ViewButton10.setBackground(Color.BLUE);
        ViewButton10.setForeground(Color.WHITE);
        ViewButton10.setOpaque(false);
        ViewButton10.setBorderPainted(false);
        add(ViewButton10);
        ViewButton10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ViewButton10.setVisible(false);

        ViewButton10.addActionListener(_ ->
        {
            String s1= (String) BookingTable.getValueAt(9,0);
            String s2= (String) BookingTable.getValueAt(9,1);
            String s3= (String) BookingTable.getValueAt(9,2);
            String s4= (String) BookingTable.getValueAt(9,3);
            String s5= (String) BookingTable.getValueAt(9,4);
            String s6= (String) BookingTable.getValueAt(9,5);
            String s7= (String) BookingTable.getValueAt(9,6);

            setVisible(false);
            new Ticket(s1,s2,s3,s4,s5,s7,s6,username);
        });

        int rowcount=BookingTable.getRowCount();
        switch (rowcount) {
            case 1 -> ViewButton1.setVisible(true);
            case 2 -> {
                ViewButton1.setVisible(true);
                ViewButton2.setVisible(true);
            }
            case 3 -> {
                ViewButton1.setVisible(true);
                ViewButton2.setVisible(true);
                ViewButton3.setVisible(true);
            }
            case 4 -> {
                ViewButton1.setVisible(true);
                ViewButton2.setVisible(true);
                ViewButton3.setVisible(true);
                ViewButton4.setVisible(true);
            }
            case 5 -> {
                ViewButton1.setVisible(true);
                ViewButton2.setVisible(true);
                ViewButton3.setVisible(true);
                ViewButton4.setVisible(true);
                ViewButton5.setVisible(true);
            }
            case 6 -> {
                ViewButton1.setVisible(true);
                ViewButton2.setVisible(true);
                ViewButton3.setVisible(true);
                ViewButton4.setVisible(true);
                ViewButton5.setVisible(true);
                ViewButton6.setVisible(true);
            }
            case 7 -> {
                ViewButton1.setVisible(true);
                ViewButton2.setVisible(true);
                ViewButton3.setVisible(true);
                ViewButton4.setVisible(true);
                ViewButton5.setVisible(true);
                ViewButton6.setVisible(true);
                ViewButton7.setVisible(true);
            }
            case 8 -> {
                ViewButton1.setVisible(true);
                ViewButton2.setVisible(true);
                ViewButton3.setVisible(true);
                ViewButton4.setVisible(true);
                ViewButton5.setVisible(true);
                ViewButton6.setVisible(true);
                ViewButton7.setVisible(true);
                ViewButton8.setVisible(true);
            }
            case 9 -> {
                ViewButton1.setVisible(true);
                ViewButton2.setVisible(true);
                ViewButton3.setVisible(true);
                ViewButton4.setVisible(true);
                ViewButton5.setVisible(true);
                ViewButton6.setVisible(true);
                ViewButton7.setVisible(true);
                ViewButton8.setVisible(true);
                ViewButton9.setVisible(true);
            }
            case 10 -> {
                ViewButton1.setVisible(true);
                ViewButton2.setVisible(true);
                ViewButton3.setVisible(true);
                ViewButton4.setVisible(true);
                ViewButton5.setVisible(true);
                ViewButton6.setVisible(true);
                ViewButton7.setVisible(true);
                ViewButton8.setVisible(true);
                ViewButton9.setVisible(true);
                ViewButton10.setVisible(true);
            }
            default -> {
            }
        }

        ImageIcon ImageIcon23 = new ImageIcon("assets/print.png");
        Image Image12=ImageIcon23.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon24=new ImageIcon(Image12);

        PrintButton=new JButton(ImageIcon24);
        PrintButton.setBounds(585, 625, 60, 60);
        PrintButton.setFont(new Font("Georgia", Font.BOLD,20));
        PrintButton.setBackground(Color.BLUE);
        PrintButton.setForeground(Color.WHITE);
        PrintButton.setOpaque(false);
        PrintButton.setBorderPainted(false);
        add(PrintButton);
        PrintButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        PrintButton.addActionListener(_ ->
        {
            try
            {
                BookingTable.print();
            }
            catch(PrinterException pe)
            {
                System.out.println("Error!");
            }
        });

        ImageIcon ImageIcon25 = new ImageIcon("assets/back.png");
        Image Image13=ImageIcon25.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon26=new ImageIcon(Image13);

        BackButton =new JButton(ImageIcon26);
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

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException
    {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        String[] columnNames = new String[columnCount];
        for (int column = 1; column <= columnCount; column++) {
            columnNames[column - 1] = metaData.getColumnName(column);
        }
        java.util.ArrayList<Object[]> dataList = new java.util.ArrayList<>();
        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = rs.getObject(i);
            }
            dataList.add(row);
        }
        Object[][] data = new Object[dataList.size()][columnCount];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }
        return new DefaultTableModel(data, columnNames);
    }
    
    public static void main(String[] args)
    {
        new UserMyBookings("");
    }
}
