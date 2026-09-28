class Solution {
    private List<List<String>> mainList;

    public List<List<String>> partition(String s) {
        mainList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(s);
        dfs(list);
        return mainList;
    }

    private void dfs(List<String> list) {
        String lastString = list.getLast();
        if (lastString.length() == 1) {
            mainList.add(list);
            return;
        }
        if (isPalindrome(lastString))
            mainList.add(list);
        for (int i = 1; i < lastString.length(); i++) {
            String currentSubstring = lastString.substring(0, i);
            if (isPalindrome(currentSubstring)) {
                List<String> copyList = new ArrayList<>(list);
                copyList.removeLast();
                copyList.add(currentSubstring);
                copyList.add(lastString.substring(i));
                dfs(copyList);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++)
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        return true;
    }
}
