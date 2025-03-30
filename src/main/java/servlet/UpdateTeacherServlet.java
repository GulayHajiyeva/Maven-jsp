package servlet;

import Teacher.entity.Teacher;
import Teacher.repo.TeacherRepo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateTeacherServlet")
public class UpdateTeacherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int teacherId = Integer.parseInt(request.getParameter("id"));


        TeacherRepo teacherRepo = new TeacherRepo();
        Teacher teacher = teacherRepo.findById(teacherId);


        request.setAttribute("teacher", teacher);
        request.getRequestDispatcher("updateTeacher.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int teacherId = Integer.parseInt(request.getParameter("id"));


        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String subject = request.getParameter("subject");
        double salary = Double.parseDouble(request.getParameter("salary"));


        TeacherRepo teacherRepo = new TeacherRepo();
        Teacher teacher = teacherRepo.findById(teacherId);

        teacher.setName(name);
        teacher.setSurname(surname);
        teacher.setSubject(subject);
        teacher.setSalary(salary);

        teacherRepo.update(teacher);


        response.sendRedirect("myservlet");
    }
}
