package jp.itohiro.web.lang;

import jp.itohiro.wgb.lang.Main;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static org.hamcrest.core.Is.is;

public class BFTest {
    @Rule
    public InOutTestResource inOutTestResource = new InOutTestResource();

    @Test
    public void testHelloWorld() throws Exception {
        URL testFilePath = BFTest.class.getClassLoader().getResource("helloworld.txt");
        Assert.assertNotNull(testFilePath);
        Main.main(new String[]{"bf.properties", testFilePath.getPath()});
        Assert.assertThat(inOutTestResource.getOutputStream().toByteArray(), is("Hello World!\n".getBytes()));
    }
}
