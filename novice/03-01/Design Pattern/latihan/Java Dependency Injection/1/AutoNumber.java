import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AutoNumber {

    Koneksi objKoneksi;

    public AutoNumber(Koneksi objKoneksi) {
        this.objKoneksi = objKoneksi;
    }

    public void setObjKoneksi(Koneksi objKoneksi) {
        this.objKoneksi = objKoneksi;
    }

    public void printAutoNumber() {
        String noService = "SER000";
        Connection conn = objKoneksi.openConn();
        try {
            Statement st = conn.createStatement();
            String sql = "select noService from Service order by asc";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                noService = rs.getString("noService");
            }
            noService = noService.substring(3);
            int i = Integer.parseInt(noService) + 1;
            noService = "00" + i;
            noService = "SER".concat(noService.substring(noService.length() - 3));
            System.out.println("Noservice : " + noService);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}