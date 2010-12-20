package com.thoughtworks.service;

import android.text.Editable;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

public class ResultsFromWeb {
    private final String API_KEY = "fce888b3343a05f4d6d139c4d8c96638866e12f2";
    private final String API_URL = "http://api.giantbomb.com/";

    public boolean find(Editable text) {
        HttpClient client = new DefaultHttpClient();
        try {
            HttpResponse response = client.execute(new HttpGet(API_URL));
            response.getEntity();
        } catch (IOException e) {
            System.out.print("Anishek : failed to retrieve");
            return false;
        }
        System.out.print("Anishek :found Nothing");
        return true;
    }
}
