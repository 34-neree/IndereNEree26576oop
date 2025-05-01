package advancedtaxenforcmentsystem;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

class WithholdingTaxDeclaration extends TaxDeclaration {
    private String category;
    private double baseAmount;

    public WithholdingTaxDeclaration(String declarationId, String taxpayerName, String taxpayerTIN, LocalDate declarationDate, String category, double baseAmount) {
        super(declarationId, taxpayerName, taxpayerTIN, declarationDate);
        this.category = category;
        this.baseAmount = baseAmount;
    }

    @Override
    public double calculateTax() {
        double rate = switch (category.toLowerCase()) {
            case "services" -> 0.15;
            case "rent" -> 0.10;
            case "dividends" -> 0.05;
            default -> throw new IllegalArgumentException("Invalid category.");
        };
        return taxAmount = baseAmount * rate;
    }

    @Override
    public void validateDeclaration() {
        List<String> validCategories = Arrays.asList("services", "rent", "dividends");
        if (!validCategories.contains(category.toLowerCase()))
            throw new IllegalArgumentException("Invalid category.");
        if (declarationDate.isAfter(LocalDate.now())) throw new IllegalArgumentException("Future date not allowed.");
        if (!taxpayerTIN.matches("\\d{9}")) throw new IllegalArgumentException("TIN must be 9 digits.");
    }

    @Override
    public void generateReceipt() {
        System.out.println("\n--- Withholding Tax Receipt ---");
        System.out.printf("ID: %s\nName: %s\nTIN: %s\nDate: %s\nCategory: %s\nTax Amount: %.2f\nPaid: %s\n",
                declarationId, taxpayerName, taxpayerTIN, declarationDate, category, taxAmount, isPaid);
    }

    @Override
    public void enforceCompliance() {
        if (!isPaid) {
            taxAmount += 3000;
            System.out.println("Penalty of 3000 RWF applied for undeclared withholding tax payment.");
        }
    }
}
