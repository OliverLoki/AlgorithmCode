import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        int[] ints = new int[]{1, 5, 3, 3, 5, 6};

        for (int i : ints) {
            i ^= i;
        }
        System.out.println(Arrays.toString(ints));

    }

}
