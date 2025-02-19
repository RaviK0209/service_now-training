import java.util.Scanner;
class NumberOfWays {
    static int numberofways(int n, int m)
    {
        int dp[][]=new int[n+2][n+2];
       
        dp[0][n + 1] = 1;
        for (int k = n; k >= m; k--) {
            for (int i = 0; i <= n; i++) {
                dp[i][k] = dp[i][k + 1];
                if (i - k >= 0)
                    dp[i][k] = (dp[i][k] + dp[i - k][k]);
            }
        }
   
        return dp[n][m];
    }
    public static void main(String args[])
    {
        int n,m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        System.out.println(numberofways(n, m));
    }
}