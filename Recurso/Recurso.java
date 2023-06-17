package Recurso;
public abstract class Recurso{

  protected final int ID=prox_ID;
  protected String url_recurso;
  public static int prox_ID=1;

  public int getID(){
    return ID;
  }

  public String getUrlRecurso(){
    return url_recurso;
  }

 

  public abstract boolean validaUrlRecurso();

}