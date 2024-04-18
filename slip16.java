import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class slip1 extends JFrame implements ActionListener {
    JTextField tno, tnm, subject, sal;
    JButton insert;

    slip1() {
        setTitle("registration");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));
        JLabel l1 = new JLabel("employee no");
        add(l1);
        tno = new JTextField(20);
        add(tno);
        JLabel l2 = new JLabel("employee name");
        add(l2);
        tnm = new JTextField(20);
        add(tnm);
        JLabel l3 = new JLabel("Designation");
        add(l3);
        subject = new JTextField(20);
        add(subject);
        JLabel l4 = new JLabel("Salary"); // Added label for salary
        add(l4);
        sal = new JTextField(20);
        add(sal);
        insert = new JButton("insert into table");
        add(insert);
        insert.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == insert) {
            int t = Integer.parseInt(tno.getText());
            String tname = tnm.getText();
            String tsub = subject.getText();
            int s = Integer.parseInt(sal.getText());
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://localhost/emp", "postgres", "harshit");
                pstmt = conn.prepareStatement("insert into emp (eno, enm, design, sal) values(?,?,?,?)");

                pstmt.setInt(1, t);
                pstmt.setString(2, tname);
                pstmt.setString(3, tsub);
                pstmt.setInt(4, s);

                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
            } catch (Exception ex) {
                System.out.println("Error"+ex.getMessage());

            }
        }
    }

    public static void main(String[] args) {
        new slip1();
    }
}

