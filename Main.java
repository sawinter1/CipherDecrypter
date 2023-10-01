import static Methods.MethodsForMain.*;

public class Main {
    public static void main(String[] args) {
        instructions();
        while(true) {
            if(run()) break;
        }

        goodbye();
    }
}