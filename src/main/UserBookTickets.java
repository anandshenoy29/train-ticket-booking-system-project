import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class UserBookTickets extends JFrame
{
    int value,intfare,intrevisedfare;
    private static final String FILE_NAME = "src/counter.txt";
    String username,linename,sourcestation,destinationstation,tickettype,classtype,singlefirst,singlesecond,stringfare,stringrevisedfare;
    String[] StationComboBoxElements;
    JComboBox<String> SourceStationComboBox, DestinationStationComboBox, TicketTypeComboBox, ClassTypeComboBox, MemberCountComboBox;
    JButton UpDownButton, GenerateFareButton, BookTicketButton, BackButton;

    UserBookTickets(String username,String linename)
    {
        this.username=username;
        this.linename=linename;
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

        JLabel Label1=new JLabel("|| Ticket Booking ||");
        Label1.setBounds(443, 168, 400, 50);
        Label1.setFont(new Font("Georgia", Font.BOLD, 35));
        Label1.setForeground(Color.YELLOW);
        add(Label1);

        switch (linename) {
            case "Central" -> StationComboBoxElements = new String[]{
                    "CSMT",
                    "Masjid Bunder",
                    "Sandhurst Road",
                    "Byculla",
                    "Chinchpokli",
                    "Currey Road",
                    "Parel",
                    "Dadar",
                    "Matunga",
                    "Sion",
                    "Kurla",
                    "Vidyavihar",
                    "Ghatkopar",
                    "Vikhroli",
                    "Kanjurmarg",
                    "Bhandup",
                    "Nahur",
                    "Mulund",
                    "Thane",
                    "Kalwa",
                    "Mumbra",
                    "Diva",
                    "Kopar",
                    "Dombivali",
                    "Thakurli",
                    "Kalyan",
                    "Shahad",
                    "Ambivli",
                    "Titwala",
                    "Khadavali",
                    "Vashind",
                    "Asangaon",
                    "Atgaon",
                    "Thansit",
                    "Khardi",
                    "Umbermali",
                    "Kasara",
                    "Vitthalwadi",
                    "Ulhasnagar",
                    "Ambernath",
                    "Badlapur",
                    "Vangani",
                    "Shelu",
                    "Neral",
                    "Bhivpuri Road",
                    "Karjat",
                    "Palasdari",
                    "Kelavli",
                    "Dolavli",
                    "Lowjee",
                    "Khopoli"
            };
            case "Western" -> StationComboBoxElements = new String[]{
                    "Churchgate",
                    "Marine Lines",
                    "Charni Road",
                    "Grant Road",
                    "Mumbai Central",
                    "Mahalaxmi",
                    "Lower Parel",
                    "Prabhadevi",
                    "Dadar",
                    "Matunga Road",
                    "Mahim",
                    "Bandra",
                    "Khar Road",
                    "Santacruz",
                    "Ville Parle",
                    "Andheri",
                    "Jogeshwari",
                    "Ram Mandir",
                    "Goregaon",
                    "Malad",
                    "Kandivali",
                    "Borivali",
                    "Dahisar",
                    "Mira Road",
                    "Bhayandar",
                    "Naigaon",
                    "Vasai Road",
                    "Nallasopara",
                    "Virar",
                    "Vaitarna",
                    "Saphale",
                    "Kelve Road",
                    "Palghar",
                    "Umroli",
                    "Boisar",
                    "Vangaon",
                    "Dahanu Road"
            };
            case "Harbour" -> StationComboBoxElements = new String[]{
                    "CSMT",
                    "Masjid Bundar",
                    "Sandhurst Road",
                    "Dockyard Road",
                    "Reay Road",
                    "Cotton Green",
                    "Sewri",
                    "Vadala Road",
                    "GTB Nagar",
                    "Chunabhatti",
                    "Kurla",
                    "Tilak Nagar",
                    "Chembur",
                    "Govandi",
                    "Mankhurd",
                    "Vashi",
                    "Sanpada",
                    "Juinagar",
                    "Nerul",
                    "Seawoods Darave",
                    "Belapur",
                    "Kharghar",
                    "Manasarovar",
                    "Khandeshwar",
                    "Panvel",
                    "Kings Circle",
                    "Mahim",
                    "Bandra",
                    "Khar Road",
                    "Santacruz",
                    "Ville Parle",
                    "Andheri",
                    "Jogeshwari",
                    "Ram Mandir",
                    "Goregaon"
            };
            case "TransHarbour" -> StationComboBoxElements = new String[]{
                    "Thane",
                    "Digha Gaon",
                    "Airoli",
                    "Rabale",
                    "Ghansoli",
                    "Kopar Khairane",
                    "Turbhe",
                    "Sanpada",
                    "Vashi",
                    "Juinagar",
                    "Nerul",
                    "Seawoods Darave",
                    "Belapur",
                    "Kharghar",
                    "Manasarovar",
                    "Khandeshwar",
                    "Panvel"
            };
            case "NerulUran" -> StationComboBoxElements = new String[]{
                    "Nerul",
                    "Seawoods Darave",
                    "Belapur",
                    "Sagar Sangam",
                    "Targhar",
                    "Bamandongari",
                    "Kharkopar",
                    "Gavan",
                    "Ranjanpada",
                    "Nhava Sheva",
                    "Dongari",
                    "Uran"
            };
        }

        Arrays.sort(StationComboBoxElements);

        JLabel SourceStationLabel=new JLabel("Source Station :");
        SourceStationLabel.setBounds(358, 250, 300, 30);
        SourceStationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        SourceStationLabel.setForeground(Color.WHITE);
        add(SourceStationLabel);

        SourceStationComboBox =new JComboBox<>(StationComboBoxElements);
        SourceStationComboBox.setBounds(670, 250, 200, 30);
        SourceStationComboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
        SourceStationComboBox.setForeground(Color.BLACK);
        add(SourceStationComboBox);
        SourceStationComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel DestinationStationLabel=new JLabel("Destination Station :");
        DestinationStationLabel.setBounds(358, 320, 300, 30);
        DestinationStationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        DestinationStationLabel.setForeground(Color.WHITE);
        add(DestinationStationLabel);

        DestinationStationComboBox =new JComboBox<>(StationComboBoxElements);
        DestinationStationComboBox.setBounds(670, 320, 200, 30);
        DestinationStationComboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
        DestinationStationComboBox.setForeground(Color.BLACK);
        add(DestinationStationComboBox);
        DestinationStationComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        ImageIcon ImageIcon3 = new ImageIcon("assets/updown.png");
        Image Image2=ImageIcon3.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon4=new ImageIcon(Image2);

        UpDownButton =new JButton(ImageIcon4);
        UpDownButton.setBounds(752, 282, 35, 35);
        UpDownButton.setFont(new Font("Georgia", Font.BOLD,20));
        add(UpDownButton);
        UpDownButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Border Border1=UpDownButton.getBorder();

        UpDownButton.addMouseListener(new MouseListener()
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
                UpDownButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
            }
            @Override
            public void mouseExited(MouseEvent me)
            {
                UpDownButton.setBorder(Border1);
            }
        });

        UpDownButton.addActionListener(_ ->
        {
            String s1=(String) SourceStationComboBox.getSelectedItem();
            String s2=(String) DestinationStationComboBox.getSelectedItem();
            DestinationStationComboBox.setSelectedItem(s1);
            SourceStationComboBox.setSelectedItem(s2);
        });

        JLabel TicketTypeLabel=new JLabel("Ticket Type :");
        TicketTypeLabel.setBounds(358, 370, 140, 25);
        TicketTypeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        TicketTypeLabel.setForeground(Color.WHITE);
        add(TicketTypeLabel);

        String[] TicketTypeComboBoxElements={
                "Single",
                "Return"
        };

        TicketTypeComboBox =new JComboBox<>(TicketTypeComboBoxElements);
        TicketTypeComboBox.setBounds(508, 370, 100, 25);
        TicketTypeComboBox.setFont(new Font("Times New Roman", Font.BOLD, 15));
        TicketTypeComboBox.setForeground(Color.BLACK);
        add(TicketTypeComboBox);
        TicketTypeComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel ClassTypeLabel=new JLabel("Class Type :");
        ClassTypeLabel.setBounds(630, 370, 125, 25);
        ClassTypeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        ClassTypeLabel.setForeground(Color.WHITE);
        add(ClassTypeLabel);

        String[] ClassTypeComboBoxElements={
                "First",
                "Second"
        };

        ClassTypeComboBox =new JComboBox<>(ClassTypeComboBoxElements);
        ClassTypeComboBox.setBounds(770, 370, 100, 25);
        ClassTypeComboBox.setFont(new Font("Times New Roman", Font.BOLD, 15));
        ClassTypeComboBox.setForeground(Color.BLACK);
        add(ClassTypeComboBox);
        ClassTypeComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel MemberCountLabel=new JLabel("No. of  Members :");
        MemberCountLabel.setBounds(485, 420, 185, 25);
        MemberCountLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        MemberCountLabel.setForeground(Color.WHITE);
        add(MemberCountLabel);

        String[] MemberCountComboBoxElements={
                "1",
                "2",
                "3",
                "4"
        };

        MemberCountComboBox =new JComboBox<>(MemberCountComboBoxElements);
        MemberCountComboBox.setBounds(690, 420, 50, 25);
        MemberCountComboBox.setFont(new Font("Times New Roman", Font.BOLD, 15));
        MemberCountComboBox.setForeground(Color.BLACK);
        add(MemberCountComboBox);
        MemberCountComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        GenerateFareButton =new JButton("Generate Fare");
        GenerateFareButton.setBounds(538, 470, 155, 40);
        GenerateFareButton.setFont(new Font("Georgia", Font.BOLD,16));
        GenerateFareButton.setBackground(new Color(1,48,10));
        GenerateFareButton.setForeground(Color.WHITE);
        add(GenerateFareButton);
        GenerateFareButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Border Border2=GenerateFareButton.getBorder();

        GenerateFareButton.addMouseListener(new MouseListener()
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
                GenerateFareButton.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
            }
            @Override
            public void mouseExited(MouseEvent me)
            {
                GenerateFareButton.setBorder(Border2);
            }
        });

        JLabel Label2=new JLabel();
        Label2.setBounds(358, 470, 512, 100);
        Label2.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        add(Label2);
        Label2.setVisible(false);

        JLabel TicketFareLabel=new JLabel("Total Ticket Fare : ₹");
        TicketFareLabel.setBounds(358, 480, 512, 30);
        TicketFareLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        TicketFareLabel.setForeground(Color.CYAN);
        TicketFareLabel.setHorizontalAlignment(JLabel.CENTER);
        add(TicketFareLabel);
        TicketFareLabel.setVisible(false);

        JLabel TicketExpiryLabel=new JLabel("( Journey should commence within 1 hour )");
        TicketExpiryLabel.setBounds(358, 530, 512, 25);
        TicketExpiryLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        TicketExpiryLabel.setForeground(Color.RED);
        TicketExpiryLabel.setHorizontalAlignment(JLabel.CENTER);
        add(TicketExpiryLabel);
        TicketExpiryLabel.setVisible(false);

        BookTicketButton=new JButton("Book Ticket");
        BookTicketButton.setBounds(538, 600, 155, 40);
        BookTicketButton.setFont(new Font("Georgia", Font.BOLD,18));
        BookTicketButton.setBackground(Color.MAGENTA);
        BookTicketButton.setForeground(Color.BLACK);
        add(BookTicketButton);
        BookTicketButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        BookTicketButton.setVisible(false);

        Border Border3=BookTicketButton.getBorder();

        BookTicketButton.addMouseListener(new MouseListener()
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
                BookTicketButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
            }
            @Override
            public void mouseExited(MouseEvent me)
            {
                BookTicketButton.setBorder(Border3);
            }
        });

        SourceStationComboBox.addActionListener(_ ->
        {
            Label2.setVisible(false);
            TicketFareLabel.setVisible(false);
            TicketExpiryLabel.setVisible(false);
            BookTicketButton.setVisible(false);
            GenerateFareButton.setVisible(true);
        });

        DestinationStationComboBox.addActionListener(_ ->
        {
            Label2.setVisible(false);
            TicketFareLabel.setVisible(false);
            TicketExpiryLabel.setVisible(false);
            BookTicketButton.setVisible(false);
            GenerateFareButton.setVisible(true);
        });

        TicketTypeComboBox.addActionListener(_ ->
        {
            Label2.setVisible(false);
            TicketFareLabel.setVisible(false);
            TicketExpiryLabel.setVisible(false);
            BookTicketButton.setVisible(false);
            GenerateFareButton.setVisible(true);
        });

        ClassTypeComboBox.addActionListener(_ ->
        {
            Label2.setVisible(false);
            TicketFareLabel.setVisible(false);
            TicketExpiryLabel.setVisible(false);
            BookTicketButton.setVisible(false);
            GenerateFareButton.setVisible(true);
        });

        MemberCountComboBox.addActionListener(_ ->
        {
            Label2.setVisible(false);
            TicketFareLabel.setVisible(false);
            TicketExpiryLabel.setVisible(false);
            BookTicketButton.setVisible(false);
            GenerateFareButton.setVisible(true);
        });

        GenerateFareButton.addActionListener(new ActionListener()
        {
            public void memberfarecount(int intfare)
            {
                if(MemberCountComboBox.getSelectedItem() == "1")
                {
                    intrevisedfare=intfare;
                    stringrevisedfare=String.valueOf(intrevisedfare);
                }
                else if(MemberCountComboBox.getSelectedItem() == "2")
                {
                    intrevisedfare=intfare*2;
                    stringrevisedfare=String.valueOf(intrevisedfare);
                }
                else if(MemberCountComboBox.getSelectedItem() == "3")
                {
                    intrevisedfare=intfare*3;
                    stringrevisedfare=String.valueOf(intrevisedfare);
                }
                else if(MemberCountComboBox.getSelectedItem() == "4")
                {
                    intrevisedfare=intfare*4;
                    stringrevisedfare=String.valueOf(intrevisedfare);
                }
            }

            @Override
            public void actionPerformed(ActionEvent ae)
            {
                sourcestation= (String) SourceStationComboBox.getSelectedItem();
                destinationstation= (String) DestinationStationComboBox.getSelectedItem();
                tickettype= (String) TicketTypeComboBox.getSelectedItem();
                classtype= (String) ClassTypeComboBox.getSelectedItem();

                if(Objects.equals(sourcestation, destinationstation))
                {
                    JOptionPane.showMessageDialog(new JFrame(), "The Source and Destination Station both are same!");
                    Label2.setVisible(false);
                    TicketFareLabel.setVisible(false);
                    TicketExpiryLabel.setVisible(false);
                    BookTicketButton.setVisible(false);
                }
                else if((Objects.equals(sourcestation, "Kasara") || Objects.equals(sourcestation, "Umbermali") || Objects.equals(sourcestation, "Khardi") || Objects.equals(sourcestation, "Thansit") || Objects.equals(sourcestation, "Atgaon") || Objects.equals(sourcestation, "Asangaon") || Objects.equals(sourcestation, "Vashind") || Objects.equals(sourcestation, "Khadavali") || Objects.equals(sourcestation, "Titwala") || Objects.equals(sourcestation, "Ambivli") || Objects.equals(sourcestation, "Shahad")) && (Objects.equals(destinationstation, "Khopoli") || Objects.equals(destinationstation, "Lowjee") || Objects.equals(destinationstation, "Dolavli") || Objects.equals(destinationstation, "Kelavli") || Objects.equals(destinationstation, "Palasdari") || Objects.equals(destinationstation, "Karjat") || Objects.equals(destinationstation, "Bhivpuri Road") || Objects.equals(destinationstation, "Neral") || Objects.equals(destinationstation, "Shelu") || Objects.equals(destinationstation, "Vangani") || Objects.equals(destinationstation, "Badlapur") || Objects.equals(destinationstation, "Ambernath") || Objects.equals(destinationstation, "Ulhasnagar") || Objects.equals(destinationstation, "Vitthalwadi")))
                {
                    JOptionPane.showMessageDialog(new JFrame(), "No Trains are available!");
                    Label2.setVisible(false);
                    TicketFareLabel.setVisible(false);
                    TicketExpiryLabel.setVisible(false);
                    BookTicketButton.setVisible(false);
                }
                else if((Objects.equals(sourcestation, "Khopoli") || Objects.equals(sourcestation, "Lowjee") || Objects.equals(sourcestation, "Dolavli") || Objects.equals(sourcestation, "Kelavli") || Objects.equals(sourcestation, "Palasdari") || Objects.equals(sourcestation, "Karjat") || Objects.equals(sourcestation, "Bhivpuri Road") || Objects.equals(sourcestation, "Neral") || Objects.equals(sourcestation, "Shelu") || Objects.equals(sourcestation, "Vangani") || Objects.equals(sourcestation, "Badlapur") || Objects.equals(sourcestation, "Ambernath") || Objects.equals(sourcestation, "Ulhasnagar") || Objects.equals(sourcestation, "Vitthalwadi")) && (Objects.equals(destinationstation, "Kasara") || Objects.equals(destinationstation, "Umbermali") || Objects.equals(destinationstation, "Khardi") || Objects.equals(destinationstation, "Thansit") || Objects.equals(destinationstation, "Atgaon") || Objects.equals(destinationstation, "Asangaon") || Objects.equals(destinationstation, "Vashind") || Objects.equals(destinationstation, "Khadavali") || Objects.equals(destinationstation, "Titwala") || Objects.equals(destinationstation, "Ambivli") || Objects.equals(destinationstation, "Shahad")))
                {
                    JOptionPane.showMessageDialog(new JFrame(), "No Trains are available!");
                    Label2.setVisible(false);
                    TicketFareLabel.setVisible(false);
                    TicketExpiryLabel.setVisible(false);
                    BookTicketButton.setVisible(false);
                }
                else if((Objects.equals(sourcestation, "Sanpada") || Objects.equals(sourcestation, "Vashi")) && (Objects.equals(destinationstation, "Juinagar") || Objects.equals(destinationstation, "Nerul") || Objects.equals(destinationstation, "Seawoods Darave") || Objects.equals(destinationstation, "Belapur") || Objects.equals(destinationstation, "Kharghar") || Objects.equals(destinationstation, "Manasarovar") || Objects.equals(destinationstation, "Khandeshwar") || Objects.equals(destinationstation, "Panvel")))
                {
                    JOptionPane.showMessageDialog(new JFrame(), "No Trains are available!");
                    Label2.setVisible(false);
                    TicketFareLabel.setVisible(false);
                    TicketExpiryLabel.setVisible(false);
                    BookTicketButton.setVisible(false);
                }
                else if((Objects.equals(sourcestation, "Juinagar") || Objects.equals(sourcestation, "Nerul") || Objects.equals(sourcestation, "Seawoods Darave") || Objects.equals(sourcestation, "Belapur") || Objects.equals(sourcestation, "Kharghar") || Objects.equals(sourcestation, "Manasarovar") || Objects.equals(sourcestation, "Khandeshwar") || Objects.equals(sourcestation, "Panvel")) && (Objects.equals(destinationstation, "Sanpada") || Objects.equals(destinationstation, "Vashi")))
                {
                    JOptionPane.showMessageDialog(new JFrame(), "No Trains are available!");
                    Label2.setVisible(false);
                    TicketFareLabel.setVisible(false);
                    TicketExpiryLabel.setVisible(false);
                    BookTicketButton.setVisible(false);
                }
                else
                {
                    if(linename.equals("Central"))
                    {
                        try
                        {
                            Database Data=new Database();
                            String Query1="select * from centralfares where Source='"+sourcestation+"' and Destination='"+destinationstation+"'";
                            ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query1);
                            Resultset.next();
                            singlefirst=Resultset.getString("SingleFirst");
                            singlesecond=Resultset.getString("SingleSecond");
                        }
                        catch(SQLException e)
                        {
                            System.out.println("Error!");
                        }
                    }
                    if(linename.equals("Western"))
                    {
                        try
                        {
                            Database Data=new Database();
                            String Query1="select * from westernfares where Source='"+sourcestation+"' and Destination='"+destinationstation+"'";
                            ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query1);
                            Resultset.next();
                            singlefirst=Resultset.getString("SingleFirst");
                            singlesecond=Resultset.getString("SingleSecond");
                        }
                        catch(SQLException e)
                        {
                            System.out.println("Error!");
                        }
                    }
                    if(linename.equals("Harbour"))
                    {
                        try
                        {
                            Database Data=new Database();
                            String Query1="select * from harbourfares where Source='"+sourcestation+"' and Destination='"+destinationstation+"'";
                            ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query1);
                            Resultset.next();
                            singlefirst=Resultset.getString("SingleFirst");
                            singlesecond=Resultset.getString("SingleSecond");
                        }
                        catch(SQLException e)
                        {
                            System.out.println("Error!");
                        }
                    }
                    if(linename.equals("TransHarbour"))
                    {
                        try
                        {
                            Database Data=new Database();
                            String Query1="select * from transharbourfares where Source='"+sourcestation+"' and Destination='"+destinationstation+"'";
                            ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query1);
                            Resultset.next();
                            singlefirst=Resultset.getString("SingleFirst");
                            singlesecond=Resultset.getString("SingleSecond");
                        }
                        catch(SQLException e)
                        {
                            System.out.println("Error!");
                        }
                    }
                    if(linename.equals("NerulUran"))
                    {
                        try
                        {
                            Database Data=new Database();
                            String Query1="select * from neruluranfares where Source='"+sourcestation+"' and Destination='"+destinationstation+"'";
                            ResultSet Resultset=Data.DatabaseStatement.executeQuery(Query1);
                            Resultset.next();
                            singlefirst=Resultset.getString("SingleFirst");
                            singlesecond=Resultset.getString("SingleSecond");
                        }
                        catch(SQLException e)
                        {
                            System.out.println("Error!");
                        }
                    }

                    if(Objects.equals(tickettype, "Single") && Objects.equals(classtype, "First"))
                    {
                        stringfare=singlefirst;
                        intfare=Integer.parseInt(stringfare);
                        memberfarecount(intfare);
                    }
                    if(Objects.equals(tickettype, "Single") && Objects.equals(classtype, "Second"))
                    {
                        stringfare=singlesecond;
                        intfare=Integer.parseInt(stringfare);
                        memberfarecount(intfare);
                    }
                    if(Objects.equals(tickettype, "Return") && Objects.equals(classtype, "First"))
                    {
                        int i1=Integer.parseInt(singlefirst);
                        int i2=i1*2;
                        stringfare=String.valueOf(i2);
                        intfare=Integer.parseInt(stringfare);
                        memberfarecount(intfare);
                    }
                    if(TicketTypeComboBox.getSelectedItem() == "Return" && ClassTypeComboBox.getSelectedItem() == "Second")
                    {
                        int i1=Integer.parseInt(singlesecond);
                        int i2=i1*2;
                        stringfare=String.valueOf(i2);
                        intfare=Integer.parseInt(stringfare);
                        memberfarecount(intfare);
                    }
                    String ticketfare=TicketFareLabel.getText();
                    TicketFareLabel.setText(ticketfare.replace(ticketfare,ticketfare.substring(0,21)+stringrevisedfare+"/-"));
                    Label2.setVisible(true);
                    TicketFareLabel.setVisible(true);
                    TicketExpiryLabel.setVisible(true);
                    BookTicketButton.setVisible(true);
                    GenerateFareButton.setVisible(false);
                }
            }
        });

        BookTicketButton.addActionListener(_ ->
        {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME)))
            {
                String line = reader.readLine();
                value = Integer.parseInt(line);
            }
            catch (IOException ie)
            {
                System.out.println("Error!");
            }
            int i=value++;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME)))
            {
                writer.write(String.valueOf(value));
            }
            catch (IOException ie)
            {
                System.out.println("Error!");
            }

            String teno=String.valueOf(i);
            String route=sourcestation+" to "+destinationstation;
            String totalmembers=(String) MemberCountComboBox.getSelectedItem();
            DateTimeFormatter DateFormat=DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDateTime Date= LocalDateTime.now();
            DateTimeFormatter TimeFormat=DateTimeFormatter.ofPattern("HH:mm");
            LocalDateTime Time=LocalDateTime.now();
            String dateandtime=DateFormat.format(Date)+" "+TimeFormat.format(Time);
            setVisible(false);
            new Payment(username,linename,teno,route,tickettype,classtype,totalmembers,stringrevisedfare,dateandtime);
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
            new UserMain(username);
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        requestFocusInWindow();
    }

    public static void main(String[] args)
    {
        new UserBookTickets("","");
    }
}
