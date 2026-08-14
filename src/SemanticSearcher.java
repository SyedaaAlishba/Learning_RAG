import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SemanticSearcher {

    private final VectorSimilarity similarity;

    public SemanticSearcher(VectorSimilarity similarity) {
        this.similarity = similarity;
    }

    public List<ChunkScore> search(
            double[] queryVector,
            List<Chunk> chunks) {

        List<ChunkScore> results = new ArrayList<>();

        for (Chunk chunk : chunks) {

            double score =
                    similarity.cosineSimilarity(
                            queryVector,
                            chunk.getEmbedding()
                    );

            results.add(
                    new ChunkScore(chunk, score)
            );
        }

        results.sort(
                Comparator.comparingDouble(
                        ChunkScore::getScore
                ).reversed()
        );

        return results;
    }
}