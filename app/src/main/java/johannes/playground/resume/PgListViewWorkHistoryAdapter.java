package johannes.playground.resume;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import johannes.playground.R;

/**
 * Created by johannesklein on 17.11.16.
 */

public class PgListViewWorkHistoryAdapter extends ArrayAdapter<PgListViewWorkHistoryItem> {

    Context mContext;
    int mLayoutResourceId;
    PgListViewWorkHistoryItem mData[] = null;

    public PgListViewWorkHistoryAdapter(Context context, int resource, PgListViewWorkHistoryItem[] objects) {
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
        PgListViewWorkHistoryAdapter.PgListViewWorkHistoryItemHolder holder = null;

        // If we currently don't have a row, inflate one, add holder as tag
        if (row == null){
            // Inflate the layout
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(mLayoutResourceId, parent, false);

            holder = new PgListViewWorkHistoryAdapter.PgListViewWorkHistoryItemHolder();

            // Get the layout elements
            holder.textViewDate = (TextView) row.findViewById(R.id.textViewWorkHistoryDate);
            holder.textViewJob = (TextView) row.findViewById(R.id.textViewWorkHistoryJob);
            holder.container = (LinearLayout) row.findViewById(R.id.containerWorkHistoryItem);

            // Add the holder as tag
            row.setTag(holder);

        } else {
            // Else use an existing holder
            holder = (PgListViewWorkHistoryAdapter.PgListViewWorkHistoryItemHolder) row.getTag();

        }

        // Get the data and display
        PgListViewWorkHistoryItem item = mData[position];
        holder.textViewDate.setText(item.date);
        holder.textViewJob.setText(item.job);

        // Add onClick Listener to holder in order to be reused
        holder.container.setOnClickListener(ExampleListener);
        holder.container.setTag(position);

        // Return the view
        return row;
    }

    View.OnClickListener ExampleListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int position = (int) view.getTag();
            PgListViewWorkHistoryItem item = mData[position];
            // TODO onClick

        }
    };

    private static class PgListViewWorkHistoryItemHolder {
        TextView textViewDate;
        TextView textViewJob;
        LinearLayout container;

    }
}