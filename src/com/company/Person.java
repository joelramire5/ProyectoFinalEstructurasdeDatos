package com.company;

public class Person {

    private int queuetime;
    private int transactiontime;
    private int customernumber;

    public Person(int queuetime, int transactiontime, int customernumber) {
        this.queuetime = queuetime;
        this.transactiontime = transactiontime;
        this.customernumber = customernumber;
    }

    public int getQueuetime() {
        return queuetime;
    }

    public void setQueuetime(int queuetime) {
        this.queuetime = queuetime;
    }

    public int getTransactiontime() {
        return transactiontime;
    }

    public void setTransactiontime(int transactiontime) {
        this.transactiontime = transactiontime;
    }

    public int getCustomernumber() {
        return customernumber;
    }

    public void setCustomernumber(int customernumber) {
        this.customernumber = customernumber;
    }


}
