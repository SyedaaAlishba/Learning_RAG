import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        Path knowledgePath = Path.of("src/resources");

        try (Stream<Path> files = Files.list(knowledgePath)) {

            files.filter(Files::isRegularFile)
                    .forEach(file -> {

                        try {
                            String content = Files.readString(file);

                            System.out.println("===== " + file.getFileName() + " =====");

                            System.out.println(content);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
//        InvertedIndex index = new InvertedIndex();
//
//        index.addDocument(
//                Path.of("java.txt"),
//                new String[]{"java", "programming", "language"}
//        );
//
//        index.addDocument(
//                Path.of("dsa.txt"),
//                new String[]{"trie", "autocomplete"}
//        );
//
//        System.out.println(index.search("java"));
//        System.out.println(index.search("autocomplete"));
//        System.out.println(index.search("python"));

        Chunker chunker = new Chunker(5, 2);

        String text =
                "Java is a powerful programming language " +
                        "used for backend development and many other applications.";

        List<Chunk> chunks =
                chunker.chunk(text, "java.txt");

        for (Chunk chunk : chunks) {

            System.out.println(
                    "Chunk " +
                            chunk.getChunkIndex() +
                            ": " +
                            chunk.getText()
            );
        }
    }
}
