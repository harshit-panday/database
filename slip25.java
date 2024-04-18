import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class slip1 extends JFrame implements ActionListener {
    JTextField ddl;
    JButton create,alter ,drop;

    slip1() {
        setTitle("ddl query");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 3));
        JLabel l1 = new JLabel("type your DDL query");
        add(l1);
        ddl = new JTextField(20);
        add(ddl);
        create = new JButton("create table");
        add(create);

        alter = new JButton("alter table");
        add(alter);

        drop = new JButton("drop table");
        add(drop);

        create.addActionListener(this);
        alter.addActionListener(this);
        drop.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String sql = ddl.getText();
            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://localhost/sample", "postgres", "harshit");
                pstmt = conn.prepareStatement(sql);

                pstmt.executeUpdate();
                ddl.setText("");
                pstmt.close();
                conn.close();
            } catch (Exception ex) {
                System.out.println("Error"+ex.getMessage());

            }
        }
    }
}
    