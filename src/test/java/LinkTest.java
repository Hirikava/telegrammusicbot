import org.junit.Assert;
import org.junit.Test;

public class LinkTest {

    @Test
    public void EnglishRequestsTest(){
        Link link1 = new Link("despacito");
        Assert.assertEquals("https://www.youtube.com/watch?v=kJQP7kiw5Fk",
                            link1.GetName());
        Link link2 = new Link("thousand foot krutch untraveled road");
        Assert.assertEquals("https://www.youtube.com/watch?v=jSD5vSSGLOM",
                            link2.GetName());
        Link link3 = new Link("lil pump");
        Assert.assertEquals("https://www.youtube.com/watch?v=cwQgjq0mCdE",
                            link3.GetName());
    }

    @Test
    public void RussianRequestsTest(){
        Link link1 = new Link("горы по колено");
        Assert.assertEquals("https://www.youtube.com/watch?v=WujKJpxaUHk",
                            link1.GetName());
        Link link2 = new Link("констракт");
        Assert.assertEquals("https://www.youtube.com/watch?v=1g1XM-FgzJQ",
                            link2.GetName());
        Link link3 = new Link("ддт осень");
        Assert.assertEquals("https://www.youtube.com/watch?v=5KC-iscJtsI",
                            link3.GetName());
    }
}
