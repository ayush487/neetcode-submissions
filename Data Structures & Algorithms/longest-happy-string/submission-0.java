class Solution {
    class Letter implements Comparable<Letter> {
        char letter;
        int count;

        public Letter(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }

        @Override
        public int compareTo(Letter l) {
            return l.count - count;
        }

        public int decrementCount() {
            return --count;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        Letter letterA = new Letter('a', a);
        Letter letterB = new Letter('b', b);
        Letter letterC = new Letter('c', c);
        PriorityQueue<Letter> maxHeap = new PriorityQueue<>();
        if (letterA.count > 0) maxHeap.offer(letterA);
        if (letterB.count > 0) maxHeap.offer(letterB);
        if (letterC.count > 0) maxHeap.offer(letterC);
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            int currLength = sb.length();
            Letter currLetter = maxHeap.poll();
            if (currLength >= 2
                    && sb.charAt(currLength - 1) == currLetter.letter
                    && sb.charAt(currLength - 2) == currLetter.letter) {
                if (maxHeap.isEmpty()) break;
                Letter nextLetter = maxHeap.poll();
                sb.append(nextLetter.letter);
                int nextLetterCount = nextLetter.decrementCount();
                if (nextLetterCount>0) maxHeap.offer(nextLetter);
                maxHeap.offer(currLetter);
            } else {
                sb.append(currLetter.letter);
                int newCount = currLetter.decrementCount();
                if (newCount>0) maxHeap.offer(currLetter);
            }
        }
        return sb.toString();
    }
}