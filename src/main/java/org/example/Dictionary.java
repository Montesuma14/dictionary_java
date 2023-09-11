package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    Map<Integer, String> dictionaryInt;
    File  dictionaryIntFile;
    Map<String, String> dictionaryStr;
    File  dictionaryStrFile;

    public Dictionary(){
        dictionaryIntFile = new File("dictionaryInt.txt");
        if(!dictionaryIntFile.exists()) {
            try {
                System.out.println("создан новый интовый словарь!");
                dictionaryIntFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        dictionaryStrFile = new File("dictionaryStr.txt");
        if(!dictionaryStrFile.exists()) {
            try {
                System.out.println("создан новый стринговый словарь словарь!");
                dictionaryStrFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        dictionaryInt = new HashMap<>();
        readDictionaryInt(dictionaryIntFile, (HashMap<Integer, String>) dictionaryInt);
        dictionaryStr = new HashMap<>();
        readDictionaryStr(dictionaryStrFile, (HashMap<String, String>) dictionaryStr);
    }

    public void putdictionaryInt(String key, String word){
        WriteDictionaryInt(dictionaryIntFile, key, word, (HashMap<Integer, String>) dictionaryInt);
        dictionaryInt.put(Integer.valueOf(key), word);

    }

    public void putdictionaryStr(String key, String word){
        WriteDictionaryStr(dictionaryStrFile, key, word, (HashMap<String, String>) dictionaryStr);
        dictionaryStr.put(key, word);
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
            try ( var out = new FileOutputStream(dictionaryIntFile)) {
                writingHashMapInt((HashMap<Integer, String>) dictionaryInt, out);
            } catch (IOException e){
                System.out.println("Ошибка при записи файла");
            }
            return true;
        }
        else return false;
    }

    public boolean removeWordDictionary(String key){
        if ( getDictionary(key)!= null){
            dictionaryStr.remove(key);
            try ( var out = new FileOutputStream(dictionaryStrFile)) {
                writingHashMapStr((HashMap<String, String>) dictionaryStr, out);
            } catch (IOException e){
                System.out.println("Ошибка при записи файла");
            }
            return true;
        }
        else return false;
    }
    private static void readDictionaryInt(File test, HashMap <Integer, String>  dictionaryint){

        int i;
        try ( var fin = new FileInputStream(test)) {
            boolean flag = true;
            String key = "";
            String word = "";
            do
            {
                i = fin.read();
                if (i =='\n'){
                    dictionaryint.put(Integer.parseInt(key), word);
                    key = "";
                    word = "";
                    flag = true;
                    continue;
                }
                if (i =='@'){
                    flag = false;
                    continue;
                }
                if (flag){
                    key += (char) i;
                }
                else {
                    word += (char) i;
                }

            }while (i != -1);
        } catch (IOException e){
            System.out.println("Ошибка при чтении файла");
        }
    }

    private static void readDictionaryStr(File test, HashMap <String, String>  dictionaryInt){

        int i;
        try ( var fin = new FileInputStream(test)) {
            boolean flag = true;
            String key = "";
            String word = "";
            do
            {
                i = fin.read();
                if (i =='\n'){
                    dictionaryInt.put(key, word);
                    key = "";
                    word = "";
                    flag = true;
                    continue;
                }
                if (i =='@'){
                    flag = false;
                    continue;
                }
                if (flag){
                    key += (char) i;
                }
                else {
                    word += (char) i;
                }

            }while (i != -1);
        } catch (IOException e){
            System.out.println("Ошибка при чтении файла");
        }
    }




    private static void WriteDictionaryInt(File test, String key, String word, HashMap <Integer, String> dictionaryInt){

        try ( var out = new FileOutputStream(test)) {

            writingHashMapInt(dictionaryInt, out);

            out.write(key.getBytes());
            out.write('@');
            out.write(word.getBytes());
            out.write('\n');
        } catch (IOException e){
            System.out.println("Ошибка при записи файла");
        }
    }

    private static void writingHashMapInt(HashMap<Integer, String> dictionaryInt, FileOutputStream out) throws IOException {
        for (Map.Entry<Integer, String> entry : dictionaryInt.entrySet()) {
            out.write(entry.getKey().toString().getBytes());
            out.write('@');
            out.write(entry.getValue().getBytes());
            out.write('\n');
        }
    }

    private static void WriteDictionaryStr(File test, String key, String word, HashMap <String, String> dictionaryStr){

        try ( var out = new FileOutputStream(test)) {

            writingHashMapStr(dictionaryStr, out);

            out.write(key.getBytes());
            out.write('@');
            out.write(word.getBytes());
            out.write('\n');
        } catch (IOException e){
            System.out.println("Ошибка при записи файла");
        }
    }

    private static void writingHashMapStr(HashMap<String, String> dictionaryInt, FileOutputStream out) throws IOException {
        for (Map.Entry<String, String> entry : dictionaryInt.entrySet()) {
            out.write(entry.getKey().toString().getBytes());
            out.write('@');
            out.write(entry.getValue().getBytes());
            out.write('\n');
        }
    }


}
