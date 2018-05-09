package creation.creation_methods.before;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Date;

public class LoanTest {
    @Test
    public void name() {
        new Loan(1, 1, new Date());
    }
}