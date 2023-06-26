package Singleton;

import java.util.ArrayList;

import Postagem.Postavel;

public class FeedSingleton {
    private static FeedSingleton instance;
    private ArrayList<Postavel> postavels;

    private FeedSingleton() {
        postavels = new ArrayList<>();
    }

    public static FeedSingleton getInstance() {
        if (instance == null) {
            instance = new FeedSingleton();
        }
        return instance;
    }

    public void adicionarPostagem(Postavel post) {
        postavels.add(post);
    }
    public void updatePostagensFeed(ArrayList<Postavel> postagens){
        this.postavels = postagens;
    }

    public ArrayList<Postavel> getPostavels(){
        return this.postavels;
    }

    public void exibirFeed() {
        try {
            if (postavels.isEmpty()) {
                System.out.println("Nenhuma postagem encontrada");
            } else {
                System.out.println("=================POSTAGENS==================" + postavels.size());

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
