import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class slip10 extends JFrame implements ActionListener
{
JTextField t1,t2,t3;
JButton insert;

slip10()
{
    setTitle("student display");
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridLayout(4, 2));

JLabel l1=new JLabel("RollNo");
add(l1);

t1=new JTextField(10);
add(t1);

JLabel l2=new JLabel("Name");
add(l2);

t2=new JTextField(10);
add(t2);

JLabel l3=new JLabel("Percentage");
add(l3);

t3=new JTextField(10);
add(t3);

insert = new JButton("display first record");
add(insert);
insert.addActionListener(this);
setVisible(true);
}
public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == insert) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs=null;;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost/student", "postgres", "harshit");
            pstmt=con.prepareStatement("select * from student",rs.TYPE_SCROLL_SENSITIVE,rs.CONCUR_READ_ONLY);
            rs=pstmt.executeQuery();
        rs.first();
        t1.setText(Integer.toString(rs.getInt(1)));
        t2.setText(rs.getString(2));
        t3.setText(Integer.toString(rs.getInt(3)));
        } 
        catch (Exception ex) {
            System.out.println("Error"+ex.getMessage());

        }
    }
}
public static void main(String[] args) throws Exception
{
new slip10();
}
}

