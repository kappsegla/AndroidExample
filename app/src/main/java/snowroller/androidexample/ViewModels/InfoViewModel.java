package snowroller.androidexample.ViewModels;

/**
 * Created by Martin on 2017-01-25.
 */

//View model for 
public class InfoViewModel {
    
    public int iconResource; /* Resource id for the image */
    public String text; /* Name */
    public InfoViewModel(int r, String n) {
        iconResource = r;
        text = n;
    }
}