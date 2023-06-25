import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import Factory.PostavelFactory;
import Postagem.Comentario;
import Postagem.Feed;
import Postagem.PostFoto;
import Postagem.PostVideo;
import Postagem.Postavel;
import Recurso.Foto;
import Recurso.Video;

public class Main {
    private static ArrayList<Postavel> postavels = new ArrayList<>();
    private static Feed feed = Feed.getInstance();

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch (opcao) {
                case 1:
                    try {
                        criarPostSemFoto(entrada, postavels);

                        break;

                    } catch (Error error) {
                        System.out.println("Error: " + error);
                    }
                case 2:
                    try {
                        criarPostComFoto(entrada, postavels);

                        break;

                    } catch (Error error) {
                        System.out.println("Erro: " + error);
                    }

                case 3:
                    try {
                        criarPostComVideo(entrada, postavels);

                        break;

                    } catch (Error error) {
                        System.out.println("Erro: " + error);
                    }

                case 4:
                    try {
                        comentar(entrada, postavels);
                        break;
                    } catch (Error error) {
                        System.out.println("Erro: " + error);
                    }

                case 5:
                    try {
                        exibirFeed();
                        break;

                    } catch (Error error) {
                        System.out.println("Erro: " + error);
                    }
                case 6:
                    try {
                        fixarComentario(entrada);
                        break;

                    } catch (Error error) {
                        System.out.println("Erro: " + error);
                    }

                case 7:
                    try {
                        desfixarComentario(entrada);
                        break;

                    } catch (Error error) {
                        System.out.println("Error: " + error);
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
        System.out.println("------------------------Bem vindos ao-----------------------------");
        System.out.println(
                "           \u2580\u2588\u2580\u2500\u2588\u2580\u2580\u2500\u2588\u2500\u2588\u2500\u2580\u2588\u2580\u2500 \u2500 \u2588\u2584\u2500\u2588\u2500\u2584\u2580\u2580\u2584\u2500\u2588\u2500\u2500\u2500\u2588\u2500");
        System.out.println(
                "           \u2500\u2588\u2500\u2500\u2588\u2580\u2580\u2500\u2584\u2580\u2584\u2500\u2500\u2588\u2500\u2500 \u2500 \u2588\u2500\u2580\u2588\u2500\u2588\u2500\u2500\u2588\u2500\u2588\u2500\u2588\u2500\u2588\u2500\r");
        System.out.println(
                "           \u2500\u2588\u2500\u2500\u2580\u2580\u2580\u2500\u2580\u2500\u2580\u2500\u2500\u2588\u2500\u2500 \u2500 \u2580\u2500\u2500\u2580\u2500\u2500\u2580\u2580\u2500\u2500\u2500\u2580\u2500\u2580\u2500\u2500");
        System.out.println("----Selecione uma opção:");
        System.out.println("----(1) Criar uma postagem sem foto (2) Criar uma postagem com foto");
        System.out.println("----(3) Criar uma postagem com video (4) Comentar em uma postagem");
        System.out.println("----(5) Exibir feed (6) Fixar Comentário (7) Desfixar Comentário" +
                "\n----(8) Sair.");
    }

    private static void exibirFeed() {
        feed.exibirFeed();

    }

    private static void criarPostSemFoto(Scanner entrada, ArrayList<Postavel> postavels) {
        try {
            System.out.println("De onde você é?");
            String localizacao = entrada.nextLine();
            System.out.println("O que você está pensando?");
            String descricao = entrada.nextLine();

            Postavel postagem = PostavelFactory.getPostavel("POSTFOTO");
            PostFoto post = ((PostFoto) postagem);
            post.setDescricao(descricao);
            post.setLocalizacao(localizacao);
            post.setData_postagem(LocalDateTime.now());
            post.printAtributos();
            postavels.add(post);
            feed.adicionarPostagem(post);
        } catch (Error error) {
            System.out.println("Erro ao criar a postagem: " + error);
        }

    }

    private static void criarPostComFoto(Scanner entrada, ArrayList<Postavel> postavels) {
        try {
            System.out.println("De onde você é?");
            String localizacao = entrada.nextLine();
            Postavel postagem = PostavelFactory.getPostavel("POSTFOTO");
            PostFoto post = ((PostFoto) postagem);
            post.setLocalizacao(localizacao);

            boolean addFotos = true;
            int cont = 1;

            while (addFotos) {
                try {
                    System.out.println("Digite a url da foto" + cont + "(ou 'sair' para finalizar):");
                    String url = entrada.nextLine();

                    if (url.equals("sair")) {
                        addFotos = false;
                        continue;
                    }

                    System.out.println("Digite a resolução da foto" + cont + ":");
                    String resolucao = entrada.nextLine();

                    Foto foto = new Foto(url, resolucao);
                    post.adicionaFoto(foto);

                    cont++;

                    if (cont > 11) {
                        System.out.println("Limite máximo de 11 fotos atingidas.");
                        break;
                    }
                } catch (Error error) {
                    System.out.println("Error ao adicionar foto: " + error.getMessage());

                }

            }
            post.posta();
            post.printAtributos();

            postavels.add(post);
            feed.adicionarPostagem(post);

        } catch (Error error) {
            System.out.println("Erro ao criar a postagem: " + error);
        }

    }

    private static void criarPostComVideo(Scanner entrada, ArrayList<Postavel> postavels) {
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
            postavels.add(post);
            feed.adicionarPostagem(post);

        } catch (Error error) {
            System.out.println("Erro ao criar a postagem: " + error);
        }
    }

