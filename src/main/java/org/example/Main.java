package org.example;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
//    public static void main(String[] args) {
//        //System.out.println("Словарь");
//        test.test();
//    }


    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.putDictionary(111, "test");
        dictionary.putDictionary(112, "tes1");
        dictionary.putDictionary(115, "test2");
        //String test =dictionary.getDictionary(299);
        //System.out.println(test);


        System.out.println("Программа словарей!");
        while (true){
            System.out.println("Выберите действие:");
            System.out.println("1.Добавить слово в словарь.");
            System.out.println("2.Получить слово по ключу.");
            System.out.println("3.Удалить слово по ключу.");
            System.out.println("4.Выход.");
            int command = take_command_and_check(4);
            switch (command){
                case 1-> {
                    System.out.println("В какой из словарей вы хотели бы добавить слово?");
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
                            System.out.println("Ваше слово" + wordKey + ". Введите его значение на русском языке:");
                            String word = inLine();
                            while (!isRuWord(word)){
                                System.out.println("Слово не является русским словом! " +
                                        "Пожалуйста, введите слово, содержащее только символы кириллицы!");
                                word = inLine();
                            }
                            dictionary.putDictionary(Integer.parseInt(wordKey), word);
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
                            System.out.println("Ваше слово" + wordKey + ". Введите его значение на русском языке:");
                            String word = inLine();
                            while (!isRuWord(word)){
                                System.out.println("Слово не является русским словом! " +
                                        "Пожалуйста, введите слово, содержащее только символы кириллицы!");
                                word = inLine();
                            }
                            dictionary.putDictionary(wordKey, word);
                        }
                        case 3-> {
                            return;
                        }
                    }
                }


                case 4 ->{
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

        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        for(int i = 0; i < s.length(); i++) {
            if(abc.indexOf(Character.toLowerCase(s.charAt(i))) ==-1)
                return false;
        }
        return true;
    }

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