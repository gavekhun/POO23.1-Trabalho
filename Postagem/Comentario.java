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
  public void setFixado(boolean fixado){
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
    System.out.println("----------------------------------------");
    return "Comentario { " + "\nData: " + this.data + "\nfixado " + this.fixado + "\ntamanho: " + getTamanho()
        + "\ntexto: " + this.texto + "}";
  }

}