package DAP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static ConexionDB instance;
    private Connection connection;

    private ConexionDB() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres2";
        String user = "postgres";
        String password = "123";
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public static ConexionDB getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConexionDB();
        } else if (instance.getConnection().isClosed()) {
            instance = new ConexionDB();
        }
        return instance;
    }

    public Connection getConnection() {
        return this.connection;
    }
}