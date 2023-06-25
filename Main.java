import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Factory.PostavelFactory;

import Postagem.PostFoto;
import Postagem.PostVideo;
import Postagem.Postavel;
import Recurso.Foto;
import Recurso.Video;

public class Main {
    public static void main(String[] args) {
        List<Postavel> postavels = new ArrayList<>();     
        Scanner entrada = new Scanner(System.in); 
        int opcao;  
       
        do{
            exibirMenu();
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch(opcao){
                case 1:
                criarPostSemFoto(entrada, postavels);
                break;
                case 2:
                criarPostComFoto(entrada, postavels);
                break;

                case 3:
                criarPostComVideo(entrada, postavels);
                break;

                case 4:
                comentar(entrada, postavels);
                break;

                case 5:
                System.out.println("Encerrando o programa...");
                break;
                default:
                System.out.println("Opção inválida!!!!!!!!!!!!!!!!!!!!!!!!");
                break;

            }

        } while(opcao != 5);

       
       
    }    

    private static void exibirMenu(){
        System.out.println("------------------------Bem vindos ao-----------------------------");
        System.out.println("           \u2580\u2588\u2580\u2500\u2588\u2580\u2580\u2500\u2588\u2500\u2588\u2500\u2580\u2588\u2580\u2500 \u2500 \u2588\u2584\u2500\u2588\u2500\u2584\u2580\u2580\u2584\u2500\u2588\u2500\u2500\u2500\u2588\u2500");
        System.out.println("           \u2500\u2588\u2500\u2500\u2588\u2580\u2580\u2500\u2584\u2580\u2584\u2500\u2500\u2588\u2500\u2500 \u2500 \u2588\u2500\u2580\u2588\u2500\u2588\u2500\u2500\u2588\u2500\u2588\u2500\u2588\u2500\u2588\u2500\r");
        System.out.println("           \u2500\u2588\u2500\u2500\u2580\u2580\u2580\u2500\u2580\u2500\u2580\u2500\u2500\u2588\u2500\u2500 \u2500 \u2580\u2500\u2500\u2580\u2500\u2500\u2580\u2580\u2500\u2500\u2500\u2580\u2500\u2580\u2500\u2500");
        System.out.println("----Selecione uma opção:");
        System.out.println("----(1) Criar uma postagem sem foto (2) Criar uma postagem com foto");
        System.out.println("----(3) Criar uma postagem com video (4) Comentar em uma postagem");
        System.out.println("----(5) Sair.");
    }
    private static void criarPostSemFoto(Scanner entrada, List<Postavel> postavels){
        System.out.println("De onde você é?");
        String localizacao = entrada.nextLine();
        System.out.println("O que você está pensando?");
        String descricao = entrada.nextLine();

        Postavel postagem = PostavelFactory.getPostavel("POSTFOTO", false, localizacao);
        ((PostFoto) postagem).postSemFoto(localizacao, descricao);
        postavels.add(postagem);
        if(((PostFoto) postagem).postSemFoto(localizacao, descricao)){
            System.out.println("\\033[92m");
            System.out.println(" Postagem criada com sucesso!");
        }

    }
    private static void criarPostComFoto(Scanner entrada, List<Postavel> postavels){
        System.out.println("De onde você é?");
        String localizacao = entrada.nextLine();
        System.out.println("Digite a url da foto:");
        String url = entrada.nextLine();
        System.out.println("Digite a resolução da foto:");
        String resolucao = entrada.nextLine();
        Foto foto = new Foto(url, resolucao);


        Postavel postagem = PostavelFactory.getPostavel("POSTFOTO", false, localizacao);
        ((PostFoto) postagem).adicionaFoto(foto);
        postagem.posta();

        postavels.add(postagem);

        if(postagem.posta()){
            System.out.println("\\033[92mPostagem criada com sucesso!");
        }
        else{
            System.out.println("Error: Não foi possível");
        }


    }
    private static void criarPostComVideo(Scanner entrada, List<Postavel> postavels){
        System.out.println("De onde você é?");
        String localizacao = entrada.nextLine();
        System.out.println("Digite a url do vídeo: ");
        String url = entrada.nextLine();
        System.out.println("Digite o frame rate do vídeo:(Número) ");
        int frame = entrada.nextInt();
        System.out.println("Digite a duração do vídeo:(Número) ");
        int duracao = entrada.nextInt();

        Video video = new Video(url, frame, duracao);

        Postavel postagem = PostavelFactory.getPostavel("POSTVIDEO", true, localizacao);
        ((PostVideo) postagem).adicionaVideo(video);
        postagem.posta();

        postavels.add(postagem);

        if(postagem.posta()){
            System.out.println("\\\\033[92m");
            System.out.println("Postagem criada com sucesso!");
        }


    }
    private static void comentar(Scanner entrada, List<Postavel> postavels){
        System.out.println("Selecione a postagem que queira comentar!");

        for( int i=0; i < postavels.size(); i++){
            System.out.println(i + 1 + ". " + postavels.get(i));
        }
        int iPost = entrada.nextInt();

        if(iPost < 1 || iPost > postavels.size()){
            System.out.println("Postagem inválida");
            
        }

        Postavel postagemSelect = postavels.get(iPost - 1);
        System.out.println("Digite seu comentário:");
        String comentario = entrada.nextLine();

        postagemSelect.comenta(comentario);

        if(postagemSelect.comenta(comentario)){
            System.out.println("\\033[92mComentário adicionado com sucesso!");
        }

    }
    
}
