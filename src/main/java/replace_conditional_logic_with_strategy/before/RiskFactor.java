package replace_conditional_logic_with_strategy.before;

public class RiskFactor {
    public static RiskFactor getFactors() {
        return new RiskFactor();
    }

    public double forRating(double riskRating) {
        throw new UnsupportedOperationException();
    }
}
