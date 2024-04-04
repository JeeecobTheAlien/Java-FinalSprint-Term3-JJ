import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class UserDao {
    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public boolean createUser(User user) {
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

        String query = "INSERT INTO users (email, password, name) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, hashedPassword);
            statement.setString(3, user.getName());

            statement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User getUserById(int id) {
        User user = null;

        String query = "SELECT * FROM users WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String hashedPassword = resultSet.getString("password");
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        BCrypt.checkpw(user.getPassword(), hashedPassword),
                        resultSet.getString("name")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public User getUserByEmail(String email) {
        User user = null;

        String query = "SELECT * FROM users WHERE email = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String hashedPassword = resultSet.getString("password");
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        BCrypt.checkpw(user.getPassword(), hashedPassword),
                        resultSet.getString("name")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public boolean updateUser(User user) {
        String query = "UPDATE users SET name = ? WHERE email = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());

            statement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(int id) {
        String query = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            statement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean verifyPassword(String email, String password) {
        User user = getUserByEmail(email);

        if (user != null) {
            return BCrypt.checkpw(password, user.getPassword());
        }

        return false;
    }
}





   /*
    public boolean createUser(User user) {
        // insert user into database 
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

        // Prepare the SQL query

        // Database logic to insert data using PREPARED Statement

    }
    public User getUserById(int id) { //get user by id from database 
        User user = null;

        // Prepare the SQL query
        // Database logic to get data by ID Using Prepared Statement

    }

    public User getUserByEmail(String email) { // get user by email from database 
        User user = null;

        // Prepare the SQL query
        // Database logic to get data by ID Using Prepared Statement

    }


    public boolean updateUser(User user) {
        // Prepare the SQL query
        // Database logic to get update user Using Prepared Statement
    }
    public boolean deleteUser(int id) { // delete user from the database 
        // Prepare the SQL query
        // Database logic to delete user
    }

    public boolean verifyPassword (String email, String password)
    {
//        String query = "SELECT password FROM users WHERE email = ?";    // SQL Statement
        //Implement logic to retrieve password using the Bcrypt
    }
*/

