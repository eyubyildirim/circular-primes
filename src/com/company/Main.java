package com.company;

import java.util.ArrayList;

public class Main {

    // 17 -> 71
    public static void main(String[] args) {
        ArrayList<Integer> asallar = sieveOfE(1000000);
        ArrayList<Integer> cemberselAsallar = new ArrayList<>();

        for (Integer asal : asallar) {
            String sSayi = String.valueOf(asal);
            int sayininUzunlugu = sSayi.length();
            boolean cemberselAsalMi = true;

            for (int i = 0; i < sayininUzunlugu - 1; i++){
                asal = sayiyiDondur(asal);
                if (!asallar.contains(asal)){
                    cemberselAsalMi = false;
                    break;
                }
            }

            if (cemberselAsalMi)
                cemberselAsallar.add(sayiyiDondur(asal));
        }

        cemberselAsallar.forEach(System.out::println);
    }

    // 352
    public static int sayiyiDondur(int sayi){
        String sSayi = String.valueOf(sayi);
        int sayininUzunlugu = sSayi.length(); // 3
        int sonRakam = sayi % 10; // 352 % 10 = 2
        int digerRakamlar = sayi / 10; // (int) 352 / 10 = 35

        return (int) ((sonRakam * (Math.pow(10, sayininUzunlugu - 1))) + digerRakamlar); // 2 * (10 ^ 2) + 35 = 235
    }

    public static ArrayList<Integer> sieveOfE(int sinir) {
        boolean[] asalSayilar = new boolean[sinir + 1];
        for (int i = 2; i <= sinir; i++) {
            asalSayilar[i] = true;
        }

        for (int carpan = 2; carpan * carpan <= sinir; carpan++) {
            if (asalSayilar[carpan]){
                for (int j = carpan; carpan * j <= sinir; j++){
                    asalSayilar[carpan * j] = false;
                }
            }
        }

        ArrayList<Integer> asallar = new ArrayList<>();
        for (int i = 2; i <= sinir; i++){
            if (asalSayilar[i]){
                asallar.add(i);
            }
        }

        return asallar;
    }
}
