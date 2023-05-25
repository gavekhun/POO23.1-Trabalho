public abstract class Recurso{

  protected final int ID=Prox_ID;
  protected String url_recurso;
  public static int Prox_ID=1;

  public abstract boolean validaUrlRecurso(){
    if (url_recurso == true){
      return true
    }
    else{
      return false
    }
    
  }

}