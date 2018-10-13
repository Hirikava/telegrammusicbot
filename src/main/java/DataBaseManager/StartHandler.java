package DataBaseManager;
import HandlerManager.IHandler;
import HandlerManager.MessageInfo;
import HandlerManager.StringHandler;
import org.telegram.telegrambots.api.objects.Message;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StartHandler implements IHandler{
    public MessageInfo handle(Message message) {
        Connection connection = DataBase.getInstance().getConecction();
        try{
            ResultSet resultSet = connection.createStatement()
                    .executeQuery("SELECT * FROM Users WHERE userID=" + message.getChatId() + ";");
            if(resultSet.next())
                return new StringHandler("You are already registrated in DataBase.").handle(message);
            else {
                connection.createStatement()
                        .execute("INSERT INTO Users VALUES (" + message.getChatId() + ");");
                return new StringHandler("You are sucsessfuly registarated in DataBase!").handle(message);
            }
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
        return new StringHandler("Somthing wrong with the server :(").handle(message);
    }

}
