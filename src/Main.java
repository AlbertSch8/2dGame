import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            Hra.Hra();
        } catch (Exception e) {
            System.err.println("Došlo k výjimce: " + e.getMessage());
            e.printStackTrace();
        }
    }
}