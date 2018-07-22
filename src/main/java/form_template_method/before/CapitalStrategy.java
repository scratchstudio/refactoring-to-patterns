package form_template_method.before;

import form_template_method.common.Loan;

/**
 * 서브클래스에서 {@link CapitalStrategy#capital(Loan)} 을 계산하는 방식이 서로 비슷함.
 */
public abstract class CapitalStrategy {
    private static final long MILLIS_PER_DAY = 86400000;
    private static final long DAYS_PER_YEAR = 365;

    public abstract double capital(Loan loan);

    double riskFactorFor(Loan loan) {
        // TODO something
        throw new UnsupportedOperationException();
    }

    double duration(Loan loan) {
        // TODO something
        throw new UnsupportedOperationException();
    }
}
