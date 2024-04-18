import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class sample extends JFrame implements ActionListener{
    JTextField ddl;
    JButton create,alter,drop;

    sample(){
        setTitle("form");
        setSize(800,600);
        setLayout(new GridLayout(2,3));
        setDefaultCloseOperation(JFraem.EXIT_ON_CLOSE);
        JLabel l1=new JLabel("type yoyr ddl query");
        add(l1);
        ddl=new JTextField(20);
        add(ddl);
        create=new JButton("create");
        add(create);
        alter=new JButton("alter");
        add(alter);
        drop=new JButton("drop");
        add(drop);

        create.addActionListener(this);
        alter.addActionListener(this);
        drop.addActionListener(this);
        setVisible(true);
    }
}