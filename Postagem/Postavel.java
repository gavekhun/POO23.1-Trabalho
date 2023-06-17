package Postagem;

public interface Postavel {

    public abstract boolean posta();

    public abstract boolean comenta(boolean fixado, int tamanho, String texto);

}
