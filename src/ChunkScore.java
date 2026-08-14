public class ChunkScore {

    private final Chunk chunk;
    private final double score;

    public ChunkScore(
            Chunk chunk,
            double score) {

        this.chunk = chunk;
        this.score = score;
    }

    public Chunk getChunk() {
        return chunk;
    }

    public double getScore() {
        return score;
    }
}