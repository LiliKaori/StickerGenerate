import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;



public class ClienHttp {
    public String buscaDados(String url){
        try{
            //fazer conexão HTTP e buscar os top 250 filmes
            URI andress = URI.create(url);
            var client =  HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(andress).GET().build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            String body = response.body();
            // System.out.println(body);
            return body;
            
    
        } catch(IOException | InterruptedException ex){
            throw new ClientHttpException("Erro ao consultar a URL.:(");
        }
    }

    

    
}
