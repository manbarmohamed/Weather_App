import java.sql.*;
import java.time.LocalDate;
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
//    public static void getAlCities() throws SQLException {
//        String sql = "SELECT * FROM City";
//        PreparedStatement statement = getConnection().prepareStatement(sql);
//        ResultSet resultSet = statement.executeQuery();
//        while (resultSet.next()){
//            int id = resultSet.getInt("cityId");
//            String name = resultSet.getString("cityName");
//            int temp = resultSet.getInt("currentTemperature");
//            int hm = resultSet.getInt("currentHumidity");
//            int wind = resultSet.getInt("currentWindSpeed");
//            System.out.println("ID: "+id+" Name: "+name+" Temp: "+temp+" Humidity: "+hm+ " Wind Speed: "+wind);
//        }
//
//    }

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
        String sql = "UPDATE City SET cityName = ?, currentTemperature=?,currentHumidity=?,currentWindSpeed=? WHERE cityId = ?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, city.getCityName());
        statement.setInt(2, city.getCurrentTemperature());
        statement.setInt(3, city.getCurrentHumidity());
        statement.setInt(4, city.getCurrentWindSpeed());
        statement.setInt(5, city.getCityId());

        statement.executeUpdate();
        connection.close();
        System.out.println("City updated successfully!");
    }

    public static void deleteCity(int id) throws SQLException {
        String sql = "DELETE FROM City WHERE cityId = ?";
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

    // Methode of CityHistory
    public static List<CityHistory> getAlCityHistory() throws SQLException {
        List<CityHistory> city_H = new ArrayList<>();
        String sql = "select * from CityHistory";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int historicalDataId = resultSet.getInt("historicalDataId");
            int cityId = resultSet.getInt("cityId");
            int temp = resultSet.getInt("temperature");
            LocalDate eventDate = resultSet.getDate("eventDate").toLocalDate();

            city_H.add(new CityHistory(historicalDataId, cityId, eventDate, temp));
        }
        connection.close();
        return city_H;
    }

    public static void addCityHistory(CityHistory city_h) throws SQLException {
        String sql = "INSERT INTO CityHistory (historicalDataId, temperature, eventDate,cityId) VALUES (?, ?, ?,?)";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, city_h.getHistoricalDataId());
        statement.setInt(2, city_h.getTemperature());
        statement.setDate(3, Date.valueOf(city_h.getEventDate()));
        statement.setInt(4, city_h.getCityId());
        statement.executeUpdate();
        connection.close();
        System.out.println("City History added successfully!");
    }

    public static void updateCityHistory(CityHistory city_h) throws SQLException {
        String sql = "UPDATE City SET temperature = ?, eventDate=? WHERE historicalDataId = ?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, city_h.getTemperature());
        statement.setDate(2, Date.valueOf(city_h.getEventDate()));
        statement.executeUpdate();
        connection.close();
        System.out.println("City updated successfully!");
    }

    public static void deleteCityHistory(int id) throws SQLException {
        String sql = "DELETE FROM CityHistory WHERE historicalDataId = ?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        connection.close();
        System.out.println("City deleted successfully!");
    }

    public static CityHistory getCityHistoryById(int id_h) throws SQLException {
        String sql = "SELECT * FROM City ,CityHistory WHERE City.cityId = ?";

        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id_h);
        ResultSet resultSet = statement.executeQuery();

        CityHistory city_h = null;
        if (resultSet.next()) {
            int historicalDataId = resultSet.getInt("historicalDataId");
            int cityId = resultSet.getInt("cityId");
            int temp = resultSet.getInt("temperature");
            LocalDate eventDate = resultSet.getDate("eventDate").toLocalDate();
            city_h = new CityHistory(historicalDataId, cityId, eventDate, temp);
        }

        connection.close();
        return city_h;
    }
}

