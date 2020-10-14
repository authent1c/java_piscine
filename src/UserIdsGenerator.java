public class UserIdsGenerator {
    private static UserIdsGenerator instance;
    private UserIdsGenerator() {};
    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }
    private int id = 0;
    public int generateId() {
        id = id + 1;
        return (id);
    }
}
