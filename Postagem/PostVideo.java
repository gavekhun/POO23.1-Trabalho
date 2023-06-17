package Postagem;

import java.time.LocalDateTime;
import java.util.ArrayList;

import Recurso.Video;

public class PostVideo implements Postavel {

  private Video video;
  private LocalDateTime data_postagem;
  private ArrayList<Comentario> lista_comentarios;
  private int qtde_fixados;

  // public PostVideo(boolean incluirVideo) {
  //   if (incluirVideo == false) {
  //     this.data_postagem = LocalDateTime.now();
  //   }
  // }
  public PostVideo(){
    this.data_postagem = LocalDateTime.now();
    this.lista_comentarios = new ArrayList<>();
    this.qtde_fixados= 0;
  }

  public boolean adicionaVideo(Video video) {
    this.video = video;
    return true;
  }

  @Override
  public boolean posta() {
    if (this.video != null) {
      this.data_postagem = LocalDateTime.now();
      return true;
    }
    pritnErro("Nenhum vídeo foi selecionado");
    return false;
  }

  @Override
  public boolean comenta() {
    Comentario comentario = new Comentario(LocalDateTime.now(),false, "Comentário inicial");
    this.lista_comentarios.add(comentario);
    
    return true;
  }

  private void pritnErro(String msg) {
    System.out.println("Não foi possível concluir a solicitação. Motivo: " + msg);
  }
}