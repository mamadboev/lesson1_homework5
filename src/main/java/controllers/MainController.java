package controllers;

import config.DbConfig;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        DbConfig dbConfig = new DbConfig();
        Scanner sc = new Scanner(System.in);
        System.out.println("Price uchun quyi qiymat kiring");
        double quyi = sc.nextDouble();
        System.out.println("Price uchun yuqori qiymat kiring");
        double yuqori = sc.nextDouble();
        System.out.println("\nNarxi "+quyi+" va "+yuqori+" orasida bo'lgan PC lar\n");
        dbConfig.getList("pc",quyi,yuqori);
        System.out.println("\nNarxi "+quyi+" va "+yuqori+" orasida bo'lgan Laptop lar\n");
        dbConfig.getList("laptop",quyi,yuqori);
        System.out.println("\nNarxi "+quyi+" va "+yuqori+" orasida bo'lgan Printer lar\n");
        dbConfig.getList("printer",quyi,yuqori);
    }
}
