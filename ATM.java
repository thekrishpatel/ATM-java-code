/*

  name : krish patel

  subject : create bankaccount and use of netbanking

  usage : this services can be use by banks for online banking services. 

 */

import java.util.*;

class BankAccount {
    String name, adress, account_number, bank_id = "BA", tyapeofaccount;
    int numberoftransiction = 0, balance, account_number_id = 1000, pin;

    int set(int i) {
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "------------------------------------------------------------------------------------------------------");
        System.out.print("Enter the name of the depositer : ");
        name = sc.nextLine();
        System.out.print("Enter the Adress of the depositer : ");
        adress = sc.nextLine();
        System.out.print("Enter account balance : ");
        balance = sc.nextInt();
        System.out.print("Enter the type of the Account : ");
        sc.nextLine();
        tyapeofaccount = sc.nextLine();
        account_number_id = account_number_id + i;
        account_number = bank_id + (account_number_id);
        System.out.println("You have alloted Account number : " + account_number);
        System.out.println("Kindly remember this account number for detail of your account");
        System.out.println(
                "------------------------------------------------------------------------------------------------------");
        System.out.print("Set the PIN : ");
        pin = sc.nextInt();
        System.out.println("Kindly remember this PIN number and do not share with any one");
        System.out.println(
                "------------------------------------------------------------------------------------------------------");
        System.out.println();
        sc.close();
        return pin;
    }

    int services() {
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "1. Withdraw money \n2. Add money \n3. Update information \n4. Check Balance \n5. show my account details \n6. Number of transiction \n7. Logout \n8. Exit");
        System.out.print("Which service do you want to use : ");
        int service = sc.nextInt();
        switch (service) {
            case 1:
                System.out.print("How many Money do you want to withdraw : ");
                int withdraw_money = sc.nextInt();
                if(withdraw_money<balance)
                {
                    balance = balance - withdraw_money;
                    numberoftransiction++;
                    System.out.println("Money successfully withdraw.");
                    break;
                }
                else
                {
                    System.out.println("Your account does not have sufficient balance.");
                }
            case 2:
                System.out.print("How many Money do you want to add : ");
                int add_money = sc.nextInt();
                balance = balance + add_money;
                numberoftransiction++;
                System.out.println("Money successfully added.");
                break;
            case 3:
                System.out.println("1. Name \n2. Adress \n3. Account type \n4. PIN change");
                System.out.print("Which information do you want to update : ");
                int number = sc.nextInt();
                switch (number) {
                    case 1:
                        System.out.println("Your old name is : " + name);
                        System.out.print("Enter the new name which you want to update : ");
                        sc.nextLine();
                        name = sc.nextLine();
                        System.out.println("Your information is successfully updated.");
                        break;
                    case 2:
                        System.out.println("Your old Adress is : " + adress);
                        System.out.println("Enter the new Adress which you want to update : ");
                        sc.nextLine();
                        adress = sc.nextLine();
                        System.out.println("Your information is successfully updated.");
                        break;
                    case 3:
                        System.out.println("Your old account type is : " + tyapeofaccount);
                        System.out.print("Enter the new Account type which you want to update : ");
                        sc.nextLine();
                        tyapeofaccount = sc.nextLine();
                        System.out.println("Your information is successfully updated.");
                        break;
                    case 4:
                        int new_pin = pin;
                        System.out.print("Enter the new PIN which you want to update : ");
                        pin = sc.nextInt();
                        if (new_pin == pin) {
                            System.out.println("New PIN can not be the same as old PIN.");
                        } else {
                            System.out.println("PIN successfully updated.");
                        }
                        break;
                }
            case 4:
                System.out.println("Your Account balance is : " + balance);
                break;
            case 5:
                System.out.println("Name of the depositer is : " + name);
                System.out.println("Account number of the depositer is : " + account_number);
                System.out.println("Type of the bank account is : " + tyapeofaccount);
                System.out.println("Adress of the depositer is : " + adress);
                System.out.println("Balance of the account is : " + balance);
                System.out.println("Number of the transictions is : " + numberoftransiction);
                break;
            case 6:
                System.out.println("Number of the transictions is : " + numberoftransiction);
                break;
            case 7:
                System.out.println("Thanks for using our bank services :)");
                sc.close();
                return 1000;
            case 8:
                System.out.println("Thanks for using our bank services :)");
                sc.close();
                return 1002;
        }
        sc.close();
        return service;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many accounts do you want to made : ");
        int total_accounts = sc.nextInt();
        BankAccount b[] = new BankAccount[total_accounts];
        int pin[] = new int[total_accounts];
        for (int i = 0; i < total_accounts; i++) {
            b[i] = new BankAccount();
            pin[i] = b[i].set(i);
        }
        for (int q = 1; q < 1000; q++) {
            System.out.print("Enter the last 4 digits of your account number : ");
            int j = sc.nextInt();
            System.out.print("Enter the PIN number : ");
            int pin_check = sc.nextInt();
            for (int i = 0; i < total_accounts; i++) {
                int count = 0;
                if (pin[i] == pin_check && j % 1000 == i) {
                    for (; i < 1000; i++) {
                        System.out.println(
                                "------------------------------------------------------------------------------------------------------");
                        int ret = b[j % 1000].services();
                        System.out.println(
                                "------------------------------------------------------------------------------------------------------");
                        i = ret;
                        q = ret - 2;
                    }
                } else {
                    count++;
                    System.out.println(count);
                    q = 1000 - 3;
                }
            }
            for (int i = 0; i < total_accounts; i++) {
                if (pin[i] == pin_check && j % 1000 == i)
                    pin[i] = b[j % 1000].pin;
                    sc.close();
            }
        }
    }
}