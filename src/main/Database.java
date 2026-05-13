import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database
{
    Connection DatabaseConnection;
    Statement DatabaseStatement;

    Database()
    {
        try
        {
            DatabaseConnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/trainease","root","password");
            DatabaseStatement=DatabaseConnection.createStatement();
        }
        catch(SQLException e)
        {
            System.out.println("Error!");
        }
    }
    
    public static void main(String[] args)
    {
        new Database();
    }
}
