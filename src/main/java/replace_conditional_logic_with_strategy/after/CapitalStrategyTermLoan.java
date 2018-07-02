package replace_conditional_logic_with_strategy.after;

import replace_conditional_logic_with_strategy.before.Payment;

import java.util.Iterator;

public class CapitalStrategyTermLoan extends CapitalStrategy {

    @Override
    public double capital(Loan loan) {
        return loan.getCommitment() * duration(loan) * riskFactorFor(loan);
    }

    public double duration(Loan loan) {
        if (loan.getExpiry() == null && loan.getMaturity() != null) {
            return weightedAverageDuration(loan);
        } else if (loan.getExpiry() != null && loan.getMaturity() == null) {
            yearsTo(loan.getExpiry(), loan);
        }

        return 0.0;
    }

    private double weightedAverageDuration(Loan loan) {
        double duration = 0.0;
        double weightedAverage = 0.0;
        double sumOfPayments = 0.0;
        Iterator loanPayments = loan.getPayments().iterator();
        while (loanPayments.hasNext()) {
            Payment payment = (Payment) loanPayments.next();
            sumOfPayments += payment.amount();
            weightedAverage += yearsTo(payment.date(), loan) * payment.amount();
        }

        if (loan.getCommitment() != 0.0) {
            duration = weightedAverage / sumOfPayments;
        }

        return duration;
    }
}
