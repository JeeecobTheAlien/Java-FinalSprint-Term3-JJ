import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HealthDataDao {
    public boolean createHealthData(HealthData healthData) throws SQLException {
        String query = "INSERT INTO health_data (user_id, weight, height, steps, heart_rate, date) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, healthData.getUserId());
            statement.setDouble(2, healthData.getWeight());
            statement.setDouble(3, healthData.getHeight());
            statement.setInt(4, healthData.getSteps());
            statement.setInt(5, healthData.getHeartRate());
            statement.setDate(6, Date.valueOf(healthData.getDate()));

            return statement.executeUpdate() > 0;
        }
    }

    public HealthData getHealthDataById(int id) throws SQLException {
        String query = "SELECT * FROM health_data WHERE id = ?";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                double weight = resultSet.getDouble("weight");
                double height = resultSet.getDouble("height");
                int steps = resultSet.getInt("steps");
                int heartRate = resultSet.getInt("heart_rate");
                LocalDate date = resultSet.getDate("date").toLocalDate();

                return new HealthData(id, userId, weight, height, steps, heartRate, date);
            }

            return null;
        }
    }

    public List<HealthData> getHealthDataByUserId(int userId) throws SQLException {
        String query = "SELECT * FROM health_data WHERE user_id = ?";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);

            ResultSet resultSet = statement.executeQuery();

            List<HealthData> healthDataList = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double weight = resultSet.getDouble("weight");
                double height = resultSet.getDouble("height");
                int steps = resultSet.getInt("steps");
                int heartRate = resultSet.getInt("heart_rate");
                LocalDate date = resultSet.getDate("date").toLocalDate();

                healthDataList.add(new HealthData(id, userId, weight, height, steps, heartRate, date));
            }

            return healthDataList;
        }
    }

    public boolean updateHealthData(HealthData healthData) throws SQLException {
        String query = "UPDATE health_data SET weight = ?, height = ?, steps = ?, heart_rate = ?, date = ? WHERE id = ?";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, healthData.getWeight());
            statement.setDouble(2, healthData.getHeight());
            statement.setInt(3, healthData.getSteps());
            statement.setInt(4, healthData.getHeartRate());
            statement.setDate(5, Date.valueOf(healthData.getDate()));
            statement.setInt(6, healthData.getId());

            return statement.executeUpdate() > 0;
        }
    }

    public boolean deleteHealthData(int id) throws SQLException {
        String query = "DELETE FROM health_data WHERE id = ?";