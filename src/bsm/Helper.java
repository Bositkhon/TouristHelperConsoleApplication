package bsm;

import java.util.Scanner;

public class Helper {

    private double balance;
    private int days;

    private Hotels hotels;
    private Entertainments entertainments;

    Helper(){
        this.set(0); // balance set equals 0
        this.hotels = new Hotels();
        this.entertainments = new Entertainments();
    }

    void run(){

        Scanner sc = new Scanner(System.in);
        int selection, days = 0, eligibleHotelID = 0;
        String goOn;
        double cost, price = 0;
        boolean retry = true;

        System.out.println("Welcome to our application!");
        System.out.println("Please, enter your budget");
        double balance = sc.nextDouble();
        this.set(balance);
        System.out.println("Your current balance is $" + this.getBalance());


        System.out.println("======================================");
        System.out.println("        Hotel program selection       ");
        System.out.println("======================================");


        while(retry){

            while(retry){
                System.out.println("How much money would you like to spend on a Standart Single Room per night in a hotel? Minimum $20");
                System.out.println("For your information: breakfast and dinner are included in the price");
                cost = sc.nextDouble();
                eligibleHotelID = this.hotels.getEligibleHotelID(cost);
                if(eligibleHotelID == 0){
                    System.out.println("Seemingly there is no eligible hotel that satisfies your preferences");
                    System.out.println("Please try again");
                }else{
                    this.showEligibleHotels(cost);
                    retry = false;
                }
            }

            retry = true;
            while(retry){
                System.out.println("Please select an eligible hotel:");
                selection = sc.nextInt();
                if(selection == eligibleHotelID + 1){
                    price = this.hotels.getPrice(selection - 1);
                    retry = false;
                }else{
                    System.out.println("Seemingly you have inputted wrong number!");
                    System.out.println("Please try again");
                    retry = true;
                }
            }

            retry = true;
            while (retry){
                System.out.println("How many days are you planning to stay in this hotel?");
                days = sc.nextInt();
                if(days > 0){
                    this.set(days);
                    retry = false;
                }else{
                    System.out.println("Seemingly you have inputted wrong number!");
                    System.out.println("Please try again");
                    retry = true;
                }
            }

            double expenditure = price * days;
            System.out.println("You are going to spend $" + expenditure);
            if(this.getBalance() > expenditure){
                System.out.println("Your spendings for room reservation for this number of days are" + "$" + expenditure);
                this.subtractFromBalance(expenditure);
                retry = false;
            }else{
                System.out.println("Seemingly, the amount of money you have in your balance is not enough to proceed this purchase.");
                System.out.println("We kindly ask you either to have more money in your balance or change your preferences =)");
            }
        }
        System.out.println("Your current balance is $" + this.getBalance());

        retry = true;

        while(retry){
            System.out.println("Type anything to continue...");
            goOn = sc.next();
            retry = false;
        }

        System.out.println("======================================");
        System.out.println("   Entertainment program selection    ");
        System.out.println("======================================");

        System.out.println("This is the list of place where you can go:");
        this.showEntertainmentsList();
        System.out.println("0. Stop choosing");

        double entertainmentExpenditures = 0;
        retry = true;
        while(retry){
            System.out.println("Please choose as much entertainment places as you want");
            System.out.println("The program will let you know as soon as your balance become negative");
            selection = sc.nextInt();
            if(selection >= 1 && selection <= this.entertainments.TOTAL_SIGHT_QUANTITY){
                if(this.getBalance() > this.entertainments.getPrice(selection - 1)){
                    this.subtractFromBalance(this.entertainments.getPrice(selection - 1));
                    entertainmentExpenditures += this.entertainments.getPrice(selection - 1);
                    this.showEntertainmentInfo(selection - 1);
                }else if(this.getBalance() == 0){
                    System.out.println("Unfortunately, there is no money left in your balance");
                    retry = false;
                }else{
                    System.out.println("Seemingly, the amount of money you have in your balance is not enough to proceed this purchase.");
                    System.out.println("We kindly ask you either to have more money in your balance or change your preferences =)");
                    retry = false;
                }
            }else if(selection == 0){
                retry = false;
            }else{
                System.out.println("Seemingly you have inputted wrong number!");
                System.out.println("Please try again");
            }
        }

        System.out.println("Your spendings for entertainment are likely to amount for $" + entertainmentExpenditures);

        System.out.println("Your current balance is $" + this.getBalance());

        if(this.getBalance() > 0){
            System.out.println("The left amount of the money in your balance you can spend on lunch, trasportation, gifts and so on");
            System.out.println("================================================================");
            System.out.println("One ordinary lunch costs on average 20$");
            System.out.println("This is the average cost of lunch whether you buy some products in a supermarket or buy fast food");
            System.out.println("================================================================");
            System.out.println("Approximate prices for 3 types of transportation in Tashkent:");
            System.out.println("1. TAXI - $0.4/KM");
            System.out.println("2. Metro - $0.2/TICKET");
            System.out.println("1. BUS - $0.2/TICKET");
            System.out.println("================================================================");
        }else{
            System.out.println("Unfortunately, you have $0 in your balance");
        }

        System.out.println("THANK YOU! Hope our program was useful!");

    }

