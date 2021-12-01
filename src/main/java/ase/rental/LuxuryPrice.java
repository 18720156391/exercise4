package ase.rental;

public class LuxuryPrice extends Price{


    public int getPriceCode() {
        return Car.LUXURY;
    }


    public int getCharge(int rentalLength) {
        return 50 * rentalLength;
    }


}
