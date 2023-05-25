public class Video extends Recurso{
  protected int frame_rate;
  protected int duracao;

  public boolean validaUrlRecurso(){
    if (url_recurso == ".mp4" || ".mov" || ".wmv"){
      return true;

    }
    else{
      return false;
    }
  }
}