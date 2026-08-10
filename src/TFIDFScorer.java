import java.nio.file.Path;
import java.util.Map;

public class TFIDFScorer {
    public double calculateTF(
            String term,
            String[] documentTokens) {

        int count = 0;

        for (String token : documentTokens) {
            if (term.equals(token)) {
                count++;
            }
        }

        return (double) count / documentTokens.length;
    }

    public int calculateDocumentFrequency(
            String term,
            Map<Path, String[]> documents) {

        int count = 0;

        for (String[] tokens : documents.values()) {

            for (String token : tokens) {

                if (term.equals(token)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public double calculateIDF(
            String term,
            Map<Path, String[]> documents) {

        int totalDocuments = documents.size();

        int documentFrequency =
                calculateDocumentFrequency(term, documents);

        return Math.log(
                (double) totalDocuments /
                        documentFrequency
        );
    }

    public double calculateTFIDF(
            String term,
            String[] documentTokens,
            Map<Path, String[]> documents) {

        double tf = calculateTF(
                term,
                documentTokens
        );

        double idf = calculateIDF(
                term,
                documents
        );

        return tf * idf;
    }
}
