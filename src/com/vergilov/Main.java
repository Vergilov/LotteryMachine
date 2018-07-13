package com.vergilov;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Integer> luckyNumbers = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        LotteryMachine lotteryMachine = new LotteryMachine();
        giveNumbers();
        lotteryMachine.drawing(luckyNumbers);
    }

    private static void giveNumbers() {
        int countdown = 0;
        int action;
        while (countdown != 6) {
            System.out.print("Give a number");
            action = in.nextInt();
            if(!(isAlready(action)) && isInRange(action)){
                    luckyNumbers.add(action);
                    System.out.println("You added " + action);
                    countdown++;
            }
        }
    }

    private static boolean isAlready(int action){
        for (int i : luckyNumbers) {
            if (action == i) {
                System.out.println(action + " is already in coupon !");
                return true;
            }
        }
        return false;
    }

    private static boolean isInRange(int action){
        boolean isInRange=true;
        if(action < 1 || action > 46){
            System.out.println("Choose Between 1 and 46");
            isInRange=false;
        }
        return isInRange;
    }
}
