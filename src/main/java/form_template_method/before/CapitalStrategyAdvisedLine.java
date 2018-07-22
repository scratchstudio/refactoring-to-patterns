package form_template_method.before;


import form_template_method.common.Loan;

public class CapitalStrategyAdvisedLine extends CapitalStrategy {
    @Override
    public double capital(Loan loan) {
        return loan.getCommitment() * loan.getUnusedPercentage()
                * duration(loan) * riskFactorFor(loan);
    }
}
