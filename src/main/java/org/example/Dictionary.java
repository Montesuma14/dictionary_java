package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

  Map<Integer, String> dictionaryInt;
  File dictionaryIntFile;
  Map<String, String> dictionaryStr;
  File dictionaryStrFile;

  public Dictionary() {
    dictionaryIntFile = new File("dictionaryInt.txt");
    if (!dictionaryIntFile.exists()) {
      try {
        System.out.println("создан новый интовый словарь!");
        dictionaryIntFile.createNewFile();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    dictionaryStrFile = new File("dictionaryStr.txt");
    if (!dictionaryStrFile.exists()) {
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

  //Добавление слова в словарь, обновление файла словаря
  public void putDictionaryInt(String key, String word) {
    writeDictionaryInt(dictionaryIntFile, key, word, (HashMap<Integer, String>) dictionaryInt);
    dictionaryInt.put(Integer.valueOf(key), word);

  }

  public void putDictionaryStr(String key, String word) {
    writeDictionaryStr(dictionaryStrFile, key, word, (HashMap<String, String>) dictionaryStr);
    dictionaryStr.put(key, word);
  }

  public String getDictionaryKey(int key) {
    return dictionaryInt.get(key);
  }

  public String getDictionaryKey(String key) {
    return dictionaryStr.get(key);
  }


  //Удаление слова из словаря и обновление файла (Интовый словарь словарь)
  public boolean removeWordDictionary(int key) {
      if (getDictionaryKey(key) != null) {
          dictionaryInt.remove(key);
          try (var out = new FileOutputStream(dictionaryIntFile)) {
              writingHashMapInt((HashMap<Integer, String>) dictionaryInt, out);
          } catch (IOException e) {
              System.out.println("Ошибка при записи файла");
          }
          return true;
      } else {
          return false;
      }
  }

  //Удаление слова из словоря и обновление файла (Латинский словарь)
  public boolean removeWordDictionary(String key) {
      if (getDictionaryKey(key) != null) {
          dictionaryStr.remove(key);
          try (var out = new FileOutputStream(dictionaryStrFile)) {
              writingHashMapStr((HashMap<String, String>) dictionaryStr, out);
          } catch (IOException e) {
              System.out.println("Ошибка при записи файла");
          }
          return true;
      } else {
          return false;
      }
  }

  //Чтение словаря из файла и запись его в hashmap (Интовый словарь)
  private static void readDictionaryInt(File test, HashMap<Integer, String> dictionaryint) {

    String[] subStr;
    try (Scanner scan = new Scanner(
        new InputStreamReader(
            new FileInputStream(test), StandardCharsets.UTF_8))) {
      while (scan.hasNextLine()) {
        subStr = scan.nextLine().split("@");
        dictionaryint.put(Integer.parseInt(subStr[0]), subStr[1]);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //Чтение словаря из файла и запись его в hashmap (Латинский словарь)
  private static void readDictionaryStr(File test, HashMap<String, String> dictionaryStr) {
    String[] subStr;
    try (Scanner scan = new Scanner(
        new InputStreamReader(
            new FileInputStream(test), StandardCharsets.UTF_8))) {
      while (scan.hasNextLine()) {
        subStr = scan.nextLine().split("@");
        dictionaryStr.put(subStr[0], subStr[1]);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  // Перезапись файла после добавления нового слова в словарь (Интовый словарь)
  private static void writeDictionaryInt(File test, String key, String word,
      HashMap<Integer, String> dictionaryInt) {

    try (var out = new FileOutputStream(test)) {

      writingHashMapInt(dictionaryInt, out);

      out.write(key.getBytes());
      out.write('@');
      out.write(word.getBytes());
      out.write('\n');
    } catch (IOException e) {
      System.out.println("Ошибка при записи файла");
    }
  }

  private static void writingHashMapInt(HashMap<Integer, String> dictionaryInt,
      FileOutputStream out) throws IOException {
    for (Map.Entry<Integer, String> entry : dictionaryInt.entrySet()) {
      out.write(entry.getKey().toString().getBytes());
      out.write('@');
      out.write(entry.getValue().getBytes());
      out.write('\n');
    }
  }

  // Перезапись файла после добавления нового слова в словарь (Латинский словарь словарь)
  private static void writeDictionaryStr(File test, String key, String word,
      HashMap<String, String> dictionaryStr) {

    try (var out = new FileOutputStream(test)) {

      writingHashMapStr(dictionaryStr, out);

      out.write(key.getBytes());
      out.write('@');
      out.write(word.getBytes());
      out.write('\n');
    } catch (IOException e) {
      System.out.println("Ошибка при записи файла");
    }
  }

  private static void writingHashMapStr(HashMap<String, String> dictionaryInt, FileOutputStream out)
      throws IOException {
    for (Map.Entry<String, String> entry : dictionaryInt.entrySet()) {
      out.write(entry.getKey().getBytes());
      out.write('@');
      out.write(entry.getValue().getBytes());
      out.write('\n');
    }
  }


}
