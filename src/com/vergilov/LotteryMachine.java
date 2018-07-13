package com.vergilov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LotteryMachine {
    private List<Integer> lotteryMachineNumber;

    public LotteryMachine() {
        this.lotteryMachineNumber = new ArrayList<>();
    }

    private int[] numbersInMachine() {
        int[] numbers = new int[47];
        for (int i = 1; i <= 46; i++) {
            numbers[i] = i;
        }
        return numbers;
    }


    private List<Integer> drawOfNumbers() {
        Random generator = new Random();
        int[] numbers = numbersInMachine();
        int count = 0;

        while (count != 6) {
            int numberLottery = generator.nextInt(45) + 1;
            for (int j = 0; j < numbers.length; j++) {
                if (numberLottery == numbers[j] && numbers[j] != 0) {
                    numbers[j] = 0;
                    this.lotteryMachineNumber.add(j);
                    count++;
                }
            }
        }
        return this.lotteryMachineNumber;
    }


    public void drawing(List<Integer> luckyNumbers) {
        int howMany = 0;
        List<Integer> bebop = drawOfNumbers();
        Collections.sort(bebop);
        System.out.println("\"LOTTERY NUMBERS\": " + bebop);

        Collections.sort(luckyNumbers);
        System.out.println("\"YOU NUMBERS\":     " + luckyNumbers);

        for (int x : luckyNumbers) {
            for (int y : bebop) {
                if (x == y) {
                    howMany++;
                    System.out.println("You have a Number: " + x);
                }
            }
        }
        System.out.println("Got " + howMany + " Hit");
    }
}
