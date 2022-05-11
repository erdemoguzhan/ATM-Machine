import exception.CustomerNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Customer> customerList=new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int id=1;
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
                double d = scanner.nextDouble();
                customer=customerSearchById(i,customerList);
                customer.depositMoney(d);
                customer.showDetails();
                break;
            case 3:
                i=scanner.nextInt();
                double w = scanner.nextDouble();
                customer=customerSearchById(i,customerList);
                customer.withdrawMoney(w);
                customer.showDetails();
                break;
            case 4:
                i=scanner.nextInt();
                customer=customerSearchById(i,customerList);
                customer.showDetails();

        }
    }
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
}

