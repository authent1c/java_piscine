import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.UUID;

enum Type {
    INCOME,
    OUTCOME;

}
public class Transaction {
    private UUID    uuid;
    private String  recipient;
    private String  sender;
    private Type    category;
    private int     amount;





    public static Transaction newTransaction(User userFrom, User userTo, Type transtactionType, int amount){
        if(amount < 0 ){
            if(Type.OUTCOME.equals(transtactionType)){
                if(userFrom.getBalance() - amount < 0){
                    throw new TransactionException(String.format("User %s have not enough money", userFrom.getName()));
                }
            }

            throw new IllegalArgumentException(String.format("Amount can't be less than zero. Amount is %s", amount));
        }

        return new Transaction(userFrom, userTo, transtactionType, amount);


    }

    private Transaction(User rcpt, User sndr, Type cat, int amnt) {
        this.uuid = new UUID(0, 1);
        this.recipient = rcpt.getName();
        this.sender = sndr.getName();
        this.category = cat;
        if (amnt < 0) {
            amnt = 0;
        }
        this.amount = amnt;
    }
    public UUID getUuid() {
        return uuid;
    }
    public String getRecipient() {
        return recipient;
    }
    public String getSender() {
        return sender;
    }
    public Type getCategory() {
        return category;
    }
    public int getAmount() {
        return amount;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "uuid=" + uuid +
                ", recipient='" + recipient + '\'' +
                ", sender='" + sender + '\'' +
                ", category=" + category +
                ", amount=" + amount +
                '}';
    }
}
