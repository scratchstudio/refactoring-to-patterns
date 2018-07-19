package chain_constructors.after;

import chain_constructors.common.CapitalStrategy;
import chain_constructors.common.RevolvingTermROC;
import chain_constructors.common.TermROC;

import java.util.Date;

/**
 * 생성자 체이닝을 통해 {@link chain_constructors.before.Loan} 에서
 * 나타난 생성자 중복 문제를 해결.
 *
 * 클래스에 생성자가 너무 많아 클라이언트가 어떤 상황에서 어느 생성자를 사용 할지
 * 알기 어려워 보인다면 {@link replace_constructors_with_creation_methods.after.Loan} 적용을 고려
 */
public class Loan {
    private CapitalStrategy strategy;
    private float notional;
    private float outstanding;
    private int rating;
    private Date expiry;
    private Date manurity;

    public Loan(float notional, float outstanding, int rating, Date expiry) {
        this(new TermROC(), notional, outstanding, rating, expiry, null);
    }

    public Loan(float notional, float outstanding, int rating, Date expiry, Date maturity) {
        this(new RevolvingTermROC(), notional, outstanding, rating, expiry, maturity);
    }

    public Loan(CapitalStrategy strategy, float notional, float outstanding, int rating, Date expiry, Date maturity) {
        this.strategy = strategy;
        this.notional = notional;
        this.outstanding = outstanding;
        this.rating = rating;
        this.expiry = expiry;
        this.manurity = maturity;
    }
}
