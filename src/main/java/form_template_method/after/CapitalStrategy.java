package form_template_method.after;

import form_template_method.common.Loan;

/**
 * {@link form_template_method.before.CapitalStrategy#capital(Loan)} 에서는 추상 메서드 였지만
 * 구체 메서드가 되고 도메인 지식을 통해 capital 을 구하는 표준 공식이 명확히 드러남.
 *
 * 어떤 공식대로 실행되거나, 순서에 맞춰 실행되어야 할 때 템플릿메서드 패턴을 사용할 수 있음.
 */
public abstract class CapitalStrategy {

    // 서브클래스에서 오버라이드를 방지하려면 final 로 선언할 수 도 있음.
    public double capital(Loan loan) {
        return riskAmountFor(loan) * duration(loan) * riskFactorFor(loan);
    }

    public abstract double riskAmountFor(Loan loan);

    protected double riskFactorFor(Loan loan) {
        // TODO something
        throw new UnsupportedOperationException();
    }

    protected double duration(Loan loan) {
        // TODO something
        throw new UnsupportedOperationException();
    }
}
