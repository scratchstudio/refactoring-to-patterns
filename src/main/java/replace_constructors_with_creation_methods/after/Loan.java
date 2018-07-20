package replace_constructors_with_creation_methods.after;

import replace_constructors_with_creation_methods.before.CapitalStrategy;
import replace_constructors_with_creation_methods.before.CapitalStrategyRCTL;
import replace_constructors_with_creation_methods.before.CapitalStrategyRevolver;
import replace_constructors_with_creation_methods.before.CapitalStrategyTermLoan;

import java.util.Date;

/**
 * 객체를 생성하는 표준 방법을 사용하지는 않지만
 * {@link replace_constructors_with_creation_methods.before.Loan} 의 생성자보다 용도를 명확히 드러낼 수 있게 됨.
 */
public class Loan {
    private double commitment;
    private double outstanding;
    private int riskRating;
    private Date maturity;
    private Date expiry;
    private CapitalStrategy capitalStrategy;

    public static Loan createTermLoan(double commitment, int riskRating, Date maturity) {
        return new Loan(new CapitalStrategyTermLoan(), commitment, 0.0, riskRating, maturity, null);
    }

    public static Loan createTermLoan(CapitalStrategy capitalStrategy, double commitment, int riskRating, Date maturity) {
        return new Loan(capitalStrategy, commitment, 0.00, riskRating, maturity, null);
    }

    public static Loan createRevolver(double commitment, double outstanding, int riskRating, Date expiry) {
        return new Loan(new CapitalStrategyRevolver(), commitment, outstanding, riskRating, null, expiry);
    }

    public static Loan createRevolver(CapitalStrategy capitalStrategy, double commitment, double outstanding, int riskRating, Date expiry) {
        return new Loan(capitalStrategy, commitment, outstanding, riskRating, null, expiry);
    }

    public static Loan createRCTL(double commitment, double outstanding, int riskRating, Date maturity, Date expiry) {
        return new Loan(new CapitalStrategyRCTL(), commitment, outstanding, riskRating, maturity, expiry);
    }

    public static Loan createRCTL(CapitalStrategy capitalStrategy, double commitment, double outstanding, int riskRating, Date maturity, Date expiry) {
        return new Loan(capitalStrategy, commitment, outstanding, riskRating, maturity, expiry);
    }

    private Loan(CapitalStrategy capitalStrategy, double commitment, double outstanding,
                int riskRating, Date maturity, Date expiry) {
        this.commitment = commitment;
        this.outstanding = outstanding;
        this.riskRating = riskRating;
        this.maturity = maturity;
        this.expiry = expiry;
        this.capitalStrategy = capitalStrategy;

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
}
