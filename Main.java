import Recurso.Foto;
import Recurso.Video;

public class Main {
    public static void main(String[] args) {
        
        Video video = new Video("gbb.mov", 5, 10);
        Foto foto = new Foto("foto-do-cageo.mov", "100px");

        video.validaUrlRecurso("gbb.io");
        video.getInfo();

        foto.validaUrlRecurso("foto-do-cageo.jpg");
        foto.getInfo();

        

        
        
        
        
    }
    
}
