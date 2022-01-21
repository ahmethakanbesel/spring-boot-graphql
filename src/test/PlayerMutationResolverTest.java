import okhttp3.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PlayerMutationResolverTest {
    private final String graphqlUri = "http://localhost:8090/graphql";

    @Test
    public void testCreatePlayer() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n    \"query\": \"mutation {\\n  createPlayer(player: {name: \\\"Name\\\", surname: \\\"Surname\\\", position: \\\"Shooting guard(SG)\\\"}) {\\n    id\\n    name\\n    surname\\n    position\\n  }\\n}\",\r\n    \"variables\": null\r\n}");
        Request request = new Request.Builder()
                .url(graphqlUri)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        assert response.body() != null;
        assertEquals("{\"data\":{\"createPlayer\":{\"id\":\"1\",\"name\":\"Name\",\"surname\":\"Surname\",\"position\":\"Shooting guard(SG)\"}}}", response.body().string());
    }

    @Test
    public void testGetPlayers() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n    \"query\": \"{\\n  getPlayers {\\n    id\\n    name\\n    surname\\n    position\\n  }\\n}\",\r\n    \"variables\": null,\r\n    \"operationName\": null\r\n}");
        Request request = new Request.Builder()
                .url(graphqlUri)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        assert response.body() != null;
        assertEquals("{\"data\":{\"getPlayers\":[{\"id\":\"1\",\"name\":\"Name\",\"surname\":\"Surname\",\"position\":\"Shooting guard(SG)\"}]}}", response.body().string());
    }

    @Test
    public void testDeletePlayer() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n    \"query\": \"mutation {\\n  deletePlayer(id: 1)\\n}\\n\",\r\n    \"variables\": null\r\n}");
        Request request = new Request.Builder()
                .url(graphqlUri)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        assert response.body() != null;
        assertEquals("{\"data\":{\"deletePlayer\":true}}", response.body().string());
    }

}