package com.thoughtworks.giantbomb;

import java.io.StringWriter;
import java.util.Map;

public class URIBuilder {
    private StringWriter uri;

    public URIBuilder(String baseUri) {
        this.uri.append(baseUri);
    }

    public void add(Map.Entry<String, String> entry) {
        uri.append("&").append(entry.getKey());
        uri.append("=").append(entry.getValue());
    }

    public String uri() {
        return uri.toString();
    }
}
