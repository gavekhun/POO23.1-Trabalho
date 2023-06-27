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
  public int getId() {
    return this.ID;
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

  public ArrayList<Comentario> getComentarios() {
    return this.lista_comentarios;
  }

  public void printAtributos() {
    Video video = this.video;
    System.out.println("------------------------------------------------------------------------");
    System.out.println("ID da postagem: " + this.ID + "\nDados do vídeo: "
        + (video != null ? video.toString() : "Nenhum video adicionado")
        + "\nData da postagem: " + this.data_postagem
        + "\nQuantidade de comentários Fixados: "
        + this.qtde_fixados);
    System.out.println("Comentários do post");
    for (Comentario coment : this.lista_comentarios) {
      System.out.println(coment.toString());
    }
    System.out.println("------------------------------------------------------------------------");
  }

  public String toString() {
    StringBuilder post = new StringBuilder();
    post.append("\n------------------------------------------------------------------------");
    post.append("\nID da postagem: " + this.ID + "\nDados do vídeo: "
        + (video != null ? video.toString() : "Nenhum video adicionado")
        + "\nData da postagem: " + this.data_postagem
        + "\nQuantidade de comentários Fixados: "
        + this.qtde_fixados);
    post.append("\nComentários do post: ");
    for (Comentario coment : this.lista_comentarios) {
      post.append(coment.toString());
    }
    post.append("\n------------------------------------------------------------------------");
    return post.toString();

  }

  public void fixaComenta(int index) {
    if (index >= 0 && index < lista_comentarios.size()) {
      Comentario comentario = lista_comentarios.get(index);
      comentario.setFixado(true);
      lista_comentarios.remove(index);
      lista_comentarios.add(qtde_fixados, comentario);
      qtde_fixados++;
    }
  }

  public void desfixaComenta(int index) {
    if (index >= 0 && index < qtde_fixados) {
      Comentario comentario = lista_comentarios.get(index);
      comentario.setFixado(false);
      lista_comentarios.remove(index);
      lista_comentarios.add(comentario);
      qtde_fixados--;
    }

  }

  private void pritnErro(String msg) {
    System.out.println("Não foi possível concluir a solicitação. Motivo: " + msg);
  }
}