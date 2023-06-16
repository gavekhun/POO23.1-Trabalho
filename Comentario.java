import java.sql.Date;

public class Comentario{

  protected DateTime data;
  protected boolean fixado;
  protected int tamanho;
  protected String texto;

  public interface DateTime{

    public abstract Date returnDate();
  }

  
}