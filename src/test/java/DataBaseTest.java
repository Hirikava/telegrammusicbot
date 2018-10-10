import org.junit.Assert;
import org.junit.Test;

public class DataBaseTest {

    @Test
    public void InitializeDataBase() {
        DataBaseBus dataBaseBus = new DataBaseBus("jdbc:sqlite:src/main/resources/dataBase/db.db");
        dataBaseBus.execute("CREATE TABLE Users (userID BIGINT);");
    }
}
