import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;


import javax.imageio.ImageIO;

public class StickerGenerate {
    
    public void create(InputStream inputStream, String nomeArquivo) throws Exception{
        //leitura da imagem
        // InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDI3MGNmOTUtMTZjNi00ODQxLWJjN2EtM2U3YTMwNzZmZmYyXkEyXkFqcGdeQXVyMTA3MDk2NDg2._V1_FMjpg_UX526_.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //criar nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 50;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original pra nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //configurar fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 24);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        //escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 10, novaAltura - 15);

        //escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }
    // public static void main(String[] args) throws Exception {
    //     var geradora = new StickerGenerate();
    //     geradora.create();
    // }

}
