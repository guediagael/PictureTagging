package training.personal.picturetagging;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by guedi on 8/25/2017.
 */

public class TextInputDialog extends DialogFragment {

    private DialogListener mListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final EditText input = new EditText(getActivity());
        builder.setView(input)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String text =input.getText().toString();
                        mListener.okPressed(text);
                    }
                });
        return builder.create();



//        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof DialogListener))
            throw new ClassCastException(context.toString()+ " must implement DialogListener");
        else mListener = (DialogListener)context;
    }

    public interface DialogListener{
        void okPressed(String text);
    }
}
