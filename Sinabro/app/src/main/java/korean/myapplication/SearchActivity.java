package korean.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    private WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        if (Build.VERSION.SDK_INT >= 21) {   //상태바 색
            getWindow().setStatusBarColor(Color.parseColor("#e53935"));
        }

        mWebview = (WebView)findViewById(R.id.WebView);
        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.loadUrl("http://korean.go.kr/front/foreignSpell/foreignSpellList.do?mn_id=96");
        mWebview.setWebViewClient(new WishWebViewClient());

        TextView text = (TextView)findViewById(R.id.text);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/MH.TTF");
        text.setTypeface(typeface);
    }
    private class WishWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }
    }

    public void onClick(View v)
    {
        Intent diction = new Intent(this, DictionActivity.class);
        Intent quiz = new Intent(this, QuizActivity.class);
        Intent note = new Intent(this, NoteActivity.class);
        Intent search = new Intent(this, SearchActivity.class);

        switch(v.getId())
        {
            case R.id.icon:
                finish();
                break;
            case R.id.diction:
                startActivity(diction);
                break;
            case R.id.quiz:
                startActivity(quiz);
                break;
            case R.id.note:
                startActivity(note);
                break;
            case R.id.search:
                startActivity(search);
                break;
        }
    }
}
