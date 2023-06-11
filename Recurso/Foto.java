package Recurso;

public class Foto extends Recurso {

  protected String resolucao;

  public Foto(String url_recurso, String resolucao) {

    this.url_recurso = url_recurso;
    this.resolucao = resolucao;
    prox_ID += 1;

  }

  @Override
  public boolean validaUrlRecurso(String url_recurso) {
    String[] extensao = url_recurso.split("\\.");

    if (extensao[1].equals("jpg"))
      return true;
    else if (extensao[1].equals("png"))
      return true;
    else if (extensao[1].equals("bmp"))
      return true;
    this.pritnErro("Extensão inválida. Selecionar .jpg, .png ou .bmp");
    return false;
  }

  public void getInfo() {
    System.out.println(
        "ID: " + this.ID + "\nResolução: " + this.resolucao + "\nValidado? " + this.validaUrlRecurso(url_recurso));
  }

  private void pritnErro(String msg) {
    System.out.println("Não foi possível concluir a solicitação. Motivo: " + msg);
  }
}