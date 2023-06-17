package Recurso;

import javax.print.event.PrintEvent;

public class Foto extends Recurso {

  protected String resolucao;

  public Foto(String url_recurso, String resolucao) {

    this.url_recurso = url_recurso;
    this.resolucao = resolucao;
    prox_ID += 1;

  }

  public String getResolucao() {
    return resolucao;
  }

  @Override
  public boolean validaUrlRecurso() {
    String url = getUrlRecurso();
    if (url.endsWith(".jpg") || url.endsWith(".png") || url.endsWith(".bmp"))
      return true;
    this.pritnErro("Extensão inválida. Selecione outra extensão '.jpg', '.png' ou '.bmp'");
      return false;

  }

  // @Override
  // public boolean validaUrlRecurso() {
  // String[] extensao = url_recurso.split("\\.");

  // if (extensao[1].equals("jpg"))
  // return true;
  // else if (extensao[1].equals("png"))
  // return true;
  // else if (extensao[1].equals("bmp"))
  // return true;
  // this.pritnErro("Extensão inválida. Selecionar .jpg, .png ou .bmp");
  // return false;
  // }

  private void pritnErro(String msg) {
    System.out.println("Não foi possível concluir a solicitação. Motivo: " + msg);
  }
}