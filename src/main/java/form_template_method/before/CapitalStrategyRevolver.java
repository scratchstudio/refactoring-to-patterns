package form_template_method.before;

import form_template_method.common.Loan;

public class CapitalStrategyRevolver extends CapitalStrategy {
    @Override
    public double capital(Loan loan) {
        return (loan.outstandingRiskAmount() * duration(loan) * riskFactorFor(loan))
                + (loan.unusedRiskAmount() * duration(loan) * unusedRiskFactor(loan));
    }

    private double unusedRiskFactor(Loan loan) {
        // TODO something
        throw new UnsupportedOperationException();
    }
}
