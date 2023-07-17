package org.example;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<Integer, String> dictionaryInt;
    private Map<String, String> dictionaryStr;
    public Dictionary(){
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
