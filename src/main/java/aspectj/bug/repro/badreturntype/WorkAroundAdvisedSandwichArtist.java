package aspectj.bug.repro.badreturntype;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import aspectj.bug.repro.badreturntype.anno.SurroundMe;

public class WorkAroundAdvisedSandwichArtist {
    @SurroundMe
    public List<Sandwich<? extends Meat>> createSandwiches() {
        final List<Sandwich<? extends Meat>> wiches = new ArrayList<>();

        int i = BigDecimal.valueOf(10 * Math.random()).intValue() + 1;
        for (int j = 1; j <= i; j++) {
            if (j % 2 == 0) {
                wiches.add(createSandwich(ESandwich.chicken));
            } else {
                wiches.add(createSandwich(ESandwich.roastbeef));
            }
        }

        return wiches;
    }

    private Sandwich<? extends Meat> createSandwich(ESandwich sandwich) {
        switch (sandwich) {
            case chicken:
                return new ChickenSandwich();
            case roastbeef:
                return new RoastBeefSandwich();
            default:
                throw new RuntimeException("I don't like that kind of meat.");
        }
    }
}
