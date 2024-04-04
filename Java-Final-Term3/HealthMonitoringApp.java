import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    // 1. 
    //   Test the following functionalities within the Main Application
    //    1. Register a new user
    //    2. Log in the user
    //    3. Add health data
    //    4. GenerHere is the updated code with the necessary test casesHere is the updated code with the necessary test cases:


public class Main {

    public static void main(String[] args) {
        // Test register a new user
        testRegisterUser();

        // Test login user
        testLoginUser();

        // Add health data
        testAddHealthData();

        // Generate recommendations
        testGenerateRecommendations();

        // Add a medicine reminder
        testAddMedicineReminder();

        // Get reminders for a specific user
        testGetReminders();

        // Get due reminders for a specific user
        testGetDueReminders();

        // Test doctor portal
        testDoctorPortal();
    }

    // 1. 
    //   Test the following functionalities within the Main Application
    //    1. Register a new user
    public static void testRegisterUser() {
        // Create a new user
        User user1 = new User("Malik", "Malik", "qmalik@gmail.com", "guggu", false);
        List<User> userList = new ArrayList<>();
        userList.add(user1);

        // Register the new user
        for (User users : userList) {
            try {
                UserDao.createUser(users);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //    2. Log in the user
    public static void testLoginUser() {
        // Test login user
        String email = "qmalik@gmail.com";
        String password = "guggu";
        try {
            User user = UserDao.getUserByEmail(email);
            if (user != null && user.getPassword().equals(password)) {
                System.out.println("User logged in successfully");
            } else {
                System.out.println("Invalid email or password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //    3. Add health data
    public static void testAddHealthData() {
        // Add health data
        HealthData healthData1 = new HealthData(1, 100, 60, 120, 1000);
        List<HealthData> healthDataList = new ArrayList<>();
        healthDataList.add(healthData1);

        // Add health data to the database
        try {
            HealthDataDao.createHealthData(healthDataList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //    4. Generate recommendations
    public static void testGenerateRecommendations() {
        // Generate recommendations
        try {
            List<Recommendation> recommendations = RecommendationEngine.generateRecommendations(1);
            System.out.println("Recommendations:");
            for (Recommendation recommendation : recommendations) {
                System.out.println(recommendation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //    5. Add a medicine reminder
    public static void testAddMedicineReminder() {
        // Add a medicine reminder
        MedicineReminder medicineReminder1 = new MedicineReminder(1, 1, "Take your medicine", "2022-01-01", false);
        List<MedicineReminder> medicineReminderList = new ArrayList<>();
        medicineReminderList.add(medicineReminder1);

        // Add medicine reminder to the database
        try {
            MedicineReminderDao.createMedicineReminder(medicineReminderList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}};

    //    6. Get reminders for a specific user
    public static void testGetReminders() {
        // Get reminders for a specific user
        try {
            List<MedicineReminder> medicineReminders = MedicineReminderDao.getMedicineRemindersByUserId(1);
            System.out.println("Medicine Reminders:");
            for (MedicHere is the updated code with the necessary changes to test the functionalities within the Main Application);
        }
    

         // 3.
    //   To test the Doctor Portal in your Health Monitoring System, provide a simple test code method that you can add
    //   to your main application class.
    //   In this method, we'll test the following functionalities:
    //   1. Fetching a doctor by ID
    //   2. Fetching patients associated with a doctor
    //   3. Fetching health data for a specific patient

    public static void testDoctorPortal() {
        // Replace the doctorId with a valid ID from your database
        int doctorId = 1;

        // Add code to Fetch the doctor by ID
        Doctor doctor = null;
        try {
            doctor = DoctorPortal.getDoctorById(doctorId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Add code to Fetch patients associated with the doctor
        List<Patient> patients = null;
        try {
            patients = DoctorPortal.getPatientByDoctorId(doctorId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Add code to Fetch health data for the patient
        for (Patient patient : patients) {
            List<HealthData> healthDataList = null;
            try {
                healthDataList = DoctorPortal.getHealthDataByPatientId(patient.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Health Data for Patient " + patient.getId() + ":");
            for (HealthData healthData : healthDataList) {
                System.out.println(healthData);
            }
        }
    }










// import com.DataBaseConnection;
// import java.sql.Date;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.List;
// import org.mindrot.jbcrypt.BCrypt;

// import static com.DataBaseConnection.DataBaseConnection.getConnection;

// public class HealthMonitoringApp {

//     private static UserDaoExample userDao = new UserDaoExample();
//     // 1
//     public static void main(String[] args) throws SQLException {
//         DatabaseConnection databaseConnection = new DatabaseConnection();
//         UserDaoExample userDao = new UserDaoExample();
//     // 2
//         List<User> userList = new ArrayList<>();

//         User user1 = new User(5,"Ainee", "Malik","qmalik@gmail.com", "guggu", false);
//         userList.add(user1);

//         for (User users : userList) {
//             userDao.createUser(users);
//         }

//         // Test login user
//         testLoginUser();
//     }

//     public static boolean loginUser(String email, String password) throws SQLException {
//         //implement method to login user.
//         User user = userDao.getUserByEmail(email);

//         if (user != null) {
//             // Compare the stored hashed password with the given password and return result
//             String hashedPassword = user.getPassword();
//             boolean passwordMatches = BCrypt.checkpw(password, hashedPassword);

//             if (passwordMatches) {
//                 // Print to console, "Login Successful"
//                 System.out.println("Login Successful");
//                 return true;
//             }
//         }

//         // Print to console, "Incorrect email or password. Please try again."
//         System.out.println("Incorrect email or password. Please try again.");

//         return false;

//     }

//     // 3
//     public static void testDoctorPortal() {
//         // Replace the doctorId with a valid ID from your database
//         int doctorId = 1;

//         // Add code to Fetch the doctor by ID
//         Doctor doctor = DoctorPortal.getDoctorById(doctorId);

//         // Add code to Fetch patients associated with the doctor
//         List<Patient> patients = DoctorPortal.getPatientByDoctorId(doctorId);

//         // Add code to Fetch health data for the patient
//         for (Patient patient : patients) {
//             List<HealthData> healthDataList = DoctorPortal.getHealthDataByPatientId(patient.getId());
//             System.out.println("Health Data for Patient " + patient.getId() + ":");
//             for (HealthData healthData : healthDataList) {
//                 System.out.println(healthData);
//             }
//         }
//     }

//     /**
//      * To test the login user functionality in your Health Monitoring System, you can
//      * add a test method to your main application class
//      */
//     public static void testLoginUser() {
//         // Replace the email and password with valid credentials from your database
//         String userEmail = "qmalik@gmail.com";
//         String userPassword = "guggu";

//         boolean loginSuccess = loginUser(userEmail, userPassword);

//         if (loginSuccess) {
//             // Print to console, "Login Successful"
//             System.out.println("Login Successful");
//         } else {
//             // Print to console, "Incorrect email or password. Please try again."
//             System.out.println("Incorrect email or password. Please try again.");
//         }
//     }

// }

// // 1. 
//     //   Test the following functionalities within the Main Application
//     //    1. Register a new user
//     //    2. Log in the user
//     //    3. Add health data
//     //    4. Generate recommendations
//     //    5. Add a medicine reminder
//     //    6. Get reminders for a specific user
//     //    7. Get due reminders for a specific user
//     //    8. test doctor portal
  
// // 2.
//     //   Test register a new user
//     //    test Login user (call testLoginUser() here)
//     //    Add health data
//     //    Generate recommendations
//     //    Add a medicine reminder
//     //    Get reminders for a specific user
//     //    Get due reminders for a specific user
//     //    test doctor portal (call testDoctorPortal() here)

// // 3.
//     //   To test the Doctor Portal in your Health Monitoring System, provide a simple test code method that you can add
//     //   to your main application class.
//     //   In this method, we'll test the following functionalities:
//     //   1. Fetching a doctor by ID
//     //   2. Fetching patients associated with a doctor
//     //   3. Fetching health data for a specific patient
      