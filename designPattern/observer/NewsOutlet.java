package designPattern.observer;

public class NewsOutlet implements Observer {
    private String name;
    public NewsOutlet(String name) {
        this.name = name;
    }
    @Override
    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}
