package org.example;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    Map<Integer, String> dictionaryInt;
    Map<String, String> dictionaryStr;
    public Dictionary(){
        File  dictionaryIntFile = new File("dictionaryInt.txt");
        if(!dictionaryIntFile.exists()) {
            try {
                System.out.println("создан новый интовый словарь!");
                dictionaryIntFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        File  dictionaryStrFile = new File("dictionaryStr.txt");
        if(!dictionaryStrFile.exists()) {
            try {
                System.out.println("создан новый стринговый словарь словарь!");
                dictionaryStrFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        dictionaryInt = new HashMap<>();
        dictionaryStr = new HashMap<>();
    }

    public void putDictionary(int key, String word){
        dictionaryInt.put(key,word);

    }

    public void putDictionary(String key, String word){
        dictionaryStr.put(key,word);
    }

    public String getDictionary(int key){
        return dictionaryInt.get(key);
    }

    public String getDictionary(String key){
        return dictionaryStr.get(key);
    }


    public boolean removeWordDictionary(int key){
        if ( getDictionary(key)!= null){
            dictionaryInt.remove(key);
            return true;
        }
        else return false;
    }

    public boolean removeWordDictionary(String key){
        if ( getDictionary(key)!= null){
            dictionaryStr.remove(key);
            return true;
        }
        else return false;
    }

}
