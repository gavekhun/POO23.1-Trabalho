public class Foto extends Recurso{

  protected String resolucao;

  public Foto(String url_recurso, String resolucao){

    this.url_recurso = url_recurso;
    this.resolucao = resolucao;
  }

  public boolean validaUrlRecurso(){
    if(url_recurso == ".jpg" || ".png" || ".bmp"){
      return true;
    }
    else{
      return false;
    }
  }
}