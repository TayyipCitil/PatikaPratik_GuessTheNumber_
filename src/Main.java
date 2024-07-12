import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner scr = new Scanner(System.in);
        int[] wrongGuesses = new int[3];// doğru aralıktaki yanlış tahminleri tutan bir dizi
        int num = rnd.nextInt(101);
        int right = 3; // tahmin hakkı
        int rangeRight = 2;//üst üste ikiden fazla kez yanlış aralıkta sayı girerse her yanlış aralık tahmini 1 tahmin hakkın azalsın
        System.out.println(num);

        System.out.print("Tahmin: ");
        int guessNum = scr.nextInt();
        while (right >= 0) {
            if (guessNum == num) { // doğru tahmin
                System.out.println("=====Bildiniz=====");
                break;
            } else { //yanlış tahmin
                if (right == 0) { // hakkın kalmadı
                    System.out.println("=====Kaybettiniz=====");
                    System.out.println("Sayı: " + num);
                    System.out.println("Tahminleriniz: " + Arrays.toString(wrongGuesses));
                    break;
                } else {// hala hakkın var
                    if (guessNum < 0 || guessNum > 100) { // tahmin yanlış aralıkta
                        switch (rangeRight) {
                            case 2:
                                System.out.println("Tahmininiz doğru aralıkta değil");
                                System.out.println("Kalan hak: "+right);
                                break;
                            case 1:
                                System.out.println("Tahmininiz yine doğru aralıkta değil");
                                System.out.println("Kalan hak: "+right);
                                break;
                            default:
                                System.out.println("Tahmininiz yine doğru aralıkta değil");
                                System.out.println("Kalan hak: "+right);
                                right--;
                                break;
                        }
                        rangeRight--;
                        System.out.print(" Yeni Tahmin: ");
                        guessNum = scr.nextInt();
                    } else { // tahmin doğru aralıkta ama yanlış
                        rangeRight = 2;
                        wrongGuesses[3 - right] = guessNum;
                        right--;
                        System.out.println("=====Bilemediniz=====");
                        System.out.println("Kalan hak: " + right);
                        System.out.print(" Yeni Tahmin: ");
                        guessNum = scr.nextInt();
                    }
                }
            }
        }
    }
}
