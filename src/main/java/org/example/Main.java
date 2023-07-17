package org.example;


import java.util.Scanner;

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



        while (true){
            System.out.println("Программа словарей! Выберите действие:");
            System.out.println("1.Добавить слово в словарь.");
            System.out.println("2.Получить слово по ключу.");
            System.out.println("3.Удалить слово по ключу.");
            int command = take_command_and_check(3);
            switch (command){
                case 1-> {
                    System.out.println("Какое слово вы хотите добавить?");
                    dictionary.putDictionary(222,"ffdsf");
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





}