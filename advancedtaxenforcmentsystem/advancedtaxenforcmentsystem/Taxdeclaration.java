package advancedtaxenforcmentsystem;

import java.time.LocalDate;

interface TaxCalculable {
    double calculateTax();
}

interface Receiptable {
    void generateReceipt();
}
abstract class TaxDeclaration implements TaxCalculable, Receiptable {
    protected String declarationId;
    protected String taxpayerName;
    protected String taxpayerTIN;
    protected LocalDate declarationDate;
    protected double taxAmount;
    protected boolean isPaid;

    public TaxDeclaration(String declarationId, String taxpayerName, String taxpayerTIN, LocalDate declarationDate) {
        this.declarationId = declarationId;
        this.taxpayerName = taxpayerName;
        this.taxpayerTIN = taxpayerTIN;
        this.declarationDate = declarationDate;
        this.isPaid = false;
    }
    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        this.isPaid = paid;
    }

    public abstract void validateDeclaration();
    public abstract void generateReceipt();
    public abstract void enforceCompliance();
}