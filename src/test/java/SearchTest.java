import org.junit.Assert;
import org.junit.Test;

public class SearchTest {

    @Test
    public void SimpleTest(){
        Assert.assertEquals("https://www.youtube.com/watch?v=kJQP7kiw5Fk", Search.SearchLink("despacito"));
    }
}
