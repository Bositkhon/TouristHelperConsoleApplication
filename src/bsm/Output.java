package bsm;

public class Output {

    public static void welcomeText(){
        System.out.println("Welcome to our application!");
    }

    public static void askForBudgetInputText(){
        System.out.println("Please, enter your budget");
    }

    public static void askForHotelSingleRoomText(){
        System.out.println("How much money would you like to spend on a Standart Single Room per night in a hotel? Minimum $20");
        System.out.println("For your information: breakfast and dinner are included in the price");
    }

    public static void askForHotelReserveTimeText(){
        System.out.println("How many days are you planning to stay in this hotel?");
    }

    public static void showHotelReservationCostText(double cost){
        System.out.println("Your spendings for room reservation for this number of days are" + "$" + cost);
    }

    public static void showCurrentBalanceText(double balance){
        System.out.println("Your current balance is $" + balance);
    }

    public static void showPresentExpenditure(double expenditure){
        System.out.println("You are going to spend $" + expenditure);
    }

    /*public static void showHotelsList(){
        String[] hotels = Hotels.getHotels();

        for(int i  = 0; i < Hotels.getHotelsQuantity(); i++){
            System.out.println((i + 1) + ". " + hotels[i]);
        }
    }*/

    public static void selectHotelText(){
        System.out.println("Please select an eligible hotel:");
    }

    public static void showEligibleHotels(double cost){
        for(int i = 0; i < Hotels.getHotelsQuantity(); i++){
            if(cost >= Hotels.getMinPrice(i) && cost <= Hotels.getMaxPrice(i)){
                System.out.println((i+1) + ". " + Hotels.getHotelName(i));
            }
        }
    }

    public static void showNotEnoughBalanceText(){
        System.out.println("Seemingly, the amount of money you have in your balance is not enough to proceed this purchase.");
        System.out.println("We kindly ask you either to have more money in your balance or change your preferences =)");
    }

    public static void showEntertainmentsList(){
        System.out.println("Museums, Theatres and Sights");
        int l1 = Entertainments.MUSEUMS_QUANTITY, l2 = Entertainments.RELIGIOUS_SIGHTS_QUANTITY, l3 = Entertainments.PARKS_QUANTITY;
        for(int i = 0; i < l1; i++){
            System.out.println((i + 1) + ". " + Entertainments.getEntertainmentName(i));
            System.out.println("    Address: " + Entertainments.getEntertainmentAddress(i));
            if(Entertainments.getEntertainmentPrice(i) != 0.0){
                System.out.println("    Price: $" + Entertainments.getEntertainmentPrice(i));
            }else{
                System.out.println("    Price: Free of charge");
            }
        }
        for (int i = l1; i < l1 + l2; i++){
            System.out.println((i + 1) + ". " + Entertainments.getEntertainmentName(i));
            System.out.println("    Address: " + Entertainments.getEntertainmentAddress(i));
            if(Entertainments.getEntertainmentPrice(i) != 0.0){
                System.out.println("    Price: $" + Entertainments.getEntertainmentPrice(i));
            }else{
                System.out.println("    Price: Free of charge");
            }
        }
        for(int i = l1 + l2; i < l1 + l2 + l3; i++){
            System.out.println((i + 1) + ". " + Entertainments.getEntertainmentName(i));
            System.out.println("    Address: " + Entertainments.getEntertainmentAddress(i));
            if(Entertainments.getEntertainmentPrice(i) != 0.0){
                System.out.println("    Price: $" + Entertainments.getEntertainmentPrice(i));
            }else{
                System.out.println("    Price: Free of charge");
            }
        }
    }

    public static void showOutOfRangeInputText(){
        System.out.println("Seemingly you have inputted wrong number!");
        System.out.println("Please try again");
    }

    public static void showEntertainmentInfo(int entertainmentID){
        System.out.println((entertainmentID + 1) + ". " + Entertainments.getEntertainmentName(entertainmentID));
        System.out.println("    Address: " + Entertainments.getEntertainmentAddress(entertainmentID));
        if(Entertainments.getEntertainmentPrice(entertainmentID) != 0.0){
            System.out.println("    Price: $" + Entertainments.getEntertainmentPrice(entertainmentID));
        }else{
            System.out.println("    Price: Free of charge");
        }
    }

    public static void showZeroBalanceText(){
        System.out.println("Unfortunately, you have $0 in your balance");
    }

}
