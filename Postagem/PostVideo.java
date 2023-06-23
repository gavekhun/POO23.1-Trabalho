package Postagem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import Recurso.Video;

public class PostVideo extends Post implements Postavel {

  private Video video;
  private LocalDateTime data_postagem;
  private ArrayList<Comentario> lista_comentarios = new ArrayList<Comentario>();
  private int qtde_fixados;

  public PostVideo() {

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
      Post.prox_ID += 1;
      return true;
    }
    throw new Error("Nenhum vídeo foi adicionado");
  }

  @Override
  public boolean comenta(String texto) {
    if (this.data_postagem == null) {
      throw new Error("O vídeo ainda não foi postado");
    }
    try {
      Comentario comentario = new Comentario(texto);
      this.lista_comentarios.add(comentario);
      return true;
    } catch (NullPointerException e) {
      System.out.println("Erro ao adicionar comentário. Tente novamente.");
      return false;
    }
  }

  public Video getVideo() {
    return this.video;
  }

  public void printAtributos() {
    Video video = this.video;
    System.out.println("ID da postagem: " + this.ID + "\nDados do vídeo: " + (video != null ? video.toString() : "Nenhum video adicionado")
        + "\nData da postagem: " + this.data_postagem
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