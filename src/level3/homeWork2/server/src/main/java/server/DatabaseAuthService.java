package server;

import java.sql.*;

public class DatabaseAuthService implements AuthService {
    private Connection connection;
    private PreparedStatement psReg;
    private PreparedStatement psFind;

    public DatabaseAuthService(Connection connection) throws SQLException {
        this.connection = connection;

        prepareStatements();
    }

    private void prepareStatements() throws SQLException {
        psReg = connection.prepareStatement("INSERT INTO user(login, password, nickname) VALUES (?, ?, ?);");
        psFind = connection.prepareStatement("SELECT nickname FROM user WHERE login=? AND password=?;");
    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        String nickname = null;
        try {
            psFind.setString(1, login);
            psFind.setString(2, password);
            ResultSet rs = psFind.executeQuery();
            if (rs.next()) {
                nickname = rs.getString(1);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nickname;
    }

    @Override
    public boolean registration(String login, String password, String nickname) {
        try {
            psReg.setString(1, login);
            psReg.setString(2, password);
            psReg.setString(3, nickname);
            psReg.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
