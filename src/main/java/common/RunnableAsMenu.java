package common;


import java.util.Scanner;

public interface RunnableAsMenu {
    default  void showMenu()
    {
        System.out.println("Hansı əməliyyatı seçmək istəyirsiniz:");
        System.out.println(
                " 0.İlk dəfə yaratmaq \n" +
                        " 1.Yenisini yaratmaq \n" +
                        " 2.Yeniləmək \n" +
                        " 3.Silmək \n " +
                        " 4.Axtarmaq \n" +
                        " 5.Hamısını görmək");
        int action = new Scanner(System.in).nextInt();

        if (action == 0) {
            initialize();
        } else if (action == 1) {
            initializeNew();
        } else if (action == 2) {
            update();
        } else if (action == 3) {
            delete();
        } else if (action == 4) {
            find();
        } else if (action == 5) {
            printAll();
        }
    }
      void initialize();
      void initializeNew( );
      void update();
      void delete();
      void printAll();
      void find();


}
