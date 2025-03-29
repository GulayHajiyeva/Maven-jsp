package Teacher.service;

import Teacher.entity.Teacher;
import Teacher.repo.TeacherRepo;
import common.RunnableAsMenu;

import java.util.List;
import java.util.Scanner;

public class TeacherMenuService implements RunnableAsMenu {

private final TeacherRepo repo = new TeacherRepo();
    @Override
    public  void initialize()
    {
        System.out.println("Neçə müəllim daxil edəcəksiniz?");
        int count= new Scanner(System.in).nextInt();

        for (int i = 0; i < count; i++) {
            System.out.println("Qeydiyyat nömrəsi:"+(i+1));
            repo.insert(requireAndCreate());
        }
       printAll();
    }
    @Override
    public  void initializeNew()
    {
        System.out.println("Neçə nəfər əlavə etmək istəyirsiniz?");
        int additionalCount= new Scanner(System.in).nextInt();
        for (int i = 0; i < additionalCount; i++) {
            repo.insert(requireAndCreate());
        }
    }
    @Override
    public  void update()
    {
        System.out.println("Neçənci müəllimin məlumatını yeniləmək istəyirsən?");
        int teacherId= new Scanner(System.in).nextInt();
        Teacher teacher= repo.findById(teacherId);
        System.out.println("Hansı məlumatını yeniləmək istəyirsən?");
        String updatedField = new Scanner(System.in).nextLine();
        if(updatedField.equals("name")){
            System.out.println("Yeni adı daxil edin:");
            teacher.setName(new Scanner(System.in).nextLine());
        } else if (updatedField.equals("surname")){
            System.out.println("Yeni soyadı daxil edin:");
            teacher.setSurname(new Scanner(System.in).nextLine());
        }else if (updatedField.equals("salary")){
            System.out.println("Yeni soyadı daxil edin:");
            teacher.setSalary(new Scanner(System.in).nextDouble());
        }else if (updatedField.equals("subject")){
            System.out.println("Yeni fənni daxil edin:");
            teacher.setSubject(new Scanner(System.in).nextLine());
        }
        repo.update(teacher);
    }
    @Override
    public  void delete(){
        System.out.println("Neçənci müəllimi qeydiyyatdan çıxarmaq istəyirsiniz?");
        int deletedTeacher= new Scanner(System.in).nextInt();
       Teacher teacher = new Teacher();
       teacher.setId(deletedTeacher);
       repo.delete(teacher);
    }
    @Override
    public  void printAll()
    {
        List<Teacher> teachers = repo.getList();
        System.out.println("Qeydiyyata alınan müəllimlər:");
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println((i+1)+""+teachers.get(i));
        }
    }
    @Override
    public  void find()
    {

        System.out.println("Axtarmaq istədiyiniz müəllimin adını və ya soyadını daxil edin:");
        String searchedTeacher = new Scanner(System.in).nextLine();
        List<Teacher> teachers =repo.getList(searchedTeacher,searchedTeacher);
        for (Teacher teacher: teachers) {
            System.out.println(teacher);
        }

    }
    private  Teacher requireAndCreate(){
        Teacher teacher = new Teacher();

        System.out.println("Müəllimin adını daxil edin:");
        teacher.setName(new Scanner(System.in).nextLine());;

        System.out.println("Müəllimin soyadını daxil edin:");
        teacher.setSurname(new Scanner(System.in).nextLine());

        System.out.println("Müəllimin fənnini daxil edin:");
        teacher.setSubject(new Scanner(System.in).nextLine());

        System.out.println("Müəllimin maaşını daxil edin:");
        teacher.setSalary(new Scanner(System.in).nextDouble());

        return teacher;
    }





}
