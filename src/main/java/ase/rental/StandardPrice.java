package ase.rental;

public class StandardPrice  extends Price{
    @Override
    public int getPriceCode() {
        return Car.STANDARD;
    }

    @Override
    public int getCharge(int rentalLength) {
        return 30 * rentalLength;
    }
}
