package vehicletaxmanagement;

class Bus extends Vehicle {
    private int passengerCapacity;

    public Bus(String vehicleId, String ownerName, int yearOfFabrication, String registrationNumber,
               double baseTaxRate, int passengerCapacity) {
        super(vehicleId, ownerName, yearOfFabrication, registrationNumber, baseTaxRate, "Bus");
        if (passengerCapacity <= 0) throw new IllegalArgumentException("Passenger capacity must be positive.");
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double calculateTax() {
        double tax = baseTaxRate * (1 + (0.02 * (passengerCapacity / 10)));
        if (java.time.Year.now().getValue() - yearOfFabrication > 20) tax *= 1.1;
        return tax;
    }

    @Override
    public void generateTaxReport() {
        System.out.println(this);
        System.out.println("Calculated Tax: " + calculateTax());
    }
}
