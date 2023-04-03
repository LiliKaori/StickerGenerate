import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {
        
        // API api = API.IMDB_TOP_SERIES;
        // String url = api.getUrl();
        // ContentExtractor extrator = api.getExtrator();

        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json";
        // ContentExtractor extrator = new NasaContentExtractor();
        
        String url ="http://localhost:8080/linguagens";
        ContentExtractor extrator = new IMDBContentExtractor();

        var http = new ClienHttp();
        String json = http.buscaDados(url);

        //Exibir e manipular os dados
        
        List<Content> conteudos = extrator.contentExtractor(json);

        var geradora = new StickerGenerate();

        
        for (int i = 0; i < 3; i++) {

            Content conteudo = conteudos.get(i);
            
            InputStream inputStream = new URL(conteudo.urlImage()).openStream();
            String nomeArquivo = "out/" + conteudo.titulo() + ".png";
            
            geradora.create(inputStream, nomeArquivo);

            
            System.out.println(conteudo.titulo());
            // System.out.println(filme.get("imDbRating"));
            
        }


    }
}
