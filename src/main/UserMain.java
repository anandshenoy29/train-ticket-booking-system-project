import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class UserMain extends JFrame
{
    String username;
    JMenu HomeMenu,SearchTrainsMenu,BookTicketsMenu,NetworkMapMenu,MyProfileMenu,SupportMenu,FeedbackMenu,AboutMenu;
    JMenuItem CentralLineMenuItem1,CentralLineMenuItem2,WesternLineMenuItem1,WesternLineMenuItem2,HarbourLineMenuItem1,HarbourLineMenuItem2,TransHarbourLineMenuItem1,TransHarbourLineMenuItem2,NerulUranLineMenuItem1,NerulUranLineMenuItem2,MyDetailsMenuItem,MyBookingsMenuItem,ChangePasswordMenuItem,LogOutMenuItem;
    JButton FollowUsButton,CustomerSupportButton;

    UserMain(String username)
    {
        this.username=username;
        setTitle("TrainEase");
        setSize(1250,730);
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

        JMenuBar MenuBar=new JMenuBar();
        setJMenuBar(MenuBar);
        MenuBar.setLocation(300, 300);

        HomeMenu=new JMenu("Home");
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
                    new UserMain(username);
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

        SearchTrainsMenu=new JMenu("Search Trains");
        SearchTrainsMenu.setFont(new Font("Georgia", Font.BOLD, 27));
        MenuBar.add(SearchTrainsMenu);
        SearchTrainsMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        CentralLineMenuItem1=new JMenuItem("Central Line");
        CentralLineMenuItem1.setFont(new Font("Georgia", Font.BOLD, 17));
        SearchTrainsMenu.add(CentralLineMenuItem1);
        CentralLineMenuItem1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        CentralLineMenuItem1.addActionListener(_ ->
        {
            setVisible(false);
            new CentralLine(username,"UserMain");
        });

        WesternLineMenuItem1=new JMenuItem("Western Line");
        WesternLineMenuItem1.setFont(new Font("Georgia", Font.BOLD, 17));
        SearchTrainsMenu.add(WesternLineMenuItem1);
        WesternLineMenuItem1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        WesternLineMenuItem1.addActionListener(_ ->
        {
            setVisible(false);
            new WesternLine(username,"UserMain");
        });

        HarbourLineMenuItem1=new JMenuItem("Harbour Line");
        HarbourLineMenuItem1.setFont(new Font("Georgia", Font.BOLD, 17));
        SearchTrainsMenu.add(HarbourLineMenuItem1);
        HarbourLineMenuItem1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        HarbourLineMenuItem1.addActionListener(_ ->
        {
            setVisible(false);
            new HarbourLine(username,"UserMain");
        });

        TransHarbourLineMenuItem1=new JMenuItem("Trans-Harbour Line");
        TransHarbourLineMenuItem1.setFont(new Font("Georgia", Font.BOLD, 17));
        SearchTrainsMenu.add(TransHarbourLineMenuItem1);
        TransHarbourLineMenuItem1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        TransHarbourLineMenuItem1.addActionListener(_ ->
        {
            setVisible(false);
            new TransHarbourLine(username,"UserMain");
        });

        NerulUranLineMenuItem1=new JMenuItem("Nerul-Uran Line");
        NerulUranLineMenuItem1.setFont(new Font("Georgia", Font.BOLD, 17));
        SearchTrainsMenu.add(NerulUranLineMenuItem1);
        NerulUranLineMenuItem1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        NerulUranLineMenuItem1.addActionListener(_ ->
        {
            setVisible(false);
            new NerulUranLine(username,"UserMain");
        });

        JSeparator Separator2=new JSeparator(JSeparator.VERTICAL);
        MenuBar.add(Separator2);

        BookTicketsMenu=new JMenu("Book Tickets");
        BookTicketsMenu.setFont(new Font("Georgia", Font.BOLD, 27));
        MenuBar.add(BookTicketsMenu);
        BookTicketsMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        CentralLineMenuItem2=new JMenuItem("Central Line");
        CentralLineMenuItem2.setFont(new Font("Georgia", Font.BOLD, 17));
        BookTicketsMenu.add(CentralLineMenuItem2);
        CentralLineMenuItem2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        CentralLineMenuItem2.addActionListener(_ ->
        {
            setVisible(false);
            new UserBookTickets(username,"Central");
        });

        WesternLineMenuItem2=new JMenuItem("Western Line");
        WesternLineMenuItem2.setFont(new Font("Georgia", Font.BOLD, 17));
        BookTicketsMenu.add(WesternLineMenuItem2);
        WesternLineMenuItem2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        WesternLineMenuItem2.addActionListener(_ ->
        {
            setVisible(false);
            new UserBookTickets(username,"Western");
        });

        HarbourLineMenuItem2=new JMenuItem("Harbour Line");
        HarbourLineMenuItem2.setFont(new Font("Georgia", Font.BOLD, 17));
        BookTicketsMenu.add(HarbourLineMenuItem2);
        HarbourLineMenuItem2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        HarbourLineMenuItem2.addActionListener(_ ->
        {
            setVisible(false);
            new UserBookTickets(username,"Harbour");
        });

        TransHarbourLineMenuItem2=new JMenuItem("Trans-Harbour Line");
        TransHarbourLineMenuItem2.setFont(new Font("Georgia", Font.BOLD, 17));
        BookTicketsMenu.add(TransHarbourLineMenuItem2);
        TransHarbourLineMenuItem2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        TransHarbourLineMenuItem2.addActionListener(_ ->
        {
            setVisible(false);
            new UserBookTickets(username,"TransHarbour");
        });

        NerulUranLineMenuItem2=new JMenuItem("Nerul-Uran Line");
        NerulUranLineMenuItem2.setFont(new Font("Georgia", Font.BOLD, 17));
        BookTicketsMenu.add(NerulUranLineMenuItem2);
        NerulUranLineMenuItem2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        NerulUranLineMenuItem2.addActionListener(_ ->
        {
            setVisible(false);
            new UserBookTickets(username,"NerulUran");
        });

        JSeparator Separator3=new JSeparator(JSeparator.VERTICAL);
        MenuBar.add(Separator3);

        NetworkMapMenu=new JMenu("Network Map");
        NetworkMapMenu.setFont(new Font("Georgia", Font.BOLD, 27));
        MenuBar.add(NetworkMapMenu);
        NetworkMapMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        NetworkMapMenu.addMenuListener(new MenuListener()
        {
            @Override
            public void menuSelected(MenuEvent me)
            {
                setVisible(false);
                new NetworkMap(username,"UserMain");
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

        MyProfileMenu=new JMenu("My Profile");
        MyProfileMenu.setFont(new Font("Georgia", Font.BOLD, 27));
        MenuBar.add(MyProfileMenu);
        MyProfileMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        MyDetailsMenuItem=new JMenuItem("My Details");
        MyDetailsMenuItem.setFont(new Font("Georgia", Font.BOLD, 17));
        MyProfileMenu.add(MyDetailsMenuItem);
        MyDetailsMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        MyDetailsMenuItem.addActionListener(_ ->
        {
            setVisible(false);
            new UserMyDetails(username);
        });

        MyBookingsMenuItem=new JMenuItem("My Bookings");
        MyBookingsMenuItem.setFont(new Font("Georgia", Font.BOLD, 17));
        MyProfileMenu.add(MyBookingsMenuItem);
        MyBookingsMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        MyBookingsMenuItem.addActionListener(_ ->
        {
            setVisible(false);
            new UserMyBookings(username);
        });

        ChangePasswordMenuItem=new JMenuItem("Change Password");
        ChangePasswordMenuItem.setFont(new Font("Georgia", Font.BOLD, 17));
        MyProfileMenu.add(ChangePasswordMenuItem);
        ChangePasswordMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        ChangePasswordMenuItem.addActionListener(_ ->
        {
            setVisible(false);
            new UserChangePassword(username);
        });

        LogOutMenuItem=new JMenuItem("Log Out");
        LogOutMenuItem.setFont(new Font("Georgia", Font.BOLD, 17));
        MyProfileMenu.add(LogOutMenuItem);
        LogOutMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        LogOutMenuItem.addActionListener(_ ->
        {
            setVisible(false);
            new Main(username);
        });

        JSeparator Separator5=new JSeparator(JSeparator.VERTICAL);
        MenuBar.add(Separator5);

        SupportMenu=new JMenu("Support");
        SupportMenu.setFont(new Font("Georgia", Font.BOLD, 27));
        MenuBar.add(SupportMenu);
        SupportMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        SupportMenu.addMenuListener(new MenuListener()
        {
            @Override
            public void menuSelected(MenuEvent me)
            {
                setVisible(false);
                new UserSupport(username);
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

        JSeparator Separator6=new JSeparator(JSeparator.VERTICAL);
        MenuBar.add(Separator6);

        FeedbackMenu=new JMenu("Feedback");
        FeedbackMenu.setFont(new Font("Georgia", Font.BOLD, 27));
        MenuBar.add(FeedbackMenu);
        FeedbackMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        FeedbackMenu.addMenuListener(new MenuListener()
        {
            @Override
            public void menuSelected(MenuEvent me)
            {
                setVisible(false);
                new UserFeedback(username);
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

        JSeparator Separator7=new JSeparator(JSeparator.VERTICAL);
        MenuBar.add(Separator7);

        AboutMenu=new JMenu("About");
        AboutMenu.setFont(new Font("Georgia", Font.BOLD, 27));
        MenuBar.add(AboutMenu);
        AboutMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        AboutMenu.addMenuListener(new MenuListener()
        {
            @Override
            public void menuSelected(MenuEvent me)
            {
                setVisible(false);
                new About(username,"UserMain");
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

        ImageIcon ImageIcon3 = new ImageIcon("assets/follow_us.png");
        Image Image2=ImageIcon3.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon4=new ImageIcon(Image2);

        FollowUsButton=new JButton(ImageIcon4);
        FollowUsButton.setBounds(10, 575, 70, 70);
        FollowUsButton.setFont(new Font("Georgia", Font.BOLD,20));
        FollowUsButton.setBackground(Color.BLUE);
        FollowUsButton.setForeground(Color.WHITE);
        FollowUsButton.setOpaque(false);
        FollowUsButton.setBorderPainted(false);
        add(FollowUsButton);
        FollowUsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        FollowUsButton.addActionListener(_ ->
        {
            setVisible(false);
            new FollowUs(username,"UserMain");
        });

        ImageIcon ImageIcon5 = new ImageIcon("assets/customer_support.png");
        Image Image3=ImageIcon5.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon6=new ImageIcon(Image3);

        CustomerSupportButton=new JButton(ImageIcon6);
        CustomerSupportButton.setBounds(1150, 575, 70, 70);
        CustomerSupportButton.setFont(new Font("Georgia", Font.BOLD,20));
        CustomerSupportButton.setBackground(Color.BLUE);
        CustomerSupportButton.setForeground(Color.WHITE);
        CustomerSupportButton.setOpaque(false);
        CustomerSupportButton.setBorderPainted(false);
        CustomerSupportButton.setContentAreaFilled(false);
        add(CustomerSupportButton);
        CustomerSupportButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        CustomerSupportButton.addActionListener(_ ->
        {
            setVisible(false);
            new CustomerSupport(username,"UserMain");
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        requestFocusInWindow();
    }

    public static void main(String[] args)
    {
        new UserMain("");
    }
}
