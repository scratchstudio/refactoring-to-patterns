package replace_conditional_logic_with_strategy.before;

public class UnusedRiskFactors {
    public static UnusedRiskFactors getFactors() {
        return new UnusedRiskFactors();
    }

    public double forRating(double riskRating) {
        throw new UnsupportedOperationException();
    }
}
