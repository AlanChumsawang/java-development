package com.pluralsight.finacialcalculator;

import java.util.Scanner;

public class AnnuityCalculator {
    double presentValue;
    double totalNumberOfPayments;
    double interestRate;
    double monthlyPayment;
    Scanner scanner = new Scanner(System.in);

    public void findPresentValue() {
        double monthlyInterestRate = interestRate / 12;
        for (int i = 1; i <= totalNumberOfPayments; i++) {
            presentValue += monthlyPayment / Math.pow(1 + monthlyInterestRate, i);
            System.out.println(presentValue);
        }
    }

    public void findMonthlyPayment() {
        double monthlyInterestRate = interestRate / 12;
        monthlyPayment = (presentValue * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -totalNumberOfPayments));
    }

    public void findTotalNumberOfPayments() {
        double monthlyInterestRate = interestRate / 12;
        totalNumberOfPayments = -Math.log(1 - (presentValue * monthlyInterestRate) / monthlyPayment) / Math.log(1 + monthlyInterestRate);
    }

    public void calculatorInterface(int desiredValue) {
        if (desiredValue == 1) {
            System.out.println("Enter Monthly Payment: ");
            monthlyPayment = scanner.nextDouble();
            System.out.println("Enter Total Number of Payments: ");
            totalNumberOfPayments = scanner.nextDouble();
            System.out.println("Enter Annual Interest Rate: ");
            interestRate = scanner.nextDouble() / 100;
            findPresentValue();
            System.out.println("Present Value: " + presentValue);
        } else if (desiredValue == 2) {
            System.out.println("Enter Present Value: ");
            presentValue = scanner.nextDouble();
            System.out.println("Enter Total Number of Payments: ");
            totalNumberOfPayments = scanner.nextDouble();
            System.out.println("Enter Interest Rate: ");
            interestRate = scanner.nextDouble() /100;
            findMonthlyPayment();
            System.out.println("Monthly Payment: " + monthlyPayment);
        } else if (desiredValue == 3) {
            System.out.println("Enter Present Value: ");
            presentValue = scanner.nextDouble();
            System.out.println("Enter Monthly Payment: ");
            monthlyPayment = scanner.nextDouble();
            System.out.println("Enter Interest Rate: ");
            interestRate = scanner.nextDouble() / 100;
            findTotalNumberOfPayments();
            System.out.println("Total Number of Payments: " + totalNumberOfPayments);
        } else {
            System.out.println("Invalid input");
        }
    }

    public static void main(String[] args) {
        AnnuityCalculator calculator = new AnnuityCalculator();
        System.out.println("Enter 1 to calculate the present value\nEnter 2 to calculate the monthly payment\nEnter 3 to calculate the total number of payments");
        int userInput = calculator.scanner.nextInt();
        calculator.calculatorInterface(userInput);
    }
}
