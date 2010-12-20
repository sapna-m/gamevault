package com.thoughtworks.giantbomb;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public abstract class Request {
    public final String API_KEY = "?api_key=fce888b3343a05f4d6d139c4d8c96638866e12f2";
    public final String API_URL = "http://api.giantbomb.com/";
    static final String MAX_RESULTS_PER_PAGE = "10";

    Map<String, String> map = new HashMap<String, String>();

    public void results() {
        HttpClient client = new DefaultHttpClient();
        try {
            HttpResponse response = client.execute(new HttpGet(create()));
            process(readContent(response));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract void process(String responseContent);

    private String readContent(HttpResponse response) throws IOException {
        StringWriter content = new StringWriter();
        byte[] bytes = new byte[4096];
        InputStream stream = response.getEntity().getContent();
        for (int bytesRead = stream.read(bytes); bytesRead > 0; bytesRead = stream.read(bytes)) {
            content.append(new String(bytes), 0, bytesRead);
        }
        return content.toString();
    }

    public String create() {
        URIBuilder uriBuilder = new URIBuilder(createBaseUri());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            uriBuilder.add(entry);
        }
        return uriBuilder.uri();
    }

    abstract String createBaseUri();

}