    public void set(double balance){
        this.balance = balance;
    }

    public void set(int days){
        this.days = days;
    }

    public double getBalance() {
        return balance;
    }

    public void subtractFromBalance(double money){
        this.balance -= money;
    }

    public void showEligibleHotels(double cost){
        for(int i = 0; i < this.hotels.quantity(); i++){
            if(cost >= this.hotels.getMinPrice(i) && cost <= this.hotels.getMaxPrice(i)){
                System.out.println((i+1) + ". " + this.hotels.getName(i));
            }
        }
    }

    public void showEntertainmentsList(){
        System.out.println("Museums, Theatres and Sights");
        int l1 = this.entertainments.MUSEUMS_QUANTITY,
            l2 = this.entertainments.RELIGIOUS_SIGHTS_QUANTITY,
            l3 = this.entertainments.PARKS_QUANTITY;
        for(int i = 0; i < l1; i++){
            System.out.println((i + 1) + ". " + this.entertainments.getName(i));
            System.out.println("    Address: " + this.entertainments.getName(i));
            if(this.entertainments.getPrice(i) != 0.0){
                System.out.println("    Price: $" + this.entertainments.getPrice(i));
            }else{
                System.out.println("    Price: Free of charge");
            }
        }
        for (int i = l1; i < l1 + l2; i++){
            System.out.println((i + 1) + ". " + this.entertainments.getName(i));
            System.out.println("    Address: " + this.entertainments.getAddress(i));
            if(this.entertainments.getPrice(i) != 0.0){
                System.out.println("    Price: $" + this.entertainments.getPrice(i));
            }else{
                System.out.println("    Price: Free of charge");
            }
        }
        for(int i = l1 + l2; i < l1 + l2 + l3; i++){
            System.out.println((i + 1) + ". " + this.entertainments.getName(i));
            System.out.println("    Address: " + this.entertainments.getAddress(i));
            if(this.entertainments.getPrice(i) != 0.0){
                System.out.println("    Price: $" + this.entertainments.getPrice(i));
            }else{
                System.out.println("    Price: Free of charge");
            }
        }
    }

    public void showEntertainmentInfo(int entertainmentID){
        System.out.println((entertainmentID + 1) + ". " + this.entertainments.getName(entertainmentID));
        System.out.println("    Address: " + this.entertainments.getAddress(entertainmentID));
        if(this.entertainments.getPrice(entertainmentID) != 0.0){
            System.out.println("    Price: $" + this.entertainments.getPrice(entertainmentID));
        }else{
            System.out.println("    Price: Free of charge");
        }
    }


}
