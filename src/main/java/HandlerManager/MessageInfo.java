package HandlerManager;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MessageInfo implements Iterable {
    private List<Object> messageList;

    public MessageInfo() {
        messageList = new LinkedList<Object>();
    }
    public void addSendObject(Object sendObject) {
        messageList.add(sendObject);
    }
    @Override
    public Iterator iterator() {
        return messageList.iterator();
    }
}
