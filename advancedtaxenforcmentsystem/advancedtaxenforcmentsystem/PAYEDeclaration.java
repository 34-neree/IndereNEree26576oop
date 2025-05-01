package advancedtaxenforcmentsystem;
import java.time.LocalDate;

class PAYEDeclaration extends TaxDeclaration {
    private double grossSalary;

    public PAYEDeclaration(String declarationId, String taxpayerName, String taxpayerTIN, LocalDate declarationDate, double grossSalary) {
        super(declarationId, taxpayerName, taxpayerTIN, declarationDate);
        this.grossSalary = grossSalary;
    }

    @Override
    public double calculateTax() {
        if (grossSalary <= 300000) return taxAmount = grossSalary * 0.0;
        else if (grossSalary <= 500000) return taxAmount = grossSalary * 0.2;
        else return taxAmount = grossSalary * 0.3;
    }

    @Override
    public void validateDeclaration() {
        if (grossSalary <= 0) throw new IllegalArgumentException("Gross salary must be positive.");
        if (declarationDate.isAfter(LocalDate.now())) throw new IllegalArgumentException("Declaration date cannot be in the future.");
        if (!taxpayerTIN.matches("\\d{9}")) throw new IllegalArgumentException("TIN must be 9 digits.");
    }

    @Override
    public void generateReceipt() {
        System.out.println("\n--- PAYE Tax Receipt ---");
        System.out.printf("ID: %s\nName: %s\nTIN: %s\nDate: %s\nTax Amount: %.2f\nPaid: %s\n",
                declarationId, taxpayerName, taxpayerTIN, declarationDate, taxAmount, isPaid);
    }

    @Override
    public void enforceCompliance() {
        LocalDate deadline = declarationDate.plusMonths(1).withDayOfMonth(15);
        if (!isPaid && LocalDate.now().isAfter(deadline)) {
            taxAmount += 5000; // Penalty
            System.out.println("Penalty of 5000 RWF applied for late PAYE payment.");
        }
    }
}