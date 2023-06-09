package StudentManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class marks1 extends JFrame implements ActionListener {
    JButton add;
    JTable sem1, sem2;
    JScrollPane sp1, sp2;
    JTabbedPane tabs;
    public static String name;
    public static String gr;
    public static String english;
    public static String maths;
    public static String science;
    public static String history, geography, marathi;
    int row;

    marks1() {
        setSize(900, 500);

        //defining tables;
        sem1 = new JTable();
        sp1 = new JScrollPane();
        sp1.setViewportView(sem1);

        sem2 = new JTable();
        sp2 = new JScrollPane();
        sp2.setViewportView(sem2);

        //fetching the data
        //sem1
        conn c = new conn();
        try {
            String str1 = "select name , gr , english , maths , science , tot1 from stud_details; ";
            ResultSet rs1 = c.s.executeQuery(str1);
            sem1.setModel(DbUtils.resultSetToTableModel(rs1));
        } catch (Exception e) {
            System.out.println(e);
        }

        //sem2
        try {
            String str2 = "select name , gr ,history, geography, marathi , tot2 from stud_details ;";
            ResultSet rs2 = c.s.executeQuery(str2);
            sem2.setModel(DbUtils.resultSetToTableModel(rs2));

        } catch (Exception e) {
            System.out.println(e);
        }

        tabs = new JTabbedPane();
        tabs.setBounds(400, 80, 450, 300);

        //adding tabs
        tabs.add("SEM 1", sp1);
        tabs.add("SEM 2", sp2);
        add(tabs);

        //buttons
        add = new JButton("Add / Update");
        add.setBounds(100, 200, 150, 50);
        add.addActionListener(this);
        add(add);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/b23.jpg"));
        Image i5 = i4.getImage().getScaledInstance(900, 500, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel j1 = new JLabel(i6);
        j1.setBounds(0, 0, 900, 500);
        add(j1);

        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    void sem1Select() {
        sem1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                row = sem1.getSelectedRow();
                name = sem1.getModel().getValueAt(row, 0).toString();
                gr = sem1.getModel().getValueAt(row, 1).toString();
                english = sem1.getModel().getValueAt(row, 2).toString();
                maths = sem1.getModel().getValueAt(row, 3).toString();
                science = sem1.getModel().getValueAt(row, 4).toString();
            }

        });
    }

    void sem2Select() {
        sem2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                row = sem2.getSelectedRow();
                name = sem2.getModel().getValueAt(row, 0).toString();
                gr = sem2.getModel().getValueAt(row, 1).toString();
                history = sem2.getModel().getValueAt(row, 2).toString();
                geography = sem2.getModel().getValueAt(row, 3).toString();
                marathi = sem2.getModel().getValueAt(row, 4).toString();
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            if (sem1.isShowing()) {
                sem1Select();
                System.out.println(english);
                System.out.println(maths);
                System.out.println(science);
            } else if (sem2.isShowing()) {
                sem2Select();
                System.out.println(history);
                System.out.println(geography);
                System.out.println(marathi);
            }


            System.out.println(row);
            System.out.println(name);
            System.out.println(gr);

            new addMarks();

        }

    }

    public static void main(String[] args) {
        new marks1();
    }
}

