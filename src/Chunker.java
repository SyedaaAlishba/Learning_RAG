import java.util.ArrayList;
import java.util.List;

public class Chunker {

    private final int chunkSize;
    private final int overlap;

    public Chunker(int chunkSize, int overlap) {

        if (overlap >= chunkSize) {
            throw new IllegalArgumentException(
                    "Overlap must be smaller than chunk size."
            );
        }

        this.chunkSize = chunkSize;
        this.overlap = overlap;
    }

    public List<Chunk> chunk(
            String text,
            String source) {

        String[] words = text.split("\\s+");

        List<Chunk> chunks = new ArrayList<>();

        int start = 0;
        int chunkIndex = 0;

        while (start < words.length) {

            int end = Math.min(
                    start + chunkSize,
                    words.length
            );

            StringBuilder chunkText =
                    new StringBuilder();

            for (int i = start; i < end; i++) {

                if (chunkText.length() > 0) {
                    chunkText.append(" ");
                }

                chunkText.append(words[i]);
            }

            chunks.add(
                    new Chunk(
                            chunkText.toString(),
                            source,
                            chunkIndex
                    )
            );

            chunkIndex++;


            if (end == words.length) {
                break;
            }
            start = end - overlap;
        }

        return chunks;
    }
}