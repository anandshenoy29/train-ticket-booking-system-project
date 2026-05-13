import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class AdminManageActiveAccounts extends JFrame
{
    String username, u, n;
    JTextField SearchTextField;
    JButton WarningButton, DeleteButton, PrintButton, BackButton;

    AdminManageActiveAccounts(String username)
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

        JLabel Label1=new JLabel("|| List of Active Accounts ||");
        Label1.setBounds(374, 185, 500, 50);
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

        JTable AccountTable=new JTable(){
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };

        AccountTable.setBounds(42, 340, 1145, 278);
        AccountTable.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        AccountTable.setBackground(Color.WHITE);
        AccountTable.setForeground(Color.BLACK);
        AccountTable.setRowHeight(25);
        add(AccountTable);

        JTableHeader AccountTableHeader=AccountTable.getTableHeader();
        AccountTableHeader.setFont(new Font("Georgia", Font.BOLD, 15));
        AccountTableHeader.setPreferredSize(new Dimension(0,25));
        AccountTableHeader.setBackground(Color.BLACK);
        AccountTableHeader.setForeground(Color.WHITE);
        AccountTableHeader.setEnabled(false);

        DefaultTableCellRenderer AccountTableCell=new DefaultTableCellRenderer();
        AccountTableCell.setHorizontalAlignment(JLabel.CENTER);

        JScrollPane AccountTableScrollPane=new JScrollPane(AccountTable);
        AccountTableScrollPane.setBounds(42, 340, 1145, 278);
        add(AccountTableScrollPane);

        JLabel Label3=new JLabel();
        Label3.setBounds(42, 618, 200, 50);
        Label3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        Label3.setForeground(Color.WHITE);
        add(Label3);

        try
        {
            Database Data=new Database();
            String Query="select FirstName,LastName,MobileNo,Username,DateTime from registration";
            ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query);
            AccountTable.setModel(buildTableModel(Resultset));
            AccountTable.getColumnModel().getColumn(0).setCellRenderer(AccountTableCell);
            AccountTable.getColumnModel().getColumn(1).setCellRenderer(AccountTableCell);
            AccountTable.getColumnModel().getColumn(2).setCellRenderer(AccountTableCell);
            AccountTable.getColumnModel().getColumn(3).setCellRenderer(AccountTableCell);
            AccountTable.getColumnModel().getColumn(4).setCellRenderer(AccountTableCell);
            Label3.setText("<html>Showing <font color='yellow'>"+AccountTable.getRowCount()+"</font> Result(s)</html>");
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
                    String Query="select FirstName,LastName,MobileNo,Username,DateTime from registration where instr(Username,'"+s+"')>0";
                    ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query);
                    AccountTable.setModel(buildTableModel(Resultset));
                    AccountTable.getColumnModel().getColumn(0).setCellRenderer(AccountTableCell);
                    AccountTable.getColumnModel().getColumn(1).setCellRenderer(AccountTableCell);
                    AccountTable.getColumnModel().getColumn(2).setCellRenderer(AccountTableCell);
                    AccountTable.getColumnModel().getColumn(3).setCellRenderer(AccountTableCell);
                    AccountTable.getColumnModel().getColumn(4).setCellRenderer(AccountTableCell);
                    Label3.setText("<html>Showing <font color='yellow'>"+AccountTable.getRowCount()+"</font> Result(s)</html>");
                }
                catch(SQLException e)
                {
                    System.out.println("Error!");
                }
            }
        });

        AccountTable.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent me)
            {
                int row=AccountTable.getSelectedRow();
                u=AccountTable.getValueAt(row,3).toString();
                n=AccountTable.getValueAt(row,2).toString();
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

            }
            @Override
            public void mouseExited(MouseEvent me)
            {

            }
        });

        ImageIcon ImageIcon3 = new ImageIcon("assets/warning.png");
        Image Image2=ImageIcon3.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon4=new ImageIcon(Image2);

        WarningButton=new JButton(ImageIcon4);
        WarningButton.setBounds(550, 625, 60, 60);
        WarningButton.setFont(new Font("Georgia", Font.BOLD,20));
        WarningButton.setBackground(Color.BLUE);
        WarningButton.setForeground(Color.WHITE);
        WarningButton.setOpaque(false);
        WarningButton.setBorderPainted(false);
        add(WarningButton);
        WarningButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        WarningButton.addActionListener(_ ->
        {
            try
            {
                Database Data=new Database();
                String Query1="select * from registration where Username='"+u+"'";
                ResultSet Resultset1=Data.DatabaseStatement.executeQuery(Query1);
                if(Resultset1.next())
                {
                    String Query2 = "select * from warnings where Username='"+u+"'";
                    ResultSet Resultset2=Data.DatabaseStatement.executeQuery(Query2);
                    if(Resultset2.next())
                    {
                        JOptionPane.showMessageDialog(new JFrame(),"Username '"+u+"' has already been warned!");
                    }
                    else
                    {
                        String Query3 = "insert into warnings values('"+u+"')";
                        Data.DatabaseStatement.executeUpdate(Query3);
                        JOptionPane.showMessageDialog(new JFrame(),"Username '"+u+"' has been warned successfully!");
                    }
                    u="";
                }
                else
                {
                    JOptionPane.showMessageDialog(new JFrame(),"Invalid Request!");
                }
            }
            catch(HeadlessException | SQLException e)
            {
                System.out.println("Error!");
            }
            SearchTextField.setText("");
            try
            {
                Database Data=new Database();
                String Query="select FirstName,LastName,MobileNo,Username,DateTime from registration";
                ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query);
                AccountTable.setModel(buildTableModel(Resultset));
                AccountTable.getColumnModel().getColumn(0).setCellRenderer(AccountTableCell);
                AccountTable.getColumnModel().getColumn(1).setCellRenderer(AccountTableCell);
                AccountTable.getColumnModel().getColumn(2).setCellRenderer(AccountTableCell);
                AccountTable.getColumnModel().getColumn(3).setCellRenderer(AccountTableCell);
                AccountTable.getColumnModel().getColumn(4).setCellRenderer(AccountTableCell);
                Label3.setText("<html>Showing <font color='yellow'>"+AccountTable.getRowCount()+"</font> Result(s)</html>");
            }
            catch(SQLException e)
            {
                System.out.println("Error!");
            }
        });

        ImageIcon ImageIcon5 = new ImageIcon("assets/delete.png");
        Image Image3=ImageIcon5.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon6=new ImageIcon(Image3);

        DeleteButton=new JButton(ImageIcon6);
        DeleteButton.setBounds(620, 625, 60, 60);
        DeleteButton.setFont(new Font("Georgia", Font.BOLD,20));
        DeleteButton.setBackground(Color.BLUE);
        DeleteButton.setForeground(Color.WHITE);
        DeleteButton.setOpaque(false);
        DeleteButton.setBorderPainted(false);
        add(DeleteButton);
        DeleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        DeleteButton.addActionListener(_ ->
        {
            try
            {
                Database Data=new Database();
                String Query1="select * from registration where Username='"+u+"'";
                ResultSet Resultset1=Data.DatabaseStatement.executeQuery(Query1);
                if(Resultset1.next())
                {
                    DateTimeFormatter DateFormat=DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDateTime Date= LocalDateTime.now();
                    DateTimeFormatter TimeFormat=DateTimeFormatter.ofPattern("HH:mm");
                    LocalDateTime Time=LocalDateTime.now();
                    String dateandtime=DateFormat.format(Date)+" "+TimeFormat.format(Time);

                    String Query2 = "delete from registration where Username='"+u+"'";
                    Data.DatabaseStatement.executeUpdate(Query2);
                    String Query3 = "delete from account where UPI_No='"+n+"'";
                    Data.DatabaseStatement.executeUpdate(Query3);
                    String Query4 = "delete from bookings where Username='"+u+"'";
                    Data.DatabaseStatement.executeUpdate(Query4);
                    String Query5 = "delete from feedbacks where Username='"+u+"'";
                    Data.DatabaseStatement.executeUpdate(Query5);
                    String Query6 = "delete from warnings where Username='"+u+"'";
                    Data.DatabaseStatement.executeUpdate(Query6);
                    String Query7="insert into notification values('"+n+"','"+dateandtime+"','Dear User! Your account has been permanently deleted because of violation to our community standards! Regards, Team TrainEase.')";
                    Data.DatabaseStatement.executeUpdate(Query7);
                    JOptionPane.showMessageDialog(new JFrame(),"Username '"+u+"' has been deleted successfully!");
                    String Query8 = "delete from notification where Mobile_No='"+n+"'";
                    Data.DatabaseStatement.executeUpdate(Query8);
                }
                else
                {
                    JOptionPane.showMessageDialog(new JFrame(),"Invalid Request!");
                }
            }
            catch(HeadlessException | SQLException e)
            {
                System.out.println("Error!");
            }
            SearchTextField.setText("");
            try
            {
                Database Data=new Database();
                String Query="select FirstName,LastName,MobileNo,Username,DateTime from registration";
                ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query);
                AccountTable.setModel(buildTableModel(Resultset));
                AccountTable.getColumnModel().getColumn(0).setCellRenderer(AccountTableCell);
                AccountTable.getColumnModel().getColumn(1).setCellRenderer(AccountTableCell);
                AccountTable.getColumnModel().getColumn(2).setCellRenderer(AccountTableCell);
                AccountTable.getColumnModel().getColumn(3).setCellRenderer(AccountTableCell);
                AccountTable.getColumnModel().getColumn(4).setCellRenderer(AccountTableCell);
                Label3.setText("<html>Showing <font color='yellow'>"+AccountTable.getRowCount()+"</font> Result(s)</html>");
            }
            catch(SQLException e)
            {
                System.out.println("Error!");
            }
        });

        JLabel Label4=new JLabel("Print :");
        Label4.setBounds(42, 290, 56, 30);
        Label4.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        Label4.setForeground(Color.WHITE);
        add(Label4);

        ImageIcon ImageIcon7 = new ImageIcon("assets/print.png");
        Image Image4=ImageIcon7.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon8=new ImageIcon(Image4);

        PrintButton=new JButton(ImageIcon8);
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
                AccountTable.print();
            }
            catch(PrinterException pe)
            {
                System.out.println("Error!");
            }
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
        new AdminManageActiveAccounts("");
    }
}
