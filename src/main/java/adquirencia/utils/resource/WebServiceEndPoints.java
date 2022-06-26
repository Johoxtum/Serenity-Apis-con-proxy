package adquirencia.utils.resource;

import adquirencia.utils.Constant.Endpoints;




public enum WebServiceEndPoints {
    URI(Endpoints.URL_KEY);



    private final String url;

    WebServiceEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
