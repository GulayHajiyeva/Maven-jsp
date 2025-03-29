import Teacher.service.TeacherMenuService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private final static TeacherMenuService service = new TeacherMenuService();

    public static void main(String[] args) {
        while (true) {
            service.showMenu();
        }
    }
}