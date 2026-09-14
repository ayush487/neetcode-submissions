class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i<asteroids.length && asteroids[i]<= 0) stack.push(asteroids[i++]);
        for (;i<asteroids.length;i++) {
            if (stack.isEmpty()) stack.push(asteroids[i]);
            else {
                int ast = asteroids[i];
                while(true) {

                    if (stack.isEmpty()) {
                        stack.push(ast);
                        break;
                    }
                    if (canCollide(stack.peek(), ast)) {
                        int ast2 = stack.pop();
                        if (ast2+ast==0) break;
                        else if (Math.abs(ast2) > Math.abs(ast)) ast = ast2;
                        else ast = ast;
                    } else {
                        stack.push(ast);
                        break;
                    }
                }
            }
        }

        int asteroidsRemaining = stack.size();
        int[] arr = new int[asteroidsRemaining];
        for (int j=asteroidsRemaining-1;j>=0;j--) {
            arr[j] = stack.pop();
        }
        return  arr;
    }

    private boolean canCollide(int a1, int a2) {
        if (a1<=0) return false;
        else if (a2>=0) return false;
        else return true;
    }
}