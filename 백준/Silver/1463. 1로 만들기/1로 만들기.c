#include <stdio.h>

int main()
{
    int a;
    scanf("%d", &a);
    int dp[a+1];
    for (int i = 0; i <= a; i++) {
        dp[i] = a;
    }
    dp[a]=0;

    for (int i=a; i>=1; i--) {
        if (i%3==0) {
            dp[i/3] = dp[i/3] > (dp[i]+1) ? dp[i]+1 : dp[i/3];
        }
        if (i%2==0) {
            dp[i/2] = dp[i/2] > (dp[i]+1) ? dp[i]+1 : dp[i/2];
        }
        dp[i-1] = dp[i-1] > (dp[i]+1) ? dp[i]+1 : dp[i-1];
    }

    printf("%d\n", dp[1]);
    return 0;
}

