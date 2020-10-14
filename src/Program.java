import java.util.UUID;

public class Program {
    public static void showTransaction(Transaction tmp) {
        System.out.print(tmp.getSender());
        System.out.print(" -> ");
        System.out.print(tmp.getRecipient());

        if (tmp.getCategory() == Type.INCOME) {
            System.out.print(", +");
        } else {
            System.out.print(", -");
        }
        System.out.print(tmp.getAmount());
        System.out.print(", ");
        System.out.print(tmp.getCategory());
        System.out.print(", ");
        System.out.println(tmp.getUuid());
    }

    public static Transaction sendMoney(User sndr, User rcpt, int amnt) {
        if ((sndr.getBalance() - amnt) < 0) {
            return null;
        }
        Transaction inTrans = new Transaction(rcpt, sndr, Type.INCOME, amnt);
        showTransaction(inTrans);
        Transaction outTrans = new Transaction(sndr, rcpt, Type.OUTCOME, amnt);
        showTransaction(outTrans);
        return inTrans;
    }

    public static void main(String[] args) {

        UsersArrayList usersArray = new UsersArrayList();

        usersArray.addUser("Joe");
        usersArray.addUser("Bob");
        usersArray.addUser("Foo");
        usersArray.addUser("A");
        usersArray.addUser("Joe2");
        usersArray.addUser("Bob2");
        usersArray.addUser("Foo2");
        usersArray.addUser("A2");

        System.out.println(usersArray.getTotal());
        System.out.println(usersArray.getUserById(3).getName());
        System.out.println(usersArray.getUserByInd(6).getName());


//        User mike = new User("Mike", 9000);
//        User john = new User("John", 1000);
//        User sally = new User("Sally", 15000);
//        User joe = new User("Joe", 6000);
//        Transaction tmp;
//        sendMoney(mike, john, 486);
//        sendMoney(mike, john, 56);
//        sendMoney(mike, john, 16);
//        sendMoney(mike, john, 4699);
//        System.out.println(UserIdsGenerator.getInstance().generateId());
//        System.out.println(UserIdsGenerator.getInstance().generateId());
//        System.out.println(UserIdsGenerator.getInstance().generateId());
//        System.out.println(UserIdsGenerator.getInstance().generateId());
//        System.out.println(UserIdsGenerator.getInstance().generateId());
    }
}
//John -> Mike, -500, OUTCOME, transaction ID