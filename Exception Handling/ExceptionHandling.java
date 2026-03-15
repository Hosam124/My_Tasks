import customExceptions.UnderAgeException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class ExceptionHandling {
    static Scanner scanner = new Scanner(System.in);

    public static void  task_1(){
        try{
            int num1 = Integer.parseInt(scanner.nextLine().trim());
            int num2 = Integer.parseInt(scanner.nextLine().trim());
            int res = num1 / num2;
            System.out.println("result = " + res);
        }catch (ArithmeticException e){
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void task_2(){
        try{
            String strNumber = scanner.nextLine();
            int number = Integer.parseInt(strNumber);
            System.out.println("Number = " + number);
        }catch (NumberFormatException e){
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void task_3(String s){
        try {
            String upperS = s.toUpperCase();
            System.out.println(upperS);
        }catch (NullPointerException e){
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void task_4(){
        try {
            int[] arr = {1,2,3,4,5};
            int idx = Integer.parseInt(scanner.nextLine());
            System.out.println(arr[idx]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static void task_5() throws FileNotFoundException {
        FileReader fileReader = new FileReader("data.txt");
    }

    public static void  task_6(Integer num1 , Integer num2){
        try{
            int res = num1 / num2;
            System.out.println("result = " + res);
        }catch (ArithmeticException e){
            System.out.println(e);
        }catch (NullPointerException e){
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void task_7(int age){
        if (age<18){
            throw new UnderAgeException("You should be over 18");
        }
        System.out.println(age);
    }

    public static void stringSize(String s) throws NullPointerException{
        System.out.println(s.length());
    }
    public static void task_9() throws NullPointerException {
        System.out.println("String length :");
        stringSize(null);
    }

    public static void task_10() throws IOException {
        FileReader fileReader = new FileReader("data.txt");
    }

    public static void task_11(){
        try {
            int res =  5/0;
            System.out.println(res);
        }catch (ArithmeticException e){
            System.out.println(e);
        }finally {
            System.out.println("program end");
        }
    }

    public static void task_12(Integer n , Integer m){
        try {
            try {
                System.out.println(n/m);
            }catch (NullPointerException e){
                System.out.println(e);
            }
        }catch (ArithmeticException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args)  {
//        task_1();
//        task_2();
//        task_3(null);
//        task_4();
//        try {
//            task_5();
//        }catch (FileNotFoundException e){
//            System.out.println(e);
//        }catch (Exception e){
//            System.out.println(e);
//        }
//        task_6(5,null);
//        try {
//            task_7(5);
//        }catch (UnderAgeException e){
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            task_9();
//        }catch (NullPointerException e){
//            System.out.println(e);
//        }

//        try {
//            task_10();
//        } catch (IOException e) {
//            System.out.println(e);;
//        }
//        task_11();
//        task_12(5,0);

    }
}
