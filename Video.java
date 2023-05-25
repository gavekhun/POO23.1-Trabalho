public class Video extends Recurso{
  protected int frame_rate;
  protected int duracao;

  public Video(String url_recurso, int frame_rate, int duracao){
    this.url_recurso = url_recurso;
    this.frame_rate = frame_rate;
    this.duracao = duracao;
  }

  public boolean validaUrlRecurso(){
    if (url_recurso == ".mp4" || ".mov" || ".wmv"){
      return true;

    }
    else{
      return false;
    }
  }
}