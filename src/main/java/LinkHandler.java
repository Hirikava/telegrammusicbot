import HandlerManager.IHandler;
import HandlerManager.MessageInfo;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class LinkHandler implements IHandler {

    public LinkHandler(){}

    public MessageInfo handle(Message msg) {
        SendMessage sndmsg = new SendMessage();
        sndmsg.enableMarkdown(true);
        sndmsg.setChatId(msg.getChatId());
        sndmsg.setText(SearchLink(msg.getText().split("\"")[1]));
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.addSendObject(sndmsg);
        return messageInfo;
    }

    private String SearchLink(String str){
        String youtubeLinkForSearching = "https://www.youtube.com/results?search_query=";
        String youtubeSearchingResultLink = youtubeLinkForSearching + str.replaceAll(" ", "+");
        String youtubeLink = "https://www.youtube.com";
        String result = youtubeLink + GetVideoId(youtubeSearchingResultLink);
        return result;
    }

    private String GetVideoId(String link) {
        try {
            URL site = new URL(link);
            BufferedReader reader = new BufferedReader(new InputStreamReader(site.openStream()));
            String line;
            while ((line = reader.readLine()) != null){
                if (line.startsWith("<li><div class=\"yt-lockup")){
                    String[] wordArr = line.split(" ");
                    for (String word:wordArr) {
                        if (word.startsWith("href=")){
                            int begin = word.indexOf('"')+1;
                            int end = word.lastIndexOf('"');
                            return word.substring(begin, end);
                        }
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
