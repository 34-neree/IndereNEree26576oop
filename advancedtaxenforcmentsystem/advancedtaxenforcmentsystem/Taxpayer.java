package advancedtaxenforcmentsystem;

class Taxpayer {
    private String tin;
    private String name;
    private String type;
    private int complianceScore;

    public Taxpayer(String tin, String name, String type) {
        setTin(tin);
        setName(name);
        this.type = type;
        this.complianceScore = 100;
    }

    public void setTin(String tin) {
        if (!tin.matches("\\d{9}")) throw new IllegalArgumentException("TIN must be 9 digits.");
        this.tin = tin;
    }

    public void setName(String name) {
        if (name.length() < 2) throw new IllegalArgumentException("Name too short.");
        this.name = name;
    }

    public String getTin() { return tin; }
    public String getName() { return name; }
    public String getType() { return type; }
    public int getComplianceScore() { return complianceScore; }
    public void deductScore(int points) { complianceScore -= points; }
}