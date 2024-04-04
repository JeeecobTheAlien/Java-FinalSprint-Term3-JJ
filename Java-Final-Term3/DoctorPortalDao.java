import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorPortalDao {
    private UserDao userDao;
    private HealthDataDao healthDataDao;

    public DoctorPortalDao() {
        userDao = new UserDao();
        healthDataDao = new HealthDataDao();
    }

    public Doctor getDoctorById(int doctorId) throws SQLException {
        return userDao.getUserById(doctorId);
    }

    public List<User> getPatientsByDoctorId(int doctorId) throws SQLException {
        List<User> patients = new ArrayList<>();

        String query = "SELECT * FROM users WHERE doctor_id = ?";

        try (DatabaseConnection connection = connection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, doctorId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                boolean isDoctor = resultSet.getBoolean("is_doctor");

                User patient = new User(id, firstName, lastName, email, password, isDoctor);
                patients.add(patient);
            }
        }

        return patients;
    }

    public List<HealthData> getHealthDataByPatientId(int patientId) throws SQLException {
        List<HealthData> healthDataList = new ArrayList<>();

        String query = "SELECT * FROM health_data WHERE user_id = ?";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, patientId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int userId = resultSet.getInt("user_id");
                double weight = resultSet.getDouble("weight");
                double height = resultSet.getDouble("height");
                int steps = resultSet.getInt("steps");
                int heartRate = resultSet.getInt("heart_rate");
                String date = resultSet.getString("date");

                HealthData healthData = new HealthData(id, userId, weight, height, steps, heartRate, date);
                healthDataList.add(healthData);
            }
        }

        return healthDataList;
    }

    // Add more methods for other doctor-specific tasks

    // Example:

    public void addMedicineReminder(int patientId, MedicineReminder medicineReminder) throws SQLException {
        // Add code to insert the medicine reminder into the database

        String query = "INSERT INTO medicine_reminders (patient_id, medicine_name, dosage, schedule, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, patientId);
            statement.setString(2, medicineReminder.getMedicineName());
            statement.setString(3, medicineReminder.getDosage());
            statement.setString(4, medicineReminder.getSchedule());
            statement.setDate(5, Date.valueOf(medicineReminder.getStartDate()));
            statement.setDate(6, Date.valueOf(medicineReminder.getEndDate()));
            statement.executeUpdate();
        }
    }

    public List<MedicineReminder> getMedicineRemindersByPatientId(int patientId) throws SQLException {
        List<MedicineReminder>