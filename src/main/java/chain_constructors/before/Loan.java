package chain_constructors.before;

import chain_constructors.common.CapitalStrategy;
import chain_constructors.common.RevolvingTermROC;
import chain_constructors.common.TermROC;

import java.util.Date;

/**
 * 생성자를 통해 전달되는 파라미터를
 * 단순 할당하는 중복된 코드를 갖는 생성자가 여러개 있음.
 */
public class Loan {
    private CapitalStrategy strategy;
    private float notional;
    private float outstanding;
    private int rating;
    private Date expiry;
    private Date manurity;

    public Loan(float notional, float outstanding, int rating, Date expiry) {
        this.strategy = new TermROC();
        this.notional = notional;
        this.outstanding = outstanding;
        this.rating = rating;
        this.expiry = expiry;
    }

    public Loan(float notional, float outstanding, int rating, Date expiry, Date maturity) {
        this.strategy = new RevolvingTermROC();
        this.notional = notional;
        this.outstanding = outstanding;
        this.rating = rating;
        this.expiry = expiry;
        this.manurity = maturity;
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
