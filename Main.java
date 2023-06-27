import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import Factory.PostavelFactory;
import Postagem.Comentario;
import Postagem.PostFoto;
import Postagem.PostVideo;
import Postagem.Postavel;
import Recurso.Foto;
import Recurso.Video;
import Singleton.FeedSingleton;

public class Main {
    protected static FeedSingleton feed = FeedSingleton.getInstance();

    public static void main(String[] args) {

        int opcao;

        do {
            exibirMenu();
            Scanner entrada = new Scanner(System.in);
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch (opcao) {
                case 1:
                    try {
                        criarPostComFoto(entrada);

                        break;

                    } catch (Error error) {
                        System.out.println("Error: " + error);
                    }
                case 2:
                    try {
                        criarPostComVideo(entrada);
                        break;

                    } catch (Error error) {
                        System.out.println("Erro: " + error);
                    }

                case 3:
                    try {
                        comentar(entrada);

                        break;

                    } catch (Error error) {
                        System.out.println("Erro: " + error);
                    }

                case 4:
                    try {
                        exibirFeed();
                        break;
                    } catch (Error error) {
                        System.out.println("Erro: " + error);
                    }

                case 5:
                    try {
                        fixarComentario(entrada);
                        break;

                    } catch (Error error) {
                        System.out.println("Erro: " + error);
                    }
                case 6:
                    try {
                        desfixarComentario(entrada);
                        break;

                    } catch (Error error) {
                        System.out.println("Erro: " + error);
                    }
                case 7:
                    try {
                        excluirPostagem(entrada);
                        break;

                    } catch (Error error) {
                        System.out.println("Erro: " + error);
                    }

                case 8:
                    System.out.println("Encerrando o programa!");
                    break;

                default:
                    System.out.println("Opção inválida!!!!!!!!!!!!!!!!!!!!!!!!");
                    break;

            }

        } while (opcao != 8);

    }

    private static void exibirMenu() {
        System.out.println("\n------------------------Bem vindos ao-----------------------------");
        System.out.println(
                "           \u2580\u2588\u2580\u2500\u2588\u2580\u2580\u2500\u2588\u2500\u2588\u2500\u2580\u2588\u2580\u2500 \u2500 \u2588\u2584\u2500\u2588\u2500\u2584\u2580\u2580\u2584\u2500\u2588\u2500\u2500\u2500\u2588\u2500");
        System.out.println(
                "           \u2500\u2588\u2500\u2500\u2588\u2580\u2580\u2500\u2584\u2580\u2584\u2500\u2500\u2588\u2500\u2500 \u2500 \u2588\u2500\u2580\u2588\u2500\u2588\u2500\u2500\u2588\u2500\u2588\u2500\u2588\u2500\u2588\u2500\r");
        System.out.println(
                "           \u2500\u2588\u2500\u2500\u2580\u2580\u2580\u2500\u2580\u2500\u2580\u2500\u2500\u2588\u2500\u2500 \u2500 \u2580\u2500\u2500\u2580\u2500\u2500\u2580\u2580\u2500\u2500\u2500\u2580\u2500\u2580\u2500\u2500");
        System.out.println("Selecione uma opção:\n");
        System.out.println(
                " (1) Criar uma postagem com foto\n (2) Criar uma postagem com video\n (3) Comentar em uma postagem\n (4) Exibir feed\n (5) Fixar Comentário\n (6) Desfixar Comenário\n (7) Excluir postagem\n (8) Sair");
    }

    private static void exibirFeed() {
        feed.exibirFeed();

    }

    private static void criarPostComFoto(Scanner entrada) {
        try {

            System.out.println("De onde você é?");
            String localizacao = entrada.nextLine();
            Postavel postagem = PostavelFactory.getPostavel("POSTFOTO");
            PostFoto post = ((PostFoto) postagem);
            post.setLocalizacao(localizacao);

            int cont = 1;

            while (cont < 11) {
                try {
                    System.out.println(
                            "Digite a url da foto " + cont + " (ou digite 'postar' para postar a(s) foto(s)):");
                    String url = entrada.nextLine();

                    if (url.equals("postar")) {
                        break;

                    }

                    System.out.println("Digite a resolução da foto " + cont + ":");
                    String resolucao = entrada.nextLine();

                    Foto foto = new Foto(url, resolucao);
                    post.adicionaFoto(foto);

                    cont++;

                } catch (Error error) {
                    System.out.println("Error ao adicionar foto: " + error.getMessage());

                }

            }
            post.posta();
            post.printAtributos();

            feed.adicionarPostagem(post);

        } catch (Error error) {
            System.out.println("Erro ao criar a postagem: " + error);
        }catch (InputMismatchException err) {
            System.out.println("Erro ao criar a postagem: " + err);

        }

    }

