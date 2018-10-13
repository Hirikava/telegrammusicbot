package HandlerManager;

import HandlerManager.IHandler;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

public class StringHandler implements IHandler {
    private String answer;

    public StringHandler(String answer)
    {
        this.answer = answer;
    }

    @Override
    public MessageInfo handle(Message msg) {
        SendMessage sndMsg = new SendMessage();
        sndMsg.enableMarkdown(true);
        sndMsg.setChatId(msg.getChatId());
        sndMsg.setText(this.answer);
        MessageInfo msgInfo = new MessageInfo();
        msgInfo.addSendObject(sndMsg);
        return msgInfo;
    }
}
