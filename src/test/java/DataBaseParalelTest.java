import DataBaseManager.DataBase;
import HandlerManager.MessageInfo;
import org.junit.Test;
import org.telegram.telegrambots.api.methods.send.SendMessage;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseParalelTest {
    @Test
    public void DataBaseParalelTest() {
        DataBase.Initialization("jdbc:sqlite:src/main/resources/dataBase/DataBase.db");
        Connection connection = DataBase.getInstance().getConecction();
        try {
            connection.createStatement().execute("CREATE TABLE Users ( userID BIGINT );");
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    @Test
    public void InstanceOf()
    {
        SendMessage sendMessage = new SendMessage();
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.addSendObject(sendMessage);
        System.out.println(messageInfo.iterator().next() instanceof SendMessage);
    }
}
