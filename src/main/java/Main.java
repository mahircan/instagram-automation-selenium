import java.util.Scanner;

public class Main {


    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {



        System.out.println("PlEASE ENTER YOUR E-MAIL ADDRESS: ");
        String userName = scanner.nextLine();

        System.out.println("PlEASE ENTER YOUR PASSWORD: ");
        String password = scanner.nextLine();

        System.out.println("PlEASE ENTER YOUR TARGET PROFILE: ");
        String targetProfile = scanner.nextLine();

        App app= new App();
        app.loginWith(userName, password);
        app.navigateToProfile(targetProfile);
        app.clickFirstPost();
        app.likeAllPost();
    }
}
