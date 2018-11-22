package bsm;

public class Hotels {

    public static final int HOTEL_UZBEKISTAN = 1;
    public static final int HOTEL_RADISSON = 2;
    public static final int HOTEL_HAYYAT = 3;
    public static final int HOTEL_WYNDHAM = 4;
    public static final int HOTEL_MIRAN = 5;
    public static final int HOTEL_SAYYOH = 6;
    public static final int HOTEL_GRAND_ALIAS = 7;

    public static String[] hotels = {
            "Uzbeksitan Hotel",
            "Radisson Hotel",
            "Hayyat Regions Hotel",
            "Wyndham Hotel",
            "Miran Hotel",
            "Sayyoh Hotel",
            "Grand Atlas Hotel"
    };

    public static double[] minPrices = {61, 121, 181, 101, 81, 20, 41};

    public static double[] fixedPrices = {70, 150, 200, 110, 95, 30, 50};

    public static double[] maxPrices = {80, 180, 220, 120, 100, 40, 60};

    public static String[] addresses = {
            "Mustaqillik Ave 45, Mirzo Ulugbek District, Tashkent, Uzbekistan, 100047",
            "Amir Temur St. 88, Yunusabad District, Tashkent, Uzbekistan, 100084",
            "Navoi St. 1A, Yunusabad District, Tashkent, Uzbekistan, 100000",
            "Amir temur St. 71, Mirzo-Ulugbek District, Tashkent",
            "Shakhrisabz passage, 4, Mirabad District, Tashkent, Uzbekistan, 100060",
            "Al-Khorazmiy St. 4/1, Chilanzar District, Tashkent, Uzbekistan, 100002",
            "Domrobod St. 182, Chilanzar District, Tashkent, Uzbekistan, 100081"
    };

    public static String[] contactPhones = {
            "+998712266676",
            "+998712422422",
            "+998711222232",
            "+998711222332",
            "+998712233444",
            "+998712898990",
            "+998712656675"
    };

//    public static String[] getHotels() {
//        return hotels;
//    }

//    public static String[] getContactPhones() {
//        return contactPhones;
//    }


    public static String getHotelName(int hotelID){
        return hotels[hotelID];
    };

    public static double getMinPrice(int hotelID){
        return minPrices[hotelID];
    }

    public static double getMaxPrice(int hotelID){
        return maxPrices[hotelID];
    }

//    public static String getHotelAddress(int hotelID){
//        return addresses[hotelID - 1];
//    }

//    public static String getHotelContactPhone(int hotelID){
//        return contactPhones[hotelID - 1];
//    }

    public static int getHotelsQuantity(){
        return hotels.length;
    }

    public static double getFixedPrice(int hotelID) {
        return fixedPrices[hotelID];
    }

    public static int getEligibleHotelID(double cost){
        for(int i = 0; i < Hotels.getHotelsQuantity(); i++){
            if(cost >= Hotels.getMinPrice(i) && cost <= Hotels.getMaxPrice(i)){
//                System.out.println((i+1) + ". " + Hotels.getHotelName(i));
                return i;
            }
        }
        return 0;
    }

}
