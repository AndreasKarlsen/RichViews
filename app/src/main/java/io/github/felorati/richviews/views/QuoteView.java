package io.github.felorati.richviews.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.github.felorati.richviews.models.Quote;
import io.github.felorati.richviews.R;

public class QuoteView extends FrameLayout {
    @InjectView(R.id.view_quote_total) TextView mQuotetotal;
    @InjectView(R.id.view_quote_checkin_date) TextView mCheckInDate;
    @InjectView(R.id.view_quote_payment_breakdown) PaymentBreakdownView mPaymentBreakdown;

    //constructors you'll need to support
    public QuoteView(Context context) {
        super(context);
        init();
    }

    public QuoteView(Context context, AttributeSet set) {
        super(context, set);
        init();
    }

    private void init() {
        //grab a layout inflater, and inflate R.layout.view_quote, into this FrameLayout
        LayoutInflater.from(getContext())
                .inflate(R.layout.view_quote, this, true);
        ButterKnife.inject(this);
    }

    public void setQuote(Quote quote) {
        //set out text views from out DTO
        mQuotetotal.setText(String.valueOf(quote.getQuoteTotal()));
        mCheckInDate.setText(quote.getCheckInDate("%F"));

        //set our PaymentBreakdownView to handle it's own display logic
        mPaymentBreakdown.setPaymentBreakdown(quote.getPaymentSchedule());
    }
}