class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c==']') {
                String temp = "";
                while(!stack.peek().equals("[")) {
                    temp = stack.pop() + temp;
                }
                stack.pop();
                String countString = stack.pop();
                int count = Integer.parseInt(countString);
                StringBuilder sb = new StringBuilder();
                for (int j=0;j<count;j++) {
                    sb.append(temp);
                }
                stack.push(sb.toString());
            } else if (isNumber(c + "")) {
                String currentNum = "";
                int x = 0;
                while(s.charAt(i+x)!='[') {
                    currentNum += s.charAt(i+x);
                    x++;
                }
                stack.push(currentNum);
                i += x;
                i--;
            }  
            else {
                stack.push(c + "");
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    private boolean isNumber(String n) {
        try {
            Integer.parseInt(n);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}