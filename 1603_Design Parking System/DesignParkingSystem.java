class ParkingSystem {
    private int[] parkingLot;

    public ParkingSystem(int big, int medium, int small) {
        parkingLot = new int[4];
        parkingLot[1] = big;
        parkingLot[2] = medium;
        parkingLot[3] = small;
    }
    
    public boolean addCar(int carType) {
        if(parkingLot[carType] > 0) {
            parkingLot[carType]--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */