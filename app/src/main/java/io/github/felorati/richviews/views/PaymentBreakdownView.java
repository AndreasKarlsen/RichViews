package io.github.felorati.richviews.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.github.felorati.richviews.R;
import io.github.felorati.richviews.adapters.PaymentBreakdownAdapter;
import io.github.felorati.richviews.models.Payment;

public class PaymentBreakdownView extends FrameLayout{

    @InjectView(android.R.id.list) ListView mListView;
    private Context mContext;

    public PaymentBreakdownView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public PaymentBreakdownView(Context context, AttributeSet set) {
        super(context, set);
        mContext = context;
        init();
    }

    private void init() {
        //grab a layout inflater, and inflate R.layout.view_quote, into this FrameLayout
        LayoutInflater.from(getContext())
                .inflate(R.layout.view_payment_breakdown, this, true);
        ButterKnife.inject(this);
    }

    public void setPaymentBreakdown(List<Payment> paymentBreakdown){
        PaymentBreakdownAdapter paymentBreakdownAdapter = new PaymentBreakdownAdapter(mContext, paymentBreakdown);
        mListView.setAdapter(paymentBreakdownAdapter);
    }

}
