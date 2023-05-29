package Recurso;
public class Video extends Recurso{
  protected int frame_rate;
  protected int duracao;



  public Video(String url_recurso, int frame_rate, int duracao){
    this.url_recurso = url_recurso;
    this.frame_rate = frame_rate;
    this.duracao = duracao;
    Prox_ID+=1;
  }
  @Override
  public boolean validaUrlRecurso(String url_recurso){

    String[] extensao = url_recurso.split("\\.");

    if(extensao[1].equals("mp4")) return true;
    else if(extensao[1].equals("mov")) return true;
    else if(extensao[1].equals("wmv")) return true;
    else return false;
    

   
  }
  public void getInfo(){
    System.out.println("ID: " + this.ID + "\nURL: " + this.url_recurso + "\nValidado? " + this.validaUrlRecurso(url_recurso));
  }

 
}