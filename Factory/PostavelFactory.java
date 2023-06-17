package Factory;

import Postagem.PostFoto;
import Postagem.PostVideo;
import Postagem.Postavel;

public class PostavelFactory {

    public static Postavel getPostavel(String tipoPost) {
        Postavel post = null;
        if (tipoPost.equals("POSTVIDEO")) {
            PostVideo postVideo = new PostVideo();
            post = postVideo;
        }

        if (tipoPost.equals("POSTFOTO")) {
            PostFoto postFoto = new PostFoto();
            post = postFoto;
        }

        return post;
    }
}
