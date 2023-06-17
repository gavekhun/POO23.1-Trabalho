package Postagem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import Recurso.Video;

public class PostVideo implements Postavel {

  private Video video;
  private LocalDateTime data_postagem;
  private ArrayList<Comentario> lista_comentarios = new ArrayList<Comentario>();
  private int qtde_fixados;

  public PostVideo(boolean incluirVideo) {
    if (incluirVideo == false) {
      this.data_postagem = LocalDateTime.now();
    }
  }

  public boolean adicionaVideo(Video video) {
    if (video != null) {
      this.video = video;
      return true;
    }
    this.pritnErro("É necessário informar um video para ser postado");
    return false;
  }

  @Override
  public boolean posta() {
    if (this.video != null) {
      this.data_postagem = LocalDateTime.now();
    }
    pritnErro("Nenhum vídeo foi selecionado");
    return false;
  }

  @Override
  public boolean comenta(boolean fixado, int tamanho, String texto) {
    try {
      Comentario comentario = new Comentario(fixado, tamanho, texto);
      this.lista_comentarios.add(comentario);
      this.printAtributos();
      return true;
    } catch (NullPointerException e) {
      System.out.println("Erro ao adicionar comentário. Tente novamente.");
      return false;
    }
  }

  private void printAtributos() {
    System.out.println("Dados do vídeo :" + this.video.toString() + "\nData da postagem: " + this.data_postagem
        + "\nQuantidade de comentários Fixados: "
        + this.qtde_fixados);
    System.out.println("Comentários do post");
    for (Comentario coment : this.lista_comentarios) {
      System.out.println(coment.toString());
    }
  }

  private void pritnErro(String msg) {
    System.out.println("Não foi possível concluir a solicitação. Motivo: " + msg);
  }
}