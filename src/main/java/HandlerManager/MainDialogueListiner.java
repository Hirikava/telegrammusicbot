package HandlerManager;

import DataBaseManager.StartHandler;

public class MainDialogueListiner extends DialogueListner {
    private static MainDialogueListiner ourInstance = new MainDialogueListiner();

    public static MainDialogueListiner getInstance() {
        return ourInstance;
    }

    private MainDialogueListiner() {
        this.addNewHandler("!start", new StartHandler());
        this.addNewHandler("!play", new AudioSendHandler());
        this.addNewHandler("!link", new LinkHandler());
    }
}
