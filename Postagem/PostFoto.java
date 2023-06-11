package Postagem;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;

import Recurso.Foto;

public class PostFoto implements Postavel {

    private int qtde_fotos;
    private ArrayList<Foto> fotos = new ArrayList<Foto>();
    private String localizacao;
    private LocalDateTime data_postagem;
    private ArrayList<Comentario> lista_comentarios = new ArrayList<Comentario>();

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

    @Override
    public boolean posta() {
        if (this.fotos.size() >= 1 && this.fotos.size() <= 10) {
            this.data_postagem = LocalDateTime.now();
            return true;
        }
        this.pritnErro("Quantidade de fotos deve estar entre 1 e 10");
        return false;
    }



    // @Override
    // public boolean comenta() {
    // }


    private void pritnErro(String msg){
        System.out.println("Não foi possível concluir a solicitação. Motivo: " + msg );
    }

}
