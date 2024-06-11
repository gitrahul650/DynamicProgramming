package adynamic;

public class FibTabulation {
    //use tabulation to solve fibonacci
    public static void main(String[] args) {
        int n = 100;
        long[] table = new long[n + 1];
        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }

        System.out.println(table[n]);
    }
}
