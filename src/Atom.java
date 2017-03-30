/**
 * Created by Siderskini1 on 3/29/17.
 */
public class Atom implements Bondable {
    private int v, p, n, e;

    public Atom() {
        this(1, 1);
    }

    public Atom(int a, int z) {
        this(a, z, 0);
    }

    public Atom(int a, int z, int c) {
        p = a;
        n = z - a;
        e = p - c;
        if (e < 3) {
            v = e;
        } else if (e < 21) {
            v = Math.floorMod(e + 6, 8);
        } else if (e < 57) {
            if ((e - 3) % 18 < 10) {
                v = -1;
            } else {
                if (e % 18 < 3) {
                    v = e % 18;
                }
                else {
                    v = (e + 8) % 18;
                }
            }
        }
        if (v == 0) {
            v = 8;
        }
    }

    public int getValence() {
        return v;
    }

	@Override
	public void add(Bond bond) {
		// TODO Auto-generated method stub
		
	}

}
