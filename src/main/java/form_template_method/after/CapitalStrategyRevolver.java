package form_template_method.after;

import form_template_method.common.Loan;

public class CapitalStrategyRevolver extends CapitalStrategy {
    @Override
    public double capital(Loan loan) {
        return super.capital(loan) + unusedCapital(loan);
    }

    @Override
    public double riskAmountFor(Loan loan) {
        return loan.outstandingRiskAmount();
    }

    private double unusedCapital(Loan loan) {
        return loan.unusedRiskAmount() * duration(loan) * unusedRiskFactor(loan);
    }

    private double unusedRiskFactor(Loan loan) {
        // TODO something
        throw new UnsupportedOperationException();
    }
}
