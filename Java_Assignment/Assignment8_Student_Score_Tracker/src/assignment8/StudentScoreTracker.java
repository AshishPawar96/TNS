package assignment8;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentScoreTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

      
        int n = sc.nextInt();
        
        ArrayList<Integer> scores = new ArrayList<>();

        
        for (int i = 0; i < n; i++) {
            scores.add(sc.nextInt());
        }

        System.out.println("Elements in the ArrayList");

        for (int score : scores) {
            System.out.println(score);
        }

        sc.close();
    }
}