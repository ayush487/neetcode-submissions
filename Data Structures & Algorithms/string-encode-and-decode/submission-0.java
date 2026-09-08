class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int currentPointer = 0;
        while (currentPointer < str.length()) {
            String strLength = "";
            while (str.charAt(currentPointer)!='#') strLength+= str.charAt(currentPointer++);
            int length = Integer.parseInt(strLength);
            currentPointer++; // ignore #
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<length;i++) {
                sb.append(str.charAt(currentPointer++));
            }
            list.add(sb.toString());
        }
        return list;
    }
}
