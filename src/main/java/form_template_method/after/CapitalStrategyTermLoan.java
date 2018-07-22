package form_template_method.after;

import form_template_method.common.Loan;

public class CapitalStrategyTermLoan extends CapitalStrategy {

    @Override
    public double riskAmountFor(Loan loan) {
        return loan.getCommitment();
    }

    @Override
    protected double duration(Loan loan) {
        return weightedAverageDuration(loan);
    }

    private double weightedAverageDuration(Loan loan) {
        // TODO something
        throw new UnsupportedOperationException();
    }
}
