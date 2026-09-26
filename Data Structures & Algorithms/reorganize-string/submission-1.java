class Solution {
    class Letter implements Comparable<Letter> {
        char letter;
        int count;

        Letter(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }

        @Override
        public int compareTo(Letter o) {
            return o.count - count;
        }

        public int decrementCount() {
            this.count--;
            return count;
        }
    }

    public String reorganizeString(String s) {
        if (s.length() == 1) return s;
        Map<Character, Integer> letterMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            letterMap.put(s.charAt(i), letterMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Letter> heap = new PriorityQueue<>();
        for (char c : letterMap.keySet()) {
            heap.offer(new Letter(c, letterMap.get(c)));
        }
        char[] charArr = new char[s.length()];
        Letter prevLetter = null;
        int currIndex = 0;
        while (!heap.isEmpty()) {
            Letter maxOccurredLetter = heap.poll();
            charArr[currIndex++] = maxOccurredLetter.letter;
            int newCount = maxOccurredLetter.decrementCount();
            if (prevLetter != null) {
                heap.offer(prevLetter);
            }
            if (newCount > 0) prevLetter = maxOccurredLetter;
            else prevLetter = null;
        }
        if (currIndex!=s.length()) return "";
        else {
            StringBuilder sb = new StringBuilder();
            for (char c : charArr) sb.append(c);
            return sb.toString();
        }
    }
}