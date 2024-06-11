package designPattern.observer;

public class Main {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();
        NewsOutlet outlet1 = new NewsOutlet("Outlet 1");
        NewsOutlet outlet2 = new NewsOutlet("Outlet 2");
        newsAgency.addObserver(outlet1);
        newsAgency.addObserver(outlet2);
        newsAgency.publishNews("Breaking: New discovery in space!");
    }
}
