import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int ans = 0;
        int n = new Scanner(System.in).nextInt();
        for (int i = 1; i <= n ; i++) {
            for (int j = i; j <= n ; j++) {
                for (int k = j; k <= n; k++) {
                    if ((i ^ j ^ k) == 0) {
                        if (i + j > k)
                            ans++;
                    }
                }

            }
        }
        System.out.println(ans);

    }

}
