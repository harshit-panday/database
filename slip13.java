import java.sql.*;
public class slip13
{
public static void main(String[] args)
{
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs=null;;
try {
    Class.forName("org.postgresql.Driver");
    con = DriverManager.getConnection("jdbc:postgresql://localhost/emp", "postgres", "harshit");
    pstmt=con.prepareStatement("select * from emp");
    rs=pstmt.executeQuery();
    DatabaseMetaData dbmd = con.getMetaData();
    System.out.println("Database Product name = " +dbmd.getDatabaseProductName());
    System.out.println("User name = " + dbmd.getUserName());
    System.out.println("Database driver name= " + dbmd.getDriverName());

    System.out.println("Database driver version = "+ dbmd.getDriverVersion());
    System.out.println("Database product name = " +dbmd.getDatabaseProductName());
    System.out.println("Database Version = " + dbmd.getDriverMajorVersion());
    rs = dbmd.getTables(null,null,null, new String[]{"TABLE"});
    System.out.println("List of tables...");
    while(rs.next())
    {
    String tblName = rs.getString("TABLE_NAME");
    System.out.println("Table : "+ tblName);
    }
    }catch (Exception ex) {
    System.out.println("Error"+ex.getMessage());

    }
}
}
