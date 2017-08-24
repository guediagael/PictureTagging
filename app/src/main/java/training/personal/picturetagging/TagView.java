package training.personal.picturetagging;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by guedi on 8/25/2017.
 */

public class TagView extends RelativeLayout {
    private String mTagText;

    public TagView(Context context,int x, int y,String tagText) {
        super(context);
        mTagText = (tagText.trim().length()>10)?tagText.substring(0,9) : tagText;
        TextView textView = new TextView(context);
        textView.setText(mTagText);
        RelativeLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        setPadding(x,y,0,0);
        setLayoutParams(params);
        addView(textView);

    }


}
