import java.util.UUID;

public interface TransactionList {
    void addTransaction();
    void removeTransaction(UUID id);
    void toArray();
}
