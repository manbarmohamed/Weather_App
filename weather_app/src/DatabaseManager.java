import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String url = "jdbc:mysql://localhost:3306/Weather_App";
    private static final String username = "root";
    private static final String password = "1620";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static List<City> getAlCities() throws SQLException {
        List<City> city = new ArrayList<>();
        String sql = "SELECT * FROM City";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("cityId");
            String name = resultSet.getString("cityName");
            int temp = resultSet.getInt("currentTemperature");
            int hm = resultSet.getInt("currentHumidity");
            int wind = resultSet.getInt("currentWindSpeed");
            city.add(new City(id, name, temp, hm, wind));
        }
        connection.close();
        return city;
    }

    public static void addCity(City city) throws SQLException {
        String sql = "INSERT INTO City (cityId, cityName, currentTemperature,currentHumidity,currentWindSpeed) VALUES (?, ?, ?,?,?)";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, city.getCityId());
        statement.setString(2, city.getCityName());
        statement.setInt(3, city.getCurrentTemperature());
        statement.setInt(4, city.getCurrentHumidity());
        statement.setInt(5, city.getCurrentWindSpeed());

        statement.executeUpdate();
        connection.close();
        System.out.println("City added successfully!");
    }

    public static void updateCity(City city) throws SQLException {
        String sql = "UPDATE City SET cityId = ?, cityName = ?, currentTemperature=?,currentHumidity=?,currentWindSpeed=?    WHERE id = ?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, city.getCityName());
        statement.setInt(2, city.getCurrentTemperature());
        statement.setInt(3, city.getCurrentHumidity());
        statement.setInt(4, city.getCurrentWindSpeed());
        statement.executeUpdate();
        connection.close();
        System.out.println("City updated successfully!");
    }

    public static void deleteCity(int id) throws SQLException {
        String sql = "DELETE FROM City WHERE id = ?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        connection.close();
        System.out.println("City deleted successfully!");
    }

    public static City getCityByName(String cityName) throws SQLException {
        String sql = "SELECT * FROM City WHERE cityName = ?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, cityName);
        ResultSet resultSet = statement.executeQuery();

        City city = null;
        if (resultSet.next()) {
            int id = resultSet.getInt("cityId");
            String name = resultSet.getString("cityName");
            int temp = resultSet.getInt("currentTemperature");
            int hm = resultSet.getInt("currentHumidity");
            int wind = resultSet.getInt("currentWindSpeed");
            city = new City(id, name, temp, hm, wind);
        }

        connection.close();
        return city;
    }
}

