public class Comentario{

  public DateTime data;
  public boolean fixado;
  public int tamanho;
  public String texto;

  public Comentario(DateTime data, boolean fixado, int tamanho, String texto){
    this.data = data;
    this.fixado = fixado;
    this.tamanho = tamanho;
    this.texto = texto;
  }
}