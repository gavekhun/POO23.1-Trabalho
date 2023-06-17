package Postagem;
import java.time.LocalDateTime;

public class Comentario {

  protected LocalDateTime data;
  protected boolean fixado;
  protected int tamanho;
  protected String texto; 
  

  public Comentario(LocalDateTime data, boolean fixado, String texto, int tamanho) {    
    this.data = LocalDateTime.now();
    this.fixado = fixado;
    this.tamanho = texto.length();
    this.texto = texto;
  }

  public String getTexto(){
    return texto;
  }

  public void setTexto(String texto){
    this.texto = texto;
  }

  public LocalDateTime getData(){
    return data;
  }

  public int getTamanho(){
    return tamanho;
  }
  public boolean isFixado(){
    return fixado;
  }
  public void setFixado(boolean fixado){
    this.fixado = fixado;

  }
}