public interface Scorer {

        double calculateScore(
                String[] queryTokens,
                String[] documentTokens
        );
}
