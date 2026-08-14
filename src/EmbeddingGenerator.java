import java.util.List;

public class EmbeddingGenerator {

    private final EmbeddingService embeddingService;

    public EmbeddingGenerator(EmbeddingService embeddingService) {
        this.embeddingService = embeddingService;
    }

    public void generateEmbeddings(List<Chunk> chunks) {

        for (Chunk chunk : chunks) {

            double[] vector =
                    embeddingService.embed(
                            chunk.getText()
                    );

            chunk.setEmbedding(vector);
        }
    }
}