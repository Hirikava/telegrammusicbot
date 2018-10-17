package HandlerManager;

import org.telegram.telegrambots.api.methods.send.SendAudio;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Audio;
import org.telegram.telegrambots.api.objects.Message;

import java.io.File;

public class AudioSendHandler implements  IHandler {
    public MessageInfo handle(Message message) {
        String querry = ((SendMessage) (new LinkHandler().handle(message).iterator().next())).getText();
        System.out.println(querry);
        AudioFile audio = new AudioFile(querry, message.getChatId());
        SendAudio sendAudio = new SendAudio();
        sendAudio.setNewAudio(new File(audio.getPath() + "/" + audio.getName()));
        sendAudio.setChatId(message.getChatId());
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.addSendObject(sendAudio);
        return messageInfo;
    }
}