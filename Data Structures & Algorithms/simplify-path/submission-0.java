class Solution {
    public String simplifyPath(String path) {
        String[] pathSplitted = path.split("//*");
        
        Stack<String> stack = new Stack<>();
        for (int i=1;i<pathSplitted.length;i++) {
            String p = pathSplitted[i];
            if (p.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
                
            } else if (p.equals(".")) {
            } else {
                stack.push(p);
            }
        }
        Stack<String> stack2 = new Stack<>();
        while(!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!stack2.isEmpty()) {
            // if (stack2.peek().equals())
            if (stack2.peek().equals("/")){
                sb.append("/");
                stack2.pop();
            } else sb.append("/").append(stack2.pop());
        }
        if (sb.isEmpty()) sb.append("/");
        return sb.toString();
    }
}