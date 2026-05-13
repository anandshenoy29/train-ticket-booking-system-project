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

public class NerulUranLine extends JFrame
{
    String username,source;
    JComboBox<String> SourceStationComboBox, DestinationStationComboBox;
    JButton UpDownButton, SearchButton, BackButton;

    NerulUranLine(String username,String source)
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
                TrainScheduleTableModel.addRow(new Object[] {"06:12 AM","Uran","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:24 AM","Uran","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:09 AM","Uran","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:32 AM","Uran","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:09 AM","Uran","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:34 AM","Uran","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:09 AM","Uran","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:49 AM","Uran","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:54 AM","Uran","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:49 PM","Uran","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:54 PM","Uran","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:49 PM","Uran","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:59 PM","Uran","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:39 PM","Uran","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:49 PM","Uran","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:39 PM","Uran","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:29 PM","Uran","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:09 PM","Uran","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:09 PM","Uran","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:44 PM","Uran","Slow"});
            }

            public void TrainScheduleMethod2()
            {
                TrainScheduleTableModel.addRow(new Object[] {"06:05 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:20 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:50 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:30 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:00 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:30 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"10:00 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"11:00 AM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"12:00 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"01:00 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"02:00 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"03:00 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:00 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"04:50 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"05:40 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"06:30 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"07:20 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"08:00 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:00 PM","Nerul","Slow"});
                TrainScheduleTableModel.addRow(new Object[] {"09:55 PM","Nerul","Slow"});
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
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Nerul") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Seawoods Darave")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Seawoods Darave") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Belapur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sagar Sangam") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Targhar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bamandongari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kharkopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Gavan") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ranjanpada") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nhava Sheva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dongari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Uran")))
                {
                    TrainScheduleMethod1();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Belapur") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Sagar Sangam")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sagar Sangam") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Targhar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bamandongari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kharkopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Gavan") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ranjanpada") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nhava Sheva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dongari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Uran")))
                {
                    TrainScheduleMethod1();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Targhar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Bamandongari")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bamandongari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kharkopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Gavan") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ranjanpada") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nhava Sheva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dongari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Uran")))
                {
                    TrainScheduleMethod1();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Kharkopar") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Gavan")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Gavan") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ranjanpada") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nhava Sheva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dongari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Uran")))
                {
                    TrainScheduleMethod1();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Ranjanpada") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Nhava Sheva")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nhava Sheva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dongari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Uran")))
                {
                    TrainScheduleMethod1();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Dongari")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Uran")))
                {
                    TrainScheduleMethod1();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Uran") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Dongari")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Dongari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nhava Sheva") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ranjanpada") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Gavan") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kharkopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bamandongari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Targhar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sagar Sangam") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Belapur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Seawoods Darave") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nerul")))
                {
                    TrainScheduleMethod2();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Nhava Sheva") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Ranjanpada")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Ranjanpada") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Gavan") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kharkopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bamandongari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Targhar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sagar Sangam") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Belapur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Seawoods Darave") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nerul")))
                {
                    TrainScheduleMethod2();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Gavan") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Kharkopar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Kharkopar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Bamandongari") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Targhar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sagar Sangam") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Belapur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Seawoods Darave") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nerul")))
                {
                    TrainScheduleMethod2();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Bamandongari") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Targhar")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Targhar") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Sagar Sangam") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Belapur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Seawoods Darave") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nerul")))
                {
                    TrainScheduleMethod2();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Sagar Sangam") || Objects.equals(SourceStationComboBox.getSelectedItem(), "Belapur")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Belapur") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Seawoods Darave") || Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nerul")))
                {
                    TrainScheduleMethod2();
                }
                else if((Objects.equals(SourceStationComboBox.getSelectedItem(), "Seawoods Darave")) && (Objects.equals(DestinationStationComboBox.getSelectedItem(), "Nerul")))
                {
                    TrainScheduleMethod2();
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
        new NerulUranLine("","");
    }
}
