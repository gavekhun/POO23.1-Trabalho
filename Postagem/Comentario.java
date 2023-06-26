package Postagem;

import java.time.LocalDateTime;

public class Comentario {

  protected LocalDateTime data;
  protected boolean fixado;
  protected String texto;
  protected int tamanho;

  public Comentario(String texto) {
    this.data = LocalDateTime.now();
    this.fixado = false;
    this.tamanho = texto.length();
    this.texto = texto;
  }

  public LocalDateTime getDate() {
    return this.data;
  }

  public boolean getFixado() {
    return this.fixado;
  }

  public void setFixado(boolean fixado) {
    this.fixado = fixado;

  }

  public int getTamanho() {
    return this.tamanho = texto.length();
  }

  public String getTexto() {
    return this.texto;
  }

  @Override
  public String toString() {
    StringBuilder comentario = new StringBuilder();
    comentario.append("\n-_-_-_-_-_-_-_-_-_-_");
    comentario.append("\nComentário { " + "\nData: " + this.data + "\nfixado " + this.fixado
        + (this.fixado ? ": Sim" : ": Não") + "\ntamanho: " + getTamanho()
        + "\ntexto: " + this.texto + "\n}");
    comentario.append("\n-_-_-_-_-_-_-_-_-_-_");

    return comentario.toString();
  }

}