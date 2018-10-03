import java.util.*;


public  class DiologListner {
    private static Map<String, IHandler> comandHandlerDict = new HashMap<String, IHandler>();

    public static IHandler getHandler(String text)
    {
        String token = text.split(" ")[0];
        if(comandHandlerDict.containsKey(token))
            return comandHandlerDict.get(token);
        else
            return new StringHandler("Command not found");
    }

    public static void registrateHandler(String text, IHandler handler)
    {
        comandHandlerDict.put(text,handler);
    }
}
