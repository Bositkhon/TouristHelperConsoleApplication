package bsm;

public class Entertainments {

    public static final int MUSEUMS_QUANTITY = 9;

    public static final int RELIGIOUS_SIGHTS_QUANTITY = 6;

    public static final int PARKS_QUANTITY  = 5;

    public static final int TOTAL_SIGHT_QUANTITY = MUSEUMS_QUANTITY + PARKS_QUANTITY + RELIGIOUS_SIGHTS_QUANTITY;

    public static String[] entertainmentNames = {
            "Uzbekistan State Museum of Applied Art",
            "Amir Timur Museum",
            "Railway Museum",
            "House Museum of Pumpkin",
            "Republican Opera and Ballet Theater named after Alisher Navoi",
            "Ilkhom Theater",
            "Monument of Courage. ",
            "Tashkent Metro",
            "Museum of Victims of Political Repression",

            "Minor Mosque",
            "Dzhuma Mosque",
            "Hazrat Imam Mosque",
            "Tilla-Sheikh Mosque",
            "Barak-Khan Madrassah",
            "Holy Assumption Cathedral",

            "Broadway",
            "Eco park",
            "Independence Square",
            "Japanese Garden",
            "Park Ashkhabad",

    };

    public static double[] entertainmentPrices = {
            15, 9, 10, 18, 15, 10, 0, 0.2, 8, // Museums, Theatres and sights
            0,0,0,0,0,0, // Spiritual and religious sights
            0,0,0,5,10 // Parks

    };

    public static String[] entertainmentAddresses = {
            "Rakatboshi St. 15, Tashkent 100031, Uzbekistan",
            "Amir Timur St. 1, Yunus-Abad district, Tashkent 100431, Uzbekistan",
            "Turkiston St. 6, Tashkent 100060, Uzbekistan",
            "Sultoniya St. 62, Tashkent, Uzbekistan",
            "Address: Ataturk St. 28, Tashkent 100029, Uzbekistan",
            "Pakhtakor St. 5, Tashkent 100011, Uzbekistan",
            "Mustaqillik Ave, Tashkent, Uzbekistan",
            "",
            "Amir Timur Avenue, Tashkent, Uzbekistan",

            "Minor District, Tashkent, Uzbekistan",
            "Chorsu Bazar, Old town, Tashkent, Uzbekistan",
            "Qarasaroy District, Tashkent, Uzbekistan",
            "Zarkaynar Street, Tashkent, Uzbekistan ",
            "Sabir-Rakhimov District, Tashkent, Uzbekistan",
            "Avliyuata St, Tashkent, Uzbekistan",

            "Saylgoh Street, Tashkent, Uzbekistan",
            "Khamid Alimdjan St., Tashkent, Uzbekistan",
            "Mustakillik St., Tashkent, Uzbekistan",
            "107, Amir Timur St., Tashkent, Uzbekistan",
            "Yashnabad district, Tashkent, Uzbekistan",
    };

    public static String getEntertainmentName(int entertainmentID) {
        return entertainmentNames[entertainmentID];
    }

    public static String getEntertainmentAddress(int entertainmentID) {
        return entertainmentAddresses[entertainmentID];
    }

    public static double getEntertainmentPrice(int entertainmentID) {
        return entertainmentPrices[entertainmentID];
    }
}
