package Factory;

import Postagem.PostFoto;
import Postagem.PostVideo;
import Postagem.Postavel;

public class PostavelFactory {

    public static Postavel getPostavel(String tipoPost, boolean incluirMidia, String localizacao) {
        Postavel post = null;
        if (tipoPost.equals("POSTVIDEO")) {
            PostVideo postVideo = new PostVideo(incluirMidia);
            post = postVideo;
        }

        if (tipoPost.equals("POSTFOTO")) {
            PostFoto postFoto = new PostFoto(incluirMidia, localizacao);
            post = postFoto;
        }

        return post;
    }
}
