package com.prashanth.pluralsight.learning;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Predicate;

import static com.prashanth.pluralsight.learning.Category.PHONE;
import static com.prashanth.pluralsight.learning.Category.PRINTER;

public class CategorisedHelpDesk {

    private final Queue<Enquiry> enquiries = new ArrayDeque<>();

    public void enquire(final Customer customer, final Category category) {
        enquiries.offer(new Enquiry(customer,category));
    }

    public void processPhoneEnquiries() {
        processEnquiry(enq -> enq.getCategory() == PHONE,
                "Is the wire properly connected?");
    }

    public void processGeneralEnquiries() {
        processEnquiry(enq -> enq.getCategory() != PHONE,
                "Have you restarted?");
    }

    private void processEnquiry(Predicate<Enquiry> enquiryPredicate, String message) {
        final Enquiry enquiry = enquiries.peek();
        if (enquiry != null && enquiryPredicate.test(enquiry)) {
            enquiries.remove();
            enquiry.getCustomer().reply(message);
        } else {
            System.out.println("No work here to do. Have some coffee!");
        }
    }



    public static void main(String[] args) {
        CategorisedHelpDesk categorisedHelpDesk = new CategorisedHelpDesk();

        categorisedHelpDesk.enquire(Customer.AMY, PHONE);
        categorisedHelpDesk.enquire(Customer.JIM, PRINTER);

        categorisedHelpDesk.processPhoneEnquiries();
        categorisedHelpDesk.processGeneralEnquiries();
        categorisedHelpDesk.processPhoneEnquiries();
    }
}

