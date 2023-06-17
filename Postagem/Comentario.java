package Postagem;

import java.time.LocalDateTime;

public class Comentario {

  protected LocalDateTime data;
  protected boolean fixado;
  protected int tamanho;
  protected String texto;

  public Comentario(boolean fixado, int tamanho, String texto) {
    this.data = LocalDateTime.now();
    this.fixado = fixado;
    this.tamanho = tamanho;
    this.texto = texto;
  }

  public LocalDateTime getDate() {
    return this.data;
  }

  public boolean getFixado() {
    return this.fixado;
  }

  public int getTamanho() {
    return this.tamanho;
  }

  public String getTexto() {
    return this.texto;
  }

  @Override
  public String toString() {
    return "Comentario {" + "data: '" + this.data + "\nfixado " + this.fixado + "\ntamanho: " + this.tamanho
        + "\ntexto: " + this.texto;
  }

}