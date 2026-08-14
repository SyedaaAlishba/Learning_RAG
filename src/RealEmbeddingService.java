import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.embeddings.EmbeddingCreateParams;
import com.openai.models.embeddings.CreateEmbeddingResponse;

public class RealEmbeddingService implements EmbeddingService {

    private final OpenAIClient client;

    public RealEmbeddingService() {
        this.client = OpenAIOkHttpClient.fromEnv();
    }

    @Override
    public double[] embed(String text) {

        EmbeddingCreateParams params =
                EmbeddingCreateParams.builder()
                        .input(text)
                        .model("text-embedding-3-small")
                        .build();

        CreateEmbeddingResponse response =
                client.embeddings()
                        .create(params);

        return response.data()
                .get(0)
                .embedding()
                .stream()
                .mapToDouble(value -> value.doubleValue())
                .toArray();
    }
}