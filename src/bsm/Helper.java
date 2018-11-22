package bsm;

import java.util.Scanner;

public class Helper {

    private double balance;
    private int currentHotel;
    private int days;

    private int[] eligibleHotelsIDs;

    public void run(){

        Scanner sc = new Scanner(System.in);
        int selection, days = 0, total, eligibleHotelID = 0;
        String goOn;
        double cost, price = 0;
        boolean retry = true;

        Output.welcomeText();
        Output.askForBudgetInputText();
        double balance = sc.nextDouble();
        this.set(balance);
        Output.showCurrentBalanceText(this.balance);


        System.out.println("======================================");
        System.out.println("        Hotel program selection       ");
        System.out.println("======================================");


        while(retry){

            while(retry){
                Output.askForHotelSingleRoomText();
                cost = sc.nextDouble();
                eligibleHotelID = Hotels.getEligibleHotelID(cost);

                if(eligibleHotelID == 0){
                    System.out.println("Seemingly there no eligible hotel that satisfies your preferences");
                    System.out.println("Please try again");
                }else{
                    Output.showEligibleHotels(cost);
                    retry = false;
                }
            }

            Output.selectHotelText();

            retry = true;
            while(retry){
                selection = sc.nextInt();
                if(selection == eligibleHotelID + 1){
                    price = Hotels.getFixedPrice(selection - 1);
                    retry = false;
                }else{
                    Output.showOutOfRangeInputText();
                    retry = true;
                }
            }

            retry = true;
            while (retry){
                Output.askForHotelReserveTimeText();
                days = sc.nextInt();
                if(days > 0){
                    this.set(days);
                    retry = false;
                }else{
                    Output.showOutOfRangeInputText();
                    retry = true;
                }
            }
            Output.showPresentExpenditure(price * days);
            if(this.getBalance() > price * days){
                Output.showHotelReservationCostText(price * days);
                this.subtractFromBalance(price * days);
                retry = false;
            }else{
                Output.showNotEnoughBalanceText();
            }
        }
        Output.showCurrentBalanceText(this.getBalance());

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
        Output.showEntertainmentsList();
        System.out.println("0. Stop choosing");

        double entertainmentExpenditures = 0;
        retry = true;
        while(retry){
            System.out.println("Please choose as much entertainment places as you want");
            System.out.println("The program will let you know as soon as your balance become negative");
            selection = sc.nextInt();
            if(selection >= 1 && selection <= Entertainments.TOTAL_SIGHT_QUANTITY){
                if(this.getBalance() > Entertainments.entertainmentPrices[selection - 1]){
                    this.subtractFromBalance(Entertainments.entertainmentPrices[selection - 1]);
                    entertainmentExpenditures += Entertainments.entertainmentPrices[selection -1];
                    Output.showEntertainmentInfo(selection - 1);
                }else if(this.getBalance() == 0){
                    Output.showZeroBalanceText();
                    retry = false;
                }else{
                    Output.showNotEnoughBalanceText();
                    retry = false;
                }
            }else if(selection == 0){
                retry = false;
            }else{
                Output.showOutOfRangeInputText();
            }
        }

        System.out.println("Your spendings for entertainment are likely to amount for $" + entertainmentExpenditures);

        Output.showCurrentBalanceText(this.getBalance());

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
            Output.showZeroBalanceText();
        }

        System.out.println("THANK YOU! Hope our program was useful!");

    }

    public double getBalance() {
        return balance;
    }

    public void subtractFromBalance(double money){
        this.balance -= money;
    }


    public void set(double balance){
        this.balance = balance;
    }
    public void set(int days){
        this.days = days;
    }

}
