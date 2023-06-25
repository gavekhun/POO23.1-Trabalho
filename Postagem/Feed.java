package Postagem;

import java.util.ArrayList;

public class Feed {
    private static Feed instance;
    private ArrayList<Postavel> postavels;

    private Feed() {
        postavels = new ArrayList<>();
    }

    public static Feed getInstance() {
        if (instance == null) {
            instance = new Feed();
        }
        return instance;
    }

    public void adicionarPostagem(Postavel post) {
        postavels.add(post);
    }

    public void exibirFeed() {
        try {
            if (postavels.isEmpty()) {
                System.out.println("Nenhuma postagem encontrada");
            } else {
                System.out.println("=================POSTAGENS==================");
                for (Postavel post : postavels) {
                    System.out.println(post.toString());
                }
                System.out.println("============================================");
            }
        } catch (Error error) {
            System.out.println("error: " + error);
        }
    }
}
