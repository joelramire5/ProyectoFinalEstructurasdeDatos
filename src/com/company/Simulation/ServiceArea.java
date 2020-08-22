package com.company.Simulation;

import com.company.Cashier;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


class CompareCashier implements Comparator<Cashier>
{
    @Override
    public int compare(Cashier o1, Cashier o2)
    {
        return o1.getEndBusyIntervalTime() - o2.getEndBusyIntervalTime();
    }
}

    class ServiceArea
    {
        // Private data fields:

        // define one priority queue
        private PriorityQueue<Cashier> busyCashierQ;

        // define two FIFO queues
        private Queue<String> PersonNp;
        private Queue<String> PersonP;
        
        
        
        private Queue<Cashier> freeCashierQ;

        private int PersonQLimit;

        public ServiceArea()
        {
            this(1,1,1);
        }

        public ServiceArea(int numCashiers, int PersonQlimit, int startCashierID)
        {
            // use ArrayDeque to construct FIFO queue objects
            PersonNp = new ArrayDeque<String>(PersonQlimit);
            freeCashierQ = new ArrayDeque<Cashier>(numCashiers);
           PersonP= new ArrayDeque<String>(PersonQlimit);

            // construct PriorityQueue object
            // overide compare() in Comparator to compare Cashier objects
            busyCashierQ = new PriorityQueue<Cashier>( numCashiers, new CompareCashier());

            // initialize PersonQlimit
            PersonQLimit = PersonQlimit;

            // Construct Cashier objects and insert into FreeCashierQ
            for (int i = 0; i < numCashiers; i++) {
                insertFreeCashierQ( new Cashier(startCashierID++) );
            }
        }

        public Cashier removeFreeCashierQ()
        {
            // remove and return a free Cashier
            return freeCashierQ.poll();
        }

        public Cashier removeBusyCashierQ()
        {
            // remove and return a busy Cashier
            return busyCashierQ.poll();
        }

        public String removePersonQ()
        {
            // remove and return a Person
            return PersonNp.poll();
        }

        public void insertFreeCashierQ(Cashier Cashier)
        {
            // insert a free Cashier
            freeCashierQ.add(Cashier);
        }

        public void insertBusyCashierQ(Cashier Cashier)
        {
            // insert a busy Cashier
            busyCashierQ.add(Cashier);
        }

        public void insertPersonQ(String Person)
        {
            // insert a Person
            PersonNp.add(Person);
        }

        public boolean emptyFreeCashierQ()
        {
            // is freeCashierQ empty?
            return freeCashierQ.isEmpty();
        }

        public boolean emptyBusyCashierQ()
        {
            // is busyCashierQ empty?
            return busyCashierQ.isEmpty();
        }

        public boolean emptyPersonQ()
        {
            // is PersonQ empty?
            return PersonNp.isEmpty();
        }

        public int numFreeCashiers()
        {
            // get number of free Cashiers
            return freeCashierQ.size();
        }

        public int numBusyCashiers()
        {
            // get number of busy Cashiers
            return busyCashierQ.size();
        }

        public int numWaitingPersons()
        {
            // get number of Persons
            return PersonNp.size();
        }

        public Cashier getFrontBusyCashierQ()
        {
            // get front of busy Cashiers
            // "retrieve" but not "remove"
            return busyCashierQ.peek();
        }

        public boolean isPersonQTooLong()
        {
            // is PersonQ too long?
            return PersonNp.size() == PersonQLimit;
        }


        public String removePersonP()
        {
            // remove and return a Person
            return PersonP.poll();
        }

        public void insertPersonP(String Person)
        {
            // insert a Person
            PersonP.add(Person);
        }

        public boolean emptyPersonP()
        {
            // is PersonQ empty?
            return PersonP.isEmpty();
        }

        public int numWaitingPersonsP()
        {
            // get number of Persons
            return PersonP.size();
        }

        public boolean isPersonPTooLong()
        {
            // is PersonQ too long?
            return PersonP.size() == PersonQLimit;
        }
}
