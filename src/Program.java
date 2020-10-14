import java.util.UUID;

public class Program {

    public static void showTransaction(Transaction tmp) {
        System.out.println(tmp.toString());
    }

    public static Transaction sendMoney(User sndr, User rcpt, int amnt) {
        Transaction inTrans = Transaction.newTransaction(rcpt, sndr, Type.INCOME, amnt);
        System.out.println(inTrans);
        Transaction outTrans = Transaction.newTransaction(sndr, rcpt, Type.OUTCOME, amnt);
        System.out.println(outTrans);
        return inTrans;
    }

    public static void main(String[] args) {

        UsersArrayList usersArray = new UsersArrayList();

        usersArray.addUsersByName("Joe", "Bob", "Foo", "A", "Joe2", "Bob2", "Foo2", "A2");

        System.out.println(usersArray.getTotal());
        try {
            System.out.println(usersArray.getUserById(3).getName());
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            System.out.println(usersArray.getUserByInd(6).getName());
        }catch (Exception e){
            e.printStackTrace();
        }



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