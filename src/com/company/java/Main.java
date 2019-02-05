package com.company.java;

import java.util.Random;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    Random rand = new Random();

    System.out.println("WELCOME! Let's play some Roulette!");

    Boolean quit = true;
    double totalScore = 0;
    int winCont = 0, loseCont = 0;
    while (quit) {

      // Getting random color
      int colorRand = rand.nextInt(2) + 1;
      String color = "";
      if(colorRand ==1){
        color = "red";
      }else{
        color = "black";
      }

      System.out.print("Enter the type of bet you would like to place " +
              "(red|black|even|odd|high|low): ");
      String bet = input.nextLine();
      System.out.print("Enter in your bet amount: ");
      double amount = input.nextDouble();

      int num = rand.nextInt(36) + 1;
      System.out.println("The ball landed on " + num + " " +  color + ".");

      if ((num % 2 == 0) && (bet.equalsIgnoreCase("even"))) {
        System.out.println("Congratulations, you've won.");
        totalScore += amount * 2;
        winCont++;
      } else if (bet.equalsIgnoreCase("odd") && (num % 2 == 1)) {
        System.out.println("Congratulations, you've won.");
        totalScore += amount * 2;
        winCont++;
      } else if (bet.equalsIgnoreCase("low") && (num >= 1 && num <= 18)) {
        System.out.println("Congratulations, you've won.");
        totalScore += amount * 2;
        winCont++;
      } else if (bet.equalsIgnoreCase("high") && (num >= 19 && num <= 36)) {
        totalScore += amount * 2;
        System.out.println("Congratulations, you've won.");
        winCont++;
      } else if(bet.equalsIgnoreCase("red") && color.equals("red")){
        System.out.println("Congratulations, you've won.");
        totalScore += amount * 2;
        winCont++;
      }else if(bet.equalsIgnoreCase("black") && color.equals("black")) {
        System.out.println("Congratulations, you've won.");
        totalScore += amount * 2;
        winCont++;
      } else {
        System.out.println("Sorry, you've lost this bet.");
        totalScore = totalScore - amount;
        loseCont++;
      }

      System.out.println("You currently have: $" + totalScore );
      System.out.println();
      System.out.print("Would you like to play again (true|false)? ");
      quit = input.nextBoolean();
      input.nextLine();
      System.out.println();
    }

    System.out.println("Thank you for playing!");
    System.out.println("This is how much money you have remaining: $" + totalScore);
    System.out.println("You've won " + winCont + " game(s) and lost " +
            loseCont + " game (s).");
  }
}
