package io.github.felorati.richviews.models;

import android.text.format.Time;

public class Payment {
    private final Time mPaybackDate;
    private final double mPaybackAmount;

    public Payment(Time mPaybackDate, double mPaybackAmount) {
        this.mPaybackDate = mPaybackDate;
        this.mPaybackAmount = mPaybackAmount;
    }

    public String getPaybackDate(String format) {
        return mPaybackDate.format(format);
    }

    public double getPaybackAmount() {
        return mPaybackAmount;
    }
}
