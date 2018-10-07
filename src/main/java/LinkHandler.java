import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

public class LinkHandler implements IHandler{

    public LinkHandler(){};

    public SendMessage handle(Message msg)
    {
        SendMessage sndmsg = new SendMessage();
        sndmsg.enableMarkdown(true);
        sndmsg.setChatId(msg.getChatId());
        sndmsg.setText(new Link(msg.getText().split("\"")[1]).GetName());
        return sndmsg;
    }
}
