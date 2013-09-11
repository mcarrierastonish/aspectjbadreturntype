package aspectj.but.repro.badreturntype.aspect;

import org.junit.Test;

import aspectj.bug.repro.badreturntype.BadReturnTypeAdvisedSandwichArtist;
import aspectj.bug.repro.badreturntype.NonAdvisedSandwichArtist;
import aspectj.bug.repro.badreturntype.WorkAroundAdvisedSandwichArtist;

public class BadReturnTypeTest {
    @Test
    public void testBadReturnType() {
        new BadReturnTypeAdvisedSandwichArtist().createSandwiches();
    }

    @Test
    public void testWorkaround() {
        new WorkAroundAdvisedSandwichArtist().createSandwiches();
    }

    @Test
    public void testNonAdvised() {
        new NonAdvisedSandwichArtist().createSandwiches();
    }
}
