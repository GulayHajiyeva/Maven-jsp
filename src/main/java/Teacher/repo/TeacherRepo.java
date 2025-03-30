package Teacher.repo;

import Teacher.entity.Teacher;
import common.CommonRepo;
import common.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TeacherRepo implements CommonRepo<Teacher> {


    @Override
    public void insert(Teacher teacher) {
        String query = "INSERT INTO teachers (name, surname, subject, salary) VALUES (?, ?, ?, ?)";
        try (Connection conn = MyDatabase.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, teacher.getName());
            stmt.setString(2, teacher.getSurname());
            stmt.setString(3, teacher.getSubject());
            stmt.setDouble(4, teacher.getSalary());
            stmt.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Teacher findById(int id) {
        Teacher teacher = null;
        String query = "SELECT * FROM teachers WHERE id = ?";
        try (Connection conn = MyDatabase.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setName(rs.getString("name"));
                teacher.setSurname(rs.getString("surname"));
                teacher.setSubject(rs.getString("subject"));
                teacher.setSalary(rs.getDouble("salary"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return teacher;
    }

    @Override
    public List<Teacher> getList(String name, String surname) {
        return null;
    }

    @Override
    public List<Teacher> getList() {
        List<Teacher> teachers = new ArrayList<>();
        String query = "SELECT * FROM teachers";
        try (Connection conn = MyDatabase.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setName(rs.getString("name"));
                teacher.setSurname(rs.getString("surname"));
                teacher.setSubject(rs.getString("subject"));
                teacher.setSalary(rs.getDouble("salary"));
                teachers.add(teacher);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return teachers;
    }

    public void update(Teacher teacher) {
        String query = "UPDATE teachers SET name = ?, surname = ?, subject = ?, salary = ? WHERE id = ?";
        try (Connection conn = MyDatabase.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, teacher.getName());
            stmt.setString(2, teacher.getSurname());
            stmt.setString(3, teacher.getSubject());
            stmt.setDouble(4, teacher.getSalary());
            stmt.setInt(5, teacher.getId());
            stmt.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void delete(Teacher teacher) {
        String query = "DELETE FROM teachers WHERE id = ?";
        try (Connection conn = MyDatabase.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, teacher.getId());
            stmt.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Teacher findByNameAndSurname(String name, String surname) {
        Teacher teacher = null;
        String query = "SELECT * FROM teachers WHERE name = ? AND surname = ?";
        try (Connection conn = MyDatabase.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, surname);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setName(rs.getString("name"));
                teacher.setSurname(rs.getString("surname"));
                teacher.setSubject(rs.getString("subject"));
                teacher.setSalary(rs.getDouble("salary"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return teacher;
    }





}
