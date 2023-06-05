package StudentManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.SQLOutput;

public class login extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField username ;
    JPasswordField pass;
    JButton si,cn;
    login(){
        setSize(600,400);

        username=new JTextField();
        username.setBounds(180,50,120,40);
        add(username);

        pass=new JPasswordField();
        pass.setBounds(180,120,120,40);
        add(pass);

        l1=new JLabel("Username");  //username label
        l1.setBounds(70,50,100,50);
        l1.setFont(new Font("SEGIO",Font.BOLD,14));
        l1.setForeground(Color.WHITE);
        add(l1);

        l2=new JLabel("Password");  //password label
        l2.setBounds(70,120,70,50);
        l2.setFont(new Font("SEGIO",Font.BOLD,14));
        l2.setForeground(Color.WHITE);
        add(l2);

        si= new JButton("Sign In");
        si.setBounds(80,250,120,40);
        si.addActionListener(this);
        add(si);

        cn = new JButton("Cancel");
        cn.setBounds(300,250,120,40);
        cn.addActionListener(this);
        add(cn);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/password_image.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150,150, Image.SCALE_SMOOTH);
        ImageIcon i3= new ImageIcon(i2);
        JLabel j3 = new JLabel(i3);
        j3.setBounds(350,50,150,150);
        add(j3);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/b15.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600,400, Image.SCALE_SMOOTH);
        ImageIcon i6= new ImageIcon(i5);
        JLabel j1 = new JLabel(i6);
        j1.setBounds(1,1,600,400);
        add(j1);

        getContentPane().setBackground(Color.GRAY);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == si) {
            String username = this.username.getText();
            String password = String.valueOf(this.pass.getPassword());
            conn c = new conn();
            try {
                String str1 = "select * from login where username='" + username + "' and password ='" + password + "';";
                ResultSet rs = c.s.executeQuery(str1);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login Credentials!");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
        public static void main (String[]args){
            new login();
        }
    }



