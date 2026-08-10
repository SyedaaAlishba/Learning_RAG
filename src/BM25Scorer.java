public class BM25Scorer {
    private final double k1;
    private final double b;

    public BM25Scorer(double k1, double b) {
        this.k1 = k1;
        this.b = b;
    }
}
