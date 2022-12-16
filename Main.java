import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap(7);
        Scanner input = new Scanner(System.in);
        System.out.println("Sayıları giriniz");

        String sayilar = input.nextLine();
        String[] virgul = sayilar.split(",");
        int[] dizi = new int[virgul.length];


        for (int i = 0; i < virgul.length; i++) {
            dizi[i] = Integer.parseInt(virgul[i]);
        }

       heap.print();

    }
}