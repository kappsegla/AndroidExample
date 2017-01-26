package snowroller.androidexample.listviewexample;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 2017-01-26.
 */
import snowroller.androidexample.R;

public class ItemAdapter extends ArrayAdapter {

    private ArrayList<ListItem> objects;

    public ItemAdapter(Context context, int resource, ArrayList<ListItem> objects) {
        super(context, resource, objects);
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // assign the view we are converting to a local variable
        View v = convertView;

        // first check to see if the view is null. if so, we have to inflate it.
        // to inflate it basically means to render, or show, the view.
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.special_list_item, null);
        }

        ListItem i = objects.get(position);

        if (i != null) {
            // This is how you obtain a reference to the TextViews.
            // These TextViews are created in the XML files we defined.
            TextView tt = (TextView) v.findViewById(R.id.textView7);
            TextView ttd = (TextView) v.findViewById(R.id.textView8);

            // check to see if each individual textview is null.
            // if not, assign some text!
            if (tt != null) {
                tt.setText(i.text);
            }
            if (ttd != null) {
                ttd.setText(i.datetime);
            }
        }
            // the view must be returned to our activity
            return v;
        }
}