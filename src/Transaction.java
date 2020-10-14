import java.util.UUID;

enum Type {
    INCOME,
    OUTCOME
}
public class Transaction {
    private UUID    uuid;
    private String  recipient;
    private String  sender;
    private Type    category;
    private int     amount;

    public Transaction(User rcpt, User sndr, Type cat, int amnt) {
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
}
