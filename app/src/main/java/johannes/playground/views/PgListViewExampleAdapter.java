package johannes.playground.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import johannes.playground.R;
import johannes.playground.views.PgListViewExampleItem;

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

        // If we currently don't have a row, inflate one, add holder as tag
        if (row == null){
            // Inflate the layout
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(mLayoutResourceId, parent, false);

            holder = new PgListViewExampleItemHolder();

            // Get the layout elements
            holder.textViewHeader = (TextView) row.findViewById(R.id.textViewRowHeader);
            holder.textViewBody = (TextView) row.findViewById(R.id.textViewRowBody);

            // Add the holder as tag
            row.setTag(holder);

        } else {
            // Else use an existing holder
            holder = (PgListViewExampleItemHolder) row.getTag();

        }

        // Get the data and display
        PgListViewExampleItem item = mData[position];
        holder.textViewHeader.setText(item.header);
        holder.textViewBody.setText(item.body);

        // Add onClick Listener to holder in order to be reused
        holder.textViewHeader.setOnClickListener(ExampleListener);
        holder.textViewHeader.setTag(position);


        // Return the view
        return row;
    }

    View.OnClickListener ExampleListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int position = (int) view.getTag();
            PgListViewExampleItem item = mData[position];
            Toast.makeText(mContext, item.popup, Toast.LENGTH_SHORT).show();
        }
    };

    private static class PgListViewExampleItemHolder {
        TextView textViewHeader;
        TextView textViewBody;

    }
}
