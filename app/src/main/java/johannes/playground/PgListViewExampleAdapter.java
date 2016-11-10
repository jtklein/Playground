package johannes.playground;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by johannesklein on 10.11.16.
 */
public class PgListViewExampleAdapter extends ArrayAdapter<PgListViewExampleItem> {

    Context mContext;
    int mLayoutResourceId;
    PgListViewExampleItem mData[] = null;

    public PgListViewExampleAdapter(Context context, int resource, PgListViewExampleItem[] objects) {
        super(context, resource, objects);

        // Save params
        this.mContext = context;
        this.mLayoutResourceId = resource;
        this.mData = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*
                            Using the holder pattern
         */
        // Save View;
        View row = convertView;

        // Create a holder reference
        PgListViewExampleItemHolder holder = null;

        // Inflate the layout
        LayoutInflater inflater = LayoutInflater.from(mContext);
        row = inflater.inflate(mLayoutResourceId, parent, false);

        // Get the layout elements
        TextView textViewHeader = (TextView) row.findViewById(R.id.textViewRowHeader);
        TextView textViewBody = (TextView) row.findViewById(R.id.textViewRowBody);

        // Get the data and display
        PgListViewExampleItem item = mData[position];
        textViewHeader.setText(item.header);
        textViewBody.setText(item.body);

        // Return the view
        return row;
    }

    private static class PgListViewExampleItemHolder {
        TextView textViewHeader;
        TextView textViewBody;

    }
}
