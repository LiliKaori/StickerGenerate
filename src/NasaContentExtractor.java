
import java.util.List;
import java.util.Map;

public class NasaContentExtractor implements ContentExtractor {
    public List<Content> contentExtractor(String json){
         //Extrai só os dados que interessa (título, poster, classificação)
         var parser = new JsonParser();
         List<Map<String, String>> contentList = parser.parse(json);
         // System.out.println(movieList.get(0));
        
        //  List<Content> conteudos = new ArrayList<>();

        //  //popular a lista de conteúdos
        //  for (Map<String, String> atributos : contentList){
        //     String titulo = atributos.get("title");
        //     String urlImagem = atributos.get("url");
        //     var conteudo = new Content(titulo, urlImagem);

        //     conteudos.add(conteudo);
        //  }
         return contentList.stream()
         .map(atributos -> new Content(atributos.get("title"),atributos.get("url")))
         .toList();         
    }
    
}
