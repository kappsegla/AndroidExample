package snowroller.androidexample;

/**
 * Created by Martin on 2017-01-25.
 */

        import android.databinding.DataBindingUtil;
        import android.databinding.ObservableArrayList;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.support.v7.widget.RecyclerView;

        import snowroller.androidexample.ViewModels.InfoViewModel;
        import snowroller.androidexample.databinding.ListItemBinding;

public class InfoViewModelAdapter extends
        RecyclerView.Adapter<InfoViewModelAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
    public ListItemBinding binder;

    public ViewHolder(View v) {
    super(v);
    binder = DataBindingUtil.bind(v);
    }
    }

    private ObservableArrayList<InfoViewModel> list;

    public InfoViewModelAdapter(ObservableArrayList<InfoViewModel> l) {
    list = l;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
    return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    final InfoViewModel info = list.get(position);
    holder.binder.setInfo(info);
    holder.binder.executePendingBindings();
    }

    @Override
    public int getItemCount() {
    return list.size();
    }
}