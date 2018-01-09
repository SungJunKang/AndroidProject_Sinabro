package korean.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class DictionActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diction);

        if (Build.VERSION.SDK_INT >= 21) {   //상태바 색
            getWindow().setStatusBarColor(Color.parseColor("#e53935"));
        }

        mWebView = (WebView)findViewById(R.id.WebView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("http://korean.go.kr");
        mWebView.setWebViewClient(new WishWebViewClient());

        final Context myApp = this;
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, final android.webkit.JsResult result) {
                new AlertDialog.Builder(myApp)
                        .setTitle("Alert title")
                        .setMessage(message)
                        .setPositiveButton(android.R.string.ok,
                                new AlertDialog.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        result.confirm();
                                    }
                                })
                        .setCancelable(false)
                        .create()
                        .show();
                return true;
            }
        });

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
