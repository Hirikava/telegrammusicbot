import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

public interface IHandler {
    public SendMessage handle(Message msg);

}
