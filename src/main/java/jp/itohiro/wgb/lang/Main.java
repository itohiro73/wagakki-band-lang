package jp.itohiro.wgb.lang;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.list.mutable.ListAdapter;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException {
        String sourceFile="";
        Properties p = new Properties();
        InputStreamReader inputStreamReader = new InputStreamReader(Main.class.getClassLoader().getResourceAsStream("wgb.properties"), Charset.forName("UTF-8"));
        if(args.length == 1){
            sourceFile = args[0];
        }
        else if(args.length == 2){
            String propertiesFile = args[0];
            InputStream propertiesFileInputStream = Main.class.getClassLoader().getResourceAsStream(propertiesFile);
            if(propertiesFileInputStream == null){
                throw new FileNotFoundException("Properties file not existing: " + propertiesFile);
            }
            inputStreamReader = new InputStreamReader(propertiesFileInputStream, Charset.forName("UTF-8"));
            sourceFile = args[1];
        }
        else{
            System.out.println("Usage: wagakki-band-lang [operation mapping file] sourceFile");
            System.exit(1);
        }
        p.load(inputStreamReader);
        inputStreamReader.close();
        MutableList<String> sourceLines = ListAdapter.adapt(Files.readAllLines(Paths.get(sourceFile)));
        String source = sourceLines.makeString("");
        BFEngine engine = new BFEngine(source, p);
        engine.run();
    }
}
