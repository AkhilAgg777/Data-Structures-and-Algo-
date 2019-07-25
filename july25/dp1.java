package july25;

public class dp1 {

	// method-1 (Fibonacci)
	public static int fib(int n) {
		if (n <= 1) {
			return n;
		}

		int fibnm1 = fib(n - 1);
		int fibnm2 = fib(n - 2);
		return fibnm1 + fibnm2;
	}

	// method-2 Fibonacci(Memoized version)
	public static int fibm(int n, int qb[]) {
		if (n <= 1) {
			return n;
		}

		if (qb[n] != n) {
			return qb[n];
		}

		int fibnm1 = fibm(n - 1, qb);
		int fibnm2 = fibm(n - 2, qb);
		qb[n] = fibnm1 + fibnm2;
		return qb[n];

	}

	// you are allowed to take 1 or 2 or 3 steps. You have to tell no. of ways
	// in which we can climb downstairs

	// Method-1 (Downstairs Problem)
	public static int climbDownStairs(int n) {
		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return 0;
		}
		int now = 0;
		now = climbDownStairs(n - 1) + climbDownStairs(n - 2) + climbDownStairs(n - 3);
		return now;
	}

	// Method-2 (downstairs problem)
	public static int climbDownStairsM(int n, int qb[]) {
		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return 0;
		}

		if (qb[n] != 0) {
			return qb[n];
		}

		int now = 0;
		qb[n] = now = climbDownStairs(n - 1) + climbDownStairs(n - 2) + climbDownStairs(n - 3);
		return now;
	}

	
	//for given array you have to tell no. of paths to reach from source to destination
	public static int noOfPaths(int arr[], int qb[]) {
		qb[arr.length - 1] = 1;

		for (int i = arr.length - 2; i >= 0; i--) {

			for (int j = i + 1; j <= i + arr[i] && j < arr.length; j++) {
				qb[i] += qb[j];
			}

		}

		return qb[0];

	}
	
	//for given array you have to tell min no. of jumps required to reach from source to destination

	public static int minSteps(int arr[], int qb[]) {
		qb[arr.length - 1] = 0;
		for (int i = arr.length - 2; i >= 0; i--) {
			qb[i] = Integer.MAX_VALUE;

			for (int j = i + 1; j <= i + arr[i] && j < arr.length; j++) {
				qb[i] = qb[j] < qb[i] ? qb[j] : qb[i];
				qb[i] = qb[i] != Integer.MAX_VALUE ? qb[i] + 1 : Integer.MAX_VALUE;
			}
		}

		return qb[0];
	}

	public static void main(String[] args) {

		// System.out.println(fib(10));
		// System.out.println(climbDownStairs(7));
		// System.out.println(climbDownStairsM(7, new int[8]));
		int arr[] = { 4, 2, 0, 0, 2, 4, 6, 3, 1, 0, 1, 2, 3, 1, 1 };
		System.out.println(noOfPaths(arr, new int[arr.length]));
		System.out.println(minSteps(arr, new int[arr.length]));

	}

}
