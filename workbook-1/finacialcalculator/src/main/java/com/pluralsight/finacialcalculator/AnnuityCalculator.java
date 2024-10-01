package com.pluralsight.finacialcalculator;

import java.util.Scanner;

public class AnnuityCalculator {
    double presentValue;
    double totalNumberOfPayments;
    double interestRate;
    double monthlyPayment;
    double monthlyInterestRate;

    public AnnuityCalculator(double interestRate) {
        this.interestRate = interestRate;
        this.monthlyInterestRate = interestRate / 12;
    }

    public void findPresentValue() {
        for (int i = 1; i <= totalNumberOfPayments; i++) {
            presentValue += monthlyPayment / (Math.pow(1 + monthlyInterestRate, i));
        }
    }

    public void findMonthlyPayment() {
        monthlyPayment = (presentValue * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -totalNumberOfPayments));
    }

    public void findTotalNumberOfPayments() {
        totalNumberOfPayments = -Math.log(1 - (presentValue * monthlyInterestRate) / monthlyPayment) / Math.log(1 + monthlyInterestRate);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1 to calculate the present value\nEnter 2 to calculate the monthly payment\nEnter 3 to calculate the total number of payments");
        int userInput = scanner.nextInt();

        String getPresentValue = "Enter Present Value: ";
        String getMonthlyPayment = "Enter Monthly Payment: ";
        String getTotalNumberOfPayments = "Enter Total Number of Payments: ";
        String getInterestRate = "Enter Annual Interest Rate: ";

        System.out.println(getInterestRate);
        double interestRate = scanner.nextDouble() / 100;
        AnnuityCalculator calculator = new AnnuityCalculator(interestRate);



        if (userInput == 1) {
            System.out.println(getMonthlyPayment);
            calculator.monthlyPayment = scanner.nextDouble();
            System.out.println(getTotalNumberOfPayments);
            calculator.totalNumberOfPayments = scanner.nextDouble();
            calculator.findPresentValue();
            System.out.println("Present Value: " + calculator.presentValue);


        } else if (userInput == 2) {
            System.out.println(getPresentValue);
            calculator.presentValue = scanner.nextDouble();
            System.out.println(getTotalNumberOfPayments);
            calculator.totalNumberOfPayments = scanner.nextDouble();
            calculator.findMonthlyPayment();
            System.out.println("Monthly Payment: " + calculator.monthlyPayment);

        } else if (userInput == 3) {
            System.out.println(getPresentValue);
            calculator.presentValue = scanner.nextDouble();
            System.out.println(getMonthlyPayment);
            calculator.monthlyPayment = scanner.nextDouble();
            calculator.findTotalNumberOfPayments();
            System.out.println("Total Number of Payments: " + calculator.totalNumberOfPayments);

        } else {
            System.out.println("Invalid input");
        }

        scanner.close();
    }
}