package bsm;

public class Hotels extends HStructure {

    private String[] names = {
            "Uzbeksitan Hotel",
            "Radisson Hotel",
            "Hayyat Regions Hotel",
            "Wyndham Hotel",
            "Miran Hotel",
            "Sayyoh Hotel",
            "Grand Atlas Hotel"
    };

    double[] prices = {70, 150, 200, 110, 95, 30, 50};

    private String[] addresses = {
            "Mustaqillik Ave 45, Mirzo Ulugbek District, Tashkent, Uzbekistan, 100047",
            "Amir Temur St. 88, Yunusabad District, Tashkent, Uzbekistan, 100084",
            "Navoi St. 1A, Yunusabad District, Tashkent, Uzbekistan, 100000",
            "Amir temur St. 71, Mirzo-Ulugbek District, Tashkent",
            "Shakhrisabz passage, 4, Mirabad District, Tashkent, Uzbekistan, 100060",
            "Al-Khorazmiy St. 4/1, Chilanzar District, Tashkent, Uzbekistan, 100002",
            "Domrobod St. 182, Chilanzar District, Tashkent, Uzbekistan, 100081"
    };

    private double[] minPrices = {61, 121, 181, 101, 81, 20, 41};


    private double[] maxPrices = {80, 180, 220, 120, 100, 40, 60};


    String[] contactPhones = {
            "+998712266676",
            "+998712422422",
            "+998711222232",
            "+998711222332",
            "+998712233444",
            "+998712898990",
            "+998712656675"
    };

    double getMinPrice(int hotelID){
        return minPrices[hotelID];
    }

    double getMaxPrice(int hotelID){
        return maxPrices[hotelID];
    }

    int getEligibleHotelID(double cost){
        for(int i = 0; i < this.quantity(); i++) {
            if (cost >= this.getMinPrice(i) && cost <= this.getMaxPrice(i)) {
                return i;
            }
        }
        return 0;
    }

    @Override
    String getName(int placeID) {
        return names[placeID];
    }

    @Override
    double getPrice(int placeID) {
        return prices[placeID];
    }

    @Override
    String getAddress(int placeID) {
        return addresses[placeID];
    }

    @Override
    int quantity() {
        return names.length;
    }
}
