package jp.itohiro.web.lang;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import jp.itohiro.wgb.lang.Main;
import org.junit.*;

import java.io.*;
import java.net.URL;

import static org.hamcrest.core.Is.is;

public class WagakkiBandLangTest {
    @Rule
    public InOutTestResource inOutTestResource = new InOutTestResource();

    @Test
    public void testHelloWorld() throws Exception {
        URL testFilePath = BFTest.class.getClassLoader().getResource("helloworld_wgb.txt");
        URL propertiesFilePath = BFTest.class.getClassLoader().getResource("wgb.properties");
        Assert.assertNotNull(testFilePath);
        Assert.assertNotNull(propertiesFilePath);
        Main.main(new String[]{testFilePath.getPath(), propertiesFilePath.getPath()});
        Assert.assertThat(inOutTestResource.getOutputStream().toByteArray(), is("Hello World!\n".getBytes()));
    }
}