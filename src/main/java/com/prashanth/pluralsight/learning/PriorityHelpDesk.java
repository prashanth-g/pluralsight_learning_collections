package com.prashanth.pluralsight.learning;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityHelpDesk {

    private static final Comparator<Enquiry> BY_CATEGORY = new Comparator<Enquiry>() {
        @Override
        public int compare(Enquiry o1, Enquiry o2) {
            return o1.getCategory().compareTo(o2.getCategory());
        }
    };

    private final Queue<Enquiry> enquiries = new PriorityQueue<>(BY_CATEGORY);

    public void enquire(final Customer customer, final Category category) {
        enquiries.offer(new Enquiry(customer,category));
    }

    public void processAllEnquiries() {
        Enquiry enquiry;
        while((enquiry = enquiries.poll()) != null) {
            enquiry.getCustomer().reply("Have you restarted ?");
        }
    }

    public static void main(String[] args) {
        PriorityHelpDesk priorityHelpDesk = new PriorityHelpDesk();

        priorityHelpDesk.enquire(Customer.AMY, Category.COMPUTER);
        priorityHelpDesk.enquire(Customer.HOWY, Category.PHONE);
        priorityHelpDesk.enquire(Customer.JIM, Category.PRINTER);

        priorityHelpDesk.processAllEnquiries();
    }
}

