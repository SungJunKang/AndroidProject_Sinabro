package korean.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BackPressCloseHandler backPressCloseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this, Splash3Activity.class));
        startActivity(new Intent(this, Splash2Activity.class));
        startActivity(new Intent(this, Splash1Activity.class));
        startActivity(new Intent(this, SplashActivity.class));

        TextView text = (TextView)findViewById(R.id.text);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/MH.TTF");
        text.setTypeface(typeface);

        if (Build.VERSION.SDK_INT >= 21) {   //상태바 색
            getWindow().setStatusBarColor(Color.parseColor("#e53935"));
        }

        backPressCloseHandler = new BackPressCloseHandler(this);
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

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();
    }
}
