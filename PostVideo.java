import Recurso.Video;

public class PostVideo implements Postavel{
    
    protected Video video = new Video(null, 0, 0);
    protected DateTime dataPostagem;
    protected Comentario listaDeComentarios[];

    public PostVideo(){
        
    }

    public boolean adicionaVideo(){
        Video video = new Video(null, 0, 0)
    }

    
    @Override
    public boolean posta() {
        
        return false;
    }


  
  
}