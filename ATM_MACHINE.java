import java.util.*;

public class ATM_MACHINE {
  private double balance;
  private double depositamount;
  private double withdrawamount;
  private double transfer;
  Map<Double, String> history = new HashMap<>();// Hashmap usd for storing transaction history

  public ATM_MACHINE()// default constractor
  {

  }

  // getter and setter method
  public double getBalance() {
    return balance;
  }

  public double setBalance(double balance) {
   return this.balance = balance;
  }

  public double getTransfer() {
    return transfer;
  }

  public double setTransfer(double transferamount) {
   return this.transfer = transferamount;
  }

  public double getDepositamount() {
    return depositamount;
  }

  public double setDepositamount(double depositeamount) {
    return this.depositamount = depositeamount;
  }

  public double getWithdrawamount() {
    return withdrawamount;
  }

  public double setWithdrawamount(double withdrawamount) {
    return this.withdrawamount = withdrawamount;
  }

  public void check_balance() {
    System.out.println("Availble Balance is:" + getBalance());
  }

  public void withdraw(double withdraw) {
    if (withdraw > getBalance()) {
      System.out.println("Insufficient Balance....");
    } else {
      history.put(withdraw, "Amount withdraw");
      System.out.println(withdraw + " Amount withdraw succcessfully....");
      setBalance(getBalance() - withdraw);
      check_balance();
    }
  }


  public void deposit(double deposit) {
    history.put(deposit, "Amount Deposite");
    System.out.println(deposit + "DepositedSuccessful.... ");
    setBalance(getBalance() - deposit);
    check_balance();
  }

public void transfer(double transfer){
    if(transfer>getBalance()){
        System.out.println("Insufficient BAlanace.....!");
    }
    else{
        history.put(transfer,"Amount Transfer");
        System.out.println("Transfer successful....!");
        setBalance(getBalance()-transfer);
        check_balance();
    }
  }
  public void history() {
    for (Map.Entry<Double, String> m : history.entrySet()) {
      System.out.println(m.getKey() + m.getValue());
    }
  }

  public static void main(String[] args) {
    int atmnumber = 12345;
    int atmpin = 123;
    Scanner sc = new Scanner(System.in);
    System.out.print("Welcome to ATM MACHINE");
    System.out.println("Enter ATM Number");
    int atmNumber = sc.nextInt();
    System.out.println("Enter ATM PIN");
    int pin = sc.nextInt();
    ATM_MACHINE atm = new ATM_MACHINE();
    if ((atmNumber == atmnumber) && (pin == atmpin)) {
      while (true) {
        System.out.println("1.check balance \n2.withdraw\n3.Deposite\4.Transfer\n5.Transaction history\n6.exit");
        System.out.println("Enter the choice");
        int ch = sc.nextInt();
        if (ch == 1) {
          atm.check_balance();
        } else if (ch == 2) {
          System.out.println("Enter the amount which you want to withdraw :");
          double with = sc.nextDouble();
          atm.withdraw(with);
        } else if (ch == 3) {
          System.out.println("Enter the amount which you want to deposite : ");
          double depo = sc.nextDouble();
          atm.deposit(depo);

        } else if (ch == 4) {
          System.out.println("Enter recipient's amount number");
          int no = sc.nextInt();
          System.out.println("Enter the amount which you want to transfer :");
          double trans = sc.nextDouble();
          atm.transfer(trans);
        } else if (ch == 5) {
          atm.history();
        } else if (ch == 6) {
          System.out.println("Collect you ATM card \n THANK YOU for using ATM Machine");
          System.exit(0);
        } else {
          System.out.println("Please Enter correct choice");
        }
      }
    } 
    else {
      System.out.println(" Incorrect atm number or pin");
    }

  }
}

