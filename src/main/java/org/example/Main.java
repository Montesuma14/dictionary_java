package org.example;


import java.util.Map;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {




    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();

        System.out.println("Программа словарей!");
        while (true){
            System.out.println("Выберите действие:");
            System.out.println("1.Добавить слово в словарь.");
            System.out.println("2.Получить слово по ключу.");
            System.out.println("3.Удалить слово по ключу.");
            System.out.println("4.Вывести данные обоих словарей.");
            System.out.println("5.Выход.");
            int command = take_command_and_check(5);
            switch (command){
                //Добавление нового слова в словарь
                case 1-> {
                    System.out.println("В какой из словарей вы хотели бы добавить слово?");
                    System.out.println("1. Словарь интовый.");
                    System.out.println("2. Словарь латинский.");
                    System.out.println("3. Назад.");
                    command = take_command_and_check(3);
                    switch (command){
                        // если пользователь вводит циферное слово, длинной 5 символов
                        case 1->{
                            System.out.println("Введите слово в формате числа. Допустимая длина 5 символов.");
                            String wordKey = inLine();
                            while(!isDigit(wordKey) || !isInt5(wordKey)){
                                System.out.println("Слово не является числом или имеет длинну 5 символов. " +
                                        "Пожалуйста, введите интовое значение длинной 5 символов");
                                wordKey = inLine();
                            }
                            System.out.println("Ваше слово: " + wordKey + ". Введите его значение на русском языке:");
                            String word = inLine();
                            while (!isRuWord(word)){
                                System.out.println("Слово не является русским словом! " +
                                        "Пожалуйста, введите слово, содержащее только символы кириллицы!");
                                word = inLine();
                            }
                            dictionary.putdictionaryInt(wordKey, word);
                        }
                        //действия, если пользователь вводит латинское слово, длинной 4 символа
                        case 2->{
                            System.out.println("Введите латинское слово длинной 4.");
                            String wordKey = inLine();
                            while(!isLatinWord(wordKey) || wordKey.length() != 4){
                                System.out.println("Слово не является латинским или имеет длинну 4 символа. " +
                                        "Пожалуйста, введите латинское слово длинной 4");
                                wordKey = inLine();
                            }
                            System.out.println("Ваше слово " + wordKey + ". Введите его значение на русском языке:");
                            String word = inLine();
                            while (!isRuWord(word)){
                                System.out.println("Слово не является русским словом! " +
                                        "Пожалуйста, введите слово, содержащее только символы кириллицы!");
                                word = inLine();
                            }
                            dictionary.putdictionaryStr(wordKey, word);
                        }
                        case 3-> {
                            break;
                        }
                    }
                }
                //Получение слова по ключу (Если оно есть)
                case 2 ->{
                    System.out.println("В каком из словарей вы бы хотели найти слово?");
                    System.out.println("1. Словарь интовый.");
                    System.out.println("2. Словарь латинский.");
                    System.out.println("3. Назад.");
                    command = take_command_and_check(3);
                    switch (command){
                        // если пользователь вводит циферное слово, длинной 5 символов
                        case 1->{
                            System.out.println("Введите слово в инте.");
                            String wordKey = inLine();
                            while(!isDigit(wordKey) || !isInt5(wordKey)){
                                System.out.println("Слово не является числом или имеет длинну 5 символов. " +
                                        "Пожалуйста, введите интовое значение длинной 5 символов");
                                wordKey = inLine();
                            }
                            String dWord = dictionary.getDictionary(Integer.parseInt(wordKey));
                            if (dWord != null)
                                System.out.println("Ваше слово: " + dWord);
                            else
                                System.out.println("Слово с таким ключем не найдено!\n");


                        }
                        //действия, если пользователь вводит латинское слово, длинной 4 символа
                        case 2->{
                            System.out.println("Введите латинское слово длинной 4.");
                            String wordKey = inLine();
                            while(!isLatinWord(wordKey) || wordKey.length() != 4){
                                System.out.println("Слово не является латинским или имеет длинну 4 символа. " +
                                        "Пожалуйста, введите латинское слово длинной 4");
                                wordKey = inLine();
                            }
                            String dWord = dictionary.getDictionary(wordKey);
                            if (dWord != null)
                                System.out.println("Ваше слово :" +dWord);
                            else
                                System.out.println("Слово с таким ключем не найдено!\n");
                        }
                        case 3-> {
                            break;
                        }
                    }

                }
                //Удаление слова по ключу
                case 3 -> {
                    System.out.println("Из какого словаря вы бы хотели удалить слово?");
                    System.out.println("1. Словарь интовый.");
                    System.out.println("2. Словарь латинский.");
                    System.out.println("3. Назад");
                    command = take_command_and_check(3);
                    switch (command) {

                        //Удаление слова из интового словаря
                        case 1->{
                            System.out.println("Введите слово в формате числа. Допустимая длина 5 символов.");
                            String wordKey = inLine();
                            while(!isDigit(wordKey) || !isInt5(wordKey)){
                                System.out.println("Слово не является числом или имеет длинну 5 символов. " +
                                        "Пожалуйста, введите интовое значение длинной 5 символов");
                                wordKey = inLine();
                            }
                            String wordRu = dictionary.getDictionary(wordKey);
                            if (dictionary.removeWordDictionary(Integer.parseInt(wordKey)))
                                System.out.println("Слово : " + wordKey + "с значением : " + wordRu + "Удалено.");
                            else
                                System.out.println("Слова с кодом : " + wordKey + "не найдено.");
                        }

                        //Удаления слова из латинского словаря
                        case 2 -> {
                            System.out.println("Введите латинское слово длинной 4.");
                            String wordKey = inLine();
                            while(!isLatinWord(wordKey) || wordKey.length() != 4){
                                System.out.println("Слово не является латинским или имеет длинну 4 символа. " +
                                        "Пожалуйста, введите латинское слово длинной 4");
                                wordKey = inLine();
                            }
                            String wordRu = dictionary.getDictionary(wordKey);
                            if (dictionary.removeWordDictionary(wordKey))
                                System.out.println("Слово : " + wordKey + "с значением : " + wordRu + "Удалено.");
                            else
                                System.out.println("Слова с кодом : " + wordKey + "не найдено.");
                        }
                        case 3-> {
                            break;
                        }
                    }


                }
                //Получение всех слов определенного словаря
                case 4 ->{
                    System.out.println("Какой из словарей вы бы хотели вывести?");
                    System.out.println("1. Словарь интовый.");
                    System.out.println("2. Словарь латинский.");
                    System.out.println("3. Назад");
                    command = take_command_and_check(3);
                    switch (command) {
                        //Получение всех слов Интового словаря
                        case 1 -> {
                            System.out.println("Интовый словарь:");
                            for (Map.Entry<Integer, String> entry : dictionary.dictionaryInt.entrySet()) {
                                System.out.println("Код =  " + entry.getKey() + " Значение = " + entry.getValue());
                            }
                            System.out.println();
                        }
                        //Получение всех слов латинского словаря
                        case 2 -> {
                            System.out.println("Латинский словарь");
                            for (Map.Entry<String, String> entry : dictionary.dictionaryStr.entrySet()) {
                            System.out.println("Код =  " + entry.getKey() + " Значение = " + entry.getValue());
                            }
                            System.out.println();
                        }
                        case 3-> {
                            break;
                        }
                    }


                }
                //Выход из программы
                case 5 ->{
                    System.out.println("Завершение программы.");
                    return;
                }
            }
        }
    }


    public static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInt5(String s) {
        int r = Integer.parseInt(s);
        if (r > 9999 && r < 100000)
            return true;
        else return false;
    }

    public static boolean isRuWord( String s){

        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя ";
        for(int i = 0; i < s.length(); i++) {
            if(abc.indexOf(Character.toLowerCase(s.charAt(i))) ==-1)
                return false;
        }
        return true;
    }

    //Проверка слова на то, все ли символы латинские.
    public static boolean isLatinWord(String s){
        String abc = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i < s.length(); i++) {
            if(abc.indexOf(Character.toLowerCase(s.charAt(i))) ==-1)
                return false;
        }
        return true;
    }

    //приём команд от пользователя
    public static byte  take_command_and_check(int commands){
        byte command;
        String input_command_string = inLine();
        while (true){
            if (isDigit(input_command_string)){
                command = Byte.parseByte(input_command_string);
                if (command >0 && command <= commands){
                    return command;
                }
                else {
                    System.out.println("Число не является командой. Допустимы номера команд от 1 до " + commands);
                    input_command_string = inLine();
                }
            }
            else {
                System.out.println("Принимаются только числовые значения команд от 1 до " + commands);
                input_command_string = inLine();
            }

        }
    }

    public static String inLine(){

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            return sc.nextLine();
        }
        return "111111111111111111111111111111111";
    }


    public static void putDictionaryInt(){

    }




}