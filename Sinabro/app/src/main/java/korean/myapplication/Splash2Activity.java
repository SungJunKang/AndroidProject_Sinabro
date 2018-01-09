package korean.myapplication;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Splash2Activity extends AppCompatActivity {
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);
        iv = (ImageView)findViewById(R.id.splash2);

        if (Build.VERSION.SDK_INT >= 21) {   //상태바 색
            getWindow().setStatusBarColor(Color.parseColor("#e53935"));
        }

        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                Drawable d = iv.getDrawable();
                if(d instanceof BitmapDrawable){
                    Bitmap bitmap = ((BitmapDrawable)d).getBitmap();
                    bitmap.recycle();
                    bitmap = null;
                }
                d.setCallback(null);
                finish();
            }
        }, 2000);
    }
}
