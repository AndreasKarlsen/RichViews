package io.github.felorati.richviews.models;

import android.text.format.Time;

import java.util.List;
import java.util.Random;

public class Quote {
    private double mQuoteTotal;
    private Time mCheckInDate;
    private PaymentBreakdown mPaymentBreakdown;

    public Quote(double quoteTotal, Time checkInDate) {
        this.mQuoteTotal = quoteTotal;
        this.mCheckInDate = checkInDate;
        this.mPaymentBreakdown = new PaymentBreakdown(quoteTotal, checkInDate);
    }

    public double getQuoteTotal() {
        return mQuoteTotal;
    }

    public String getCheckInDate(String format) {
        return mCheckInDate.format(format);
    }

    public final List<Payment> getPaymentSchedule(){
        return mPaymentBreakdown.getPaymentSchedule();
    }

    public static class Factory{
        private static Quote sCachedQuote;

        public static Quote generateQuote() {
            if (sCachedQuote == null) {
                Time loanObtained = new Time();
                loanObtained.setToNow();
                Random random = new Random(loanObtained.toMillis(false));
                long loanAmount = random.nextInt(1000);
                sCachedQuote = new Quote(loanAmount, loanObtained);
            }
            return sCachedQuote;
        }
    }

}
