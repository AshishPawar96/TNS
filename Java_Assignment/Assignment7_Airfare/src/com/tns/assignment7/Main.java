package com.tns.assignment7;

public class Main {

    public static void main(String[] args) {

        AirIndia airIndia = new AirIndia(1000);

        KingFisher kingFisher = new KingFisher(1000);

        Indigo indigo = new Indigo(1000);

        System.out.printf("AirIndia Fare : %.2f%n",
                airIndia.calculateAmount());

        System.out.printf("KingFisher Fare : %.2f%n",
                kingFisher.calculateAmount());

        System.out.printf("Indigo Fare : %.2f%n",
                indigo.calculateAmount());
    }
}