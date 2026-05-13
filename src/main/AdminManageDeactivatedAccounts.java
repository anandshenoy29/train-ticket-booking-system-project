import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class AdminManageDeactivatedAccounts extends JFrame
{
    String username;
    JButton PrintButton, ClearButton, BackButton;
    AdminManageDeactivatedAccounts(String username)
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

        JLabel Label1=new JLabel("|| List of Deactivated Accounts ||");
        Label1.setBounds(322, 185, 600, 50);
        Label1.setFont(new Font("Georgia", Font.BOLD, 35));
        Label1.setForeground(Color.YELLOW);
        add(Label1);

        JTable AccountTable=new JTable();
        AccountTable.setBounds(42, 300, 1145, 278);
        AccountTable.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        AccountTable.setBackground(Color.WHITE);
        AccountTable.setForeground(Color.BLACK);
        AccountTable.setRowHeight(25);
        add(AccountTable);
        AccountTable.setEnabled(false);

        JTableHeader AccountTableHeader=AccountTable.getTableHeader();
        AccountTableHeader.setFont(new Font("Georgia", Font.BOLD, 15));
        AccountTableHeader.setPreferredSize(new Dimension(0,25));
        AccountTableHeader.setBackground(Color.BLACK);
        AccountTableHeader.setForeground(Color.WHITE);
        AccountTableHeader.setEnabled(false);

        DefaultTableCellRenderer AccountTableCell=new DefaultTableCellRenderer();
        AccountTableCell.setHorizontalAlignment(JLabel.CENTER);

        JScrollPane AccountTableScrollPane=new JScrollPane(AccountTable);
        AccountTableScrollPane.setBounds(42, 300, 1145, 278);
        add(AccountTableScrollPane);

        JLabel Label3=new JLabel();
        Label3.setBounds(42, 578, 200, 50);
        Label3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        Label3.setForeground(Color.WHITE);
        add(Label3);

        try
        {
            Database Data=new Database();
            String Query="select * from deactivation";
            ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query);
            AccountTable.setModel(buildTableModel(Resultset));
            AccountTable.getColumnModel().getColumn(0).setCellRenderer(AccountTableCell);
            AccountTable.getColumnModel().getColumn(1).setCellRenderer(AccountTableCell);
            AccountTable.getColumnModel().getColumn(2).setCellRenderer(AccountTableCell);
            AccountTable.getColumnModel().getColumn(3).setCellRenderer(AccountTableCell);
            AccountTable.getColumnModel().getColumn(4).setCellRenderer(AccountTableCell);
            AccountTable.getColumnModel().getColumn(5).setCellRenderer(AccountTableCell);
            AccountTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            AccountTable.getColumnModel().getColumn(1).setPreferredWidth(5);
            AccountTable.getColumnModel().getColumn(2).setPreferredWidth(5);
            AccountTable.getColumnModel().getColumn(3).setPreferredWidth(5);
            AccountTable.getColumnModel().getColumn(4).setPreferredWidth(120);
            AccountTable.getColumnModel().getColumn(5).setPreferredWidth(15);
            Label3.setText("<html>Showing <font color='yellow'>"+AccountTable.getRowCount()+"</font> Result(s)</html>");
        }
        catch(SQLException e)
        {
            System.out.println("Error!");
        }

        ImageIcon ImageIcon3 = new ImageIcon("assets/print.png");
        Image Image2=ImageIcon3.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon4=new ImageIcon(Image2);

        PrintButton=new JButton(ImageIcon4);
        PrintButton.setBounds(545, 585, 60, 60);
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
                AccountTable.print();
            }
            catch(PrinterException pe)
            {
                System.out.println("Error!");
            }
        });

        ImageIcon ImageIcon5 = new ImageIcon("assets/delete.png");
        Image Image3=ImageIcon5.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon6=new ImageIcon(Image3);

        ClearButton=new JButton(ImageIcon6);
        ClearButton.setBounds(625, 585, 60, 60);
        ClearButton.setFont(new Font("Georgia", Font.BOLD,20));
        ClearButton.setBackground(Color.BLUE);
        ClearButton.setForeground(Color.WHITE);
        ClearButton.setOpaque(false);
        ClearButton.setBorderPainted(false);
        add(ClearButton);
        ClearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        ClearButton.addActionListener(_ ->
        {
            String s1="I faced some issues while booking tickets";
            String s2="I no longer needed this account";
            String s3="I have switched to another platform";
            String s4="I faced some other issues";
            try
            {
                Database Data=new Database();
                String Query1="delete from deactivation where Reason='"+s1+"'";
                Data.DatabaseStatement.executeUpdate(Query1);
                String Query2="delete from deactivation where Reason='"+s2+"'";
                Data.DatabaseStatement.executeUpdate(Query2);
                String Query3="delete from deactivation where Reason='"+s3+"'";
                Data.DatabaseStatement.executeUpdate(Query3);
                String Query4="delete from deactivation where Reason='"+s4+"'";
                Data.DatabaseStatement.executeUpdate(Query4);
                JOptionPane.showMessageDialog(new JFrame(),"Cleared successfully!");
                String Query5="select * from deactivation";
                ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query5);
                AccountTable.setModel(buildTableModel(Resultset));
                AccountTable.getColumnModel().getColumn(0).setCellRenderer(AccountTableCell);
                AccountTable.getColumnModel().getColumn(1).setCellRenderer(AccountTableCell);
                AccountTable.getColumnModel().getColumn(2).setCellRenderer(AccountTableCell);
                AccountTable.getColumnModel().getColumn(3).setCellRenderer(AccountTableCell);
                AccountTable.getColumnModel().getColumn(4).setCellRenderer(AccountTableCell);
                AccountTable.getColumnModel().getColumn(5).setCellRenderer(AccountTableCell);
                AccountTable.getColumnModel().getColumn(0).setPreferredWidth(5);
                AccountTable.getColumnModel().getColumn(1).setPreferredWidth(5);
                AccountTable.getColumnModel().getColumn(2).setPreferredWidth(5);
                AccountTable.getColumnModel().getColumn(3).setPreferredWidth(5);
                AccountTable.getColumnModel().getColumn(4).setPreferredWidth(120);
                AccountTable.getColumnModel().getColumn(5).setPreferredWidth(15);
                Label3.setText("<html>Showing <font color='yellow'>"+AccountTable.getRowCount()+"</font> Result(s)</html>");
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
            new AdminMain(username);
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
        new AdminManageDeactivatedAccounts("");
    }
}
