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

public class HarbourLine extends JFrame
{
    String username,source;
    JComboBox<String> SourceStationComboBox, DestinationStationComboBox;
    JButton UpDownButton, SearchButton, BackButton;

    HarbourLine(String username,String source)
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
                TrainScheduleTableModel.addRow(new Object[] {"05:07 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:51 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:01 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:55 AM","Goregaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:56 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:26 AM","Belapur","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 AM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 AM","Panvel","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 AM","Goregaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:27 AM","Panvel","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:38 AM","Belapur","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:53 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:16 AM","Goregaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","Panvel","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:58 AM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:04 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:24 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 AM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:54 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:30 PM","Panvel","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:44 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:10 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:15 PM","Vashi","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:42 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:07 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:17 PM","Panvel","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:42 PM","Vashi","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:46 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:09 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:32 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:40 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:17 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:21 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:50 PM","Vashi","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:19 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:29 PM","Belapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:45 PM","Goregaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:56 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:28 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:32 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:39 PM","Panvel","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:57 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:18 PM","Belapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:30 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:46 PM","Goregaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:00 PM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:04 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:30 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:44 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:32 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:47 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:50 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 PM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:08 AM","Goregaon","Slow"});
            }

            public void TrainScheduleMethod2()
            {
                TrainScheduleTableModel.addRow(new Object[] {"03:55 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:23 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:39 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:49 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:55 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:06 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:14 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:29 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:35 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:47 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:55 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:59 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:07 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:11 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:15 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:19 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:27 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:27 AM","Belapur","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:31 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:51 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:55 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:03 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:11 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:15 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:19 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:22 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:28 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:32 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:36 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:47 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:50 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:54 AM","Panvel","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:01 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:06 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:09 AM","Belapur","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:13 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:17 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:24 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:28 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 AM","Panvel","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:36 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 AM","Vashi","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:44 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:52 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 AM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:00 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 AM","Panvel","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:22 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:33 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:46 AM","Panvel","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:55 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:06 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:18 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:36 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:52 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:02 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:10 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:29 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:41 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:50 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:02 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:11 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:19 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:31 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:39 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:48 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:58 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:07 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:20 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:31 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:40 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:51 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:02 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:11 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:19 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:27 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:38 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:48 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:08 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:26 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:50 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:59 PM","Vashi","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:14 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:25 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:34 PM","Belapur","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:49 PM","Panvel","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:02 PM","Vashi","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:23 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:40 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:55 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:11 PM","Vashi","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:28 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:39 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:52 PM","Vashi","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:05 PM","Panvel","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:15 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:25 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:37 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:48 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:05 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:25 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:38 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:01 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:10 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:19 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:27 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:55 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:42 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:07 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:19 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:28 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:37 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:49 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:58 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:07 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:27 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:43 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:54 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:03 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:11 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:15 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:19 AM","Vashi","Slow"});
            }

            public void TrainScheduleMethod3()
            {
                TrainScheduleTableModel.addRow(new Object[] {"05:12 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:40 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:20 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:27 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:04 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:23 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:43 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:03 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:14 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:31 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:51 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:04 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:14 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:39 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:47 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:01 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:12 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:55 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:14 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:27 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:00 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:12 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:35 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:49 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:10 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:24 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:37 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:03 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:13 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:36 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:54 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:05 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:20 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:30 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:00 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:24 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:33 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:48 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:00 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:23 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:34 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:54 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:10 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:17 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:34 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:49 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:14 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:24 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:38 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:59 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:15 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:20 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:50 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:11 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:36 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:15 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:55 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:14 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:32 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:05 AM","Panvel","Slow"});
            }

            public void TrainScheduleMethod4()
            {
                TrainScheduleTableModel.addRow(new Object[] {"05:12 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:20 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:04 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:03 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:14 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:39 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:01 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:14 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:00 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:49 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:24 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:03 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:36 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:54 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:20 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:00 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:24 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:48 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:23 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:54 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:10 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:34 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:14 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:59 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:15 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:50 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:11 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:36 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:15 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:55 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:14 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:32 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:05 AM","Panvel","Slow"});
            }

            public void TrainScheduleMethod5()
            {
                TrainScheduleTableModel.addRow(new Object[] {"05:25 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:53 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:09 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:39 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:59 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:17 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:35 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:53 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:23 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:36 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:09 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:53 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:07 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:20 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:35 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:06 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:20 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:35 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:48 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:06 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:18 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:41 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:00 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:50 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:19 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:46 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:00 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:25 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:40 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:52 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:07 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:19 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:40 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:55 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:08 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:46 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:06 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:24 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:42 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:59 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:19 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:34 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:54 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:05 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:28 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:43 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:00 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:41 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:01 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:25 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:45 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:09 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:45 PM","Bandra","Slow"});
            }

            public void TrainScheduleMethod6()
            {
                TrainScheduleTableModel.addRow(new Object[] {"03:51 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:59 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:10 AM","Goregaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:57 AM","Goregaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:22 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:18 AM","Goregaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:18 AM","Goregaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:10 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:19 PM","Goregaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:31 PM","Goregaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:42 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:35 PM","Goregaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:16 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:02 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:17 PM","Goregaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:15 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:21 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 PM","Goregaon","Slow"});
            }

            public void TrainScheduleMethod7()
            {
                TrainScheduleTableModel.addRow(new Object[] {"04:19 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:07 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:51 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:01 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:55 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:56 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:26 AM","Belapur","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 AM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 AM","Panvel","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 AM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:27 AM","Panvel","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:38 AM","Belapur","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:53 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:16 AM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","Panvel","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:58 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:04 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:24 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 AM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:54 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:30 PM","Panvel","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:44 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:10 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:15 PM","Vashi","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:42 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:07 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:17 PM","Panvel","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:42 PM","Vashi","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:46 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:09 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:32 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:40 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:17 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:21 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:50 PM","Vashi","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:19 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:29 PM","Belapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:45 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:56 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:28 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:32 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:39 PM","Panvel","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:57 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:18 PM","Belapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:30 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:46 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:00 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:04 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:30 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:44 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:32 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:47 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:50 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:08 AM","CSMT","Slow"});
            }

            public void TrainScheduleMethod8()
            {
                TrainScheduleTableModel.addRow(new Object[] {"04:19 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:07 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:51 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:01 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:55 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:56 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:26 AM","Belapur","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 AM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 AM","Panvel","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:27 AM","Panvel","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:38 AM","Belapur","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:53 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:16 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","Panvel","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:58 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:04 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:24 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 AM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:54 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:30 PM","Panvel","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:44 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:10 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:15 PM","Vashi","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:42 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:07 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:17 PM","Panvel","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:42 PM","Vashi","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:46 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:09 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:32 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:40 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:17 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:21 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:50 PM","Vashi","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:19 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:29 PM","Belapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:45 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:56 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:28 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:32 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:39 PM","Panvel","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:57 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:18 PM","Belapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:30 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:46 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:00 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:04 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:30 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:44 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:32 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:47 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:50 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:08 AM","CSMT","Slow"});
            }

            public void TrainScheduleMethod9()
            {
                TrainScheduleTableModel.addRow(new Object[] {"05:12 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:20 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:04 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:03 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:14 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:39 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:01 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:14 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:00 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:49 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:24 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:03 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:36 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:54 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:20 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:00 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:24 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:48 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:23 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:54 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:10 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:34 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:14 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:59 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:15 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:50 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:11 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:36 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:15 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:55 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:14 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:32 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:05 AM","CSMT","Slow"});
            }

            public void TrainScheduleMethod10()
            {
                TrainScheduleTableModel.addRow(new Object[] {"04:19 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:07 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:51 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:01 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:55 AM","Goregaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:56 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:26 AM","Belapur","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 AM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 AM","Goregaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:27 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:38 AM","Belapur","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:53 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:16 AM","Goregaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:58 AM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:04 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:24 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 AM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:54 AM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:30 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:44 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:10 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:15 PM","Vashi","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:42 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:07 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:17 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:42 PM","Vashi","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:46 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:09 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:32 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:40 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:17 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:21 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:50 PM","Vashi","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:19 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:29 PM","Belapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:45 PM","Goregaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:56 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:28 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:32 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:39 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:57 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:18 PM","Belapur","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:30 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:46 PM","Goregaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:00 PM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:04 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:30 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:44 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:32 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:47 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:50 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 PM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 PM","Belapur","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:08 AM","Goregaon","Slow"});
            }

            public void TrainScheduleMethod11()
            {
                TrainScheduleTableModel.addRow(new Object[] {"04:19 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:07 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:51 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:01 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:14 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:55 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:56 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:26 AM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 AM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 AM","Goregaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:27 AM","Goregaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:38 AM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:53 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:16 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","Goregaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:58 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:04 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:24 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 AM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:54 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:30 PM","Goregaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"12:44 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:10 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:15 PM","Vashi","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:42 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:07 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:17 PM","Goregaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:42 PM","Vashi","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"02:46 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:09 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:32 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:40 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:17 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:21 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:50 PM","Vashi","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:19 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:29 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:45 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:56 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:28 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:32 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:39 PM","Goregaon","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:57 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:18 PM","Bandra","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:30 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:46 PM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:00 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:04 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:30 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:44 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:32 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:47 PM","Vashi","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"10:50 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:16 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:08 AM","CSMT","Slow"});
            }

            public void TrainScheduleMethod12()
            {
                TrainScheduleTableModel.addRow(new Object[] {"03:55 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:23 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:39 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:49 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:55 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:06 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:14 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:29 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:35 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:47 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:55 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:59 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:07 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:11 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:15 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:19 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:27 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:27 AM","Goregaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:31 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:41 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:51 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:55 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:03 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:11 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:15 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:19 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:22 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:28 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:32 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:36 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:42 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:47 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:50 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:54 AM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:01 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:06 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:09 AM","Goregaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:13 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:17 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:24 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:28 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 AM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:36 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 AM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"08:44 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:52 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 AM","CSMT","Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:00 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:12 AM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:22 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:33 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:46 AM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"09:55 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:06 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:18 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:36 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:52 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:02 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:10 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 AM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:29 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:41 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:50 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:02 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:11 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:19 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:31 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:39 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:48 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:58 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:07 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:20 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:31 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:40 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:51 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:02 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:11 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:19 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:27 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:38 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:48 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:08 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:26 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:50 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:59 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:14 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:25 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:34 PM","Goregaon","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"04:49 PM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:02 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"05:23 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:40 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:55 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:11 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"06:28 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:39 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:52 PM","CSMT","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:05 PM","Bandra","Super Fast"});
                TrainScheduleTableModel.addRow(new Object[] {"07:15 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:25 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:37 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:48 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:05 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:16 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:25 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:38 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:48 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:01 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:10 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:19 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:27 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:55 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:42 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:07 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:19 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:28 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:37 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:49 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:58 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:07 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:27 PM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:43 PM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:54 PM","CSMT","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:03 AM","Bandra","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:11 AM","Goregaon","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:15 AM","Bandra","Slow"});
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
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "CSMT") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Masjid Bundar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bundar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dockyard Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Reay Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Cotton Green") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sewri") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vadala Road")))
                {
                    TrainScheduleMethod1();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dockyard Road")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dockyard Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Reay Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Cotton Green") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sewri") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vadala Road")))
                {
                    TrainScheduleMethod1();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Reay Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Cotton Green")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Cotton Green") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sewri") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vadala Road")))
                {
                    TrainScheduleMethod1();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Sewri")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vadala Road")))
                {
                    TrainScheduleMethod1();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "CSMT") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Masjid Bundar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dockyard Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Reay Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Cotton Green") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sewri") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vadala Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "GTB Nagar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "GTB Nagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chunabhatti") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Tilak Nagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chembur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Govandi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mankhurd") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vashi")))
                {
                    TrainScheduleMethod2();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Chunabhatti") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kurla")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Tilak Nagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chembur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Govandi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mankhurd") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vashi")))
                {
                    TrainScheduleMethod2();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Tilak Nagar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chembur")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chembur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Govandi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mankhurd") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vashi")))
                {
                    TrainScheduleMethod2();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Govandi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mankhurd")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mankhurd") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vashi")))
                {
                    TrainScheduleMethod2();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "CSMT") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Masjid Bundar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dockyard Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Reay Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Cotton Green") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sewri") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vadala Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "GTB Nagar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chunabhatti") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Tilak Nagar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chembur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Govandi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mankhurd") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vashi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sanpada")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sanpada") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Juinagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nerul") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Seawoods Darave") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Belapur")))
                {
                    TrainScheduleMethod3();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Juinagar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nerul")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nerul") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Seawoods Darave") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Belapur")))
                {
                    TrainScheduleMethod3();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Seawoods Darave")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Belapur")))
                {
                    TrainScheduleMethod3();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "CSMT") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Masjid Bundar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dockyard Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Reay Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Cotton Green") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sewri") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vadala Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "GTB Nagar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chunabhatti") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Tilak Nagar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chembur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Govandi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mankhurd") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vashi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sanpada") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Juinagar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nerul") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Seawoods Darave") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Belapur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kharghar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kharghar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Manasarovar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khandeshwar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Panvel")))
                {
                    TrainScheduleMethod4();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Manasarovar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khandeshwar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khandeshwar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Panvel")))
                {
                    TrainScheduleMethod4();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "CSMT") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Masjid Bundar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dockyard Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Reay Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Cotton Green") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sewri") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vadala Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kings Circle")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kings Circle") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mahim") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bandra")))
                {
                    TrainScheduleMethod5();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Mahim")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bandra")))
                {
                    TrainScheduleMethod5();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "CSMT") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Masjid Bundar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dockyard Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Reay Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Cotton Green") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sewri") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vadala Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kings Circle") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mahim") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bandra") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khar Road")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khar Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Santacruz") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ville Parle") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Andheri") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Jogeshwari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ram Mandir") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Goregaon")))
                {
                    TrainScheduleMethod6();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Santacruz") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ville Parle")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ville Parle") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Andheri") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Jogeshwari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ram Mandir") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Goregaon")))
                {
                    TrainScheduleMethod6();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Andheri") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Jogeshwari")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Jogeshwari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ram Mandir") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Goregaon")))
                {
                    TrainScheduleMethod6();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Ram Mandir")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Goregaon")))
                {
                    TrainScheduleMethod6();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Goregaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ram Mandir")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ram Mandir") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Jogeshwari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Andheri") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ville Parle") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Santacruz") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khar Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bandra")))
                {
                    TrainScheduleMethod7();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Jogeshwari") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Andheri")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Andheri") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ville Parle") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Santacruz") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khar Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bandra")))
                {
                    TrainScheduleMethod7();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Ville Parle") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Santacruz")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Santacruz") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khar Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bandra")))
                {
                    TrainScheduleMethod7();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Khar Road")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bandra")))
                {
                    TrainScheduleMethod7();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Goregaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ram Mandir") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Jogeshwari") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Andheri") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ville Parle") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Santacruz") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khar Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bandra") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mahim")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mahim") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kings Circle") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vadala Road")))
                {
                    TrainScheduleMethod8();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Kings Circle")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vadala Road")))
                {
                    TrainScheduleMethod8();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Goregaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ram Mandir") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Jogeshwari") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Andheri") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ville Parle") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Santacruz") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khar Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bandra") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mahim") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kings Circle") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vadala Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sewri")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sewri") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Cotton Green") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Reay Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dockyard Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bundar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod9();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Cotton Green") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Reay Road")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Reay Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dockyard Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bundar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod9();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Dockyard Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sandhurst Road")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bundar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod9();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Masjid Bundar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod9();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Goregaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ram Mandir") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Jogeshwari") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Andheri") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ville Parle") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Santacruz") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khar Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bandra") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mahim") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kings Circle")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "GTB Nagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chunabhatti") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Tilak Nagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chembur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Govandi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mankhurd") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vashi")))
                {
                    TrainScheduleMethod2();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Goregaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ram Mandir") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Jogeshwari") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Andheri") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ville Parle") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Santacruz") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khar Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bandra") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mahim") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kings Circle")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sanpada") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Juinagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nerul") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Seawoods Darave") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Belapur")))
                {
                    TrainScheduleMethod3();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Goregaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ram Mandir") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Jogeshwari") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Andheri") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ville Parle") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Santacruz") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khar Road") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bandra") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mahim") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kings Circle")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kharghar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Manasarovar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khandeshwar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Panvel")))
                {
                    TrainScheduleMethod4();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Panvel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khandeshwar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khandeshwar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Manasarovar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kharghar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Belapur")))
                {
                    TrainScheduleMethod10();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Manasarovar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kharghar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kharghar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Belapur")))
                {
                    TrainScheduleMethod10();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Panvel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khandeshwar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Manasarovar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kharghar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Belapur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Seawoods Darave")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Seawoods Darave") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nerul") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Juinagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sanpada") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vashi")))
                {
                    TrainScheduleMethod11();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Nerul") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Juinagar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Juinagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sanpada") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vashi")))
                {
                    TrainScheduleMethod11();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Sanpada")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vashi")))
                {
                    TrainScheduleMethod11();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Panvel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khandeshwar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Manasarovar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kharghar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Belapur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Seawoods Darave")  || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nerul") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Juinagar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sanpada") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vashi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mankhurd")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mankhurd") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Govandi") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chembur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Tilak Nagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chunabhatti") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "GTB Nagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vadala Road")))
                {
                    TrainScheduleMethod12();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Govandi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chembur")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chembur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Tilak Nagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chunabhatti") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "GTB Nagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vadala Road")))
                {
                    TrainScheduleMethod12();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Tilak Nagar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kurla")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Chunabhatti") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "GTB Nagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vadala Road")))
                {
                    TrainScheduleMethod12();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Chunabhatti") || Objects.equals(SourceStationComboBox.getSelectedItem(), "GTB Nagar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "GTB Nagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vadala Road")))
                {
                    TrainScheduleMethod12();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Panvel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khandeshwar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Manasarovar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kharghar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Belapur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Seawoods Darave") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nerul") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Juinagar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sanpada") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vashi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mankhurd") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Govandi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chembur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Tilak Nagar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chunabhatti") || Objects.equals(SourceStationComboBox.getSelectedItem(), "GTB Nagar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kings Circle") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Mahim") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bandra")))
                {
                    TrainScheduleMethod5();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Panvel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khandeshwar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Manasarovar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kharghar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Belapur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Seawoods Darave") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nerul") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Juinagar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sanpada") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vashi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mankhurd") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Govandi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chembur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Tilak Nagar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chunabhatti") || Objects.equals(SourceStationComboBox.getSelectedItem(), "GTB Nagar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khar Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Santacruz") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ville Parle") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Andheri") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Jogeshwari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ram Mandir") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Goregaon")))
                {
                    TrainScheduleMethod6();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Panvel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khandeshwar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Manasarovar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kharghar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Belapur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Seawoods Darave") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nerul") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Juinagar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sanpada") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vashi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Mankhurd") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Govandi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chembur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Tilak Nagar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kurla") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Chunabhatti") || Objects.equals(SourceStationComboBox.getSelectedItem(), "GTB Nagar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sewri") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Cotton Green") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Reay Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dockyard Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sandhurst Road") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Masjid Bundar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "CSMT")))
                {
                    TrainScheduleMethod9();
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
        new HarbourLine("","");
    }
}
