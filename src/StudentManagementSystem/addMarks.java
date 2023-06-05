package StudentManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class addMarks extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5;
    JTextField science, gr, english, maths, tot1;
    JButton submit, display, dtot;
    JTable t1;
    JButton home, back;

    addMarks() {
        setBounds(400, 20, 600, 700);

        l1 = new JLabel("GR Number");
        l1.setBounds(40, 60, 120, 30);
        l1.setFont(new Font("SEGIO", Font.BOLD, 15));
        l1.setForeground(Color.WHITE);
        add(l1);

        gr = new JTextField();
        gr.setBounds(175, 60, 180, 40);
        add(gr);

        t1 = new JTable();
        t1.setBounds(40, 180, 500, 50);
        t1.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        t1.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        add(t1);


        l4 = new JLabel("English:");
        l4.setBounds(40, 250, 150, 30);
        l4.setFont(new Font("SEGIO", Font.BOLD, 15));
        l4.setForeground(Color.WHITE);
        add(l4);

        l3 = new JLabel("Maths: ");
        l3.setBounds(40, 330, 150, 30);
        l3.setFont(new Font("SEGIO", Font.BOLD, 15));
        l3.setForeground(Color.WHITE);
        add(l3);

        l2 = new JLabel("Science: ");
        l2.setBounds(40, 410, 150, 30);
        l2.setFont(new Font("SEGIO", Font.BOLD, 15));
        l2.setForeground(Color.WHITE);
        add(l2);

        l5 = new JLabel("Total: ");
        l5.setBounds(40, 490, 150, 30);
        l5.setFont(new Font("SEGIO", Font.BOLD, 15));
        l5.setForeground(Color.WHITE);
        add(l5);

        english = new JTextField();
        english.setBounds(190, 250, 180, 40);
        add(english);

        maths = new JTextField();
        maths.setBounds(190, 330, 180, 40);
        add(maths);

        science = new JTextField();
        science.setBounds(190, 400, 180, 40);
        add(science);

        tot1 = new JTextField();
        tot1.setBounds(190, 490, 180, 40);
        add(tot1);

        submit = new JButton("Submit");
        submit.setBounds(200, 570, 100, 40);
        submit.addActionListener(this);
        add(submit);

        display = new JButton("Display");
        display.setBounds(400, 60, 80, 40);
        display.addActionListener(this);
        add(display);

        // button to calculate the total of the marks
        dtot = new JButton("Calculate Total");
        dtot.setBounds(360, 490, 120, 40);
        dtot.addActionListener(this);
        add(dtot);
        //back button
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("images/back.png"));
        Image i12 = i11.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        ImageIcon i13 = new ImageIcon(i12);
        back = new JButton(i13);
        back.setBounds(5, 5, 35, 35);

        back.addActionListener(this);
        add(back);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/b9.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 700, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel j1 = new JLabel(i6);
        j1.setBounds(1, 1, 600, 700);
        add(j1);

        //dasboard button
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        home = new JButton(i3);
        home.setBounds(550, 5, 35, 30);
        home.addActionListener(this);
        add(home);

        setLayout(null);
        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == display) {
            String gr = this.gr.getText();
            try {
                conn c = new conn();
                String str = "select name, attendance ,tot1 from stud_details where gr = '"+gr+"'";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else  if(ae.getSource()==submit){
            String gr = this.gr.getText();
            String english = this.english.getText();
            String maths = this.maths.getText();
            String science = this.science.getText();
            String marks = tot1.getText();
            try {
                conn c = new conn();
                String str = "update stud_details set tot1 = '"+marks+"',english = '"+english+"',maths='"+maths+"',science='"+science+"' where gr = '"+gr+"';";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Marks  Added Successfully");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==back){
            new marks().setVisible(true);
            this.setVisible(false);

        }
        else if(ae.getSource()== home) {
            new dashboard().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==dtot){
            int total = Integer.parseInt(this.english.getText())+Integer.parseInt(this.maths.getText())+Integer.parseInt(this.science.getText());
            this.tot1.setText(String.valueOf(total));
        }
    }

    public static void main(String[] args) {
        new addMarks();
    }
}