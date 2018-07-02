package replace_conditional_logic_with_strategy.after;

import replace_conditional_logic_with_strategy.before.UnusedRiskFactors;

public class CapitalStrategyAdviseLine extends CapitalStrategy {

    @Override
    public double capital(Loan loan) {
        return (loan.outstandingRiskAmount() * loan.duration() * riskFactorFor(loan))
                + (loan.unusedRiskAmount() * loan.duration() * unusedRiskFactorFor(loan));
    }

    private double unusedRiskFactorFor(Loan loan) {
        return UnusedRiskFactors.getFactors().forRating(loan.getRiskRating());
    }
}
