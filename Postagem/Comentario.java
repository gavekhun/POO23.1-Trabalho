package Postagem;
import java.time.LocalDateTime;

public class Comentario {

  protected LocalDateTime data;
  protected boolean fixado;
  protected int tamanho;
  protected String texto;

  public Comentario(LocalDateTime data, boolean fixado, int tamanho, String texto) {
    this.data = data;
    this.fixado = fixado;
    this.tamanho = tamanho;
    this.texto = texto;
  }
}