package com.intro.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
public class CopyCharacters {
    public static void main(String[] args) throws IOException {
 
        FileReader inputStream = null;
        FileWriter outputStream = null;
 
        try {
            inputStream = new FileReader("xanadu.txt");
            outputStream = new FileWriter("characteroutput.txt");
            
                        
            int c;
            char[] cha = new char[32];
            
            while ((c = inputStream.read(cha)) != -1) {
                outputStream.write(cha);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}