    private static void comentar(Scanner entrada, ArrayList<Postavel> postavels) {
        try {
            exibirFeed();
            if (postavels.isEmpty()) {
                return;
            }
            System.out.println("Selecione a postagem que queira comentar!");

            int iPost = entrada.nextInt();
            entrada.nextLine();

            if (iPost < 1 || iPost > postavels.size()) {
                System.out.println("Postagem inválida");

            }

            Postavel postagemSelect = postavels.get(iPost - 1);
            System.out.println("Digite seu comentário: ");
            String comentario = entrada.nextLine();

            postagemSelect.comenta(comentario);

        } catch (Error error) {
            System.out.println("Erro ao comentar: " + error);
        }

    }

    private static void fixarComentario(Scanner entrada) {
        try {
            exibirFeed();
            if (postavels.isEmpty()) {
                System.out.println("Não há postagens disponiveis.");
            }

            System.out.println("Selecione a postagem em que deseja fixar um comentário");
            int indexPost = entrada.nextInt();
            entrada.nextLine();

            if (indexPost < 1 || indexPost > postavels.size()) {
                System.out.println("Postagem invalida");
                return;
            }

            Postavel postSelect = postavels.get(indexPost - 1);
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

                    if (indexComment < 1 || indexPost > comentarios.size()) {
                        System.out.println("Comentário invalido.");
                        return;
                    }

                    Comentario comentario = comentarios.get(indexComment - 1);
                    comentario.setFixado(true);

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
                    Comentario comentario = comentarios.get(indexComment - 1);
                    comentario.setFixado(true);

                    System.out.println("Comentário fixado.");
                } catch (Error error) {
                    System.out.println("Um erro inesperado: " + error);
                }

            } else {
                System.out.println("A postagem não é do tipo PostFoto ou PostVideo.");
            }

        } catch (Error error) {
            System.out.println("Erro: " + error);
        }

    }

    private static void desfixarComentario(Scanner entrada) {
        try {
            exibirFeed();
            if (postavels.isEmpty()) {
                System.out.println("Não há postagens disponiveis.");
            }

            System.out.println("Selecione a postagem em que deseja desfixar um comentário");
            int indexPost = entrada.nextInt();
            entrada.nextLine();

            if (indexPost < 1 || indexPost > postavels.size()) {
                System.out.println("Postagem invalida");
                return;
            }

            Postavel postSelect = postavels.get(indexPost - 1);
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

                    if (indexComment < 1 || indexPost > comentarios.size()) {
                        System.out.println("Comentário invalido.");
                        return;
                    }

                    Comentario comentario = comentarios.get(indexComment - 1);
                    comentario.setFixado(false);

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
                    Comentario comentario = comentarios.get(indexComment - 1);
                    comentario.setFixado(false);

                    System.out.println("Comentário fixado.");
                } catch (Error error) {
                    System.out.println("Um erro inesperado: " + error);
                }

            } else {
                System.out.println("A postagem não é do tipo PostFoto ou PostVideo.");
            }

        } catch (Error error) {
            System.out.println("Erro: " + error);
        }

    }

    
    // private static void removerFotos(Scanner entrada) {
    //     exibirFeed();
    //     if (postavels.isEmpty()) {
    //         System.out.println("Não há postagens");
    //     }

    //     System.out.println("Selecione a postagem que você quer remover a foto:");
    //     int foto = entrada.nextInt();
    //     entrada.nextLine();

    //     if (foto < 1 || foto > postavels.size()) {
    //         System.out.println("Postagem invalida!");
    //         return;
    //     }

    //     Postavel postSelect = postavels.get(foto - 1);

    //     if (postSelect instanceof PostFoto) {
    //         PostFoto postFoto = (PostFoto) postSelect;
    //         ArrayList<Foto> fotos = postFoto.getFotos();
    //         if (fotos.isEmpty()) {
    //             System.out.println("Sem fotos para serem removidas!");
    //             return;
    //         }

    //         System.out.println("Selecione a foto que queira remover:");
    //         int indexFoto = entrada.nextInt();
    //         entrada.nextLine();
    //         if (indexFoto < 1 || indexFoto > fotos.size()) {
    //             System.out.println("Foto invalida");
    //             return;
    //         }
    //         boolean removido = postFoto.removeFoto(indexFoto - 1);

    //     }
    // }

}
