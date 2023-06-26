package Postagem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import Recurso.Foto;

public class PostFoto extends Post implements Postavel {

    private int qtde_fotos;
    private ArrayList<Foto> fotos = new ArrayList<Foto>();
    private String localizacao;
    private LocalDateTime data_postagem;
    private ArrayList<Comentario> lista_comentarios = new ArrayList<Comentario>();
    private int qtde_fixados;
    private String descricao;

    public PostFoto() {
    }

    public boolean adicionaFoto(Foto foto) {
        if (foto == null) {
            this.pritnErro("É necessário informar uma foto para ser inserida na lista");
            return false;
        }
        if (this.validaQuantFoto()) {
            this.fotos.add(foto);
            this.qtde_fotos += 1;
            return true;
        }

        throw new Error("Não é possível adicionar mais de 10 fotos na lista!");
    }

    private boolean validaQuantFoto() {
        if (this.fotos.size() < 10) {
            return true;
        }
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

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;

    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public void setData_postagem(LocalDateTime data_postagem) {
        this.data_postagem = LocalDateTime.now();
    }

    public void fixaComenta(int index) {
        if (index >= 0 && index < lista_comentarios.size()) {
            Comentario comentario = lista_comentarios.get(index);
            comentario.setFixado(true);
            lista_comentarios.remove(index);
            lista_comentarios.add(qtde_fixados, comentario);
            qtde_fixados++;
        }
    }

    public void desfixaComenta(int index) {
        if (index >= 0 && index < qtde_fixados) {
            Comentario comentario = lista_comentarios.get(index);
            comentario.setFixado(false);
            lista_comentarios.remove(index);
            lista_comentarios.add(comentario);
            qtde_fixados--;
        }

    }

    @Override
    public int getId(){
        return this.ID;
    }

    @Override
    public boolean posta() {
        if (this.fotos.size() > 0) {
            this.data_postagem = LocalDateTime.now();            
            Post.prox_ID += 1;
            return true;
        }
        throw new Error("Nenhuma foto adicionada ao post");
    }

    @Override
    public boolean comenta(String texto) {
        if (this.data_postagem == null) {
            throw new Error("Foto(s) ainda não postada(s)");
        }
        try {
            Comentario comentario = new Comentario(texto);
            this.lista_comentarios.add(comentario);
            return true;
        } catch (Error e) {
            System.out.println("Erro ao adicionar comentário. Tente novamente." + e);
            return false;
        }
    }

    public void printAtributos() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("ID da postagem: " + this.ID + "\nQuantidade de fotos: " + this.qtde_fotos
                + "\nData da postagem: " + this.data_postagem
                + "\nLocalização: " + this.getLocalizacao() + "\nQuantidade de comentários Fixados: "
                + this.qtde_fixados);
        if (this.descricao != null) {
            System.out.println("Descrição: " + this.descricao);
        }
        System.out.println("Fotos adicionadas ao post: ");
        for (Foto foto : this.fotos) {
            System.out.println(foto.toString());
        }
        System.out.println("Comentários do post: ");
        for (Comentario coment : this.lista_comentarios) {
            System.out.println(coment.toString());
        }
        System.out.println("------------------------------------------------------------------------");

    }

    public String toString() {
        StringBuilder post = new StringBuilder();
        post.append("\n------------------------------------------------------------------------");
        post.append("\nID: " + this.ID + "\nQuantidade de fotos: " + this.qtde_fotos +
                "\nData da postagem: " + this.data_postagem + "\nLocalização: " + this.getLocalizacao()
                + "\nQuantidade de comentários fixados: " + this.qtde_fixados);
        if (this.descricao != null) {
            post.append("Descrição: " + this.descricao);
        }
        post.append("\nFotos: ");
        for (Foto foto : this.fotos) {
            post.append(foto.toString());
        }
        post.append("\nComentários:");
        for (Comentario coment : this.lista_comentarios) {
            post.append(coment.toString());
        }
        post.append("\n------------------------------------------------------------------------");
        return post.toString();
    }

    private void pritnErro(String msg) {
        System.out.println("Não foi possível concluir a solicitação. Motivo: " + msg);
    }

    
}
