package creation.creation_methods.before;

import java.util.Date;

public class Loan {

    private final double commitment;
    private final double outstanding;
    private final int riskRating;
    private final Date maturity;
    private final Date expiry;
    private CapitalStrategy capitalStrategy;

    public Loan(double commitment, int riskRating, Date maturity) {
        this(commitment, 0.00, riskRating, maturity, null);
    }

    public Loan(double commitment, int riskRating, Date maturity, Date expiry) {
        this(commitment, 0.00, riskRating, maturity, expiry);
    }

    public Loan(double commitment, double outstanding, int riskRating, Date maturity, Date expiry) {
        this(null, commitment, outstanding, riskRating, maturity, expiry);
    }

    public Loan(CapitalStrategy capitalStrategy, double commitment, int riskRating, Date maturity, Date expiry) {
        this(capitalStrategy, commitment, 0.00, riskRating, maturity, expiry);
    }

    public Loan(CapitalStrategy capitalStrategy, double commitment, double outstanding, int riskRating, Date maturity, Date expiry) {
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
