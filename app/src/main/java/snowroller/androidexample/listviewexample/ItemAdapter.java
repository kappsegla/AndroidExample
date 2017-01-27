package snowroller.androidexample.listviewexample;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 2017-01-26.
 */
import snowroller.androidexample.R;

public class ItemAdapter extends BaseAdapter {

    private List<ListItem> objects;
    private Context context;
    private LayoutInflater inflater;

    public ItemAdapter(Context context, List<ListItem> objects) {
        this.context = context;
        this.objects = objects;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        //Return number of items in list so our View knows how many posts should be displayed
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        //Return the object reference at specified position
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        //Can be implemented to return a unique id for the specified position.
        //Example database id. Shortens the code from
        //adapter.getItem(pos).getId to adapter.getId(pos)
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        // first check to see if the view is null. if so, we have to inflate it.
        if (v == null) {
            v = inflater.inflate(R.layout.special_list_item, parent, false);
        }

        //Get the listitem to show
        ListItem i = objects.get(position);

        if (i != null) {
            //Get references to view objects in our xml
            TextView textView7 = (TextView) v.findViewById(R.id.textView7);
            TextView textView8 = (TextView) v.findViewById(R.id.textView8);

            textView7.setText(i.text);
            textView8.setText(i.datetime.toString());

        }
            // Return the view
            return v;
        }
}