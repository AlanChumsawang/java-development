package com.pluralsight.finacialcalculator;

import java.util.Scanner;

public class FinancialCalculator {

    //Method to access the annuity calculator
    public void annuityCalculator(Scanner scanner) {
        double presentValue = 0;
        int totalNumberOfPayments = 0;
        double interestRate;
        double monthlyPayment = 0;
        double monthlyInterestRate;

        boolean isDone = false;
        while (!isDone) {
            System.out.println("Enter 1 to calculate the present value\nEnter 2 to calculate the monthly payment\nEnter 3 to calculate the total number of payments");
            int userInput = scanner.nextInt();

            String getPresentValue = "Enter Present Value: ";
            String getMonthlyPayment = "Enter Monthly Payment: ";
            String getTotalNumberOfPayments = "Enter Total Number of Payments: ";
            String getInterestRate = "Enter Annual Interest Rate: ";

            System.out.println(getInterestRate);
            interestRate = scanner.nextDouble() / 100;
            monthlyInterestRate = interestRate / 12;

            if (userInput == 1) {
                System.out.println(getMonthlyPayment);
                monthlyPayment = scanner.nextDouble();
                System.out.println(getTotalNumberOfPayments);
                totalNumberOfPayments = scanner.nextInt();
                presentValue = 0;
                for (int i = 1; i <= totalNumberOfPayments; i++) {
                    presentValue += monthlyPayment / (Math.pow(1 + monthlyInterestRate, i));
                }
                System.out.printf("Present Value: %.2f\n", presentValue);

            } else if (userInput == 2) {
                System.out.println(getPresentValue);
                presentValue = scanner.nextDouble();
                System.out.println(getTotalNumberOfPayments);
                totalNumberOfPayments = scanner.nextInt();
                monthlyPayment = (presentValue * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -totalNumberOfPayments));
                System.out.printf("Monthly Payment: %.2f\n", monthlyPayment);

            } else if (userInput == 3) {
                System.out.println(getPresentValue);
                presentValue = scanner.nextDouble();
                System.out.println(getMonthlyPayment);
                monthlyPayment = scanner.nextFloat();
                totalNumberOfPayments = (int) (-Math.log(1 - (presentValue * monthlyInterestRate) / monthlyPayment) / Math.log(1 + monthlyInterestRate));
                System.out.println("Total Number of Payments: " + totalNumberOfPayments);

            } else {
                System.out.println("Invalid input");
            }

            System.out.println("More Calculations? Y/N");
            char answer = scanner.next().charAt(0);
            if (answer == 'N' || answer == 'n') {
                isDone = true;
            }
        }
    }

    //Method to access the cd calculator
    public void cdCalculator(Scanner scanner) {
        double deposit;
        double interestRate;
        int years;
        double futureValue;
        double totalInterest = 0;
        double currentBalance;

        System.out.println("Enter the initial investment: ");
        deposit = scanner.nextDouble();
        currentBalance = deposit;

        System.out.println("Enter the interest rate: ");
        interestRate = scanner.nextDouble();

        System.out.println("Enter the CD length in years: ");
        years = scanner.nextInt();

        for (int i = 1; i <= years; i++) {
            totalInterest += currentBalance * (interestRate / 100);
            currentBalance += currentBalance * (interestRate / 100);
        }
        futureValue = deposit + totalInterest;

        System.out.println("Future Value: " + futureValue);
        System.out.println("Total Interest: " + totalInterest);
    }

    //Method to access the mortgage calculator
    public void mortgageCalculator(Scanner scanner) {
        double principal;
        double interestRate;
        int loanLength;
        double monthlyPayment;
        double totalInterest = 0;
        double amountRemaining;

        System.out.println("Enter Desired Loan Amount: ");
        principal = scanner.nextDouble();
        System.out.println("Enter Annual Interest Rate: ");
        interestRate = scanner.nextDouble() / 100;
        System.out.println("Enter Desired Loan Length: ");
        loanLength = scanner.nextInt();

        double monthlyInterestRate = interestRate / 12;
        int totalNumberOfPayments = loanLength * 12;
        monthlyPayment = (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalNumberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, totalNumberOfPayments) - 1);
        amountRemaining = principal;

        for (int i = 1; i < totalNumberOfPayments; i++) {
            double interest = amountRemaining * monthlyInterestRate;
            totalInterest += interest;
            amountRemaining = amountRemaining - (monthlyPayment - interest);
        }

        System.out.println("Monthly payment: " + monthlyPayment);
        System.out.println("Total Interest: " + totalInterest);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FinancialCalculator calculator = new FinancialCalculator();



        boolean isFinished = false;
        while (!isFinished) {
            System.out.println("Choose a calculator:\n1: Annuity Calculator\n2: CD Calculator\n3: Loan Calculator");
            int calculatorType = scanner.nextInt();

            while (calculatorType < 1 || calculatorType > 3) {
                System.out.println("Invalid input. Please choose a valid calculator:\n1: Annuity Calculator\n" +
                        "2: CD Calculator\n3: Loan Calculator");
                calculatorType = scanner.nextInt();
            }
            if (calculatorType == 1) {
                calculator.annuityCalculator(scanner);
            } else if (calculatorType == 2) {
                calculator.cdCalculator(scanner);
            } else {
                calculator.mortgageCalculator(scanner);
            }

            System.out.println("Continue calculating? Y/N");
            char answer = scanner.next().charAt(0);
            if (answer == 'N' || answer == 'n') {
                isFinished = true;
            }

        }
    }
}