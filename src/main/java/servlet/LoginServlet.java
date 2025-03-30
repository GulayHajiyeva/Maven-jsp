package servlet;
import Teacher.repo.TeacherRepo;
import Teacher.entity.Teacher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TeacherRepo teacherRepo;

    public void init() {
        teacherRepo = new TeacherRepo();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");


        Teacher teacher = teacherRepo.findByNameAndSurname(name, surname);

        if (teacher != null) {

            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", teacher);

            response.sendRedirect("myservlet");
        } else {

            request.setAttribute("error", "Invalid name or surname.");
            request.getRequestDispatcher("login").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
