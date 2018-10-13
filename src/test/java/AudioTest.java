import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class AudioTest {

    @Test
    public void SimpleTest() throws IOException {
        Audio a = new Audio("https://www.youtube.com/watch?v=kJQP7kiw5Fk", 787887886);
        File audio = new File(a.getPath()+"/"+a.getName());
        assert audio.exists() == true;
        FileUtils.deleteDirectory(new File(a.getPath()));
        a = null;
    }
}
