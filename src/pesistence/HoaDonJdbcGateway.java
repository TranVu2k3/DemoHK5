package pesistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.model.HoaDon;

public class HoaDonJdbcGateway implements HoaDonGateway {

private Connection connection;

    public HoaDonJdbcGateway() {
        // Initialize the database connection here (replace dbUrl, username, and password with your SQL Server credentials)
        String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=YourDatabaseName;encrypt=true;trustServerCertificate=true";
        String username = "YourUsername";
        String password = "123";
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addHoaDon(HoaDon hoaDon) {
        String sql = "INSERT INTO Students (id, name, major, java_mark, html_mark, css_mark) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, hoaDon.getMaHoaDon());
            statement.setString(2, hoaDon.getNgayHoaDon());
            statement.setString(3, hoaDon.getTenKhachHang());
            statement.setString(4, hoaDon.getMaPhong());
            statement.setInt(5, hoaDon.getDonGia());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editHoaDon(HoaDon hoaDon) {
        String sql = "UPDATE Students SET name = ?, major = ?, java_mark = ?, html_mark = ?, css_mark = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, hoaDon.getMaHoaDon());
            statement.setString(2, hoaDon.getNgayHoaDon());
            statement.setString(3, hoaDon.getTenKhachHang());
            statement.setString(4, hoaDon.getMaPhong());
            statement.setInt(5, hoaDon.getDonGia());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteHoaDon(int id) {
        String sql = "DELETE FROM Students WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public HoaDon getHoaDonById(int id) {
        String sql = "SELECT * FROM Students WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String date = resultSet.getString("date");
                String name = resultSet.getString("name");
                int idroom = resultSet.getInt("idroom");
                int unitprice = resultSet.getInt("unitprice");
                // Calculate the average mark using the formula provided
                double price = 4.0;

                return new HoaDon(id, date, name, idroom, unitprice, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HoaDon> getAllHoaDon() {
        List<HoaDon> hoaDons = new ArrayList<>();
        String sql = "SELECT * FROM Students";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String date = resultSet.getString("date");
                String name = resultSet.getString("name");
                int idroom = resultSet.getInt("idroom");
                int unitprice = resultSet.getInt("unitprice");
                // Calculate the average mark using the formula provided
                double price = 4.0;

                hoaDons.add(new HoaDon(id, date, name, idroom, unitprice, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoaDons;
    }
}