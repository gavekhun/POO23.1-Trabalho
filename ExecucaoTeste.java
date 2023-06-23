import Factory.PostavelFactory;
import Postagem.PostFoto;
import Postagem.PostVideo;
import Postagem.Postavel;
import Recurso.Foto;
import Recurso.Video;

public class ExecucaoTeste {

    public static void postagemTextoTeste() {
        try {
            Postavel postavel = PostavelFactory.getPostavel("POSTTEXTO");
        } catch (Error e) {
            System.out.println("Erro ao tentar realizar post com texto: " + e);
        }
    }

    public static void postagemComVideoTeste() {
        try {
            Video video = new Video("video.mp4", 45, 65);
            Postavel postagem = PostavelFactory.getPostavel("POSTVIDEO");
            PostVideo post = ((PostVideo) postagem);
            post.adicionaVideo(video);
            post.posta();
            post.printAtributos();
        } catch (Error e) {
            System.out.println("Erro ao tentar realizar postagem com video: " + e);
        }

    }

    public static void postagemSemVideoTeste() {
        try {

            Postavel postagem = PostavelFactory.getPostavel("POSTVIDEO");
            PostVideo post = ((PostVideo) postagem);
            post.posta();
            post.printAtributos();
        } catch (Error e) {
            System.out.println("Erro ao tentar realizar postagem sem vídeo: " + e);
        }

    }

    public static void postagemSemFotoTeste() {
        try {

            Postavel postagem = PostavelFactory.getPostavel("POSTFOTO");
            PostFoto post = ((PostFoto) postagem);
            post.setLocalizacao("Cidade Universitária, Fundão - Rio de Janeiro");
            post.posta();
            post.printAtributos();
        } catch (Error e) {
            System.out.println("Erro ao tentar realizar postagem sem foto: " + e);

        }
    }

    public static void postagemComCincoFotosTeste() {
        try {
            Postavel postagem = PostavelFactory.getPostavel("POSTFOTO");
            PostFoto post = ((PostFoto) postagem);
            post.setLocalizacao("Cidade Universitária, Fundão - Rio de Janeiro");
            int i = 5;
            while (i != 0) {
                Foto foto = new Foto("foto" + i + ".png", "5px");
                post.adicionaFoto(foto);
                i--;
            }
            post.posta();
            post.printAtributos();
        } catch (Error e) {
            System.out.println("Erro ao tentar realizar postagem com cinco fotos: " + e);
        }
    }

    public static void postagemComOnzeFotosTeste() {
        try {
            Postavel postagem = PostavelFactory.getPostavel("POSTFOTO");
            PostFoto post = ((PostFoto) postagem);
            post.setLocalizacao("Cidade Universitária, Fundão - Rio de Janeiro");
            int i = 15;
            while (i != 0) {
                Foto foto = new Foto("foto" + i + ".png", "5px");
                post.adicionaFoto(foto);
                i--;
            }
            post.posta();
            post.printAtributos();
        } catch (Error e) {
            System.out.println("Erro ao tentar realizar postgem com onze fotos: " + e);
        }
    }

    public static void comentarioPostFotoTeste() {
        try {
            Postavel postagem = PostavelFactory.getPostavel("POSTFOTO");
            PostFoto post = ((PostFoto) postagem);
            post.setLocalizacao("Cidade Universitária, Fundão - Rio de Janeiro");
            Foto foto = new Foto("foto.png", "25px");
            post.adicionaFoto(foto);
            post.posta();
            post.comenta("Lindo!!😘");
            post.printAtributos();
        } catch (Error e) {
            System.out.println("Erro ao tentar comentar na foto: " + e);
        }

    }

    public static void comentarioPostVideoTeste() {
        try {
            Video video = new Video("video.mp4", 45, 65);
            Postavel postagem = PostavelFactory.getPostavel("POSTVIDEO");
            PostVideo post = ((PostVideo) postagem);
            post.adicionaVideo(video);
            post.posta();
            post.comenta("Que beleza!");
            post.printAtributos();
        } catch (Error e) {
            System.out.println("Erro ao tentar comentar no vídeo: " + e);
        }

    }

    public static void videoInvalidoTeste() {
        try {
            Video video = new Video("video.uhg", 45, 65);
            Postavel postagem = PostavelFactory.getPostavel("POSTVIDEO");
            PostVideo post = ((PostVideo) postagem);
            post.adicionaVideo(video);
            post.posta();
            post.comenta("Que beleza!");
            post.printAtributos();
        } catch (Error e) {
            System.out.println("Erro ao enviar vídeo: " + e);
        }
    }

    public static void fotoInvalidaTeste() {
        try {
            Postavel postagem = PostavelFactory.getPostavel("POSTFOTO");
            PostFoto post = ((PostFoto) postagem);
            post.setLocalizacao("Cidade Universitária, Fundão - Rio de Janeiro");
            Foto foto = new Foto("foto.cjd", "25px");
            post.adicionaFoto(foto);
            post.posta();
            post.comenta("Lindo!!😘");
            post.printAtributos();
        } catch (Error e) {
            System.out.println("Erro ao enviar fpoto: " + e);

        }
    }

    public static void teste() {
        int i = 5;
        while (i != 0) {
            i--;
            throw new Error();
        }
    }

    public static void main(String[] args) {
        System.out.println("------------------------Bem vindos ao-----------------------------");
        System.out.println("Iniciando execuçao dos testes \n\n");
        ExecucaoTeste.postagemTextoTeste();
        System.out.println("\n1.Tentativa de postagem com um vídeo atribuído\n");
        ExecucaoTeste.postagemComVideoTeste();
        System.out.print("\n2.Tentativa de postagem sem vídeo\n");
        ExecucaoTeste.postagemSemVideoTeste();
        System.out.println("\n3.Tentativa de postagem sem foto\n");
        ExecucaoTeste.postagemSemFotoTeste();
        System.out.println("\n4.Tentativa de postagem com 5 fotos atribuídas\n");
        ExecucaoTeste.postagemComCincoFotosTeste();
        System.out.println("\n5.Tentativa de postagem com 11 fotos atribuídas\n");
        ExecucaoTeste.postagemComOnzeFotosTeste();
        System.out.println("\n6.Tentativa de criação de comentário em uma postagem com foto\n");
        ExecucaoTeste.comentarioPostFotoTeste();
        System.out.println("\n7.Tentativa de criação de comentário em uma postagem com vídeo\n");
        ExecucaoTeste.comentarioPostVideoTeste();
        System.out.println("\n8.Tentativa de criação de vídeo inválida\n");
        ExecucaoTeste.videoInvalidoTeste();
        System.out.println("\n9.Tentativa de criação de foto inválida\n");
        ExecucaoTeste.fotoInvalidaTeste();

    }
}
