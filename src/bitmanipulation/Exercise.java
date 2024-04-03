package bitmanipulation;

/**
 * @author kansanja on 02/04/24.
 */
public class Exercise {
    public static void main(String[] args) {

        int x = 6;
        if ((x & 1) > 0) {
            System.out.println("Odd");
        } else {
            System.out.println("Even");
        }


        int n = 5;
        int i = 1;
        System.out.println("bit " + i + " is: " + getIthBit(n, i));

        System.out.println(setIthBit(n, 1));
        System.out.println(clearIthBit(n, 2));
        System.out.println(updateIthBit(n, 3, 1));
        System.out.println(clearLastIBits(n, 2));
        System.out.println(clearBitsInRange(n, 1, 0));
    }

    private static int getIthBit(int n, int i) {
        int mask = (1 << i);
        return (n & mask) > 0 ? 1 : 0;
    }

    private static int setIthBit(int n, int i) {
        int mask = (1 << i);
        return (n | mask);
    }

    private static int clearIthBit(int n, int i) {
        int mask = ~(1 << i);
        return (n & mask);
    }

    private static int updateIthBit(int n, int i, int v) {
        clearIthBit(n, i);
        int mask = (v << i);
        return (n | mask);
    }

    private static int clearLastIBits(int n, int i) {
        int mask = (-1 << i);
        return (n & mask);
    }

    private static int clearBitsInRange(int n, int i, int j) {
        int a = (-1 << j + 1);
        int b = (1 << j) - 1;
        int mask = (a | b);
        return (n & mask);
    }
}
