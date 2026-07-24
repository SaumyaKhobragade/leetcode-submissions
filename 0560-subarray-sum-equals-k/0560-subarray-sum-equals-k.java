class Solution {
    public int subarraySum(int[] arr, int k) {
        int currentSum = 0;
        int prefix[] = new int[arr.length];
        int counter = 0;

        prefix[0] = arr[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                currentSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];

                if(currentSum == k) {
                    counter++;
                }
            }
        }
        return counter;
    }
}