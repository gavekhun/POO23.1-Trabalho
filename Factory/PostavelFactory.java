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
            return post;
        }
        if (tipoPost.equals("POSTFOTO")) {
            PostFoto postFoto = new PostFoto();
            post = postFoto;
            return post;
        } else {
            throw new Error("O tipo de post " + tipoPost
                    + " não existe. As entradas válidas são apenas: \nPOSTVIDEO \nPOSTFOTO");
        }

    }
}
