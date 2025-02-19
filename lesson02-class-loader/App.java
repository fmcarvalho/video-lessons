import static java.lang.System.out;
import static java.lang.System.console;

public class App {
    public static void main(String[] args) {
        out.println("Press ENTER to proceed.");
        console().readLine();
        new X().print();
    }

    public static void bar() {
        new Y().print();
    }
}
