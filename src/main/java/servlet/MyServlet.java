package servlet;

import Teacher.repo.TeacherRepo;
import Teacher.entity.Teacher;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myservlet")
public class MyServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private TeacherRepo teacherRepo;

        public void init() {
            teacherRepo = new TeacherRepo();
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");

            if (action != null && action.equals("insert")) {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String subject = request.getParameter("subject");
                double salary = Double.parseDouble(request.getParameter("salary"));

                Teacher newTeacher = new Teacher();
                newTeacher.setName(name);
                newTeacher.setSurname(surname);
                newTeacher.setSubject(subject);
                newTeacher.setSalary(salary);

                teacherRepo.insert(newTeacher);
                response.sendRedirect("test.jsp");
            } else if (action != null && action.equals("update")) {
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

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");

            if (action != null && action.equals("delete")) {
                int teacherId = Integer.parseInt(request.getParameter("id"));
                Teacher teacher = new Teacher();
                teacher.setId(teacherId);
                teacherRepo.delete(teacher);
                response.sendRedirect("myservlet");
                return;
            } else if (action != null && action.equals("update")) {
                int teacherId = Integer.parseInt(request.getParameter("id"));
                TeacherRepo teacherRepo = new TeacherRepo();
                Teacher teacher = teacherRepo.findById(teacherId);
                request.setAttribute("teacher", teacher);
                request.getRequestDispatcher("updateTeacher.jsp").forward(request, response);
            }
            List<Teacher> teachers = teacherRepo.getList();
            request.setAttribute("teachers", teachers);

            request.getRequestDispatcher("test.jsp").forward(request, response);



        }
    }

