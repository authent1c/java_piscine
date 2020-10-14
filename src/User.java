import java.util.UUID;

public class User {
    private int     id;
    private String  name;
    private int     balance = 0;

    public User(String name){
        this.name = name;
        this.id = UserIdsGenerator.getInstance().generateId();
    }
    public User(String name, int balance) {
        if (balance < 0) {
            balance = 0;
        }
        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        this.balance = balance;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getBalance() {
        return balance;
    }
}
