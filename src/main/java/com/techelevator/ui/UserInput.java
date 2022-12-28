package com.techelevator.ui;

import com.techelevator.models.FeedMoney;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput
{
    private Scanner scanner = new Scanner(System.in);


    public String getHomeScreenOption()
    {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Machine Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if (option.equals("D"))
        {
            return "display";
        }
        else if (option.equals("P"))
        {
            return "purchase";

        }
        else if (option.equals("E"))
        {
            return "exit";
        }
        else
        {
            return "";
        }

    }
    public String HomeScreenMenu() {
        System.out.println("(M) Feed Money");
        System.out.println("(S) Select Item");
        System.out.println("(F) Finish Transaction");
        System.out.println();
        System.out.println("Please select an option: ");
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if (option.equals("M")) {
            return "feed money";
        } else if (option.equals("S")) {
            return "select";
        } else if (option.equals("F")) {
            return "finish transaction";
        } else {
            return "";
        }
    }

    // create method to ask user to feed money!
    public double askFeedMoney(){
        System.out.println("put your money into Vending machine: ");
        double money = Double.parseDouble(scanner.nextLine());
        return money;
    }

    public String askCustomerForItem(){
        System.out.println("Which item do you want to buy?");
        String choice = scanner.nextLine();
        return choice;
    }
    
}
