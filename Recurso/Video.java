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

    if (url_recurso.endsWith(".mp4")) {
      return true;
    } else if (url_recurso.endsWith(".mov")) {
      return true;
    } else if (url_recurso.endsWith(".wmv")) {
      return true;
    }
    throw new Error("Extensão inválida. O vídeo precisa ter uma das extensões: .mp4, .mov ou .wmv");

  }

  @Override
  public String toString() {
    StringBuilder video = new StringBuilder();
    video.append("\n-_-_-_-_-_-_-_-_-_-_");
    video.append("\nVideo { " + "ID: " + this.ID + "\nURL: " + this.url_recurso + "\nValidado: "
        + (this.validaUrlRecurso(url_recurso) ? "Sim" : "Não") + " \n}");
    video.append("\n-_-_-_-_-_-_-_-_-_-_");
    return video.toString();
  }

}