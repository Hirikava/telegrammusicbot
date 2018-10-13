import HandlerManager.MainDialogueListiner;
import HandlerManager.MessageInfo;
import HandlerManager.StringHandler;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendAudio;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try{
            telegramBotsApi.registerBot(new Bot());
        }
        catch (TelegramApiRequestException e){
            e.printStackTrace();
        }
    }

    public void sendMsg(MessageInfo messageInfo){
        try {
            for(Object sendObj:messageInfo)
            {
                if(sendObj instanceof SendMessage){
                    SendMessage sendMessage = (SendMessage)sendObj;
                    sendMessage(sendMessage);
                    break;
                }
                if(sendObj instanceof SendAudio){
                    SendAudio sendAudio = (SendAudio) sendObj;
                    sendAudio(sendAudio);
                    break;
                }
            }
            SendMessage sendMessage = new SendMessage();
            this.setButtons(sendMessage);
            sendMessage(sendMessage);
        }
        catch (TelegramApiException ex) {
            ex.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update){
        Message message = update.getMessage();
        if (message !=  null && message.hasText()){
            this.sendMsg(MainDialogueListiner.getInstance()
                    .getHandler(message.getText().split(" ")[0]).handle(message));
        }
    }

    public void setButtons(SendMessage sendMessage){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRowsList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();

        keyboardFirstRow.add(new KeyboardButton("!start"));

        keyboardRowsList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowsList);
    }

    public String getBotUsername() {
        return "MyF4kingMusicBot";
    }

    public String getBotToken() {
        return "659916332:AAFgUX8BzG47rS1ECuixC985gN-RqqvdoJU";
    }
}