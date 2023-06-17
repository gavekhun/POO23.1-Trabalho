package Postagem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import Recurso.Foto;

public class PostFoto implements Postavel {

    private int qtde_fotos;
    private ArrayList<Foto> fotos = new ArrayList<Foto>();
    private String localizacao;
    private LocalDateTime data_postagem;
    private ArrayList<Comentario> lista_comentarios = new ArrayList<Comentario>();
    private int qtde_fixados;

    public PostFoto(boolean incluirFoto, String localizacao) {
        if (incluirFoto == false) {
            this.data_postagem = LocalDateTime.now();
            this.localizacao = localizacao;
        }
    }

    public boolean adicionaFoto(Foto foto) {
        if (foto != null) {
            this.fotos.add(foto);
            this.qtde_fotos += 1;
            return true;
        }
        this.pritnErro("É necessário informar uma foto para ser inserida na lista");

        return false;
    }

    public boolean removeFoto(Foto foto) {
        if (foto != null) {
            this.fotos.remove(foto);
            this.qtde_fotos -= 1;
            return true;
        }
        this.pritnErro("É necessário informar uma foto para ser removida da lista");
        return false;
    }

    public int getQtde_Fotos() {
        return this.qtde_fotos;
    }

    public ArrayList<Foto> getFotos() {
        return this.fotos;
    }

    public String getLocalizacao() {
        return this.localizacao != null ? this.localizacao : "Nenhuma localização adicionada";
    }

    public ArrayList<Comentario> getComentarios() {
        return this.lista_comentarios;
    }

    public LocalDateTime getData_Postagem() {
        return this.data_postagem;
    }

    public int getQtde_Fixados() {
        return this.qtde_fixados;
    }

    @Override
    public boolean posta() {
        if (this.fotos.size() >= 1 && this.fotos.size() <= 10) {
            this.data_postagem = LocalDateTime.now();
            return true;
        }
        this.pritnErro("Quantidade de fotos deve estar entre 1 e 10");
        return false;
    }

    @Override
    public boolean comenta(boolean fixado, int tamanho, String texto) {
        try {
            Comentario comentario = new Comentario(fixado, tamanho, texto);
            this.lista_comentarios.add(comentario);
            this.printAtributos();
            return true;
        } catch (NullPointerException e) {
            System.out.println("Erro ao adicionar comentário. Tente novamente.");
            return false;
        }
    }

    private void printAtributos() {
        System.out.println("Quantidade de fotos :" + this.qtde_fotos + "\nData da postagem: " + this.data_postagem
                + "\nLocalizacao: " + this.getLocalizacao() + "\nQuantidade de comentários Fixados: "
                + this.qtde_fixados);
        System.out.println("Fotos adicionadas ao post :");
        for (Foto foto : this.fotos) {
            System.out.println(foto.toString());
        }
        System.out.println("Comentários do post");
        for (Comentario coment : this.lista_comentarios) {
            System.out.println(coment.toString());
        }
    }

    private void pritnErro(String msg) {
        System.out.println("Não foi possível concluir a solicitação. Motivo: " + msg);
    }

}
