import static org.junit.jupiter.api.Assertions.assertEquals;

import chemistry.Bond;
import chemistry.FunctionalGroup;
import org.junit.Test;

import chemistry.Atom;
import graphics.Frame;

/**
 * Created by Siderskini1 on 3/29/17.
 */
public class Tester {

    public static void main(String[] args) {
        Frame frame = new Frame(new FunctionalGroup("Hydrogen", new Atom("Hydrogen"),
                new Bond(new Atom("Oxygen"), null)));
        frame.display();
    }

    @Test
    public static void valenceTest() {
        int[] check = {1, 2, 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, 3, 4, 5, 6, 7, 8, 1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 3, 4, 5, 6, 7, 8, 1, 2};
        Atom x;
        for (int i = 1; i < 57; i++) {
            x = new Atom("Henry", i);
            assertEquals(check[i - 1], x.getValence());
        }
    }

    @Test
    public static void frameTest() {
        Frame frame = new Frame(new FunctionalGroup(null, null, null));
        frame.display();
    }
}
