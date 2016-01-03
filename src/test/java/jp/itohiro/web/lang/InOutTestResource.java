package jp.itohiro.web.lang;

import org.junit.After;
import org.junit.Before;
import org.junit.rules.ExternalResource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class InOutTestResource extends ExternalResource {
    private final ByteArrayInputStream in = new ByteArrayInputStream(new byte[]{});
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    public void before(){
        System.setIn(in);
        System.setOut(new PrintStream(out));
    }

    public void after(){
        System.setIn(null);
        System.setOut(null);
    }

    public ByteArrayInputStream getInputStream(){
        return this.in;
    }

    public ByteArrayOutputStream getOutputStream(){
        return this.out;
    }
}
