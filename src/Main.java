import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;
public class Main {

    public static void main(String[] args) throws IOException {

        Chunker chunker = new Chunker(5, 2);

        String text =
                "Java is a powerful programming language " +
                        "used for backend development and many other applications.";

        // 1. Create chunks
        List<Chunk> chunks =
                chunker.chunk(text, "java.txt");

        // 2. Create embedding service
        EmbeddingService embeddingService =
                new RealEmbeddingService();

        // 3. Create embedding generator
        EmbeddingGenerator generator =
                new EmbeddingGenerator(embeddingService);

        // 4. Generate embeddings
        generator.generateEmbeddings(chunks);

        // 5. Check the results
        for (Chunk chunk : chunks) {

            System.out.println(
                    "Chunk " + chunk.getChunkIndex()
            );

            System.out.println(
                    "Text: " + chunk.getText()
            );

            System.out.println(
                    "Vector size: " +
                            chunk.getEmbedding().length
            );

            System.out.println();
        }
    }
}