package replace_conditional_logic_with_strategy.after;

import replace_conditional_logic_with_strategy.before.RiskFactor;

import java.util.Date;

/**
 * {@link replace_conditional_logic_with_strategy.before.Loan#capital()} 의 if-else 문이 모두 사라지고,
 * 각각의 하위 클래스들이 capital 계산 로직을 구현한다
 */
public abstract class CapitalStrategy {
    private static final long MILLIS_PER_DAY = 86400000;
    private static final long DAYS_PER_YEAR = 365;

    public abstract double capital(Loan loan);

    double riskFactorFor(Loan loan) {
        return RiskFactor.getFactors().forRating(loan.getRiskRating());
    }

    double duration(Loan loan) {
        return yearsTo(loan.getExpiry(), loan);
    }

    double yearsTo(Date endDate, Loan loan) {
        Date beginDate = (loan.getToday() == null ? loan.getStart() : loan.getToday());
        return (endDate.getTime() - beginDate.getTime()) / MILLIS_PER_DAY / DAYS_PER_YEAR;
    }
}
