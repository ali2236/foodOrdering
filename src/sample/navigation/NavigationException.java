package sample.navigation;

public class NavigationException extends RuntimeException {
    public NavigationException(){}
    public NavigationException(String massage){
        super(massage);
    }
}
