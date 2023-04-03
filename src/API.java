public enum API {
    IMDB_TOP_MOVIES("https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060", new IMDBContentExtractor()),
    IMDB_TOP_SERIES("https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060", new IMDBContentExtractor()),
    NASA("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json", new NasaContentExtractor());

    private String url;
    private ContentExtractor extrator;

    API(String url, ContentExtractor extrator){
        this.url = url;
        this.extrator = extrator;
    }

    public String getUrl(){
        return url;
    }

    public ContentExtractor getExtrator() {
        return extrator;
    }
}
