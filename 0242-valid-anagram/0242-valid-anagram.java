class Solution {
    public boolean isAnagram(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();

        if (a.length() == b.length()) {
            char[] c1 = a.toCharArray();
            char[] c2 = b.toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);
            return Arrays.equals(c1, c2);
        } else {
            return false;
        }
    }
}