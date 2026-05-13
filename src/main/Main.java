import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.border.Border;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class Main extends JFrame
{
    String username;
    JMenu HomeMenu, SearchTrainsMenu, Menu1, Menu2, NetworkMapMenu, AboutMenu;
    JMenuItem CentralLineMenuItem, WesternLineMenuItem, HarbourLineMenuItem, TransHarbourLineMenuItem, NerulUranLineMenuItem;
    JButton RegisterButton, LoginButton, FollowUsButton, CustomerSupportButton;

    Main(String username)
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
        ImageLabel1.setBounds(535, 185, 160, 160);
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

        RegisterButton =new JButton("REGISTER");
        RegisterButton.setBounds(450, 360, 150, 50);
        RegisterButton.setFont(new Font("Georgia", Font.BOLD,20));
        RegisterButton.setBackground(Color.CYAN);
        RegisterButton.setForeground(Color.BLACK);
        add(RegisterButton);
        RegisterButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Border Border1=RegisterButton.getBorder();

        RegisterButton.addMouseListener(new MouseListener()
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
                RegisterButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
            }
            @Override
            public void mouseExited(MouseEvent me)
            {
                RegisterButton.setBorder(Border1);
            }
        });

        RegisterButton.addActionListener(_ ->
        {
            setVisible(false);
            new Register(username);
        });

        LoginButton =new JButton("LOGIN");
        LoginButton.setBounds(630, 360, 150, 50);
        LoginButton.setFont(new Font("Georgia", Font.BOLD,20));
        LoginButton.setBackground(Color.CYAN);
        LoginButton.setForeground(Color.BLACK);
        add(LoginButton);
        LoginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Border Border2=LoginButton.getBorder();

        LoginButton.addMouseListener(new MouseListener()
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
                LoginButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
            }
            @Override
            public void mouseExited(MouseEvent me)
            {
                LoginButton.setBorder(Border2);
            }
        });

        LoginButton.addActionListener(_ ->
        {
            setVisible(false);
            new Login(username);
        });

        JLabel Label4=new JLabel("Plan your journey with us...");
        Label4.setBounds(303, 390, 1000, 100);
        Label4.setFont(new Font("Georgia", Font.BOLD, 44));
        Label4.setForeground(Color.WHITE);
        add(Label4);

        ImageIcon ImageIcon3 = new ImageIcon("assets/tick.png");
        Image Image2=ImageIcon3.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon4=new ImageIcon(Image2);
        JLabel ImageLabel2=new JLabel(ImageIcon4);
        ImageLabel2.setBounds(362, 465, 70, 70);
        add(ImageLabel2);

        JLabel Label5=new JLabel("Enjoy fastest train ticket booking!");
        Label5.setBounds(432, 474, 700, 50);
        Label5.setFont(new Font("Georgia", Font.BOLD, 22));
        Label5.setForeground(Color.WHITE);
        add(Label5);

        ImageIcon ImageIcon5 = new ImageIcon("assets/tick.png");
        Image Image3=ImageIcon5.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon6=new ImageIcon(Image3);
        JLabel ImageLabel3=new JLabel(ImageIcon6);
        ImageLabel3.setBounds(362, 525, 70, 70);
        add(ImageLabel3);

        JLabel Label6=new JLabel("Get generated digital tickets!");
        Label6.setBounds(432, 535, 700, 50);
        Label6.setFont(new Font("Georgia", Font.BOLD, 22));
        Label6.setForeground(Color.WHITE);
        add(Label6);

        ImageIcon ImageIcon7 = new ImageIcon("assets/tick.png");
        Image Image4=ImageIcon7.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon8=new ImageIcon(Image4);
        JLabel ImageLabel4=new JLabel(ImageIcon8);
        ImageLabel4.setBounds(362, 585, 70, 70);
        add(ImageLabel4);

        JLabel Label7=new JLabel("24/7 Customer Support!");
        Label7.setBounds(432, 592, 700, 50);
        Label7.setFont(new Font("Georgia", Font.BOLD, 22));
        Label7.setForeground(Color.WHITE);
        add(Label7);

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
                    new Main(username);
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

        SearchTrainsMenu =new JMenu("Search Trains");
        SearchTrainsMenu.setFont(new Font("Georgia", Font.BOLD, 27));
        MenuBar.add(SearchTrainsMenu);
        SearchTrainsMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        CentralLineMenuItem =new JMenuItem("Central Line");
        CentralLineMenuItem.setFont(new Font("Georgia", Font.BOLD, 17));
        SearchTrainsMenu.add(CentralLineMenuItem);
        CentralLineMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        CentralLineMenuItem.addActionListener(_ ->
        {
            setVisible(false);
            new CentralLine(username,"Main");
        });

        WesternLineMenuItem =new JMenuItem("Western Line");
        WesternLineMenuItem.setFont(new Font("Georgia", Font.BOLD, 17));
        SearchTrainsMenu.add(WesternLineMenuItem);
        WesternLineMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        WesternLineMenuItem.addActionListener(_ ->
        {
            setVisible(false);
            new WesternLine(username,"Main");
        });

        HarbourLineMenuItem =new JMenuItem("Harbour Line");
        HarbourLineMenuItem.setFont(new Font("Georgia", Font.BOLD, 17));
        SearchTrainsMenu.add(HarbourLineMenuItem);
        HarbourLineMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        HarbourLineMenuItem.addActionListener(_ ->
        {
            setVisible(false);
            new HarbourLine(username,"Main");
        });

        TransHarbourLineMenuItem =new JMenuItem("Trans-Harbour Line");
        TransHarbourLineMenuItem.setFont(new Font("Georgia", Font.BOLD, 17));
        SearchTrainsMenu.add(TransHarbourLineMenuItem);
        TransHarbourLineMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        TransHarbourLineMenuItem.addActionListener(_ ->
        {
            setVisible(false);
            new TransHarbourLine(username,"Main");
        });

        NerulUranLineMenuItem =new JMenuItem("Nerul-Uran Line");
        NerulUranLineMenuItem.setFont(new Font("Georgia", Font.BOLD, 17));
        SearchTrainsMenu.add(NerulUranLineMenuItem);
        NerulUranLineMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        NerulUranLineMenuItem.addActionListener(_ ->
        {
            setVisible(false);
            new NerulUranLine(username,"Main");
        });

        JSeparator Separator2=new JSeparator(JSeparator.VERTICAL);
        MenuBar.add(Separator2);

        Menu1 =new JMenu("");
        MenuBar.add(Menu1);

        JSeparator Separator3=new JSeparator(JSeparator.HORIZONTAL);
        MenuBar.add(Separator3);

        Menu2 =new JMenu("");
        MenuBar.add(Menu2);

        JSeparator Separator4=new JSeparator(JSeparator.VERTICAL);
        MenuBar.add(Separator4);

        NetworkMapMenu =new JMenu("Network Map");
        NetworkMapMenu.setFont(new Font("Georgia", Font.BOLD, 27));
        MenuBar.add(NetworkMapMenu);
        NetworkMapMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        NetworkMapMenu.addMenuListener(new MenuListener()
        {
            @Override
            public void menuSelected(MenuEvent me)
            {
                setVisible(false);
                new NetworkMap(username,"Main");
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

        AboutMenu =new JMenu("About");
        AboutMenu.setFont(new Font("Georgia", Font.BOLD, 27));
        MenuBar.add(AboutMenu);
        AboutMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        AboutMenu.addMenuListener(new MenuListener()
        {
            @Override
            public void menuSelected(MenuEvent me)
            {
                setVisible(false);
                new About(username,"Main");
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

        ImageIcon ImageIcon9 = new ImageIcon("assets/follow_us.png");
        Image Image5=ImageIcon9.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon10=new ImageIcon(Image5);

        FollowUsButton=new JButton(ImageIcon10);
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
            new FollowUs(username,"Main");
        });

        ImageIcon ImageIcon11 = new ImageIcon("assets/customer_support.png");
        Image Image6=ImageIcon11.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon12=new ImageIcon(Image6);

        CustomerSupportButton=new JButton(ImageIcon12);
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
            new CustomerSupport(username,"Main");
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        requestFocusInWindow();
    }
    
    public static void main(String[] args)
    {
        new Main("");
    }
}
