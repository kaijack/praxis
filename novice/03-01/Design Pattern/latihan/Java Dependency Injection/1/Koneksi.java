import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {
    public Connection openConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
            return conn;
        } catch (Exception e) {
            return conn = null;
        }
    }
}