    private static void criarPostComVideo(Scanner entrada) {
        try {

            System.out.println("Digite a url do vídeo: ");
            String url = entrada.nextLine();
            System.out.println("Digite o frame rate do vídeo:(Número) ");
            int frame = entrada.nextInt();
            System.out.println("Digite a duração do vídeo:(Número) ");
            int duracao = entrada.nextInt();
            Video video = new Video(url, frame, duracao);
            Postavel postagem = PostavelFactory.getPostavel("POSTVIDEO");
            PostVideo post = ((PostVideo) postagem);

            post.adicionaVideo(video);
            post.posta();
            post.printAtributos();
            feed.adicionarPostagem(post);

        } catch (Error err) {
            System.out.println("Erro ao criar a postagem: " + err);
        } catch (InputMismatchException err) {
            System.out.println("Erro ao criar a postagem: " + err);

        }
    }

    private static void comentar(Scanner entrada) {
        try {
            exibirFeed();
            ArrayList<Postavel> postavels = getPostavels();

            if (postavels.isEmpty()) {
                return;
            }
            System.out.println("Selecione a postagem que queira comentar!");

            int iPost = entrada.nextInt();
            entrada.nextLine();
            int finded = -1;
            for (Postavel post : postavels) {
                if (post.getId() == iPost) {
                    finded = postavels.indexOf(post);
                    break;
                }
            }
            if (finded == -1) {
                System.out.println("Postagem inválida");
                return;
            }

            Postavel postagemSelect = postavels.get(finded);
            System.out.println("Digite seu comentário: ");
            String comentario = entrada.nextLine();

            postagemSelect.comenta(comentario);

        } catch (Error error) {
            System.out.println("Erro ao comentar: " + error);
        } catch (InputMismatchException err) {
            System.out.println("Erro ao criar a postagem: " + err);

        }

    }

    private static void fixarComentario(Scanner entrada) {
        try {
            ArrayList<Postavel> postavels = getPostavels();

            exibirFeed();
            if (postavels.isEmpty()) {
                System.out.println("Não há postagens disponiveis.");
            }

            System.out.println("Selecione a postagem em que deseja fixar um comentário");
            int idPost = entrada.nextInt();
            entrada.nextLine();

            int finded = -1;
            for (Postavel post : postavels) {
                if (post.getId() == idPost) {
                    finded = postavels.indexOf(post);
                    break;
                }
            }
            if (finded == -1) {
                System.out.println("Postagem inválida");
                return;
            }

            Postavel postSelect = postavels.get(finded);
            if (postSelect instanceof PostFoto) {
                try {
                    PostFoto postFoto = (PostFoto) postSelect;

                    ArrayList<Comentario> comentarios = postFoto.getComentarios();
                    if (comentarios.isEmpty()) {
                        System.out.println("A postagem não possui comentários");
                        return;
                    }

                    System.out.println("Selecione o comentário que deseja fixar: ");
                    int indexComment = entrada.nextInt();
                    entrada.nextLine();

                    if (indexComment < 1 || indexComment > comentarios.size()) {
                        System.out.println("Comentário não encontrado.");
                        return;
                    }

                    // Comentario comentario = comentarios.get(indexComment - 1);
                    // comentario.setFixado(true);
                    postFoto.fixaComenta(indexComment - 1);

                    System.out.println("Comentário fixado!");

                } catch (Error error) {
                    System.out.println("Um erro inesperado: " + error);
                }
            } else if (postSelect instanceof PostVideo) {
                try {
                    PostVideo postVideo = (PostVideo) postSelect;

                    ArrayList<Comentario> comentarios = postVideo.getComentarios();
                    if (comentarios.isEmpty()) {
                        System.out.println("A postagem não possui comentários.");
                    }
                    System.out.println("Selecione o comentário que você quer fixar:");
                    int indexComment = entrada.nextInt();
                    entrada.nextLine();

                    if (indexComment < 1 || indexComment > comentarios.size()) {
                        System.out.println("Comentário invalido.");
                        return;
                    }
                    // Comentario comentario = comentarios.get(indexComment - 1);
                    // comentario.setFixado(true);
                    postVideo.fixaComenta(indexComment - 1);
                    System.out.println("Comentário fixado.");
                } catch (Error error) {
                    System.out.println("Um erro inesperado: " + error);
                }

            } else {
                System.out.println("A postagem não é do tipo PostFoto ou PostVideo.");
            }

        } catch (Error error) {
            System.out.println("Erro: " + error);
        } catch (InputMismatchException err) {
            System.out.println("Erro ao criar a postagem: " + err);

        }

    }

