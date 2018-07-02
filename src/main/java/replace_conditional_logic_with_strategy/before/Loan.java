package replace_conditional_logic_with_strategy.before;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Loan {
    private static final long MILLIS_PER_DAY = 86400000;
    private static final long DAYS_PER_YEAR = 365;

    private Date expiry;
    private Date maturity;
    private Date start;
    private double commitment;
    private double riskRating;
    private double unusedPercentage;
    private double outstanding;
    private List<Payment> payments;

    private Date today;

    public Loan(Date expiry, Date maturity, Date start, double commitment, double riskRating,
                double unusedPercentage, double outstanding, List<Payment> payments) {
        this.expiry = expiry;
        this.maturity = maturity;
        this.start = start;
        this.commitment = commitment;
        this.riskRating = riskRating;
        this.unusedPercentage = unusedPercentage;
        this.outstanding = outstanding;
        this.payments = payments;

        this.today = new Date();
    }

    /**
     * 대출의 종류를 정하기 위한 로직
     */
    public double capital() {
        // Term Loan
        if (expiry == null && maturity != null) {
            return commitment * duration() * riskFactor();
        }

        if (expiry != null && maturity == null) {
            // Revolver
            if (getUnusedPercentage() != 1.0) {
                return commitment * getUnusedPercentage() * duration() * riskFactor();

            // Advised Line
            } else {
                return (outstandingRiskAmount() * duration() * riskFactor())
                        + (unusedRiskAmount() * duration() * unusedRiskFactor());
            }
        }
        return 0.0;
    }

    // 이하 도우미 메서드들
    private double outstandingRiskAmount() {
        return outstanding;
    }

    private double unusedRiskAmount() {
        return commitment - outstanding;
    }

    private double duration() {
        if (expiry == null && maturity != null) {
            return weightedAverageDuration();
        } else if (expiry != null && maturity == null) {
            yearsTo(expiry);
        }

        return 0.0;
    }

    private double weightedAverageDuration() {
        double duration = 0.0;
        double weightedAverage = 0.0;
        double sumOfPayments = 0.0;
        Iterator loanPayments = payments.iterator();
        while (loanPayments.hasNext()) {
            Payment payment = (Payment) loanPayments.next();
            sumOfPayments += payment.amount();
            weightedAverage += yearsTo(payment.date()) * payment.amount();
        }

        if (commitment != 0.0) {
            duration = weightedAverage / sumOfPayments;
        }

        return duration;
    }

    private double yearsTo(Date endDate) {
        Date beginDate = (today == null ? start : today);
        return (endDate.getTime() - beginDate.getTime()) / MILLIS_PER_DAY / DAYS_PER_YEAR;
    }

    private double riskFactor() {
        return RiskFactor.getFactors().forRating(riskRating);
    }

    private double unusedRiskFactor() {
        return UnusedRiskFactors.getFactors().forRating(riskRating);
    }

    private double getUnusedPercentage() {
        return unusedPercentage;
    }
}
