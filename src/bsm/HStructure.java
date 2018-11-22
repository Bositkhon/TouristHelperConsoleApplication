package bsm;

public abstract class HStructure {

    abstract String getName(int placeID);

    abstract double getPrice(int placeID);

    abstract String getAddress(int placeID);

    abstract int quantity();

}
