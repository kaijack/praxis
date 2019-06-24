package vending;

public class VendingMachineFactory {
    public static VendingMachine createVendingMachine() {
        return new VendinMachineImpl();
    }
}