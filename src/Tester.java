import static org.junit.Assert.*;

import org.junit.*;

import chemistry.Atom;

/**
 * Created by Siderskini1 on 3/29/17.
 */
public class Tester {

    public static void main(String[] args) {
        Atom x;
        for (int i = 1; i < 57; i++) {
            x = new Atom(i, 100, 1);
            System.out.println(x.getValence());
        }
    }

    @Test
    public void valenceTest() {
        int[] check = {1, 2, 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, 3, 4, 5, 6, 7, 8, 1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 3, 4, 5, 6, 7, 8, 1, 2};
        Atom x;
        for (int i = 1; i < 57; i++) {
            x = new Atom(i, 100);
            assertEquals(check[i - 1], x.getValence());
        }
    }
}
