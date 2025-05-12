// ✅ Approach 1: DP + Permutations + Fermat's Theorem + Binary Exponentiation + Memoization
// 🎯 Goal: Count number of digit permutations where digits at even indices and odd indices both add up to half of total sum.
// 🧠 Idea: We try all possible ways to assign digits to even positions, and remaining to odd positions, such that their sum becomes totalSum/2 each.
//T.C-O( 10 * n^2 * S) 
//S.C-O(n^2 * S)
class Solution {
    int M = 1_000_000_007;  // 🔐 Modulo for large number arithmetic
    int totalSum;
    long totalPermPossible = 0;
    int n;

    public int countBalancedPermutations(String num) {
        n = num.length();
        int[] count = new int[10];
        totalSum = 0;

        // ✅ Step 1: Count frequency of each digit and calculate total sum of all digits
        for (char ch : num.toCharArray()) {
            totalSum += ch - '0';
            count[ch - '0']++;
        }

        // 🔴 If totalSum is odd, it's impossible to divide it into two equal parts
        if (totalSum % 2 != 0)
            return 0;

        // ✅ Step 2: Precompute factorials up to n
        long[] fact = new long[n + 1];
        fact[0] = 1;
        fact[1] = 1;
        for (int i = 2; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % M;
        }

        // ✅ Step 3: Compute modular inverse of factorials using Fermat’s Little Theorem
        // 🧮 Fermat's Little Theorem: (1 / a) % M = a^(M-2) % M when M is prime
        long[] fermatFact = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            fermatFact[i] = findPow(fact[i], M - 2); // 👇 Binary exponentiation used here
        }

        // ✅ Step 4: Total permutations possible when we choose any (n+1)/2 digits for even indices and n/2 for odd indices
        totalPermPossible = (fact[(n + 1) / 2] * fact[n / 2]) % M;

        // ✅ Step 5: Prepare memoization table
        int[][][] memo = new int[10][(n + 1) / 2 + 1][totalSum + 1];
        for (int[][] arr1 : memo) {
            for (int[] arr2 : arr1) {
                Arrays.fill(arr2, -1);
            }
        }

        // 🚀 Start solving from digit = 0, evenIndexDigitsCount = 0, and currSum = 0
        return solve(0, 0, 0, count, fermatFact, memo);
    }

    // ⚡ Fast Power Algorithm (Binary Exponentiation)
    // Computes (a^b) % M in log(b) time
    public int findPow(long a, long b) {
        if (b == 0) return 1;

        long half = findPow(a, b / 2);
        long res = (half * half) % M;

        if (b % 2 == 1) {
            res = (res * a) % M;
        }

        return (int) res;
    }

    // 🎯 Recursive DP function to try placing digits at even indices and count valid permutations
    // digit: current digit (0 to 9)
    // evenIndexDigitsCount: how many digits already placed at even indices
    // currSum: current sum of digits placed at even indices
    public int solve(int digit, int evenIndexDigitsCount, int currSum, int[] count, long[] fermatFact, int[][][] memo) {

        // ✅ Base condition: If all digits (0 to 9) are considered
        if (digit == 10) {
            // 🎯 If sum of even-position digits is exactly half of total and we used exactly (n+1)/2 digits
            if ((currSum == totalSum / 2) && (evenIndexDigitsCount == (n + 1) / 2)) {
                // Return the total permutations of indices assuming valid digit assignments
                return (int) totalPermPossible;
            }
            return 0; // otherwise, invalid configuration
        }

        // 🔁 Return memoized result if already computed for same state
        if (memo[digit][evenIndexDigitsCount][currSum] != -1) {
            return memo[digit][evenIndexDigitsCount][currSum];
        }

        long ways = 0;

        // ✅ Try placing 0 to count[digit] occurrences of current digit into even indices
        for (int cnt = 0; cnt <= Math.min(count[digit], (n + 1) / 2 - evenIndexDigitsCount); cnt++) {
            int evenPosCount = cnt;
            int oddPosCount = count[digit] - cnt;

            // 🔐 Calculate contribution of placing `evenPosCount` at even indices and `oddPosCount` at odd indices
            // 1/(evenPosCount! * oddPosCount!) using Fermat’s inverse
            long div = (fermatFact[evenPosCount] * fermatFact[oddPosCount]) % M;

            // 🔄 Move to next digit with updated even count and sum
            long val = solve(
                digit + 1,
                evenIndexDigitsCount + evenPosCount,
                currSum + digit * cnt,
                count,
                fermatFact,
                memo
            );

            // 🧮 Add total ways multiplied by combination probability
            ways = (ways + (val * div) % M) % M;
        }

        return memo[digit][evenIndexDigitsCount][currSum] = (int) ways;
    }
}
