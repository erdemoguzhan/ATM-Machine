public class Customer {
    String name;
    String surname;
    int age;
    double income;
    int id;
    double balance;

    void depositMoney(double dmoney) {
        balance += dmoney;
    }

    void withdrawMoney(double wmoney) {
        balance -= wmoney;
    }
    void showDetails(){
        System.out.println("\t\t\t-----Account Details------");
        System.out.println("User ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Surname "+surname);
        System.out.println("Age: "+age);
        System.out.println("Balance: "+balance);
    }
    Customer(String name,String surname,int age,int id){
        this.name=name;
        this.surname=surname;
        this.age=age;
        this.id=id;

    }
    Customer (String name,String surname,int age,int id,double balance){
        this.name=name;
        this.surname=surname;
        this.age=age;
        this.balance=0;
        this.id=id;
    }


}
