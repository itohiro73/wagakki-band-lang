package jp.itohiro.wgb.lang;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.list.mutable.ListAdapter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException {
        String sourceFile = args[0];
        if(args.length > 1){
            String propertiesFile = args[1];
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(Paths.get(propertiesFile).toFile()), Charset.forName("UTF-8"));

            Properties p = new Properties();
            p.load(inputStreamReader);
            System.setProperties(p);
            inputStreamReader.close();
        }
        MutableList<String> sourceLines = ListAdapter.adapt(Files.readAllLines(Paths.get(sourceFile)));
        String singleLine = sourceLines.makeString("");
        Engine engine = new Engine(singleLine);
        engine.run();
    }
}
