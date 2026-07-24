class Solution {
    public int maxSubArray(int[] numbers) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        int flag = 1;
        int max_term = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > -1) {
                flag = 0;
            }
            if (numbers[i] > max_term) {
                max_term = numbers[i];
            }
        }

        if(flag == 0) {
            for (int i = 0; i < numbers.length; i++) {
                cs = cs + numbers[i];
                if (cs < 0) {
                    cs = 0;
                }
                ms = Math.max(cs, ms);
            }
            return ms;
        } else {
            return max_term;
        }

    }
}