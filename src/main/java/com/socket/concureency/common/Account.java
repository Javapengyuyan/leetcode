package com.socket.concureency.common;

public class Account {

    Integer balance;

    public Integer getBalance(){
        return this.balance;
    }

    public Integer debit(Integer num){
        balance += num;
        return balance;
    }

    public Integer credit(Integer num){
        balance -= num;
        return balance;
    }


}
