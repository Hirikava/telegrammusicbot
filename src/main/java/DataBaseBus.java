import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.sqlite.SQLiteDataSource;
import org.sqlite.SQLiteJDBCLoader;

public class DataBaseBus {

    SQLiteDataSource dataSource;


    public DataBaseBus(String url)
    {
        dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);
    }

    public ResultSet execute(String sqlRequest) {
        ResultSet resultSet = null;
        try {
            resultSet = dataSource.getConnection().createStatement()
                    .executeQuery(sqlRequest);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return resultSet;
    }
}
