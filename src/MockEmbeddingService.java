public class MockEmbeddingService
        implements EmbeddingService {

    @Override
    public double[] embed(String text) {

        return new double[]{
                0.12,
                0.45,
                -0.23,
                0.78
        };
    }
}