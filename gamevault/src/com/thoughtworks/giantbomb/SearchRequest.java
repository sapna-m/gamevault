package com.thoughtworks.giantbomb;

public class SearchRequest extends Request {
    public final String SEARCH = "search/";
    private String searchString;

    public SearchRequest() {
        map.put("resources", "game");
        map.put("offset", "0");
        map.put("limit", MAX_RESULTS_PER_PAGE);
    }

    @Override
    protected void process(String responseContent) {
        
    }

    String createBaseUri() {
        return API_URL + SEARCH + API_KEY;
    }

    public void addSearchString(String searchString) {
        if (searchString != null && !"".equals(searchString.trim()))
            map.put("query", searchString);
    }
}
