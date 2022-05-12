public class Transaction {
    private int id;
    private int userId;
    private double amount;

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", userId=" + userId +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                '}';
    }

    private TransactionType transactionType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Transaction(int id, int userId, double amount, TransactionType transactionType) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.transactionType = transactionType;
    }
}
