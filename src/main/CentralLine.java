import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class CentralLine extends JFrame
{
    String username,source;
    JComboBox<String> SourceStationComboBox, DestinationStationComboBox;
    JButton UpDownButton, SearchButton, BackButton;
    
    CentralLine(String username,String source)
    {
        this.username=username;
        this.source=source;
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

        String[] StationComboBoxElements={
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

        Arrays.sort(StationComboBoxElements);

        JLabel SourceStationLabel=new JLabel("Source Station :");
        SourceStationLabel.setBounds(358, 200, 300, 30);
        SourceStationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        SourceStationLabel.setForeground(Color.WHITE);
        add(SourceStationLabel);

        SourceStationComboBox =new JComboBox<>(StationComboBoxElements);
        SourceStationComboBox.setBounds(670, 200, 200, 30);
        SourceStationComboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
        SourceStationComboBox.setForeground(Color.BLACK);
        add(SourceStationComboBox);
        SourceStationComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel DestinationStationLabel=new JLabel("Destination Station :");
        DestinationStationLabel.setBounds(358, 270, 300, 30);
        DestinationStationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        DestinationStationLabel.setForeground(Color.WHITE);
        add(DestinationStationLabel);

        DestinationStationComboBox =new JComboBox<>(StationComboBoxElements);
        DestinationStationComboBox.setBounds(670, 270, 200, 30);
        DestinationStationComboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
        DestinationStationComboBox.setForeground(Color.BLACK);
        add(DestinationStationComboBox);
        DestinationStationComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        ImageIcon ImageIcon3 = new ImageIcon("assets/updown.png");
        Image Image2=ImageIcon3.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        ImageIcon ImageIcon4=new ImageIcon(Image2);

        UpDownButton =new JButton(ImageIcon4);
        UpDownButton.setBounds(752, 232, 35, 35);
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

        SearchButton =new JButton("Search");
        SearchButton.setBounds(563, 340, 105, 40);
        SearchButton.setFont(new Font("Georgia", Font.BOLD,20));
        SearchButton.setBackground(Color.MAGENTA);
        SearchButton.setForeground(Color.WHITE);
        add(SearchButton);
        SearchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel TrainScheduleLabel=new JLabel("|| Train Schedule ||");
        TrainScheduleLabel.setBounds(466, 410, 350, 30);
        TrainScheduleLabel.setFont(new Font("Georgia", Font.BOLD, 30));
        TrainScheduleLabel.setForeground(Color.WHITE);
        add(TrainScheduleLabel);

        DefaultTableModel TrainScheduleTableModel=new DefaultTableModel();
        TrainScheduleTableModel.addColumn("Train Time");
        TrainScheduleTableModel.addColumn("Train Name");
        TrainScheduleTableModel.addColumn("Train Type");

        JTable TrainScheduleTable=new JTable(TrainScheduleTableModel);
        TrainScheduleTable.setBounds(315, 460, 600, 205);
        TrainScheduleTable.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        TrainScheduleTable.setBackground(Color.WHITE);
        TrainScheduleTable.setForeground(Color.BLACK);
        TrainScheduleTable.setRowHeight(25);
        add(TrainScheduleTable);
        TrainScheduleTable.setEnabled(false);

        JTableHeader TrainScheduleTableHeader=TrainScheduleTable.getTableHeader();
        TrainScheduleTableHeader.setFont(new Font("Georgia", Font.BOLD, 20));
        TrainScheduleTableHeader.setBackground(Color.BLACK);
        TrainScheduleTableHeader.setForeground(Color.WHITE);
        TrainScheduleTableHeader.setEnabled(false);

        TableColumnModel TrainScheduleTableColumnModel=TrainScheduleTable.getColumnModel();
        TrainScheduleTableColumnModel.getColumn(0).setCellRenderer(new DefaultTableCellRenderer());
        TrainScheduleTableColumnModel.getColumn(1).setCellRenderer(new DefaultTableCellRenderer());
        TrainScheduleTableColumnModel.getColumn(2).setCellRenderer(new DefaultTableCellRenderer());
        ((DefaultTableCellRenderer) TrainScheduleTableColumnModel.getColumn(0).getCellRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((DefaultTableCellRenderer) TrainScheduleTableColumnModel.getColumn(1).getCellRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((DefaultTableCellRenderer) TrainScheduleTableColumnModel.getColumn(2).getCellRenderer()).setHorizontalAlignment(JLabel.CENTER);

        JScrollPane TrainScheduleTableScrollPane=new JScrollPane(TrainScheduleTable);
        TrainScheduleTableScrollPane.setBounds(315, 460, 600, 205);
        add(TrainScheduleTableScrollPane);

        SourceStationComboBox.addActionListener(_ ->
        {
            int TrainScheduleTableRows = TrainScheduleTableModel.getRowCount();
            if (TrainScheduleTableRows != 0)
            {
                for (int i = TrainScheduleTableRows - 1; i >= 0; i--)
                {
                    TrainScheduleTableModel.removeRow(i);
                }
            }
        });

        DestinationStationComboBox.addActionListener(_ ->
        {
            int TrainScheduleTableRows = TrainScheduleTableModel.getRowCount();
            if (TrainScheduleTableRows != 0)
            {
                for (int i = TrainScheduleTableRows - 1; i >= 0; i--)
                {
                    TrainScheduleTableModel.removeRow(i);
                }
            }
        });

        SearchButton.addActionListener(new ActionListener()
        {
            public void TrainScheduleMethod1()
            {
                TrainScheduleTableModel.addRow(new Object[] {"04:19 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:28 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:32 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:47 AM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:52 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:56 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:00 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:06 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:07 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:10 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:16 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:22 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:26 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:30 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:33 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:40 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:43 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:50 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:51 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:56 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:00 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:01 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:04 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:08 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:11 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:16 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:23 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:24 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:28 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:32 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:36 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:40 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:46 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:48 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:50 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:54 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:56 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:59 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:00 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:05 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:08 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:09 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:12 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:13 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:16 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:17 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:21 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:24 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:26 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:28 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:30 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:32 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:36 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:36 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:40 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:46 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:48 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:51 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:53 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:56 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:58 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:00 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:04 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:08 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:12 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:12 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:20 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:20 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:24 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:26 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:29 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:37 AM","Ghatkopar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:37 AM","Chembur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:42 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:45 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:46 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:49 AM","Thakurli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:50 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:53 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:54 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:58 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:01 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:02 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:05 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:06 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:09 AM","Ghatkopar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:10 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:14 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:16 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:18 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:22 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:23 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:26 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:26 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:37 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:38 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:41 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:42 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:45 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:45 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:48 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:49 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:52 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:53 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:55 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:57 AM","Ghatkopar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:59 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:03 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:04 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:06 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:07 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:10 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:14 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:14 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:18 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:18 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:22 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:22 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:26 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:27 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:30 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:30 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:34 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:34 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:38 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:39 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:41 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:44 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:45 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:51 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:52 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:56 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:56 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:00 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:00 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:04 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:07 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:08 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:12 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:12 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:20 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:20 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:24 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:26 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:32 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:36 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:36 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:40 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:40 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:45 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:48 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:50 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:52 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:54 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:56 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:58 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:00 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:07 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:08 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:12 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:15 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:17 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:21 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:24 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:25 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:27 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:29 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:32 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:36 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:38 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:39 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:44 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:47 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:48 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:51 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:55 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:58 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:58 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:02 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:03 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:06 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:07 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:10 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:11 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:15 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:19 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:26 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:26 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:34 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:38 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:42 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:46 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:48 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:50 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:52 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:54 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:56 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:04 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:07 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:11 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:15 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:18 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:20 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:22 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:25 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:28 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:29 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:34 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:34 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:38 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:40 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:44 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:46 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:48 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:52 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:54 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:56 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:58 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:00 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:01 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:04 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:08 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:09 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:12 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:16 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:18 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:20 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:24 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:24 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:28 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:28 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:32 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:32 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:36 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:40 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:44 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:45 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:48 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:54 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:57 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:00 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:00 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:04 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:04 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:08 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:08 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:12 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:13 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:16 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:17 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:21 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:23 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:27 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:30 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:31 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:34 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:35 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:39 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:43 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:43 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:47 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:48 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:51 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:52 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:56 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:00 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:00 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:04 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:04 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:08 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:16 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:16 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:20 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:24 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:26 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:29 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:32 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:33 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:36 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:37 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:41 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:44 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:45 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:48 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:50 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:53 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:57 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:57 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:01 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:03 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:05 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:07 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:08 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:12 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:16 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:18 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:22 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:22 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:26 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:26 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:33 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:33 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:45 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:45 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:49 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:49 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:53 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:57 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:58 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:01 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:05 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:07 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:09 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:13 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:14 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:17 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:18 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:22 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:24 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:28 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:32 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:34 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:36 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:38 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:40 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:44 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:45 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:48 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:50 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:52 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:55 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:56 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:04 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:04 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:08 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:10 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:13 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:20 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:22 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:26 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:28 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:30 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:32 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:34 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:36 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:38 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:40 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:46 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:49 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:52 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:54 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:00 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:02 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:04 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:06 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:08 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:10 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:14 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:16 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:18 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:22 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:26 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:28 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:32 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:36 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:38 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:40 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:42 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:44 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:46 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:50 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:54 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:56 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:58 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:02 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:04 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:06 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:08 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:10 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:14 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:16 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:20 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:20 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:24 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:24 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:28 PM","Khopoli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:30 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:31 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:34 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:38 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:42 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:45 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:46 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:50 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:50 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:54 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:54 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:58 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:00 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:02 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:04 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:08 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:14 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 PM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:20 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:23 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:26 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 PM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:34 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:35 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:38 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:46 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:46 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:51 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:52 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:55 PM","Thane","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:57 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:58 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:59 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:02 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:05 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:05 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:08 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:12 AM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:13 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:17 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:24 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:36 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:40 AM","Panvel","Slow"});
            }

            public void TrainScheduleMethod2()
            {
                TrainScheduleTableModel.addRow(new Object[] {"04:19 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:47 AM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:00 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:07 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:16 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:40 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:51 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:01 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:23 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:48 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:56 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:00 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:08 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:12 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:16 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:24 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:28 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:32 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:36 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:46 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:53 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:58 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:08 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:12 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:20 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:26 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:37 AM","Ghatkopar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:45 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:49 AM","Thakurli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:53 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:01 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:05 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:09 AM","Ghatkopar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:16 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:23 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:26 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:37 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:41 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:45 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:49 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:53 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:57 AM","Ghatkopar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:04 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:07 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:14 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:18 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:22 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:27 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:30 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:34 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:39 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:44 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:51 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:56 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:00 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:04 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:07 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:12 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:20 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:24 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:36 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:40 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:45 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:50 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:54 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:58 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:07 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:15 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:24 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:27 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:32 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:38 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:44 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:48 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:58 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:02 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:06 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:10 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:26 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:42 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:46 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:50 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:54 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:07 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:11 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:15 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:20 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:25 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:29 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:34 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:38 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:46 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:54 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:58 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:01 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:09 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:18 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:24 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:28 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:32 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:40 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:45 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:57 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:00 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:04 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:08 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:13 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:17 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:21 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:30 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:34 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:43 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:48 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:52 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:00 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:04 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:08 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:16 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:24 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:32 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:36 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:44 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:48 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:57 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:03 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:07 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:18 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:22 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:26 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:33 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:45 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:49 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:58 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:07 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:14 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:18 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:22 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:34 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:38 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:45 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:50 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:55 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:04 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:10 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:13 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:22 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:26 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:30 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:34 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:38 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:52 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:00 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:04 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:08 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:16 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:28 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:32 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:36 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:40 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:44 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:56 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:04 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:08 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:16 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:20 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:24 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:28 PM","Khopoli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:31 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:42 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:46 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:50 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:54 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:00 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:04 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:08 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 PM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:23 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 PM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:34 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:35 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:46 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:51 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:55 PM","Thane","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:58 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:59 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:02 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:05 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:08 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:12 AM","Karjat","Slow"});
            }

            public void TrainScheduleMethod3()
            {
                TrainScheduleTableModel.addRow(new Object[] {"04:19 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:32 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:35 AM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:47 AM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:52 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:00 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:06 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:07 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:16 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:22 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:30 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:40 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:43 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:46 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:51 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:56 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:00 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:01 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:06 AM","Kalyan","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:08 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:10 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:16 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:23 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:24 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:24 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:32 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:40 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:46 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:48 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:49 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:54 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:55 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:56 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:59 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:00 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:05 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:08 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:09 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:12 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:13 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:16 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:17 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:22 AM","Kalyan","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:24 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:26 AM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:26 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:28 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:30 AM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:30 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:32 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:36 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:40 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:46 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:48 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:53 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:55 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:56 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:58 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:00 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:08 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:12 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:12 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:20 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:20 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:24 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:26 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:36 AM","Kalyan","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:37 AM","Ghatkopar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:37 AM","Chembur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:45 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:45 AM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:46 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 AM","Thane","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:49 AM","Thakurli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:52 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:53 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:54 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:58 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:01 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:01 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:05 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:05 AM","Thane","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:06 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:09 AM","Ghatkopar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:09 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:10 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 AM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:15 AM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:16 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:18 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 AM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:22 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:23 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:23 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:26 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:27 AM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:37 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:38 AM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:38 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:41 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:42 AM","Thane","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:45 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:45 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:46 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:48 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:49 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:52 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:53 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:57 AM","Ghatkopar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:57 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:59 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:03 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:04 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:07 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:08 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:10 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:12 AM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:14 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:14 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:16 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:18 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:18 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:20 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:22 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:25 AM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:26 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:27 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:30 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:30 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:34 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:34 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:36 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:39 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:40 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:41 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:44 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:45 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:51 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:52 AM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:52 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:56 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:56 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:58 AM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:00 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:04 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:07 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:08 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:12 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:14 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 AM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:20 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:20 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:24 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:26 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:32 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:36 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:37 AM","Dombivli","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:40 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:40 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:45 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:50 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:50 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:52 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:54 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:56 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:58 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:07 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:08 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:15 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:17 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:20 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:24 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:25 PM","Kalyan","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:25 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:27 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:29 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:30 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:32 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:38 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:39 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:44 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:48 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:51 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:53 PM","Kalyan","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:55 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:58 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:02 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:03 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:06 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:07 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:10 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:15 PM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:15 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:19 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:19 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:23 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:26 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:34 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:40 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:42 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:46 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:48 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:50 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:50 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:54 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:56 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:07 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:11 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:15 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:17 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:20 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:22 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:25 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:29 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:34 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:34 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:38 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:42 PM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:44 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:45 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:46 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:48 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:54 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:56 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:58 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:00 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:01 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:03 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:08 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:09 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:10 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:12 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:14 PM","Kalyan","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:16 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:18 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:24 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:24 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:28 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:28 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:32 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:35 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:36 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:39 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:40 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:44 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:45 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:54 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:57 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:00 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:00 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:04 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:08 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:08 PM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:08 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:12 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:13 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:17 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:17 PM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:21 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:23 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:27 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:30 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:30 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:34 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:35 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:39 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:42 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:43 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:47 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:48 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:50 PM","Kasara","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:51 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:52 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:00 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:00 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:04 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:04 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:08 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:16 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:16 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:19 PM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:20 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:22 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:24 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:25 PM","Kalyan","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:26 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:29 PM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:32 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:33 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:33 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:36 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:37 PM","Dombivli","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:41 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:41 PM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:44 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:45 PM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:45 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:48 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:53 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:56 PM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:57 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:57 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:59 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:01 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:03 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:03 PM","Kalyan","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:06 PM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:07 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:08 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:12 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:16 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:18 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:21 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:22 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:25 PM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:26 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:26 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:28 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:32 PM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:33 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:33 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:39 PM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:42 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:45 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:49 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:49 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:50 PM","Kalyan","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:53 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:57 PM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:57 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:58 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:00 PM","Thane","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:01 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:05 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:07 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:13 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:14 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:14 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:17 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:18 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:18 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:22 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:23 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:28 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:29 PM","Kalyan","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:30 PM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:32 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:34 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:36 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:38 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:44 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:45 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:46 PM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:48 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:50 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:50 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:52 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:55 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:00 PM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:04 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:04 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:10 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:13 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:22 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:26 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:28 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:30 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:32 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:34 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:38 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:40 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:44 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:47 PM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:49 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:52 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:00 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:02 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:04 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:06 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:08 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:14 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:16 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:18 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:26 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:26 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:28 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:32 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:36 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:38 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:40 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:42 PM","Kalyan","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:42 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:44 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:50 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:54 PM","Kalyan","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:54 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:56 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:58 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:58 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:04 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:06 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:08 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:14 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:16 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:20 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:20 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:24 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:25 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:28 PM","Khopoli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:30 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:31 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:34 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:42 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:45 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:46 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:47 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:50 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:50 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:54 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:58 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:00 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:04 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:08 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:14 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 PM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:20 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:23 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 PM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:34 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:35 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:46 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:51 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:52 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:55 PM","Thane","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:57 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:58 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:59 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:02 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:05 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:05 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:08 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:12 AM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:13 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:24 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:40 AM","Panvel","Slow"});
            }

            public void TrainScheduleMethod4()
            {
                TrainScheduleTableModel.addRow(new Object[] {"04:19 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:35 AM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:47 AM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:00 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:07 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:16 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:40 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:46 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:51 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:01 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:06 AM","Kalyan","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:10 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:23 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:24 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:32 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:46 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:48 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:49 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:55 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:56 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:00 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:05 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:08 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:12 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:13 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:16 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:22 AM","Kalyan","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:24 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:26 AM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:28 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:30 AM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:30 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:32 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:36 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:46 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:48 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:53 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:55 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:58 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:08 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:12 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:20 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:20 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:26 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:36 AM","Kalyan","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:37 AM","Ghatkopar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:45 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:45 AM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 AM","Thane","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:49 AM","Thakurli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:52 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:53 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:58 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:01 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:01 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:05 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:05 AM","Thane","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:09 AM","Ghatkopar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:09 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 AM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:15 AM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:16 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 AM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:23 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:23 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:26 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:27 AM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:37 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:38 AM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:38 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:41 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:42 AM","Thane","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:45 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:46 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:49 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:53 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:57 AM","Ghatkopar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:57 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:59 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:04 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:07 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:08 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:12 AM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:14 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:14 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:16 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:18 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:20 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:22 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:25 AM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:26 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:27 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:30 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:30 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:34 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:36 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:39 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:40 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:44 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:51 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:52 AM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:56 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:56 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:58 AM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:00 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:04 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:07 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:12 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:14 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 AM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:20 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:24 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:32 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:36 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:37 AM","Dombivli","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:40 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:45 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:50 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:50 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:54 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:58 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:07 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:08 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:15 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:17 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:20 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:24 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:25 PM","Kalyan","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:25 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:27 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:29 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:30 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:32 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:38 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:39 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:44 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:48 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:51 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:53 PM","Kalyan","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:55 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:58 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:02 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:03 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:06 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:07 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:10 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:15 PM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:15 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:19 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:19 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:23 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:26 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:34 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:40 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:42 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:46 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:48 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:50 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:50 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:54 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:56 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:07 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:11 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:15 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:17 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:20 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:22 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:25 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:29 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:34 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:34 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:38 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:42 PM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:44 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:45 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:46 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:48 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:54 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:56 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:58 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:00 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:01 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:03 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:08 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:09 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:10 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:12 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:14 PM","Kalyan","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:16 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:18 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:24 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:24 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:28 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:28 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:32 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:35 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:36 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:39 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:40 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:44 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:45 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:54 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:57 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:00 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:00 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:04 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:08 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:08 PM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:08 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:12 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:13 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:17 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:17 PM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:21 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:23 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:27 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:30 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:30 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:34 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:35 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:39 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:42 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:43 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:47 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:48 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:50 PM","Kasara","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:51 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:52 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:00 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:00 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:04 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:04 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:08 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:16 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:16 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:19 PM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:20 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:22 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:24 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:25 PM","Kalyan","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:26 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:29 PM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:32 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:33 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:33 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:36 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:37 PM","Dombivli","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:41 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:41 PM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:44 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:45 PM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:45 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:48 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:53 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:56 PM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:57 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:57 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:59 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:01 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:03 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:03 PM","Kalyan","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:06 PM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:07 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:08 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:12 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:16 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:18 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:21 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:22 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:25 PM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:26 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:26 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:28 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:32 PM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:33 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:33 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:39 PM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:42 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:45 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:49 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:49 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:50 PM","Kalyan","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:53 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:57 PM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:57 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:58 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:00 PM","Thane","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:01 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:05 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:07 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:13 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:14 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:14 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:17 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:18 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:18 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:22 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:23 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:28 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:29 PM","Kalyan","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:30 PM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:32 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:34 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:36 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:38 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:44 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:45 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:46 PM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:48 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:50 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:50 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:52 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:55 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:00 PM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:04 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:04 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:10 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:13 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:22 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:26 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:28 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:30 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:32 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:34 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:38 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:40 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:44 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:47 PM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:49 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:52 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:00 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:02 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:04 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:06 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:08 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:14 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:16 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:18 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:26 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:26 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:28 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:32 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:36 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:38 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:40 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:42 PM","Kalyan","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:42 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:44 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:50 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:54 PM","Kalyan","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:54 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:56 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:58 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:58 PM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:04 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:06 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:08 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:14 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:16 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:20 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:20 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:24 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:25 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:28 PM","Khopoli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:30 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:31 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:34 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:42 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:45 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:46 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:47 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:50 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:50 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:54 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:58 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:00 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:04 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:08 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:14 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 PM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:20 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:23 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 PM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:34 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:35 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:46 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:51 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:52 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:55 PM","Thane","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:57 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:58 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:59 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:02 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:05 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:05 AM","Belapur CBD","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:08 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:12 AM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:13 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:24 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:40 AM","Panvel","Slow"});
            }

            public void TrainScheduleMethod5()
            {
                TrainScheduleTableModel.addRow(new Object[] {"04:19 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:47 AM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:00 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:07 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:16 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:40 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:51 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:01 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:23 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:48 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:56 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:00 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:08 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:12 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:16 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:24 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:28 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:32 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:36 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:46 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:53 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:58 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:08 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:12 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:20 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:26 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:37 AM","Ghatkopar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:45 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:49 AM","Thakurli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:01 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:05 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:09 AM","Ghatkopar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:16 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:26 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:37 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:41 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:49 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:53 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:57 AM","Ghatkopar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:04 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:07 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:14 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:18 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:22 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:27 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:34 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:39 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:51 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:56 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:04 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:07 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:20 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:24 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:36 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:40 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:45 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:50 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:54 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:58 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:07 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:15 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:24 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:27 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:32 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:38 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:44 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:48 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:58 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:02 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:06 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:10 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:26 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:42 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:46 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:50 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:54 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:07 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:11 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:15 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:20 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:25 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:29 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:34 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:38 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:46 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:54 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:58 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:01 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:09 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:18 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:24 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:28 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:32 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:40 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:45 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:57 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:00 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:04 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:08 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:13 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:17 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:21 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:30 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:34 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:48 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:52 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:00 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:04 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:08 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:16 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:24 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:32 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:36 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:48 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:57 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:03 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:07 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:18 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:26 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:33 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:45 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:58 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:07 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:14 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:18 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:22 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:34 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:38 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:45 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:50 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:55 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:04 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:10 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:13 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:22 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:26 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:30 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:34 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:38 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:52 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:00 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:04 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:08 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:16 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:28 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:32 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:40 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:44 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:04 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:08 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:16 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:20 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:24 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:28 PM","Khopoli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:42 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:46 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:50 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:00 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:08 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 PM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 PM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:46 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:51 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:55 PM","Thane","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:02 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:08 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:12 AM","Karjat","Slow"});
            }

            public void TrainScheduleMethod6()
            {
                TrainScheduleTableModel.addRow(new Object[] {"04:19 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:47 AM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:00 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:07 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:16 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:40 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:51 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:01 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:23 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:24 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:48 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:56 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:00 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:08 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:12 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:16 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:24 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:28 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:32 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:36 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:46 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:53 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:58 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:08 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:12 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:20 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:26 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:45 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 AM","Thane","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:49 AM","Thakurli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:01 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:05 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:09 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:16 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:26 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:27 AM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:37 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:41 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:46 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:49 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:53 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:04 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:07 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:08 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:14 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:18 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:20 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:22 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:27 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:34 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:39 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:40 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:51 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:56 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:04 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:07 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:20 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:24 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:36 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:40 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:45 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:50 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:54 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:58 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:07 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:15 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:24 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:27 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:32 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:38 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:44 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:48 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:58 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:02 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:06 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:10 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:26 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:42 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:46 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:50 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:54 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:07 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:11 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:15 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:20 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:25 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:29 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:34 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:38 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:46 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:54 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:58 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:01 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:09 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:18 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:24 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:28 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:32 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:40 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:45 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:57 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:00 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:04 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:08 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:08 PM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:13 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:17 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:21 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:30 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:34 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:48 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:52 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:00 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:04 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:08 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:16 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:22 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:24 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:32 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:36 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:41 PM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:48 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:57 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:03 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:03 PM","Kalyan","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:07 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:18 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:26 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:32 PM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:33 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:45 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:57 PM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:58 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:00 PM","Thane","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:07 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:14 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:18 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:22 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:30 PM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:34 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:38 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:45 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:50 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:55 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:04 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:10 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:13 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:22 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:26 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:30 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:34 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:38 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:52 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:00 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:04 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:08 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:16 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:28 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:32 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:40 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:42 PM","Kalyan","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:44 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:04 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:08 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:16 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:20 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:24 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:28 PM","Khopoli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:42 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:46 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:50 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:00 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:08 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 PM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 PM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:38 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:46 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:51 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:55 PM","Thane","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:02 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:08 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:12 AM","Karjat","Slow"});
            }

            public void TrainScheduleMethod7()
            {
                TrainScheduleTableModel.addRow(new Object[] {"04:19 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:47 AM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:07 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:16 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:40 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:51 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:01 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:23 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:48 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:56 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:08 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:16 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:24 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:26 AM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:32 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:36 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:53 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:12 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:20 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:05 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:16 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:26 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:27 AM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:37 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:38 AM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:53 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:04 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:14 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:34 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:58 AM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:04 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:20 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:24 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 AM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:40 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:54 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:07 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:15 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:27 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:38 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:44 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:48 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:02 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:10 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:15 PM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:26 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:42 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:46 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:50 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:54 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:07 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:11 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:15 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:20 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:34 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:38 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:42 PM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:46 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:54 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:58 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:09 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:18 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:32 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:40 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:45 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:57 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:04 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:13 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:21 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:34 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:48 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:50 PM","Kasara","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:00 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:08 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:16 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:25 PM","Kalyan","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:36 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:37 PM","Dombivli","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:57 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:03 PM","Kalyan","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:33 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:42 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:50 PM","Kalyan","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:14 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:18 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:34 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:38 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:50 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:00 PM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:04 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:13 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:26 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:30 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:38 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:08 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 PM","Dombivli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:28 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:32 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:40 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:44 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:04 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:24 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:28 PM","Khopoli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:42 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:50 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:08 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 PM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 PM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:51 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:02 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:08 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:12 AM","Karjat","Slow"});
            }

            public void TrainScheduleMethod8()
            {
                TrainScheduleTableModel.addRow(new Object[] {"04:19 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:47 AM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:07 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:16 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:40 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:51 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:01 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:10 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:48 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:55 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:56 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:08 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:24 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:26 AM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:32 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:53 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:55 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:12 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:05 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:26 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:27 AM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:37 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:38 AM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:53 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:57 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:04 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:14 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:16 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:25 AM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:58 AM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:04 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 AM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:20 AM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:24 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:40 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:54 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:07 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:15 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:27 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:30 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:44 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:48 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:02 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:10 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:15 PM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:19 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:26 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:42 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:46 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:50 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:50 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:07 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:11 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:15 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:17 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:20 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:34 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:38 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:42 PM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:45 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:46 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:54 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:58 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:09 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:18 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:32 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:35 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:40 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:57 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:04 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:13 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:17 PM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:21 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:42 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:48 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:50 PM","Kasara","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:00 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:16 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:19 PM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:25 PM","Kalyan","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:36 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:56 PM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:03 PM","Kalyan","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:21 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:33 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:39 PM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:50 PM","Kalyan","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:14 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:18 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:34 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:38 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:50 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:00 PM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:04 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:13 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:26 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:30 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:38 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:47 PM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:08 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:28 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:32 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:40 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:44 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:52 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:04 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:24 PM","Kalyan","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:28 PM","Khopoli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:42 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:08 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 PM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 PM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:51 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:02 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:08 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:12 AM","Karjat","Slow"});
            }

            public void TrainScheduleMethod9()
            {
                TrainScheduleTableModel.addRow(new Object[] {"04:19 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:07 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:51 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:01 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:55 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:56 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:26 AM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 AM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 AM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:27 AM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:38 AM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:53 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:16 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:58 AM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:04 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:24 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:54 AM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:30 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:44 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:10 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:15 PM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:42 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:07 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:17 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:42 PM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:46 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:09 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:32 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:40 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:17 PM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:21 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:50 PM","Kasara","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:19 PM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:29 PM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:45 PM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:56 PM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:28 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:32 PM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:39 PM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:57 PM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:18 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:30 PM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:46 PM","Titwala","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:00 PM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:04 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:30 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:44 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:32 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:47 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:50 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 PM","Titwala","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 PM","Titwala","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:08 AM","Kasara","Slow"});
            }

            public void TrainScheduleMethod10()
            {
                TrainScheduleTableModel.addRow(new Object[] {"04:19 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:07 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:01 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:55 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:26 AM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 AM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:16 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:30 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:10 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:15 PM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:17 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:42 PM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:46 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:32 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:17 PM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:50 PM","Kasara","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:19 PM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:45 PM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:28 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:32 PM","Asangaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:18 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:00 PM","Asangaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:44 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 PM","Asangaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:32 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:47 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:08 AM","Kasara","Slow"});
            }

            public void TrainScheduleMethod11()
            {
                TrainScheduleTableModel.addRow(new Object[] {"04:19 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:07 AM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:55 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:16 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 AM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:30 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:10 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:17 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:46 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:50 PM","Kasara","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:28 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:18 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:44 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:32 PM","Kasara","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:47 PM","Kasara","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:08 AM","Kasara","Slow"});
            }

            public void TrainScheduleMethod12()
            {
                TrainScheduleTableModel.addRow(new Object[] {"04:35 AM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:47 AM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:16 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:40 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:46 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:10 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:24 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:48 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:49 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:05 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:30 AM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:55 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:45 AM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:52 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:01 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:09 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:15 AM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:23 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:46 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:57 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:08 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:12 AM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:20 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:25 AM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:36 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:40 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:52 AM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:14 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 AM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:40 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:50 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:20 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:48 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:19 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:23 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:40 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:50 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:50 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:15 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:34 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:45 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:54 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:03 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:10 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:35 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:39 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:08 PM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:13 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:30 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:42 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:22 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:33 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:41 PM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:59 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:06 PM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:21 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:25 PM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:33 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:34 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:50 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:13 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:38 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:47 PM","Ambernath","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:08 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:28 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:40 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:44 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:28 PM","Khopoli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:42 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:08 PM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 PM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:51 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:02 AM","Ambernath","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:12 AM","Karjat","Slow"});
            }

            public void TrainScheduleMethod13()
            {
                TrainScheduleTableModel.addRow(new Object[] {"04:35 AM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:47 AM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:46 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:10 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:24 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:49 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:05 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:30 AM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:55 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:52 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:01 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:09 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:23 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:46 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:57 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:08 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:20 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:36 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:40 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:14 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:50 AM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:20 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:19 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:23 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:40 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:50 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:50 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:15 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:45 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:03 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:10 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:35 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:39 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:30 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:42 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:22 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:33 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:59 PM","Badlapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:21 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:34 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:50 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:08 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:28 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:44 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:28 PM","Khopoli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:42 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 PM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:51 PM","Badlapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:12 AM","Karjat","Slow"});
            }

            public void TrainScheduleMethod14()
            {
                TrainScheduleTableModel.addRow(new Object[] {"04:35 AM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:47 AM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:46 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:10 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:49 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:30 AM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:01 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:57 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:36 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:14 AM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:20 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:19 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:40 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:45 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:10 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:35 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:30 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:33 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:21 PM","Karjat","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:28 PM","Khopoli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 PM","Karjat","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:12 AM","Karjat","Slow"});
            }

            public void TrainScheduleMethod15()
            {
                TrainScheduleTableModel.addRow(new Object[] {"04:35 AM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:30 AM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:20 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:10 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:33 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:58 PM","Khopoli","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:28 PM","Khopoli","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 PM","Khopoli","Fast"});
            }

            public void TrainScheduleMethod16()
            {
                TrainScheduleTableModel.addRow(new Object[] {"03:51 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:59 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:10 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:57 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:22 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:18 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:18 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:10 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:19 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:31 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:42 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:35 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:16 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:02 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:17 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:15 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:21 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 PM","CSMT","Slow"});
            }

            public void TrainScheduleMethod17()
            {
                TrainScheduleTableModel.addRow(new Object[] {"05:08 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:34 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:58 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:06 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:48 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:20 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:33 PM","CSMT","Slow"});
            }

            public void TrainScheduleMethod18()
            {
                TrainScheduleTableModel.addRow(new Object[] {"03:55 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:23 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:39 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:49 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:55 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:06 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:14 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:29 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:35 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:47 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:55 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:59 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:07 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:11 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:15 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:19 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:27 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:27 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:31 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:51 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:55 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:03 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:11 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:15 AM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:19 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:22 AM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:28 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:32 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:36 AM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:47 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:50 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:54 AM","Dadar Central","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:01 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:06 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:09 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:13 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:17 AM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:24 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:28 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:36 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:44 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:52 AM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:00 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:22 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:33 AM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:46 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:55 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:06 AM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:18 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:36 AM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:52 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:02 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:10 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 AM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:29 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:41 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:50 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:02 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:11 PM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:19 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:31 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:39 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:48 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:58 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:07 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:20 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:31 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:40 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:51 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:02 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:11 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:19 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:27 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:38 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:48 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:08 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:26 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:50 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:59 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:14 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:25 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:34 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:49 PM","Dadar","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:02 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:23 PM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:40 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:55 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:11 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:28 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:39 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:52 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:05 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:15 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:25 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:37 PM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:48 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:05 PM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:25 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:38 PM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:01 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:10 PM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:19 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:27 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:42 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:55 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:07 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:19 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:28 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:37 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:49 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:58 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:07 PM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:27 PM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:43 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:54 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:03 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:11 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:15 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:19 AM","CSMT","Slow"});
            }

            public void TrainScheduleMethod19()
            {
                TrainScheduleTableModel.addRow(new Object[] {"03:55 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:23 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:39 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:49 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:55 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:06 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:14 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:29 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:35 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:47 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:55 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:59 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:07 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:11 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:15 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:19 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:27 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:27 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:31 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:51 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:55 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:03 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:11 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:15 AM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:19 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:22 AM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:28 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:32 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:36 AM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:47 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:50 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:54 AM","Dadar Central","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:01 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:06 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:09 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:13 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:17 AM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:24 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:28 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:36 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:52 AM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:00 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:22 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:33 AM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:46 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:55 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:06 AM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:18 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:36 AM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:52 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:02 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:10 AM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 AM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:41 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:02 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:11 PM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:19 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:31 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:39 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:48 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:58 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:07 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:20 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:31 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:40 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:51 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:02 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:11 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:19 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:27 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:38 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:08 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:26 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:50 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:59 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:14 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:34 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:49 PM","Dadar","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:02 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:23 PM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:40 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:55 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:11 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:28 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:39 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:52 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:05 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:15 PM","Kurla","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:37 PM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:48 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:05 PM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:25 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:38 PM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:01 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:10 PM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:27 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:42 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:55 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:07 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:19 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:28 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:37 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:49 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:58 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:07 PM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:27 PM","Parel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:43 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:03 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:19 AM","CSMT","Slow"});
            }

            public void TrainScheduleMethod20()
            {
                TrainScheduleTableModel.addRow(new Object[] {"03:55 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:23 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:39 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:49 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:55 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:06 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:14 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:29 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:35 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:47 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:55 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:59 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:07 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:11 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:15 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:19 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:27 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:27 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:31 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:51 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:55 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:03 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:11 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:19 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:28 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:32 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:47 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:50 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:01 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:06 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:09 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:13 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:24 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:28 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:36 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:00 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:22 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:46 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:55 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:18 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:52 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:02 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:41 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:02 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:19 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:31 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:39 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:48 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:58 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:07 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:20 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:31 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:40 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:51 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:02 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:11 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:19 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:27 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:38 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:08 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:26 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:50 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:59 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:14 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:34 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:02 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:40 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:55 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:11 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:28 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:39 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:52 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:05 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:48 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:25 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:01 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:27 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:42 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:55 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:07 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:19 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:28 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:37 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:49 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:58 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:43 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:03 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:19 AM","CSMT","Slow"});
            }

            @Override
            public void actionPerformed(ActionEvent ae)
            {
                int TrainScheduleTableRows = TrainScheduleTableModel.getRowCount();
                if (TrainScheduleTableRows != 0)
                {
                    for (int i = TrainScheduleTableRows - 1; i >= 0; i--)
                    {
                        TrainScheduleTableModel.removeRow(i);
                    }
                }

                if (Objects.equals(SourceStationComboBox.getSelectedItem(), DestinationStationComboBox.getSelectedItem()))
                {
                    JOptionPane.showMessageDialog(new JFrame(), "The Source and Destination Station both are same!");
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Kasara") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Umbermali") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khardi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thansit") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Atgaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Asangaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vashind") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khadavali") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Titwala") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ambivli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Shahad")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khopoli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Lowjee") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dolavli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kelavli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Palasdari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Karjat") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhivpuri Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Neral") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Shelu") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vangani") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Badlapur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ambernath") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ulhasnagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vitthalwadi")))
                {
                    JOptionPane.showMessageDialog(new JFrame(), "No Trains are available!");
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Khopoli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Lowjee") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dolavli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kelavli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Palasdari") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Karjat") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bhivpuri Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Neral") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Shelu") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vangani") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Badlapur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ambernath") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ulhasnagar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vitthalwadi")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kasara") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Umbermali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khardi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thansit") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Atgaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Asangaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vashind") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khadavali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Titwala") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ambivli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Shahad")))
                {
                    JOptionPane.showMessageDialog(new JFrame(), "No Trains are available!");
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "CSMT") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Masjid Bunder")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road")))
                {
                    TrainScheduleMethod1();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "CSMT") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Byculla")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sion")))
                {
                    TrainScheduleMethod2();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Currey Road")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sion")))
                {
                    TrainScheduleMethod2();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Parel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dadar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sion")))
                {
                    TrainScheduleMethod2();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Matunga")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sion")))
                {
                    TrainScheduleMethod2();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "CSMT") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sandhurst Road")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla")))
                {
                    TrainScheduleMethod3();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Parel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sion")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla")))
                {
                    TrainScheduleMethod4();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "CSMT") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Parel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sion") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vidyavihar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghatkopar")))
                {
                    TrainScheduleMethod5();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "CSMT") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Parel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sion") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vikhroli")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane")))
                {
                    TrainScheduleMethod6();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bhandup")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane")))
                {
                    TrainScheduleMethod6();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mulund")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane")))
                {
                    TrainScheduleMethod6();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "CSMT") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Parel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sion") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thane") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kalwa")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Diva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dombivali")))
                {
                    TrainScheduleMethod7();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Diva")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Diva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dombivali")))
                {
                    TrainScheduleMethod7();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Kopar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dombivali")))
                {
                    TrainScheduleMethod7();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "CSMT") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Parel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sion") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thane") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Diva") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thakurli")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalyan")))
                {
                    TrainScheduleMethod8();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "CSMT") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Parel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sion") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thane") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Diva") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Shahad")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Shahad") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ambivli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Titwala")))
                {
                    TrainScheduleMethod9();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Ambivli")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Titwala")))
                {
                    TrainScheduleMethod9();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "CSMT") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Parel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sion") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thane") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Diva") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Shahad") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ambivli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Titwala") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khadavali")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khadavali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vashind") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Asangaon")))
                {
                    TrainScheduleMethod10();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Vashind")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Asangaon")))
                {
                    TrainScheduleMethod10();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "CSMT") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Parel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sion") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thane") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Diva") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Shahad") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ambivli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Titwala") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khadavali") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vashind") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Asangaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Atgaon")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Atgaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thansit") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khardi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Umbermali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kasara")))
                {
                    TrainScheduleMethod11();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Thansit") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khardi")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khardi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Umbermali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kasara")))
                {
                    TrainScheduleMethod11();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Umbermali")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kasara")))
                {
                    TrainScheduleMethod11();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "CSMT") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Parel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sion") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thane") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Diva") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vitthalwadi")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vitthalwadi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ulhasnagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ambernath")))
                {
                    TrainScheduleMethod12();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Ulhasnagar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ambernath")))
                {
                    TrainScheduleMethod12();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "CSMT") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Parel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sion") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thane") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Diva") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vitthalwadi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ulhasnagar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ambernath")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Badlapur")))
                {
                    TrainScheduleMethod13();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "CSMT") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Parel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sion") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thane") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Diva") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vitthalwadi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ulhasnagar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ambernath") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Badlapur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vangani")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vangani") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Shelu") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Neral") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhivpuri Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Karjat")))
                {
                    TrainScheduleMethod14();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Shelu") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Neral")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Neral") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhivpuri Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Karjat")))
                {
                    TrainScheduleMethod14();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Bhivpuri Road")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Karjat")))
                {
                    TrainScheduleMethod14();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "CSMT") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Parel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sion") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thane") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Diva") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vitthalwadi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ulhasnagar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ambernath") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Badlapur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vangani") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Shelu") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Neral") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bhivpuri Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Karjat") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Palasdari")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Palasdari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kelavli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dolavli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Lowjee") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khopoli")))
                {
                    TrainScheduleMethod15();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Kelavli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dolavli")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dolavli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Lowjee") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khopoli")))
                {
                    TrainScheduleMethod15();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Lowjee")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khopoli")))
                {
                    TrainScheduleMethod15();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Kasara") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Umbermali")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Umbermali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khardi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thansit") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Atgaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Asangaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vashind") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khadavali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Titwala") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ambivli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Shahad") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Diva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sion") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod16();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Khardi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thansit")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thansit") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Atgaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Asangaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vashind") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khadavali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Titwala") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ambivli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Shahad") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Diva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sion") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod16();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Atgaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Asangaon")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Asangaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vashind") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khadavali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Titwala") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ambivli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Shahad") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Diva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sion") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod16();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Vashind") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khadavali")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khadavali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Titwala") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ambivli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Shahad") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Diva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sion") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod16();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Titwala") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ambivli")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ambivli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Shahad") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Diva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sion") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod16();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Shahad")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Diva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sion") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod16();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Khopoli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Lowjee")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Lowjee") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dolavli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kelavli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Palasdari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Karjat") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhivpuri Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Neral") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Shelu") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vangani") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Badlapur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ambernath") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ulhasnagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vitthalwadi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Diva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sion") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod17();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Dolavli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kelavli")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kelavli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Palasdari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Karjat") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhivpuri Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Neral") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Shelu") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vangani") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Badlapur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ambernath") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ulhasnagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vitthalwadi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Diva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sion") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod17();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Palasdari") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Karjat")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Karjat") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhivpuri Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Neral") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Shelu") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vangani") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Badlapur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ambernath") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ulhasnagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vitthalwadi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Diva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sion") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod17();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Bhivpuri Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Neral")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Neral") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Shelu") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vangani") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Badlapur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ambernath") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ulhasnagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vitthalwadi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Diva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sion") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod17();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Shelu") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vangani")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vangani") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Badlapur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ambernath") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ulhasnagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vitthalwadi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Diva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sion") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod17();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Badlapur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ambernath")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ambernath") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ulhasnagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vitthalwadi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Diva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sion") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod17();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Ulhasnagar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vitthalwadi")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vitthalwadi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Diva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sion") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod17();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thakurli")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Diva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane")))
                {
                    TrainScheduleMethod18();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kopar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Diva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane")))
                {
                    TrainScheduleMethod18();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Diva") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mumbra")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane")))
                {
                    TrainScheduleMethod18();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Kalwa")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane")))
                {
                    TrainScheduleMethod18();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Diva") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thane") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mulund")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla")))
                {
                    TrainScheduleMethod19();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bhandup")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla")))
                {
                    TrainScheduleMethod19();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vikhroli")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla")))
                {
                    TrainScheduleMethod19();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vidyavihar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla")))
                {
                    TrainScheduleMethod19();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Kalyan") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thakurli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dombivali") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Diva") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mumbra") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kalwa") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Thane") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mulund") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nahur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bhandup") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kanjurmarg") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vikhroli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ghatkopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vidyavihar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sion")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sion") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod20();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Matunga") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dadar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod20();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Parel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Currey Road")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Currey Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod20();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Chinchpokli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Byculla")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Byculla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod20();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Masjid Bunder")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bunder") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod20();
                }
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
            switch (source) {
                case "Main" -> new Main(username);
                case "UserMain" -> new UserMain(username);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        requestFocusInWindow();
    }
    
    public static void main(String[] args)
    {
        new CentralLine("","");
    }
}
