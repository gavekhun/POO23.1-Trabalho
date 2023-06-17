package Postagem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Scanner;

import Recurso.Foto;
import Postagem.Comentario;

public class PostFoto implements Postavel {

    private int qtde_fotos;
    private ArrayList<Foto> fotos;
    private String localizacao;
    private LocalDateTime data_postagem;
    private ArrayList<Comentario> lista_comentarios;
    private int qtde_fixados;

    // public PostFoto(boolean incluirFoto, String localizacao) {
    // if (incluirFoto == false) {
    // this.data_postagem = LocalDateTime.now();
    // this.localizacao = localizacao;
    // this.lista_comentarios = new ArrayList<>();
    // }
    // }
    public PostFoto() {
        this.qtde_fotos = 0;
        this.fotos = new ArrayList<>();
        this.localizacao = "";
        this.data_postagem = LocalDateTime.now();
        this.qtde_fixados = 0;
        this.lista_comentarios = new ArrayList<>();
    }

    public boolean adicionaFoto(Foto foto) {
        if (foto != null) {
            this.fotos.add(foto);
            this.qtde_fotos++;
            return true;
        }
        this.pritnErro("É necessário informar uma foto para ser inserida na lista");

        return false;
    }

    public boolean removeFoto(Foto foto) {
        if (foto != null) {
            this.fotos.remove(foto);
            this.qtde_fotos--;
            return true;
        }
        this.pritnErro("É necessário informar uma foto para ser removida da lista");
        return false;
    }

    // public boolean addComentario(Comentario comentario){
    // if(comentario != null){
    // this.lista_comentarios.add(comentario);
    // return true;
    // }
    // this.pritnErro("É necessário adicionar um comentário");
    // return false;

    // }

    @Override
    public boolean posta() {
        if ((qtde_fotos) >= 1 && (qtde_fotos) <= 10) {
            data_postagem = LocalDateTime.now();            
            return true;
        }
        this.pritnErro("Quantidade de fotos deve estar entre 1 e 10");
        return false;
    }

    @Override
    public boolean comenta() {
        LocalDateTime dataComentario = LocalDateTime.now();
        String texto = "";
        int tamanhoComentario = texto.length();
        Comentario comentario = new Comentario(dataComentario, false, texto, tamanhoComentario);
        lista_comentarios.add(comentario);
        return true;
    }

    public void fixaComentario(int index){
        if(index >= 0 && index < lista_comentarios.size()){

        }

    }

    public int getQtdeFotos() {
        return qtde_fotos;
    }

    public ArrayList<Foto> getFotos() {
        return fotos;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;

    }

    public LocalDateTime getDataPostagem() {
        return data_postagem;
    }

    public ArrayList<Comentario> getComentarios() {
        return lista_comentarios;
    }
    public int getQtdeFixados(){
        return qtde_fixados;
    }



    private void pritnErro(String msg) {
        System.out.println("Não foi possível concluir a solicitação. Motivo: " + msg);
    }

}
