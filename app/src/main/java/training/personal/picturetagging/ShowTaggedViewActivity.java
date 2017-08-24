package training.personal.picturetagging;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

public class ShowTaggedViewActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT = "text";
    public static final String EXTRA_X_COORDINATE = "x";
    public static final String EXTRA_Y_COORDINATE = "y";

    private  int mX, mY;
    private  String mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_tagged_view);
        Intent intent = getIntent();
        mX = intent.getIntExtra(EXTRA_X_COORDINATE,0);
        mY = intent.getIntExtra(EXTRA_Y_COORDINATE,0);
        mText = intent.getStringExtra(EXTRA_TEXT);


        if (mX!=0 && mY!=0){
            ((FrameLayout)findViewById(R.id.frame_taggedView)).addView(new TagView(this,mX,mY,mText));
        }else Toast.makeText(this,"nothing set",Toast.LENGTH_SHORT).show();


    }
}
