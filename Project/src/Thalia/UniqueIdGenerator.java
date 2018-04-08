package Thalia;

import java.util.concurrent.atomic.AtomicInteger;

public class UniqueIdGenerator {
	static int start = 307;
    static AtomicInteger atomicIntegerShows = new AtomicInteger();
    static AtomicInteger atomicIntegerOrders = new AtomicInteger();
    static AtomicInteger atomicIntegerTickets = new AtomicInteger();
    static AtomicInteger atomicIntegerDonations = new AtomicInteger();

    
    public static int getUniqueShowID() {
        return atomicIntegerShows.incrementAndGet()+start;
    }
    
    public static int getUniqueOrderID() {
        return atomicIntegerOrders.incrementAndGet();
    }
    
    public static int getUniqueTicketID() {
        return atomicIntegerTickets.incrementAndGet();
    }
    
    public static int getUniqueDonationID() {
        return atomicIntegerDonations.incrementAndGet();
    }
}
