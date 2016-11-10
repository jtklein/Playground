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
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View row = inflater.inflate(mLayoutResourceId, parent, false);

        TextView textViewHeader = (TextView) row.findViewById(R.id.textViewRowHeader);
        TextView textViewBody = (TextView) row.findViewById(R.id.textViewRowBody);

        PgListViewExampleItem item = mData[position];
        textViewHeader.setText(item.header);
        textViewBody.setText(item.body);

        return row;
    }
}
