package io.github.felorati.richviews.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.github.felorati.richviews.R;
import io.github.felorati.richviews.models.Payment;

public class PaymentBreakdownAdapter extends BaseAdapter {
    private List<Payment> mPayments;
    private Context mContext;

    public PaymentBreakdownAdapter(Context context, List<Payment> payments) {
        super();
        mContext = context;
        mPayments = payments;
    }

    @Override public int getCount() {
        return mPayments.size();
    }

    @Override public Object getItem(int position) {
        return mPayments.get(position);
    }

    @Override public long getItemId(int position) {
        return position;
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.view_payment_breakdown_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        Payment payment = mPayments.get(position);
        holder.date.setText(payment.getPaybackDate("%F"));
        holder.amount.setText(String.valueOf(payment.getPaybackAmount()));

        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.view_payment_breakdown_item_date) TextView date;
        @InjectView(R.id.view_payment_breakdown_item_amount) TextView amount;

        public ViewHolder(View view){
            ButterKnife.inject(this, view);
        }
    }
}
