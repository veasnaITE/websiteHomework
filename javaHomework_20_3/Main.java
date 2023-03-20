import java.util.*;

class Account{
    int id;
    String ownerName;
    double balance;
    Account(){}
    Account(int id, String ownerName, double balance){
        this.id=id;
        this.ownerName=ownerName;
        this.balance=balance;
    }
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
public class Main {
    //acc id owner balance
    //add acc add edit remove show
    //show account information
    // 1 . descending order by account_id
    // 2.  ascending order by account_id
    // 3. descendinder order by balance
    public static void main(String[] args) {
        int option;
        List<Account> accountList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("1: Add account:");
            System.out.println("2: Remove Account: ");
            System.out.println("3. Edit Account ");
            System.out.println("4. Sort account ");
            System.out.println("5. Show account info ");
            System.out.println("6. Exit ");
            System.out.println("Choose option ( 1 - 6 ) : ");
            option  = input.nextInt();
            switch (option){
                case  1 : {
                    // enter account information
                    // object add list
                    //accountList.add();
                    System.out.println("Enter your account infor");
                    Account acc = new Account();
                    System.out.print("Input ID:");
                    acc.id = input.nextInt();
                    System.out.print("Name:");
                    input.nextLine();
                    acc.ownerName = input.nextLine();
                    System.out.print("Balance:");
                    acc.balance = input.nextInt();
                    accountList.add(acc);
                }break;
                case 2 :{
                    System.out.println("Please Input Which Account ID your wanna Remove :");
                    int reId=input.nextInt();
                    boolean isFound = false;
                    for (int i=0 ; i<accountList.size();i++) {
                        if (accountList.get(i).id== reId) {
                            accountList.remove(i);
                            isFound = true;
                        }
                    }
                    if (!isFound) {
                        System.out.println("ID is not found");
                    }
                } break;
                case 3 :{
                    System.out.println("Enter Id for update");
                    int idforUpdate = input.nextInt();
                    boolean isCheck = false;
                    if(accountList.size()>0) {
                        for (Account account1 : accountList) {
                            if (account1.id == idforUpdate) {
                                System.out.println("Enter the new Owner ");
                                account1.ownerName = input.next();
                                System.out.println("Enter the new Balance ");
                                account1.balance = input.nextDouble();
                                isCheck = true;
                            }
                        }
                    }
                    if(!isCheck) System.out.println("There is no data for update");

                } break;
                case 4 : {
                    int showOption;
                    System.out.println("Sort");
                    System.out.println("1. Ascending order (by ID )");
                    System.out.println("2. Descending order (by ID) ");
                    System.out.println("3. Descending order by balance ");
                    System.out.println("Choose show option : ");
                    showOption = input.nextInt();
                    switch (showOption) {
                        case 1: {
                            Collections.sort(accountList,Comparator.comparingInt(o->o.id));
                            System.out.println("Sort Success");
                        }break;
                        case 2:{
                            Collections.sort(accountList,(o1, o2) -> Integer.compare(o2.id,o1.id));
                            System.out.println("Sort Success");
                        }break;
                        case 3:{
                            Collections.sort(accountList,(o1, o2) -> Double.compare(o2.balance,o1.balance));
                            System.out.println("Sort Success");
                        }break;
                    }
                }break;
                case 5 : {
                    for (Account account1 : accountList
                    ) {
                        System.out.println(account1);
                    }
                }break;
            }
        }while(option  !=6);

    }
}