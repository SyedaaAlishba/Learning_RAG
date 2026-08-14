public class VectorSimilarity {

    public double cosineSimilarity(
            double[] a,
            double[] b) {

        if (a.length != b.length) {
            throw new IllegalArgumentException(
                    "Vectors must have the same dimensions."
            );
        }

        double dotProduct = 0.0;
        double magnitudeA = 0.0;
        double magnitudeB = 0.0;

        for (int i = 0; i < a.length; i++) {

            dotProduct += a[i] * b[i];

            magnitudeA += a[i] * a[i];

            magnitudeB += b[i] * b[i];
        }

        magnitudeA = Math.sqrt(magnitudeA);
        magnitudeB = Math.sqrt(magnitudeB);

        if (magnitudeA == 0 || magnitudeB == 0) {
            return 0.0;
        }

        return dotProduct /
                (magnitudeA * magnitudeB);
    }
}