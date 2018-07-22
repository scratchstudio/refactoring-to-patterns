package form_template_method.after;


import form_template_method.common.Loan;

public class CapitalStrategyAdvisedLine extends CapitalStrategy {

    @Override
    public double riskAmountFor(Loan loan) {
        return loan.getCommitment() * loan.getUnusedPercentage();
    }
}
