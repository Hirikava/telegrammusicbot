package DataBaseManager;

import HandlerManager.StringHandler;
import com.sun.org.apache.xml.internal.security.Init;
import org.sqlite.SQLiteDataSource;

import java.sql.SQLException;

public class DataBase {
    private String url;
    private SQLiteDataSource sqLiteDataSource;
    private static DataBase ourInstance;

    private DataBase(String url){
        this.url = url;
        sqLiteDataSource = new SQLiteDataSource();
        sqLiteDataSource.setUrl(this.url);
    }

    public static DataBase getInstance() {
        return ourInstance;
    }

    public static void Initialization(String url) {
        ourInstance = new DataBase(url);
    }

    public java.sql.Connection getConecction(){
        try {
            return sqLiteDataSource.getConnection();
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
