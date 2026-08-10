import java.nio.file.Path;
import java.util.*;
public class InvertedIndex {

    private final Map<String, Set<Path>> index = new HashMap<>();

    public void addDocument(Path documentPath, String[] tokens) {

        for (String token : tokens) {

            index
                    .computeIfAbsent(token, key -> new HashSet<>())
                    .add(documentPath);
        }
    }

    public Set<Path> search(String token) {

        return index.getOrDefault(
                token,
                Collections.emptySet()
        );
    }
}