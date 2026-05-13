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

public class WesternLine extends JFrame
{
    String username,source;
    JComboBox<String> SourceStationComboBox, DestinationStationComboBox;
    JButton UpDownButton, SearchButton, BackButton;

    WesternLine(String username,String source)
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
                TrainScheduleTableModel.addRow(new Object[] {"04:19 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:07 AM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 AM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:51 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:01 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:55 AM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:56 AM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:26 AM","Dahanu Road","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 AM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 AM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 AM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:27 AM","Virar","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:38 AM","Borivali","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:53 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:16 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:58 AM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:04 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:24 AM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 AM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:54 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:30 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:44 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:10 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:15 PM","Virar","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:42 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:07 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:17 PM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:42 PM","Virar","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:46 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:09 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:32 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:40 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:17 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:21 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:50 PM","Dahanu Road","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:19 PM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:29 PM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:45 PM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:56 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:28 PM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:32 PM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:39 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:57 PM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:18 PM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:30 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:46 PM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:00 PM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:04 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:30 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:44 PM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:32 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:47 PM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:50 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 PM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:08 AM","Borivali","Slow"});
            }

            public void TrainScheduleMethod2()
            {
                TrainScheduleTableModel.addRow(new Object[] {"04:35 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:47 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:16 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:40 AM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:46 AM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:10 AM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:24 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:48 AM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:49 AM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:05 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:30 AM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:55 AM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 AM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:45 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:52 AM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:01 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:09 AM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:15 AM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:23 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 AM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:46 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:57 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:08 AM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:12 AM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:20 AM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:25 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:36 AM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:40 AM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:52 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:14 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 AM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:40 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:50 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:20 PM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:48 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:19 PM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:23 PM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:40 PM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:50 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:50 PM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:15 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:34 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:45 PM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:54 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:03 PM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:10 PM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:35 PM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:39 PM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:08 PM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:13 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:30 PM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:42 PM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:22 PM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:33 PM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:41 PM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:59 PM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:06 PM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:21 PM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:25 PM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:33 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:34 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:50 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:13 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:38 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 PM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:47 PM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:08 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:28 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:40 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:44 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:28 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:42 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:08 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:51 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:02 AM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:12 AM","Virar","Slow"});
            }

            public void TrainScheduleMethod3()
            {
                TrainScheduleTableModel.addRow(new Object[] {"03:55 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:23 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:39 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:49 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:55 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:06 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:14 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:29 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:35 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:47 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:55 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:59 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:07 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:11 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:15 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:19 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:27 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:27 AM","Dahanu Road","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:31 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:51 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:55 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:03 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:11 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:15 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:19 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:22 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:28 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:32 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:36 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:47 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:50 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:54 AM","Virar","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:01 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:06 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:09 AM","Virar","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:13 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:17 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:24 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:28 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 AM","Dahanu Road","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:36 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 AM","Virar","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:44 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:52 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 AM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:00 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 AM","Virar","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:22 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:33 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:46 AM","Virar","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:55 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:06 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:18 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:36 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:52 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:02 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:10 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:29 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:41 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:50 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:02 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:11 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:19 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:31 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:39 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:48 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:58 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:07 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:20 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:31 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:40 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:51 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:02 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:11 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:19 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:27 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:38 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:48 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:08 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:26 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:50 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:59 PM","Dahanu Road","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:14 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:25 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:34 PM","Virar","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:49 PM","Dahanu Road","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:02 PM","Virar","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:23 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:40 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:55 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:11 PM","Virar","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:28 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:39 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:52 PM","Dahanu Road","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:05 PM","Virar","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:15 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:25 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:37 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:48 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:05 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:25 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:38 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:01 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:10 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:19 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:27 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:55 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:42 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:07 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:19 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:28 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:37 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:49 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:58 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:07 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:27 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:43 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:54 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:03 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:11 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:15 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:19 AM","Virar","Slow"});
            }

            public void TrainScheduleMethod4()
            {
                TrainScheduleTableModel.addRow(new Object[] {"03:51 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:59 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:10 AM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:57 AM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:22 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:18 AM","Dahanu Road","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:18 AM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:10 AM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:19 PM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:31 PM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:42 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:35 PM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:16 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:02 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:17 PM","Dahanu Road","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:15 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:21 PM","Dahanu Road","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 PM","Dahanu Road","Slow"});
            }

            public void TrainScheduleMethod5()
            {
                TrainScheduleTableModel.addRow(new Object[] {"04:19 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:07 AM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 AM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:51 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:01 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:55 AM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:56 AM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:26 AM","Churchgate","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 AM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 AM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 AM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:27 AM","Virar","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:38 AM","Borivali","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:53 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:16 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:58 AM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:04 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:24 AM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 AM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:54 AM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:30 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:44 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:10 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:15 PM","Virar","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:42 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:07 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:17 PM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:42 PM","Virar","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:46 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:09 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:32 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:40 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:17 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:21 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:50 PM","Churchgate","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:19 PM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:29 PM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:45 PM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:56 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:28 PM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:32 PM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:39 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:57 PM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:18 PM","Virar","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:30 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:46 PM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:00 PM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:04 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:30 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:44 PM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:32 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:47 PM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:50 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 PM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 PM","Virar","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:08 AM","Borivali","Slow"});
            }

            public void TrainScheduleMethod6()
            {
                TrainScheduleTableModel.addRow(new Object[] {"04:35 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:47 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:16 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:40 AM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:46 AM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:10 AM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:24 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:48 AM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:49 AM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:05 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:30 AM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:55 AM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 AM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:45 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:52 AM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:01 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:09 AM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:15 AM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:23 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 AM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:46 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:57 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:08 AM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:12 AM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:20 AM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:25 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:36 AM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:40 AM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:52 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:14 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 AM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:40 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:50 AM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:20 PM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:48 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:19 PM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:23 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:40 PM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:50 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:50 PM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:15 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:34 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:45 PM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:54 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:03 PM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:10 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:35 PM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"03:39 PM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:08 PM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:13 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:30 PM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:42 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:22 PM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:33 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:41 PM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:59 PM","Borivali","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:06 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:21 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:25 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:33 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:34 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:50 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:13 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:38 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:47 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:08 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:28 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:40 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:44 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:28 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:42 PM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:08 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:30 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:51 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:02 AM","Borivali","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:12 AM","Bandra","Slow"});
            }

            public void TrainScheduleMethod7()
            {
                TrainScheduleTableModel.addRow(new Object[] {"03:55 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:23 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:39 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:49 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:55 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:06 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:14 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:29 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:35 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:47 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:55 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:59 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:07 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:11 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:15 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:19 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:27 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:27 AM","Churchgate","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:31 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:51 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:55 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:03 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:11 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:15 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:19 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:22 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:28 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:32 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:36 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:47 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:50 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:54 AM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:01 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:06 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:09 AM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:13 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:17 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:24 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:28 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 AM","Churchgate","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:36 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 AM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:44 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:52 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 AM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:00 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 AM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:22 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:33 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:46 AM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:55 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:06 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:18 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:36 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:52 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:02 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:10 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:29 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:41 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:50 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:02 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:11 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:19 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:31 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:39 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:48 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:58 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:07 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:20 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:31 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:40 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:51 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:02 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:11 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:19 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:27 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:38 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:48 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:08 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:26 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:50 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:59 PM","Churchgate","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:14 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:25 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:34 PM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:49 PM","Churchgate","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:02 PM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:23 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:40 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:55 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:11 PM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:28 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:39 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:52 PM","Churchgate","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:05 PM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:15 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:25 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:37 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:48 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:05 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:25 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:38 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:01 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:10 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:19 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:27 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:55 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:42 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:07 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:19 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:28 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:37 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:49 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:58 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:07 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:27 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:43 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:54 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:03 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:11 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:15 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:19 AM","Bandra","Slow"});
            }

            public void TrainScheduleMethod8()
            {
                TrainScheduleTableModel.addRow(new Object[] {"03:51 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:59 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:10 AM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:57 AM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:22 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:18 AM","Churchgate","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:18 AM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:10 AM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:19 PM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:31 PM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:42 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:35 PM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:16 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:02 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:17 PM","Churchgate","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:15 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:21 PM","Churchgate","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 PM","Churchgate","Slow"});
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
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Churchgate") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Marine Lines")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Marine Lines") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Charni Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Grant Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbai Central") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mahalaxmi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Lower Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Prabhadevi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mahim") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bandra")))
                {
                    TrainScheduleMethod1();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Charni Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Grant Road")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Grant Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbai Central") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mahalaxmi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Lower Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Prabhadevi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mahim") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bandra")))
                {
                    TrainScheduleMethod1();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Mumbai Central") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mahalaxmi")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mahalaxmi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Lower Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Prabhadevi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mahim") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bandra")))
                {
                    TrainScheduleMethod1();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Lower Parel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Prabhadevi")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Prabhadevi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mahim") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bandra")))
                {
                    TrainScheduleMethod1();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Matunga Road")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mahim") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bandra")))
                {
                    TrainScheduleMethod1();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Mahim")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bandra")))
                {
                    TrainScheduleMethod1();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Churchgate") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Marine Lines") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Charni Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Grant Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mumbai Central") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mahalaxmi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Lower Parel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Prabhadevi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Matunga Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mahim") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bandra") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khar Road")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khar Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Santacruz") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ville Parle") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Andheri") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Jogeshwari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ram Mandir") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Goregaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Malad") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kandivali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Borivali")))
                {
                    TrainScheduleMethod2();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Santacruz") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ville Parle")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ville Parle") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Andheri") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Jogeshwari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ram Mandir") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Goregaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Malad") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kandivali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Borivali")))
                {
                    TrainScheduleMethod2();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Andheri") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Jogeshwari")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Jogeshwari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ram Mandir") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Goregaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Malad") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kandivali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Borivali")))
                {
                    TrainScheduleMethod2();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Ram Mandir") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Goregaon")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Goregaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Malad") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kandivali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Borivali")))
                {
                    TrainScheduleMethod2();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Malad") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kandivali")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kandivali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Borivali")))
                {
                    TrainScheduleMethod2();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Churchgate") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Marine Lines") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Charni Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Grant Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mumbai Central") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mahalaxmi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Lower Parel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Prabhadevi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Matunga Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mahim") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bandra") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khar Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Santacruz") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ville Parle") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Andheri") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Jogeshwari") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ram Mandir") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Goregaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Malad") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kandivali") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Borivali") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dahisar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dahisar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mira Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhayandar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Naigaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vasai Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nallasopara") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Virar")))
                {
                    TrainScheduleMethod3();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Mira Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bhayandar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhayandar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Naigaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vasai Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nallasopara") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Virar")))
                {
                    TrainScheduleMethod3();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Naigaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vasai Road")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vasai Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nallasopara") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Virar")))
                {
                    TrainScheduleMethod3();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Nallasopara")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Virar")))
                {
                    TrainScheduleMethod3();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Churchgate") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Marine Lines") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Charni Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Grant Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mumbai Central") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mahalaxmi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Lower Parel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Prabhadevi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Matunga Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mahim") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bandra") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khar Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Santacruz") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ville Parle") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Andheri") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Jogeshwari") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ram Mandir") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Goregaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Malad") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kandivali") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Borivali") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dahisar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mira Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bhayandar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Naigaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vasai Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nallasopara") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Virar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vaitarna")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vaitarna") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Saphale") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kelve Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Palghar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Umroli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Boisar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vangaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dahanu Road")))
                {
                    TrainScheduleMethod4();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Saphale") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kelve Road")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kelve Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Palghar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Umroli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Boisar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vangaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dahanu Road")))
                {
                    TrainScheduleMethod4();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Palghar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Umroli")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Umroli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Boisar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vangaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dahanu Road")))
                {
                    TrainScheduleMethod4();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Boisar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vangaon")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vangaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dahanu Road")))
                {
                    TrainScheduleMethod4();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Dahanu Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vangaon")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vangaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Boisar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Umroli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Palghar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kelve Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Saphale") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vaitarna") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Virar")))
                {
                    TrainScheduleMethod5();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Boisar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Umroli")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Umroli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Palghar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kelve Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Saphale") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vaitarna") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Virar")))
                {
                    TrainScheduleMethod5();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Palghar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kelve Road")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kelve Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Saphale") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vaitarna") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Virar")))
                {
                    TrainScheduleMethod5();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Saphale") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vaitarna")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vaitarna") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Virar")))
                {
                    TrainScheduleMethod5();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Dahanu Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vangaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Boisar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Umroli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Palghar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kelve Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Saphale") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vaitarna") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Virar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nallasopara")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nallasopara") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vasai Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Naigaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhayandar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mira Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dahisar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Borivali")))
                {
                    TrainScheduleMethod6();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Vasai Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Naigaon")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Naigaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bhayandar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mira Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dahisar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Borivali")))
                {
                    TrainScheduleMethod6();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Bhayandar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mira Road")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mira Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dahisar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Borivali")))
                {
                    TrainScheduleMethod6();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Dahisar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Borivali")))
                {
                    TrainScheduleMethod6();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Dahanu Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vangaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Boisar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Umroli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Palghar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kelve Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Saphale") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vaitarna") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Virar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nallasopara") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vasai Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Naigaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bhayandar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mira Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dahisar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Borivali") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kandivali")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kandivali") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Malad") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Goregaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ram Mandir") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Jogeshwari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Andheri") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ville Parle") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Santacruz") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khar Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bandra")))
                {
                    TrainScheduleMethod7();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Malad") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Goregaon")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Goregaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ram Mandir") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Jogeshwari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Andheri") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ville Parle") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Santacruz") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khar Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bandra")))
                {
                    TrainScheduleMethod7();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Ram Mandir") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Jogeshwari")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Jogeshwari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Andheri") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ville Parle") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Santacruz") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khar Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bandra")))
                {
                    TrainScheduleMethod7();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Andheri") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ville Parle")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ville Parle") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Santacruz") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khar Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bandra")))
                {
                    TrainScheduleMethod7();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Santacruz") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khar Road")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khar Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bandra")))
                {
                    TrainScheduleMethod7();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Dahanu Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vangaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Boisar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Umroli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Palghar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kelve Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Saphale") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vaitarna") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Virar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nallasopara") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vasai Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Naigaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bhayandar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mira Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dahisar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Borivali") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kandivali") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Malad") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Goregaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ram Mandir") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Jogeshwari") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Andheri") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ville Parle") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Santacruz") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khar Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bandra") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mahim")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mahim") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Matunga Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Prabhadevi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Lower Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mahalaxmi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbai Central") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Grant Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Charni Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Marine Lines") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Churchgate")))
                {
                    TrainScheduleMethod8();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Matunga Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dadar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dadar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Prabhadevi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Lower Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mahalaxmi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbai Central") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Grant Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Charni Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Marine Lines") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Churchgate")))
                {
                    TrainScheduleMethod8();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Prabhadevi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Lower Parel")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Lower Parel") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mahalaxmi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbai Central") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Grant Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Charni Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Marine Lines") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Churchgate")))
                {
                    TrainScheduleMethod8();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Mahalaxmi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mumbai Central")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mumbai Central") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Grant Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Charni Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Marine Lines") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Churchgate")))
                {
                    TrainScheduleMethod8();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Grant Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Charni Road")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Charni Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Marine Lines") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Churchgate")))
                {
                    TrainScheduleMethod8();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Marine Lines")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Churchgate")))
                {
                    TrainScheduleMethod8();
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
        new WesternLine("","");
    }
}
