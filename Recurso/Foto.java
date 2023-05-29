package Recurso;
public class Foto extends Recurso{

  protected String resolucao;

  public Foto(String url_recurso, String resolucao){

    this.url_recurso = url_recurso;
    this.resolucao = resolucao;
  }

  @Override
  public boolean validaUrlRecurso(String url_recurso){
    String[] extensao = url_recurso.split("\\.");

    if(extensao[1].equals("jpg")) return true;
    else if(extensao[1].equals("png")) return true;
    else if(extensao[1].equals("bmp")) return true;
    else return false;
  }
  public void getInfo(){
    System.out.println("ID: "+ this.ID + "\nResolução: " + this.resolucao + "\nValidado? " + this.validaUrlRecurso(url_recurso));
  }
}