    private static void desfixarComentario(Scanner entrada) {
        try {
            ArrayList<Postavel> postavels = getPostavels();

            exibirFeed();
            if (postavels.isEmpty()) {
                System.out.println("Não há postagens disponiveis.");
            }

            System.out.println("Selecione a postagem em que deseja desfixar um comentário");
            int idPost = entrada.nextInt();
            entrada.nextLine();

            int finded = -1;
            for (Postavel post : postavels) {
                if (post.getId() == idPost) {
                    finded = postavels.indexOf(post);
                    break;
                }
            }
            if (finded == -1) {
                System.out.println("Postagem inválida");
                return;
            }

            Postavel postSelect = postavels.get(finded);
            if (postSelect instanceof PostFoto) {
                try {
                    PostFoto postFoto = (PostFoto) postSelect;

                    ArrayList<Comentario> comentarios = postFoto.getComentarios();
                    if (comentarios.isEmpty()) {
                        System.out.println("A postagem não possui comentários");
                        return;
                    }

                    System.out.println("Selecione o comentário que deseja desfixar: ");
                    int indexComment = entrada.nextInt();
                    entrada.nextLine();

                    if (indexComment < 1 || indexComment > comentarios.size()) {
                        System.out.println("Comentário não encontrado.");
                        return;
                    }

                    // Comentario comentario = comentarios.get(indexComment - 1);
                    // comentario.setFixado(false);
                    postFoto.desfixaComenta(indexComment - 1);
                    System.out.println("Comentário fixado!");

                } catch (Error error) {
                    System.out.println("Um erro inesperado: " + error);
                }
            } else if (postSelect instanceof PostVideo) {
                try {
                    PostVideo postVideo = (PostVideo) postSelect;

                    ArrayList<Comentario> comentarios = postVideo.getComentarios();
                    if (comentarios.isEmpty()) {
                        System.out.println("A postagem não possui comentários.");
                    }
                    System.out.println("Selecione o comentário que você quer desfixar:");
                    int indexComment = entrada.nextInt();
                    entrada.nextLine();

                    if (indexComment < 1 || indexComment > comentarios.size()) {
                        System.out.println("Comentário invalido.");
                        return;
                    }
                    // Comentario comentario = comentarios.get(indexComment - 1);
                    // comentario.setFixado(false);
                    postVideo.desfixaComenta(indexComment - 1);
                    System.out.println("Comentário fixado.");
                } catch (Error error) {
                    System.out.println("Um erro inesperado: " + error);
                }

            } else {
                System.out.println("A postagem não é do tipo PostFoto ou PostVideo.");
            }

        } catch (Error error) {
            System.out.println("Erro: " + error);
        } catch (InputMismatchException err) {
            System.out.println("Erro ao criar a postagem: " + err);

        }
    }

    private static void excluirPostagem(Scanner entrada) {
        try {
            ArrayList<Postavel> postavels = getPostavels();
            exibirFeed();
            if (postavels.isEmpty()) {
                System.out.println("Não há postagens disponiveis.");
                return;
            }
            System.out.println("Selecione o ID postagem que você deseja excluir");
            int id = entrada.nextInt();
            Postavel finded = null;
            for (Postavel post : postavels) {
                System.out.println("ID" + post.getId());
                if (post.getId() == id) {
                    finded = (post);
                    break;
                }
            }
            if (finded == null) {
                System.out.println("ID não encontrado! Por favor, insira um ID válido!");
                return;
            }
            System.out.println("finded " + finded);
            postavels.remove(finded);
            System.out.println(postavels.toString());
            System.out.print("Postagem deletada com sucesso!");
            return;
        } catch (Error error) {
            System.out.println("Erro: " + error);
        } catch (InputMismatchException err) {
            System.out.println("Erro ao criar a postagem: " + err);

        }

    }

    private static ArrayList<Postavel> getPostavels() {
        return Main.feed.getPostavels();
    }

}
