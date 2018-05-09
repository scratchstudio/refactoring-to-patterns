package creation.creation_methods.after;

import java.util.Date;

public class Loan {

    private final double commitment;
    private final double outstanding;
    private final int riskRating;
    private final Date maturity;
    private final Date expiry;
    private CapitalStrategy capitalStrategy;

    public static Loan createTermLoan(double commitment, int riskRating, Date maturity) {
        return new Loan(null, commitment, 0.00, riskRating, maturity, null);
    }

    public static Loan createTermLoan(double commitment, int riskRating, Date maturity, Date expiry) {
        return new Loan(null, commitment, 0.00, riskRating, maturity, expiry);
    }

    public static Loan createTermLoan(double commitment, double outstanding, int riskRating, Date maturity, Date expiry) {
        return new Loan(null, commitment, outstanding, riskRating, maturity, expiry);
    }

    public static Loan createTermLoan(CapitalStrategy capitalStrategy, double commitment, int riskRating, Date maturity) {
        return new Loan(capitalStrategy, commitment, 0.00, riskRating, maturity, null);
    }

    // 유일한 생성자는 가시성을 private 으로 변경
    private Loan(CapitalStrategy capitalStrategy, double commitment, double outstanding, int riskRating, Date maturity, Date expiry) {
        this.commitment = commitment;
        this.outstanding = outstanding;
        this.riskRating = riskRating;
        this.maturity = maturity;
        this.expiry = expiry;

        if (capitalStrategy == null) {
            if (expiry == null) {
                this.capitalStrategy = new CapitalStrategyTermLoan();
            } else if (maturity == null) {
                this.capitalStrategy = new CapitalStrategyRevolver();
            } else {
                this.capitalStrategy = new CapitalStrategyRCTL();
            }
        }
    }

    public interface CapitalStrategy {
    }

    private class CapitalStrategyTermLoan implements CapitalStrategy {
    }

    private class CapitalStrategyRevolver implements CapitalStrategy {
    }

    private class CapitalStrategyRCTL implements CapitalStrategy {
    }
}
