import java.util.ArrayList;
import java.util.List;


import Factory.PostavelFactory;
import Postagem.Comentario;
import Postagem.PostFoto;
import Postagem.Postavel;
import Recurso.Foto;

public class Main {
    public static void main(String[] args) {
        Foto foto = new Foto("cageo.oi", "1900x800");

        System.out.println("URL É VALIDA? " + foto.validaUrlRecurso());

        Postavel postFoto = PostavelFactory.getPostavel("POSTFOTO");

        if (postFoto instanceof PostFoto){
                ((PostFoto) postFoto).adicionaFoto(foto);
                ((PostFoto)postFoto).comenta();
                ((PostFoto)postFoto).posta();
                ((PostFoto) postFoto).getComentarios();

                ArrayList<Comentario> comentarios = ((PostFoto) postFoto).getComentarios();
                System.out.println("Comentários:");
                for (Comentario comentario : comentarios){
                        System.out.println("Data: " + comentario.getData() +
                                           "\nTamanho: " + comentario.getTamanho()+
                                           "\nTexto: " + comentario.getTexto() +
                                           "\nFixado: " + comentario.isFixado());
                }
            
        }
        if (postFoto instanceof PostFoto){
            
        }
        
    }
    
}
