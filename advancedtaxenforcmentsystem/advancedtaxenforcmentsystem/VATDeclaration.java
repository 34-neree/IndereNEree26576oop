package advancedtaxenforcmentsystem;

import java.time.LocalDate;

class VATDeclaration extends TaxDeclaration {
    private double sales;
    private double purchases;

    public VATDeclaration(String declarationId, String taxpayerName, String taxpayerTIN, LocalDate declarationDate, double sales, double purchases) {
        super(declarationId, taxpayerName, taxpayerTIN, declarationDate);
        this.sales = sales;
        this.purchases = purchases;
    }

    @Override
    public double calculateTax() {
        return taxAmount = (sales - purchases) * 0.18;
    }

    @Override
    public void validateDeclaration() {
        if (sales <= purchases) throw new IllegalArgumentException("Sales must be greater than purchases.");
        if (declarationDate.isAfter(LocalDate.now())) throw new IllegalArgumentException("Declaration date cannot be in the future.");
        if (!taxpayerTIN.matches("\\d{9}")) throw new IllegalArgumentException("TIN must be 9 digits.");
    }

    @Override
    public void generateReceipt() {
        System.out.println("\n--- VAT Tax Receipt ---");
        System.out.printf("ID: %s\nName: %s\nTIN: %s\nDate: %s\nTax Amount: %.2f\nPaid: %s\n",
                declarationId, taxpayerName, taxpayerTIN, declarationDate, taxAmount, isPaid);
    }

    @Override
    public void enforceCompliance() {
        if (!isPaid) {
            taxAmount += 10000; // Penalty
            System.out.println("Penalty of 10,000 RWF applied for VAT non-compliance.");
        }
    }
}
