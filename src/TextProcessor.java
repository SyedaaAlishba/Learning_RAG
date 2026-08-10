public class TextProcessor {

    public String normalize(String text) {
        return text
                .toLowerCase()
                .replaceAll("[^a-zA-Z0-9\\s]", "");
    }

    public String[] tokenize(String text) {
        String normalizedText = normalize(text);
        return normalizedText.split("\\s+");
    }
}