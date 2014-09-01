package io.github.felorati.richviews.models;

import android.text.format.Time;

import java.util.ArrayList;
import java.util.List;

public class PaymentBreakdown {
    private List<Payment> mPayments;
    private static final int DEFAULT_PAYBACK_RATE = 10;
    public PaymentBreakdown(double quoteTotal, Time checkInDate) {
        mPayments = new ArrayList<Payment>();
        calculatePaymentBreakdown(quoteTotal, checkInDate);
    }

    private void calculatePaymentBreakdown(double quoteTotal, Time checkInDate){
        for (int i = 0; i < DEFAULT_PAYBACK_RATE; i++) {
            double paybackAmount = quoteTotal / DEFAULT_PAYBACK_RATE;
            Time paybackDate = new Time();
            paybackDate.set(checkInDate.monthDay, checkInDate.month, checkInDate.year + i);
            mPayments.add(new Payment(paybackDate, paybackAmount));
        }
    }

    final List<Payment> getPaymentSchedule(){
        return mPayments;
    }
}
