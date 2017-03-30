/**
 * Created by Siderskini1 on 3/29/17.
 */
public class Tester {

    public static void main(String[] args) {
        Atom x;
        for (int i = 1; i < 57; i++) {
            x = new Atom(i, 100);
            System.out.println(x.getValence());
        }
    }

}
