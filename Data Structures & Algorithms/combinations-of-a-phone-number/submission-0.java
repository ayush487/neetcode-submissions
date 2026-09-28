class Solution {
    private Map<Character, char[]> map;

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<String>();
        map = new HashMap<>();
        fillMap();
        char[] chars = map.get(digits.charAt(0));
        List<StringBuilder> listSB = new ArrayList<>();
        for (char c : chars)
            listSB.add(new StringBuilder().append(c));
        for (int i = 1; i < digits.length(); i++) {
            List<StringBuilder> tempListSB = new ArrayList<>();
            char currentDigit = digits.charAt(i);
            for (StringBuilder currentSB : listSB) {
                for (char c : map.get(currentDigit)) {
                    tempListSB.add(new StringBuilder(currentSB).append(c));
                }
            }
            listSB = tempListSB;
        }
        List<String> result = new ArrayList<>();
        for (StringBuilder sb : listSB) result.add(sb.toString());
        return result;
    }

    private void fillMap() {
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
    }
}
