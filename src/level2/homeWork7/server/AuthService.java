package level2.homeWork7.server;

public interface AuthService {
    /**
     * @return nickname если пользователь есть
     * @return null если пользоватаеля нет
     * */
    String getNicknameByLoginAndPassword(String login, String password);
}
