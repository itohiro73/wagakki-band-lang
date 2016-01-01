package jp.itohiro.wgb.lang;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.list.mutable.ListAdapter;
import org.eclipse.collections.impl.string.immutable.CodePointAdapter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        String sourceFile = args[0];
        MutableList<String> sourceLines = ListAdapter.adapt(Files.readAllLines(Paths.get(sourceFile)));
        String singleLine = sourceLines.makeString("");
        Engine engine = new Engine(singleLine);
        engine.run();
    }
}
