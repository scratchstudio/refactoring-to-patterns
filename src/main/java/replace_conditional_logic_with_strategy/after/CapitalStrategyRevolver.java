package replace_conditional_logic_with_strategy.after;

public class CapitalStrategyRevolver extends CapitalStrategy {

    @Override
    public double capital(Loan loan) {
        return loan.getCommitment() * loan.getUnusedPercentage() * loan.duration() * riskFactorFor(loan);
    }
}
