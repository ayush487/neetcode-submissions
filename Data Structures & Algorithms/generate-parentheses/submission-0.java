class Solution {
    private class Parantheses {
        StringBuilder sb;
        int open;
        int close;

        public Parantheses(StringBuilder sb, int open, int close) {
            this.sb = sb;
            this.open = open;
            this.close = close;
        }

        public Parantheses copy(char bracket) {
            StringBuilder newSb = new StringBuilder(sb);
            int newOpen = open;
            int newClose = close;
            if (bracket == '(') {
                newSb.append('(');
                newOpen++;
            } else {
                newSb.append(')');
                newClose++;
            }
            return new Parantheses(newSb, newOpen, newClose);
        }
    }

    private List<String> list;

    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        dfs(n, new Parantheses(new StringBuilder(), 0, 0));
        return list;
    }

    private void dfs(int n, Parantheses current) {
        if (current.sb.length() == 2 * n) {
            if (current.close == current.open)
                list.add(current.sb.toString());
            return;
        }
        if (current.close>current.open) return;
        dfs(n, current.copy('('));
        dfs(n, current.copy(')'));
    }
}
