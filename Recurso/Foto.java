package Recurso;

public class Foto extends Recurso {

  protected String resolucao;

  public Foto(String url_recurso, String resolucao) {
    if (validaUrlRecurso(url_recurso)) {
      this.url_recurso = url_recurso;
      this.resolucao = resolucao;
      prox_ID += 1;
    }

  }

  @Override
  public boolean validaUrlRecurso(String url_recurso) {

    if (url_recurso.endsWith(".jpg")) {

      return true;

    } else if (url_recurso.endsWith(".png")) {

      return true;
    } else if (url_recurso.endsWith(".bmp")) {

      return true;
    }
    this.pritnErro("Extensão inválida. Selecionar .jpg, .png ou .bmp");
    return false;
  }

  @Override
  public String toString() {
    return "Foto {" + "ID: " + this.ID + "\nResolução: " + this.resolucao + "\nValidado? "
        + this.validaUrlRecurso(url_recurso) + "}";
  }

  private void pritnErro(String msg) {
    System.out.println("Não foi possível concluir a solicitação. Motivo: " + msg);
  }
}