package com.company;

public class Cashier {

    private int starttime;
    private  int endtime;

    private int CashierNumber;
    private Person currentPerson;

    private int transactionwaitingtime;
    private int totalcustomer;
    private int freeTime;


    public void freetoBusy(Person currentPerson, int CurrentTime){

        freeTime+= (CurrentTime- starttime);
            starttime=CurrentTime;
            endtime= starttime+ this.currentPerson.getTransactiontime();
            this.currentPerson = this.currentPerson;
            totalcustomer++;
        }


    Person busytoFree(){
        transactionwaitingtime+=(endtime-starttime);
        starttime=endtime;
        return currentPerson;
    }


    public void setEndInterval(int endsimulationtime, int intervalType){
        endtime = endsimulationtime;

        if (intervalType==0){
            transactionwaitingtime+= endtime -starttime;
        }else{
            transactionwaitingtime += endtime-starttime;
        }
    }



    public int getFreeTime() {
        return freeTime;
    }

    public Cashier(int CashierNumber){
        CashierNumber=CashierNumber;
    }

    public int getStarttime() {
        return starttime;
    }

    public int getEndtime() {
        return endtime;
    }

    public int getCashierNumber() {
        return CashierNumber;
    }

    public Person getCurrentPerson() {
        return currentPerson;
    }

    public int getTransactionwaitingtime() {
        return transactionwaitingtime;
    }

    public int getTotalcustomer() {
        return totalcustomer;
    }

    public int getEndBusyIntervalTime() {
        return endtime;
    }
}
