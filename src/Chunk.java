public class Chunk {
    private final String text;
    private final String source;
    private final int chunkIndex;
    private double[] embedding;
    public Chunk(String text, String source, int chunkIndex) {
        this.text = text;
        this.source = source;
        this.chunkIndex = chunkIndex;
    }

    public String getText() {
        return text;
    }

    public String getSource() {
        return source;
    }

    public int getChunkIndex() {
        return chunkIndex;
    }
    public double[] getEmbedding() {
        return embedding;
    }

    public void setEmbedding(double[] embedding) {
        this.embedding = embedding;
    }
}
