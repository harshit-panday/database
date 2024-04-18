import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class slip1 extends JFrame implements ActionListener {
    JTextField pid, pname, pdesp, pstatus;
    JButton insert;

    slip1() {
        setTitle("registration");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));
        JLabel l1 = new JLabel("employee no");
        add(l1);
        pid = new JTextField(20);
        add(pid);
        JLabel l2 = new JLabel("employee name");
        add(l2);
        pname = new JTextField(20);
        add(pname);
        JLabel l3 = new JLabel("Designation");
        add(l3);
        pdesp = new JTextField(20);
        add(pdesp);
        JLabel l4 = new JLabel("Salary"); // Added label for salary
        add(l4);
        pstatus = new JTextField(20);
        add(pstatus);
        insert = new JButton("insert into table");
        add(insert);
        insert.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == insert) {
            int p = Integer.parseInt(pid.getText());
            String pnm = pname.getText();
            String description = pdesp.getText();
            int s = Integer.parseInt(pstatus.getText());
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://localhost/emp", "postgres", "harshit");
                pstmt = conn.prepareStatement("insert into emp (eno, enm, design, sal) values(?,?,?,?)");

                pstmt.setInt(1, p);
                pstmt.setString(2, pnm);
                pstmt.setString(3, description);
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