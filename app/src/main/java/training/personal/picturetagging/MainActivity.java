package training.personal.picturetagging;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener,
        TextInputDialog.DialogListener {

    public static final String REQUEST_CODE_TAG_VIEW = "555";
    private int mX, mY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.frame_main);
        frameLayout.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        mX = (int)motionEvent.getX();
        mY =(int)motionEvent.getY();
        DialogFragment dialogFragment = new TextInputDialog();
        dialogFragment.show(getSupportFragmentManager(),"TextInputDialog");
        return true;
    }


    @Override
    public void okPressed(String text) {
        Intent intent = new Intent(this,ShowTaggedViewActivity.class);
        intent.putExtra(ShowTaggedViewActivity.EXTRA_TEXT,text);
        intent.putExtra(ShowTaggedViewActivity.EXTRA_X_COORDINATE,mX);
        intent.putExtra(ShowTaggedViewActivity.EXTRA_Y_COORDINATE,mY);
        startActivity(intent);
    }
}
