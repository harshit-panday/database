import java.sql.*;
public class slip7{
    public static void main(String args[]){
        Connection con=null;
        ResultSet rs;
        PreparedStatement pstmt =null;
        try{
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql://localhost/product","postgres","harshit");
            pstmt=con.prepareStatement("select * from product1");
            rs=pstmt.executeQuery();
            while(rs.next()){
                System.out.println("Product id:"+rs.getInt(1));
                System.out.println("Product Name:"+rs.getString(2));
                System.out.println("Product description:"+rs.getInt(3));
            }
        }catch(Exception ex){
            System.out.println("Error"+ex.getMessage());
        }
    }
}