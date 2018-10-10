import org.telegram.telegrambots.api.objects.Message;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseStartHandler extends IDataBaseHandler {

    public String prep(Message message) {
        DataBaseBus dataBaseBus = new DataBaseBus("jdbc:sqlite:src/main/resources/dataBase/db.db");
        try {
            ResultSet resultSet = dataBaseBus
                    .execute("SELECT * FROM Users WHERE userID=" + message.getChatId() + ";" );
            if(resultSet.next())
                return "You are already registered in data base :)";
            else
                dataBaseBus.execute("INSERT INTO Users VALUES (" + message.getChatId() + ");");
                return "You are sucesfully registered in data base :)";
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
        return "Something wrong with the server :(";
    }
}
