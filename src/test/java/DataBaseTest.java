import org.junit.Assert;
import org.junit.Test;

public class DataBaseTest {

    @Test
    public void InitializeDataBase()
    {
        DataBaseBus dataBaseBus = new DataBaseBus("jdbc:sqlite:C:\\Users\\TheDAX\\Desktop\\TelegramBot\\DataBase\\db.db");
    }
}
