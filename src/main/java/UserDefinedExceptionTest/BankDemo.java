package UserDefinedExceptionTest;

import com.sun.javaws.jnl.IconDesc;

import java.util.Scanner;

public class BankDemo {
    public static double bankMoney=10000;
    public static void main(String [] args)
    {
        Account c = new Account(111);
        Scanner in = new Scanner(System.in);
        int flag=1;
        int n;
        while (true) {
            if(flag==1) {
                System.out.println("1,取钱");
                System.out.println("2,存钱");
                System.out.print("请输入要操作的序号：");
                flag=0;
            }
            n = in.nextInt();
            if(n!=1 && n!=2){
                System.out.print("输入有误，请重新输入：");
            }
            if (n==1) {
                flag = 1;
                System.out.print("请输入要取的金额：");
                double amount = in.nextDouble();
                try {
                    c.getMoney(amount, bankMoney);
                    bankMoney -= amount;
                    System.out.println("卡号为：" + c.getNumber() + ",余额：" + c.getBalance());
                    System.out.println("银行余额：" + bankMoney);
                } catch (UserGetMoneyException e) {
                    synchronized (c) {
                        //System.out.println(e.getMsg());
                        System.out.println(e.getMessage() + "\n\n" + e.getCause() + "\n\n" + (e.getClass()) + "\n\n");
                        e.printStackTrace();
                    }
                }
            }
            if(n==2){
                flag=1;
                System.out.print("请输入要存的金额：");
                double amount = in.nextDouble();
                c.saveMoney(amount);
                bankMoney+=amount;
                System.out.println("卡号为："+c.getNumber()+",余额："+c.getBalance());
                System.out.println("银行余额："+bankMoney);
            }
        }
    }
}

//自定义用户取钱时异常类，继承Exception类
class UserGetMoneyException extends Exception {
    //用户账户的金额
    private double userMoney;
    private double bankMoney;
    private int code;
    String  msg=null;
    public UserGetMoneyException(double amount,int code,double bankMoney)
    {
        this.userMoney = amount;
        this.bankMoney = bankMoney;
        this.code = code;
    }

    @Override
    public String getMessage(){
        if(code!=1) {
            msg = "余额不足，你的余额为：" + userMoney;
        }
        else {
            msg = "银行余额不足！";
        }
        return msg;
    }
}
//此类模拟银行账户
class Account {
    //balance为余额，number为卡号
    private double balance;
    private int number;
    public Account(int number)
    {
        this.number = number;
    }
    //方法：存钱
    public void saveMoney(double amount)
    {
        balance += amount;
    }
    //方法：取钱
    public void getMoney(double amount,double bankMoney) throws UserGetMoneyException
    {
        if(balance>0) {
            if (amount <= balance ) {
                if(amount<=bankMoney) {
                    balance -= amount;
                }
                else {
                    throw new UserGetMoneyException(balance,1,bankMoney);
                }
            } else {
                throw new UserGetMoneyException(balance,0,bankMoney);
            }
        }
        else {
            throw new UserGetMoneyException(balance,0,bankMoney);
        }
    }
    //方法：返回余额
    public double getBalance()
    {
        return balance;
    }
    //方法：返回卡号
    public int getNumber()
    {
        return number;
    }
}
