import HandlerManager.AudioFile;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class AudioFileTest {

    @Test
    public void simpleTest() throws IOException {
        AudioFile a = new AudioFile("https://www.youtube.com/watch?v=kJQP7kiw5Fk", 787887886L);
        File audio = new File(a.getPath()+"/"+a.getName());
        assert audio.exists() == true;
        FileUtils.deleteDirectory(new File(a.getPath()));
        a = null;
    }
}
