import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

public abstract class IDataBaseHandler implements IHandler {

    public SendMessage handle(Message message) {
        SendMessage sndmsg = new SendMessage();
        sndmsg.enableMarkdown(true);
        sndmsg.setChatId(message.getChatId());
        sndmsg.setText(this.prep(message));
        return sndmsg;

    }

    public abstract String prep(Message msg);
}
