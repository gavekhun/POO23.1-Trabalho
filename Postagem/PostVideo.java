package Postagem;

import java.time.LocalDateTime;
import java.util.ArrayList;

import Recurso.Video;

public class PostVideo implements Postavel {

  private Video video;
  private LocalDateTime data_postagem;
  private ArrayList<Comentario> lista_comentarios = new ArrayList<Comentario>();

  public PostVideo(boolean incluirVideo) {
    if (incluirVideo == false) {
      this.data_postagem = LocalDateTime.now();
    }
  }

  public boolean adicionaVideo(Video video) {
    this.video = video;
    return posta();
  }

  @Override
  public boolean posta() {
    if (this.video != null) {
      this.data_postagem = LocalDateTime.now();
    }
    pritnErro("Nenhum vídeo foi selecionado");
    return false;
  }

  // @Override
  // public boolean comenta(){
  // Comentario comentario = new Comentario();
  // this.lista_comentarios.add(comentario);
  // return true;
  // }

  private void pritnErro(String msg) {
    System.out.println("Não foi possível concluir a solicitação. Motivo: " + msg);
  }
}