<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="Teacher.repo.TeacherRepo" %>
<%@ page import="Teacher.entity.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Form with Bootstrap</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%

    if (request.getParameter("action") != null && request.getParameter("action").equals("delete")) {
        int teacherId = Integer.parseInt(request.getParameter("id"));
        TeacherRepo tp = new TeacherRepo();
        Teacher teacher = new Teacher();
        teacher.setId(teacherId);
        tp.delete(teacher); // Delete the teacher
        response.sendRedirect("test.jsp");
        return;
    }


    if (request.getParameter("action") != null && request.getParameter("action").equals("insert")) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String subject = request.getParameter("subject");
        double salary = Double.parseDouble(request.getParameter("salary"));

        Teacher newTeacher = new Teacher();
        newTeacher.setName(name);
        newTeacher.setSurname(surname);
        newTeacher.setSubject(subject);
        newTeacher.setSalary(salary);

        TeacherRepo tp = new TeacherRepo();
        tp.insert(newTeacher);  // Insert the new teacher into the database
        response.sendRedirect("test.jsp");
        return;
    }
%>

<div class="container mt-5">
    <h2 class="mb-4">Insert New Teacher</h2>
    <form action="test.jsp" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" name="name" placeholder="Enter name" required>
        </div>
        <div class="mb-3">
            <label for="surname" class="form-label">Surname</label>
            <input type="text" class="form-control" name="surname" placeholder="Enter surname" required>
        </div>
        <div class="mb-3">
            <label for="subject" class="form-label">Subject</label>
            <input type="text" class="form-control" name="subject" placeholder="Enter subject" required>
        </div>
        <div class="mb-3">
            <label for="salary" class="form-label">Salary</label>
            <input type="number" class="form-control" name="salary" placeholder="Enter salary" required>
        </div>
        <input type="hidden" name="action" value="insert">
        <button type="submit" class="btn btn-success">Insert</button>
    </form>


    <h3 class="mt-5">Teacher List</h3>
    <table class="table table-bordered" id="resultTable">
       <thead>
           <tr>
               <th>Name</th>
               <th>Surname</th>
               <th>Subject</th>
               <th>Salary</th>
               <th>Actions</th>
           </tr>
       </thead>
       <tbody>
           <%
               TeacherRepo tp = new TeacherRepo();
               List<Teacher> teachers = tp.getList();

               for (Teacher teacher : teachers) {
           %>
               <tr>
                   <td><%= teacher.getName() %></td>
                   <td><%= teacher.getSurname() %></td>
                   <td><%= teacher.getSubject() %></td>
                   <td><%= teacher.getSalary() %></td>
                   <td>
                      <a href="updateTeacher.jsp?id=<%= teacher.getId() %>" class="btn btn-warning">Update</a>
                      <a href="?action=delete&id=<%= teacher.getId() %>" class="btn btn-danger">Delete</a>
                  </td>
               </tr>
           <%
               }
           %>
       </tbody>
   </table>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
