package advancedtaxenforcmentsystem;

import java.util.ArrayList;
import java.util.List;

class TaxOfficer {
    private String officerId;
    private String fullName;
    private String assignedRegion;
    private List<TaxDeclaration> auditsConducted = new ArrayList<>();

    public TaxOfficer(String officerId, String fullName, String assignedRegion) {
        this.officerId = officerId;
        this.fullName = fullName;
        this.assignedRegion = assignedRegion;
    }

    public void auditDeclaration(TaxDeclaration declaration) {
        auditsConducted.add(declaration);
        declaration.enforceCompliance();
    }

    public void generateAuditSummary() {
        System.out.println("\n--- Audit Summary ---");
        for (TaxDeclaration decl : auditsConducted) {
            decl.generateReceipt();
        }
    }
}
