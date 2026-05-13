import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class AdminMain extends JFrame
{
    String username;
    JMenu HomeMenu, ManageAccountsMenu, ManageBookingsMenu, ManageFeedbacksMenu, AdminDetailsMenu, LogOutMenu;
    JMenuItem ActiveAccountsMenuItem,DeactivatedAccountsMenuItem;

    AdminMain(String username)
    {
        this.username=username;
        setTitle("TrainEase");
        setSize(1245,730);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLUE);
        setLayout(null);

        ImageIcon ImageIcon1 = new ImageIcon("assets/trainease_1.png");
        Image Image1=ImageIcon1.getImage().getScaledInstance(360, 360, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon2=new ImageIcon(Image1);
        JLabel ImageLabel1=new JLabel(ImageIcon2);
        ImageLabel1.setBounds(495, 185, 240, 240);
        add(ImageLabel1);

        JLabel Label1=new JLabel("Welcome");
        Label1.setBounds(508, 5, 360, 50);
        Label1.setFont(new Font("Georgia", Font.BOLD, 44));
        Label1.setForeground(Color.WHITE);
        add(Label1);

        JLabel Label2=new JLabel("to");
        Label2.setBounds(594, 55, 360, 50);
        Label2.setFont(new Font("Georgia", Font.BOLD, 44));
        Label2.setForeground(Color.WHITE);
        add(Label2);

        JLabel Label3=new JLabel("TrainEase Train Ticket Booking Platform");
        Label3.setBounds(153, 85, 1000, 100);
        Label3.setFont(new Font("Georgia", Font.BOLD, 44));
        Label3.setForeground(Color.WHITE);
        add(Label3);

        JLabel Label4=new JLabel("Total Accounts");
        Label4.setBounds(80, 430, 350, 50);
        Label4.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Label4.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
        Label4.setHorizontalAlignment(JLabel.CENTER);
        Label4.setForeground(Color.WHITE);
        add(Label4);

        JLabel Label5=new JLabel();
        Label5.setBounds(80, 480, 350, 50);
        Label5.setFont(new Font("Times New Roman", Font.BOLD, 44));
        Label5.setHorizontalAlignment(JLabel.CENTER);
        Label5.setForeground(Color.WHITE);
        add(Label5);

        try
        {
            Database Data=new Database();
            String Query="select count(*) from registration";
            ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query);
            if(Resultset.next())
            {
                Label5.setText(String.valueOf(Resultset.getInt(1)));
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error!");
        }

        JLabel Label6=new JLabel("Total Bookings");
        Label6.setBounds(440, 430, 350, 50);
        Label6.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Label6.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
        Label6.setHorizontalAlignment(JLabel.CENTER);
        Label6.setForeground(Color.WHITE);
        add(Label6);

        JLabel Label7=new JLabel();
        Label7.setBounds(440, 480, 350, 50);
        Label7.setFont(new Font("Times New Roman", Font.BOLD, 44));
        Label7.setHorizontalAlignment(JLabel.CENTER);
        Label7.setForeground(Color.WHITE);
        add(Label7);

        try
        {
            Database Data=new Database();
            String Query="select count(*) from bookings";
            ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query);
            if(Resultset.next())
            {
                Label7.setText(String.valueOf(Resultset.getInt(1)));
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error!");
        }

        JLabel Label8=new JLabel("Total Feedbacks");
        Label8.setBounds(800, 430, 350, 50);
        Label8.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Label8.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
        Label8.setHorizontalAlignment(JLabel.CENTER);
        Label8.setForeground(Color.WHITE);
        add(Label8);

        JLabel Label9=new JLabel();
        Label9.setBounds(800, 480, 350, 50);
        Label9.setFont(new Font("Times New Roman", Font.BOLD, 44));
        Label9.setHorizontalAlignment(JLabel.CENTER);
        Label9.setForeground(Color.WHITE);
        add(Label9);

        try
        {
            Database Data=new Database();
            String Query="select count(*) from feedbacks";
            ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query);
            if(Resultset.next())
            {
                Label9.setText(String.valueOf(Resultset.getInt(1)));
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error!");
        }

        JMenuBar MenuBar=new JMenuBar();
        setJMenuBar(MenuBar);
        MenuBar.setLocation(300, 300);

        HomeMenu =new JMenu("Home");
        HomeMenu.setFont(new Font("Georgia", Font.BOLD, 27));
        MenuBar.add(HomeMenu);
        HomeMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        HomeMenu.addMenuListener(new MenuListener()
        {
            @Override
            public void menuSelected(MenuEvent me)
            {
                try
                {
                    setVisible(false);
                    Thread.sleep(1000);
                    new AdminMain(username);
                }
                catch(InterruptedException e)
                {
                    System.out.println("Error!");
                }
            }

            @Override
            public void menuDeselected(MenuEvent me)
            {

            }

            @Override
            public void menuCanceled(MenuEvent me)
            {

            }
        });

        JSeparator Separator1=new JSeparator(JSeparator.VERTICAL);
        MenuBar.add(Separator1);

        ManageAccountsMenu =new JMenu("Manage Accounts");
        ManageAccountsMenu.setFont(new Font("Georgia", Font.BOLD, 27));
        MenuBar.add(ManageAccountsMenu);
        ManageAccountsMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        ActiveAccountsMenuItem=new JMenuItem("Active Accounts");
        ActiveAccountsMenuItem.setFont(new Font("Georgia", Font.BOLD, 21));
        ManageAccountsMenu.add(ActiveAccountsMenuItem);
        ActiveAccountsMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        ActiveAccountsMenuItem.addActionListener(_ ->
        {
            setVisible(false);
            new AdminManageActiveAccounts(username);
        });

        DeactivatedAccountsMenuItem=new JMenuItem("Deactivated Accounts");
        DeactivatedAccountsMenuItem.setFont(new Font("Georgia", Font.BOLD, 21));
        ManageAccountsMenu.add(DeactivatedAccountsMenuItem);
        DeactivatedAccountsMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        DeactivatedAccountsMenuItem.addActionListener(_ ->
        {
            setVisible(false);
            new AdminManageDeactivatedAccounts(username);
        });

        JSeparator Separator2=new JSeparator(JSeparator.VERTICAL);
        MenuBar.add(Separator2);

        ManageBookingsMenu =new JMenu("Manage Bookings");
        ManageBookingsMenu.setFont(new Font("Georgia", Font.BOLD, 27));
        MenuBar.add(ManageBookingsMenu);
        ManageBookingsMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        ManageBookingsMenu.addMenuListener(new MenuListener()
        {
            @Override
            public void menuSelected(MenuEvent me)
            {
                setVisible(false);
                new AdminManageBookings(username);
            }

            @Override
            public void menuDeselected(MenuEvent me)
            {

            }

            @Override
            public void menuCanceled(MenuEvent me)
            {

            }
        });

        JSeparator Separator3=new JSeparator(JSeparator.VERTICAL);
        MenuBar.add(Separator3);

        ManageFeedbacksMenu =new JMenu("Manage Feedbacks");
        ManageFeedbacksMenu.setFont(new Font("Georgia", Font.BOLD, 27));
        MenuBar.add(ManageFeedbacksMenu);
        ManageFeedbacksMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        ManageFeedbacksMenu.addMenuListener(new MenuListener()
        {
            @Override
            public void menuSelected(MenuEvent me)
            {
                setVisible(false);
                new AdminManageFeedbacks(username);
            }

            @Override
            public void menuDeselected(MenuEvent me)
            {

            }

            @Override
            public void menuCanceled(MenuEvent me)
            {

            }
        });

        JSeparator Separator4=new JSeparator(JSeparator.VERTICAL);
        MenuBar.add(Separator4);

        AdminDetailsMenu =new JMenu("Admin Details");
        AdminDetailsMenu.setFont(new Font("Georgia", Font.BOLD, 27));
        MenuBar.add(AdminDetailsMenu);
        AdminDetailsMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        AdminDetailsMenu.addMenuListener(new MenuListener()
        {
            @Override
            public void menuSelected(MenuEvent me)
            {
                setVisible(false);
                new AdminDetails(username);
            }

            @Override
            public void menuDeselected(MenuEvent me)
            {

            }

            @Override
            public void menuCanceled(MenuEvent me)
            {

            }
        });

        JSeparator Separator5=new JSeparator(JSeparator.VERTICAL);
        MenuBar.add(Separator5);

        LogOutMenu =new JMenu("Log Out");
        LogOutMenu.setFont(new Font("Georgia", Font.BOLD, 27));
        MenuBar.add(LogOutMenu);
        LogOutMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        LogOutMenu.addMenuListener(new MenuListener()
        {
            @Override
            public void menuSelected(MenuEvent me)
            {
                setVisible(false);
                new Main(username);
            }

            @Override
            public void menuDeselected(MenuEvent me)
            {

            }

            @Override
            public void menuCanceled(MenuEvent me)
            {

            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        requestFocusInWindow();
    }
    
    public static void main(String[] args)
    {
        new AdminMain("");
    }
}
