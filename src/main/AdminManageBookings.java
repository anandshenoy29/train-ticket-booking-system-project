import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class AdminManageBookings extends JFrame
{
    String username;
    JTextField SearchTextField;
    JButton PrintButton, BackButton;

    AdminManageBookings(String username)
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

        JLabel Label1=new JLabel("|| List of Bookings ||");
        Label1.setBounds(435, 185, 400, 50);
        Label1.setFont(new Font("Georgia", Font.BOLD, 35));
        Label1.setForeground(Color.YELLOW);
        add(Label1);

        JLabel Label2=new JLabel("Search Username :");
        Label2.setBounds(860, 290, 175, 30);
        Label2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        Label2.setForeground(Color.WHITE);
        add(Label2);

        SearchTextField =new JTextField();
        SearchTextField.setBounds(1035, 290, 150, 30);
        SearchTextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        SearchTextField.setForeground(Color.BLACK);
        add(SearchTextField);

        JTable BookingTable=new JTable();
        BookingTable.setBounds(42, 340, 1145, 278);
        BookingTable.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        BookingTable.setBackground(Color.WHITE);
        BookingTable.setForeground(Color.BLACK);
        BookingTable.setRowHeight(25);
        add(BookingTable);
        BookingTable.setEnabled(false);

        JTableHeader BookingTableHeader=BookingTable.getTableHeader();
        BookingTableHeader.setFont(new Font("Georgia", Font.BOLD, 15));
        BookingTableHeader.setPreferredSize(new Dimension(0,25));
        BookingTableHeader.setBackground(Color.BLACK);
        BookingTableHeader.setForeground(Color.WHITE);
        BookingTableHeader.setEnabled(false);

        DefaultTableCellRenderer BookingTableCell=new DefaultTableCellRenderer();
        BookingTableCell.setHorizontalAlignment(JLabel.CENTER);

        JScrollPane BookingTableScrollPane=new JScrollPane(BookingTable);
        BookingTableScrollPane.setBounds(42, 340, 1145, 278);
        add(BookingTableScrollPane);

        JLabel Label3=new JLabel();
        Label3.setBounds(42, 618, 200, 50);
        Label3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        Label3.setForeground(Color.WHITE);
        add(Label3);

        try
        {
            Database Data=new Database();
            String Query="select * from bookings";
            ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query);
            BookingTable.setModel(buildTableModel(Resultset));
            BookingTable.getColumnModel().getColumn(0).setCellRenderer(BookingTableCell);
            BookingTable.getColumnModel().getColumn(1).setCellRenderer(BookingTableCell);
            BookingTable.getColumnModel().getColumn(2).setCellRenderer(BookingTableCell);
            BookingTable.getColumnModel().getColumn(3).setCellRenderer(BookingTableCell);
            BookingTable.getColumnModel().getColumn(4).setCellRenderer(BookingTableCell);
            BookingTable.getColumnModel().getColumn(5).setCellRenderer(BookingTableCell);
            BookingTable.getColumnModel().getColumn(6).setCellRenderer(BookingTableCell);
            BookingTable.getColumnModel().getColumn(7).setCellRenderer(BookingTableCell);
            BookingTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            BookingTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            BookingTable.getColumnModel().getColumn(2).setPreferredWidth(5);
            BookingTable.getColumnModel().getColumn(3).setPreferredWidth(5);
            BookingTable.getColumnModel().getColumn(4).setPreferredWidth(5);
            BookingTable.getColumnModel().getColumn(5).setPreferredWidth(15);
            BookingTable.getColumnModel().getColumn(6).setPreferredWidth(15);
            BookingTable.getColumnModel().getColumn(7).setPreferredWidth(5);
            Label3.setText("<html>Showing <font color='yellow'>"+BookingTable.getRowCount()+"</font> Result(s)</html>");
        }
        catch(SQLException e)
        {
            System.out.println("Error!");
        }

        SearchTextField.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent ke)
            {
                String s=SearchTextField.getText();
                if(s.length()>15)
                {
                    ke.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent ke)
            {

            }
            @Override
            public void keyReleased(KeyEvent ke)
            {
                String s=SearchTextField.getText();
                try
                {
                    Database Data=new Database();
                    String Query="select * from bookings where instr(Username,'"+s+"')>0";
                    ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query);
                    BookingTable.setModel(buildTableModel(Resultset));
                    BookingTable.getColumnModel().getColumn(0).setCellRenderer(BookingTableCell);
                    BookingTable.getColumnModel().getColumn(1).setCellRenderer(BookingTableCell);
                    BookingTable.getColumnModel().getColumn(2).setCellRenderer(BookingTableCell);
                    BookingTable.getColumnModel().getColumn(3).setCellRenderer(BookingTableCell);
                    BookingTable.getColumnModel().getColumn(4).setCellRenderer(BookingTableCell);
                    BookingTable.getColumnModel().getColumn(5).setCellRenderer(BookingTableCell);
                    BookingTable.getColumnModel().getColumn(6).setCellRenderer(BookingTableCell);
                    BookingTable.getColumnModel().getColumn(7).setCellRenderer(BookingTableCell);
                    BookingTable.getColumnModel().getColumn(0).setPreferredWidth(5);
                    BookingTable.getColumnModel().getColumn(1).setPreferredWidth(120);
                    BookingTable.getColumnModel().getColumn(2).setPreferredWidth(5);
                    BookingTable.getColumnModel().getColumn(3).setPreferredWidth(5);
                    BookingTable.getColumnModel().getColumn(4).setPreferredWidth(5);
                    BookingTable.getColumnModel().getColumn(5).setPreferredWidth(15);
                    BookingTable.getColumnModel().getColumn(6).setPreferredWidth(15);
                    BookingTable.getColumnModel().getColumn(7).setPreferredWidth(5);
                    Label3.setText("<html>Showing <font color='yellow'>"+BookingTable.getRowCount()+"</font> Result(s)</html>");
                }
                catch(SQLException e)
                {
                    System.out.println("Error!");
                }
            }
        });

        JLabel Label4=new JLabel("Print :");
        Label4.setBounds(42, 290, 56, 30);
        Label4.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        Label4.setForeground(Color.WHITE);
        add(Label4);

        ImageIcon ImageIcon3 = new ImageIcon("assets/print.png");
        Image Image2=ImageIcon3.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon4=new ImageIcon(Image2);

        PrintButton=new JButton(ImageIcon4);
        PrintButton.setBounds(98, 280, 50, 50);
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
            new AdminMain(username);
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        SearchTextField.requestFocusInWindow();
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
        new AdminManageBookings("");
    }
}
