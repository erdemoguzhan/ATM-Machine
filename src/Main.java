import exception.CustomerNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Customer> customerList=new ArrayList<>();
        List<Transaction> transactions=new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int id=1;
        int transactionId=1;
        Customer customer;
        while (true){
        menu();
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                String n=scanner.next();
                String b= scanner.next();
                int a=scanner.nextInt();
                createCustomer(n,b,a,customerList,id);
                id++;
                break;
            case 2:
                int i=scanner.nextInt();
                double deposit = scanner.nextDouble();
                customer=customerSearchById(i,customerList);
                customer.depositMoney(deposit);
                createTransaction(transactionId,customer.id,deposit,TransactionType.DEPOSIT,transactions);
                transactionId++;
                break;
            case 3:
                i=scanner.nextInt();
                double withdraw = scanner.nextDouble();
                customer=customerSearchById(i,customerList);
                customer.withdrawMoney(withdraw);
                createTransaction(transactionId,customer.id,withdraw,TransactionType.WITHDRAW,transactions);
                transactionId++;
                break;
            case 4:
                i=scanner.nextInt();
                customer=customerSearchById(i,customerList);
                break;
            case 7:
                accountWithTheMostBalance(customerList);
                break;
            case 8:
                int userid=scanner.nextInt();
                displayTransactionHistoryByUserId(userid,transactions);
                break;
            case 9:
                System.out.println(totalDepositAmount(transactions));
                break;

        }
    }
}

    private static void createTransaction(int id,int userId,double amount,TransactionType transactionType,List<Transaction> transactions) {
         transactions.add(new Transaction(id, userId, amount, transactionType));
    }

    public static void createCustomer (String name, String surname, int age,List<Customer> customerList,int id){
        customerList.add(new Customer(name,surname,age,id));
    }
    public static void menu(){
        System.out.println("1- Open New Bank Acoount");
        System.out.println("2- Deposit Money");
        System.out.println("3- Withdraw Money");
        System.out.println("4- Show Account Details");
        System.out.println("5- Apply Credit");
        System.out.println("6- Delete My Account");
        System.out.println("7- Display the acoount which has a most balance");
        System.out.println("8- Display the transaction history to user");
        System.out.println("9- Display the total deposit amount");

    }
    public static void interestCalculator(double balance){
        Scanner scanner=new Scanner(System.in);
        double yearlyinterest=balance+(balance*2.5);
        double monthlyinterest=balance+(balance*0.15);
        double weeklyinterest=balance+(balance*0.03);

    }
    public static Customer customerSearchById(int id,List<Customer> customerList){
        var s=customerList.stream().filter(x ->x.id==id).findFirst();
        if(s.isPresent()){
            return s.get();
        }
        throw new CustomerNotFoundException();
    }
    public static void accountWithTheMostBalance(List<Customer> customerList){
        Customer customerWithMostBalance=customerList.stream().max(Comparator.comparing(x-> x.balance)).get();
            System.out.println("Account with the most balance is: ID= "+customerWithMostBalance.id+"   NAME= "+customerWithMostBalance.name+"   SURNAME= "+
                    customerWithMostBalance.surname+"   AGE= "+ customerWithMostBalance.age+"   BALANCE= "+ customerWithMostBalance.balance);
    }
    public static void displayTransactionHistoryByUserId(int userId,List<Transaction> transactionList){
        List<Transaction> transactionHistoryListByDistinctId= transactionList.stream().filter(x -> x.getUserId() == userId).toList();
        transactionHistoryListByDistinctId.forEach(x-> System.out.println(x.toString()));
    }
    public static double totalDepositAmount(List<Transaction>transactionList){
        List<Transaction> transactionsWithOnlyDeposit=transactionList.stream().filter(x-> x.getTransactionType()==TransactionType.DEPOSIT).toList();
        return transactionsWithOnlyDeposit.stream().mapToDouble(x-> x.getAmount()).sum();
    }

}

