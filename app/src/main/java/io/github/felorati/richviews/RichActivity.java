package io.github.felorati.richviews;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.github.felorati.richviews.models.Quote;
import io.github.felorati.richviews.views.QuoteView;


public class RichActivity extends Activity {
    @InjectView(R.id.activity_rich_quote_view) QuoteView mQuoteView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rich);
        ButterKnife.inject(this);
        Quote quote = Quote.Factory.generateQuote();
        mQuoteView.setQuote(quote);
    }
}
