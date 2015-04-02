/**
 * Given a tree {@code t} and a range {@code [a..b]} you need to find the size of the largest subtree
 * of {@code t} in which all nodes have value inside given range.
 */
public class LargestSubtreeWithinRange {
    private final Answer answerBuffer = new Answer();

    public int solve(int a, int b, Tree t) {
        return findAnswer(a, b, t).size;
    }

    private Answer findAnswer(int a, int b, Tree t) {
        if (t == null) {
            return answer(0, true);
        }

        boolean inRange = (t.x >= a) && (t.x <= b);
        Answer childAnswer;

        childAnswer = findAnswer(a, b, t.l);
        int leftSize = childAnswer.size;
        inRange = inRange && childAnswer.wholeInRange;

        childAnswer = findAnswer(a, b, t.r);
        int rightSize = childAnswer.size;
        inRange = inRange && childAnswer.wholeInRange;

        if (inRange) {
            return answer(leftSize + 1 + rightSize, true);
        }

        return answer(Math.max(leftSize, rightSize), false);
    }

    private Answer answer(int size, boolean wholeInRange) {
        answerBuffer.size = size;
        answerBuffer.wholeInRange = wholeInRange;
        return answerBuffer;
    }

    private static class Answer {
        public int size;
        public boolean wholeInRange;
    }
}

class Tree {
    public int x;
    public Tree l;
    public Tree r;
}