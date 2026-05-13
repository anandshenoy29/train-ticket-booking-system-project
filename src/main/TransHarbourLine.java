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

public class TransHarbourLine extends JFrame
{
    String username,source;
    JComboBox<String> SourceStationComboBox, DestinationStationComboBox;
    JButton UpDownButton, SearchButton, BackButton;

    TransHarbourLine(String username,String source)
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
                TrainScheduleTableModel.addRow(new Object[] {"05:12 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:25 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:40 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:53 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:09 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:20 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:27 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:39 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:59 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:04 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:17 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:23 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:35 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:43 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:53 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:03 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:14 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:23 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:31 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:36 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:51 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:04 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:09 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:14 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:39 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:47 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:53 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:01 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:07 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:12 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:20 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:35 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:55 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:06 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:14 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:20 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:27 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:35 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:48 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:00 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:06 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:12 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:18 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:35 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:41 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:49 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:00 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:10 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:24 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:37 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:50 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:03 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:13 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:19 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:36 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:46 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:54 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:00 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:05 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:20 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:25 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:30 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:40 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:52 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:00 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:07 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:19 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:24 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:33 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:40 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:48 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:55 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:00 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:08 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:23 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:34 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:46 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:54 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:06 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:10 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:17 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:24 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:34 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:42 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:49 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:59 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:14 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:19 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:24 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:34 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:38 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:54 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:59 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:05 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:15 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:20 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:28 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:43 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:50 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:00 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:11 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:36 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:41 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:01 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:15 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:25 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:45 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:55 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:09 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:14 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:32 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:45 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:05 AM","Panvel","Slow"});
            }

            public void TrainScheduleMethod2()
            {
                TrainScheduleTableModel.addRow(new Object[] {"05:25 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:53 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:09 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:39 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:59 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:17 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:35 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:53 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:23 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:36 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:56 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:09 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:53 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:07 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:20 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:35 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:48 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:06 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:20 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:35 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:48 AM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:06 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:18 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:41 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:00 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:30 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:50 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:19 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:46 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:00 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:25 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:40 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:52 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:07 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:19 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:40 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:55 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:08 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:28 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:46 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:06 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:24 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:42 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:59 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:19 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:34 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:54 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:05 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:28 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:43 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:00 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:41 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:01 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:25 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:45 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:09 PM","Vashi","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:45 PM","Vashi","Slow"});
            }

            public void TrainScheduleMethod3()
            {
                TrainScheduleTableModel.addRow(new Object[] {"05:12 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:40 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:20 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:27 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:04 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:23 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:43 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:03 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:14 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:31 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:41 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:51 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:04 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:14 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:39 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:47 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:01 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:12 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:55 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:14 AM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:27 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:42 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:00 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:12 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:35 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:49 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:10 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:24 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:37 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:03 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:13 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:36 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:54 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:05 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:20 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:30 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:00 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:24 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:33 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:48 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:00 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:23 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:34 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:54 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:10 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:17 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:34 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:49 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:14 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:24 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:38 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:59 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:15 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:20 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:33 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:50 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:11 PM","Panvel","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 PM","Nerul","Slow"});
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
                TrainScheduleTableModel.addRow(new Object[] {"04:33 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:53 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:21 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:13 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:37 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:01 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:18 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:43 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:04 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:15 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:01 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:48 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:12 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:41 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:02 AM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:19 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:04 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:01 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:24 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:04 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:36 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:53 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:26 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:12 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:37 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:57 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:22 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:01 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:13 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:31 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:19 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:20 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:15 PM","Thane","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:18 PM","Thane","Slow"});
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
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Sanpada") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Vashi")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Juinagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nerul") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Seawoods Darave") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Belapur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kharghar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Manasarovar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khandeshwar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Panvel")))
                {
                    JOptionPane.showMessageDialog(new JFrame(), "No Trains are available!");
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Juinagar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nerul") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Seawoods Darave") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Belapur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kharghar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Manasarovar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khandeshwar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Panvel")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sanpada") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vashi")))
                {
                    JOptionPane.showMessageDialog(new JFrame(), "No Trains are available!");
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Thane") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Digha Gaon")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Digha Gaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Airoli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Rabale") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghansoli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar Khairane") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Turbhe")))
                {
                    TrainScheduleMethod1();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Airoli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Rabale")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Rabale") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghansoli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar Khairane") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Turbhe")))
                {
                    TrainScheduleMethod1();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Ghansoli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kopar Khairane")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar Khairane") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Turbhe")))
                {
                    TrainScheduleMethod1();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Thane") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Digha Gaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Airoli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Rabale") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ghansoli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kopar Khairane") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Turbhe") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sanpada")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sanpada") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Vashi")))
                {
                    TrainScheduleMethod2();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Thane") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Digha Gaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Airoli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Rabale") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ghansoli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kopar Khairane") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Turbhe") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Juinagar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Juinagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nerul")))
                {
                    TrainScheduleMethod3();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Thane") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Digha Gaon") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Airoli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Rabale") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ghansoli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kopar Khairane") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Turbhe") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Juinagar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nerul") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Seawoods Darave")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Seawoods Darave") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Belapur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kharghar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Manasarovar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khandeshwar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Panvel")))
                {
                    TrainScheduleMethod4();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Belapur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kharghar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kharghar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Manasarovar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khandeshwar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Panvel")))
                {
                    TrainScheduleMethod4();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Manasarovar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khandeshwar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khandeshwar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Panvel")))
                {
                    TrainScheduleMethod4();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Panvel") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Khandeshwar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Khandeshwar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Manasarovar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kharghar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Belapur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Seawoods Darave") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nerul") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Juinagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Turbhe") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar Khairane") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghansoli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Rabale") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Airoli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Digha Gaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane")))
                {
                    TrainScheduleMethod5();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Manasarovar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kharghar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kharghar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Belapur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Seawoods Darave") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nerul") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Juinagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Turbhe") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar Khairane") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghansoli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Rabale") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Airoli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Digha Gaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane")))
                {
                    TrainScheduleMethod5();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Belapur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Seawoods Darave")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Seawoods Darave") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nerul") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Juinagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Turbhe") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar Khairane") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghansoli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Rabale") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Airoli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Digha Gaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane")))
                {
                    TrainScheduleMethod5();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Nerul") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Juinagar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Juinagar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Turbhe") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar Khairane") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghansoli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Rabale") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Airoli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Digha Gaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane")))
                {
                    TrainScheduleMethod5();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Vashi") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sanpada")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sanpada") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Turbhe") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar Khairane") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghansoli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Rabale") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Airoli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Digha Gaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane")))
                {
                    TrainScheduleMethod5();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Turbhe") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kopar Khairane")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kopar Khairane") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ghansoli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Rabale") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Airoli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Digha Gaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane")))
                {
                    TrainScheduleMethod5();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Ghansoli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Rabale")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Rabale") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Airoli") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Digha Gaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane")))
                {
                    TrainScheduleMethod5();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Airoli") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Digha Gaon")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Digha Gaon") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Thane")))
                {
                    TrainScheduleMethod5();
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
        new TransHarbourLine("","");
    }
}
