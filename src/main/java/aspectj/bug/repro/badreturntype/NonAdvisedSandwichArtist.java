package aspectj.bug.repro.badreturntype;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NonAdvisedSandwichArtist {
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
        Sandwich<? extends Meat> wich;

        switch (sandwich) {
            case chicken:
                wich = new ChickenSandwich();
                break;
            case roastbeef:
                wich = new RoastBeefSandwich();
                break;
            default:
                throw new RuntimeException("I don't like that kind of meat.");
        }

        return wich;
    }
}
