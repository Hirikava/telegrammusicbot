package HandlerManager;

import org.telegram.telegrambots.api.objects.Message;

public interface IHandler {
    MessageInfo handle(Message msg);
}
