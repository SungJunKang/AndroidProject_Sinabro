package korean.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity implements OnClickListener{

    EditText mMemoEdit;
    TextFileManager mTextFileManager = new TextFileManager(this);
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        if (Build.VERSION.SDK_INT >= 21) {   //상태바 색
            getWindow().setStatusBarColor(Color.parseColor("#e53935"));
        }

        text =  (TextView)findViewById(R.id.text);
        mMemoEdit = (EditText)findViewById(R.id.memo_edit);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/MH.TTF");
        text.setTypeface(typeface);
    }

    @Override
    public void onClick(View v) {

        Intent diction = new Intent(this, DictionActivity.class);
        Intent quiz = new Intent(this, QuizActivity.class);
        Intent note = new Intent(this, NoteActivity.class);
        Intent search = new Intent(this, SearchActivity.class);

        switch (v.getId()){
            case R.id.load_btn:{
                String memoData = mTextFileManager.load();
                mMemoEdit.setText(memoData);

                Toast.makeText(this, "불러오기 완료", Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.save_btn: {
                String memoData = mMemoEdit.getText().toString();
                mTextFileManager.save(memoData);
                mMemoEdit.setText("");

                Toast.makeText(this, "저장 완료", Toast.LENGTH_SHORT).show();
                break;
            }
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
