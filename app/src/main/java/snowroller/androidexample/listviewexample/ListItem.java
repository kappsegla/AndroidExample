package snowroller.androidexample.listviewexample;

import java.util.Date;

/**
 * Created by Martin on 2017-01-26.
 */

public class ListItem {

    public String text;
    public Date datetime;

    ListItem(String text, Date datetime)
    {
        this.text = text;
        this.datetime = datetime;
    }
}
