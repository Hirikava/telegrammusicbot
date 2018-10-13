package HandlerManager;
import java.util.*;
import java.io.*;


public class DialogueListner {
    private Map<String, IHandler> commandHandlerDict;

    public DialogueListner() {
        commandHandlerDict = new HashMap<>();
    }

    public void addNewHandler(String command, IHandler handler) {
        try{
            if (commandHandlerDict.containsKey(command))
                throw new Exception("DiaologueListiner already contains key: " + command);
            else
                commandHandlerDict.put(command,handler);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public IHandler getHandler(String command)
    {
        if(commandHandlerDict.containsKey(command))
            return commandHandlerDict.get(command);
        return new StringHandler("Command not found :(");
    }
}
