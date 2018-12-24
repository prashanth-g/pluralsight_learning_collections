package com.prashanth.pluralsight.learning;

import java.util.ArrayDeque;
import java.util.Queue;

public class HelpDesk {

    private final Queue<Enquiry> enquiries = new ArrayDeque<>();

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
        HelpDesk helpDesk = new HelpDesk();

        helpDesk.enquire(Customer.AMY, Category.COMPUTER);
        helpDesk.enquire(Customer.HOWY, Category.PHONE);
        helpDesk.enquire(Customer.JIM, Category.PRINTER);

        helpDesk.processAllEnquiries();
    }
}
