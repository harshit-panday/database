import java.sql.*;
public class slip11
{
public static void main(String[] args)
{
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs=null;
    try {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql://localhost/student", "postgres", "harshit");
        pstmt=con.prepareStatement("select * from student");
        rs=pstmt.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int noOfColumns = rsmd.getColumnCount();

        System.out.println("Number of columns = " +noOfColumns);
        for(int i=1; i<=noOfColumns; i++)
        {
        System.out.println("Column No : " + i);
        System.out.println("Column Name : " +

        rsmd.getColumnName(i));

        System.out.println("Column Type : " +rsmd.getColumnTypeName(i));
        System.out.println("Column display size : " +rsmd.getColumnDisplaySize(i));
        }
        }catch (Exception ex) {
            System.out.println("Error"+ex.getMessage());

        }
    }
}

