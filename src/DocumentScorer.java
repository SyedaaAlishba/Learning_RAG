public class DocumentScorer {

    public int calculateScore(
            String[] documentTokens,
            String[] queryTokens) {

        int score = 0;

        for (String queryToken : queryTokens) {

            for (String documentToken : documentTokens) {

                if (queryToken.equals(documentToken)) {
                    score++;
                }
            }
        }

        return score;
    }
}