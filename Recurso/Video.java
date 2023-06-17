package Recurso;

public class Video extends Recurso {
  protected int frame_rate;
  protected int duracao;

  public Video(String url_recurso, int frame_rate, int duracao) {
    if (validaUrlRecurso(url_recurso)) {
      this.url_recurso = url_recurso;
      this.frame_rate = frame_rate;
      this.duracao = duracao;
      prox_ID += 1;

    }
  }

  @Override
  public boolean validaUrlRecurso(String url_recurso) {

    String[] extensao = url_recurso.split("\\.");

    if (extensao[1].equals("mp4")) {
      System.out.println(this.toString());
      return true;
    } else if (extensao[1].equals("mov")) {
      System.out.println(this.toString());

      return true;
    } else if (extensao[1].equals("wmv")) {
      System.out.println(this.toString());

      return true;
    }
    this.pritnErro("O vídeo precisa ter uma das extensões: .mp4, .mov ou .wmv");
    return false;

  }

  @Override
  public String toString() {
    return "Video { " + "ID: " + this.ID + "\nURL: " + this.url_recurso + "\nValidado? "
        + this.validaUrlRecurso(url_recurso) + " }";
  }

  public void getInfo() {
    System.out
        .println("ID: " + this.ID + "\nURL: " + this.url_recurso + "\nValidado? " + this.validaUrlRecurso(url_recurso));
  }

  private void pritnErro(String msg) {
    System.out.println("Não foi possível concluir a solicitação. Motivo: " + msg);
  }
}