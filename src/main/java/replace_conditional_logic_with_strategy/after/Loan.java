package replace_conditional_logic_with_strategy.after;

import replace_conditional_logic_with_strategy.before.Payment;

import java.util.Date;
import java.util.List;

public class Loan {
    private CapitalStrategy capitalStrategy;

    private double commitment;
    private Date start;
    private Date expiry;
    private Date maturity;
    private double riskRating;

    private double unusedPercentage;
    private double outstanding;
    private List<Payment> payments;

    private Date today;

    public Loan(double commitment, double notSureWhatThisIs, Date start, Date expiry,
                Date maturity, int riskRating, CapitalStrategy capitalStrategy) {
        this.commitment = commitment;
        this.start = start;
        this.expiry = expiry;
        this.maturity = maturity;
        this.riskRating = riskRating;
        this.capitalStrategy = capitalStrategy;
    }

    public static Loan newTermLoan(double commitment, Date start, Date maturity, int riskRating) {
        return new Loan(commitment, commitment, start, null, maturity, riskRating,
                new CapitalStrategyTermLoan());
    }

    public static Loan newRevolver(double commitment, Date start, Date expiry, int riskRating) {
        return new Loan(commitment, 0, start, expiry, null, riskRating,
                new CapitalStrategyRevolver());
    }

    public static Loan newAdvisedLine(double commitment, Date start, Date expiry, int riskRating) {
        if (riskRating > 3) {
            return null;
        }
        Loan advisedLine = new Loan(commitment, 0, start, expiry, null, riskRating,
                new CapitalStrategyAdviseLine());
        advisedLine.setUnusedPercentage(0.1);
        return advisedLine;
    }

    public double captial() {
        return capitalStrategy.capital(this);
    }

    public double duration() {
        return capitalStrategy.duration(this);
    }

    double outstandingRiskAmount() {
        return outstanding;
    }

    double unusedRiskAmount() {
        return commitment - outstanding;
    }

    double getUnusedPercentage() {
        return unusedPercentage;
    }

    public Date getExpiry() {
        return expiry;
    }

    public Date getMaturity() {
        return maturity;
    }

    public double getCommitment() {
        return commitment;
    }

    public double getRiskRating() {
        return riskRating;
    }

    public Date getToday() {
        return today;
    }

    public Date getStart() {
        return start;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    private void setUnusedPercentage(double unusedPercentage) {
        this.unusedPercentage = unusedPercentage;
    }
}
