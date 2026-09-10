class Solution {
    public void reverseString(char[] s) {
        final int length = s.length;
        for (int i=0;i<length/2;i++) {
            swap(s, i, length - 1 - i);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}