<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="Teacher.repo.TeacherRepo" %>
<%@ page import="Teacher.entity.Teacher" %>
<%@ page import="java.util.List" %>  <!-- Import java.util.List -->
<%@ page import="java.util.ArrayList" %>

<html>
<body>
    <h2>List of Teachers</h2>

    <%

        TeacherRepo tp = new TeacherRepo();


        List<Teacher> teachers = tp.getList();


        for (Teacher teacher : teachers) {
            out.println("<p>" + teacher.getName() + "</p>");
        }
    %>

</body>
</html>
