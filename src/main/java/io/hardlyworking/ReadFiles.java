package io.hardlyworking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadFiles {
    //TODO Parse args(code|name|file) Perform search without prompt
    File file;

    public ReadFiles(String file) throws FileNotFoundException {
        this.file = new File(file);
    }

    BufferedReader reader = new BufferedReader(new FileReader(file));

}
