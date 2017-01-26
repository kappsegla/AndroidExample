package snowroller.androidexample.listviewexample;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import snowroller.androidexample.R;

public class ListViewActivity extends AppCompatActivity {

    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    private ListView myListView;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        myListView = (ListView) findViewById(R.id.listView);
        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
           listItems);

        myListView.setAdapter(adapter);

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                addListItem();
//            }
//        }
//        );
    }

    //Called when clicked on fab button. Bounded in layoutfile
    public void fabClicked(View view)
    {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        listItems.add(dateformat.format(new Date()));
        adapter.notifyDataSetChanged();
    }
}
