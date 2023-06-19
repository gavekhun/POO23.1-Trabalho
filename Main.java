import Factory.PostavelFactory;
import Postagem.PostFoto;
import Postagem.PostVideo;
import Postagem.Postavel;
import Recurso.Foto;
import Recurso.Video;

public class Main {
    public static void main(String[] args) {
        
        Foto foto = new Foto("cageo.png", "1980x800");
        Foto foto2 = new Foto("imagem2.jpg", "800x800");
        Foto foto3 = new Foto("imagem3.png", "1200x960");
        Video video1 = new Video("video.mov", 20, 100);
        Postavel postFoto = PostavelFactory.getPostavel("POSTFOTO", false, "Duque de caxias");
        Postavel postFoto2 = PostavelFactory.getPostavel("POSTFOTO", false, "Belford Roxo");
        Postavel postVideo = PostavelFactory.getPostavel("POSTVIDEO", true, "Ilha do Governador");

        if (postFoto instanceof PostFoto){
            ((PostFoto) postFoto).adicionaFoto(foto);
            ((PostFoto) postFoto).adicionaFoto(foto2);
            ((PostFoto) postFoto).comenta( "Olá 1");
            ((PostFoto) postFoto).comenta("Olá 2");
            ((PostFoto) postFoto).comenta( "Olá 3");
            ((PostFoto) postFoto).fixaComenta(2);
            ((PostFoto) postFoto).posta(); 
                 
            
        }
        if (postFoto2 instanceof PostFoto){
            
            ((PostFoto) postFoto2).comenta("Primeiro comentário.");
            ((PostFoto) postFoto2).comenta("Segundo comentário.");
            ((PostFoto) postFoto2).comenta("Terceiro comentário.");
            ((PostFoto) postFoto2).fixaComenta(2);
            ((PostFoto) postFoto2).postSemFoto("Barbante");   

            
        }

        if ( postVideo instanceof PostVideo){

            ((PostVideo) postVideo).adicionaVideo(video1);  
            ((PostVideo) postVideo).comenta("Primeiro video comentário.");
            ((PostVideo) postVideo).posta();


        }

        

        
        
        
        
    }
    
}
