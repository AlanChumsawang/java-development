package com.pluralsight.finacialcalculator;

import java.util.Scanner;

public class CdCalculator {
    double deposit;
    double interestRate;
    int years;
    double futureValue;
    double totalInterest;
    double currentBalance;

    public  void findFutureValue() {
        for (int i = 1; i <= years; i++) {
            totalInterest += currentBalance * (interestRate / 100);
            currentBalance += currentBalance * (interestRate / 100);
        }
        futureValue = deposit + totalInterest;


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CdCalculator calculator = new CdCalculator();

        System.out.println("Enter the initial investment: ");
        calculator.deposit = scanner.nextDouble();
        calculator.currentBalance = calculator.deposit;

        System.out.println("Enter the interest rate: ");
        calculator.interestRate = scanner.nextDouble();

        System.out.println("Enter the CD length in years: ");
        calculator.years = scanner.nextInt();

        calculator.findFutureValue();
        System.out.println("Future Value: " + calculator.futureValue);
        System.out.println("Total Interest: " + calculator.totalInterest);
    }
    }
