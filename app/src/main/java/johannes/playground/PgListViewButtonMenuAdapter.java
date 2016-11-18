package johannes.playground;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

/**
 * Created by johannesklein on 10.11.16.
 */
public class PgListViewButtonMenuAdapter extends ArrayAdapter<PgListViewButtonMenuItem> {

    Context mContext;
    int mLayoutResourceId;
    PgListViewButtonMenuItem mData[] = null;

    public PgListViewButtonMenuAdapter(Context context, int resource, PgListViewButtonMenuItem[] objects) {
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
        PgListViewButtonMenuItemHolder holder = null;

        // If we currently don't have a row, inflate one, add holder as tag
        if (row == null){
            // Inflate the layout
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(mLayoutResourceId, parent, false);

            holder = new PgListViewButtonMenuItemHolder();

            // Get the layout elements
            holder.button = (Button) row.findViewById(R.id.buttonButtonMenu);

            // Add the holder as tag
            row.setTag(holder);

        } else {
            // Else use an existing holder
            holder = (PgListViewButtonMenuItemHolder) row.getTag();

        }

        // Get the data and display
        PgListViewButtonMenuItem item = mData[position];
        holder.button.setText(item.text);

        // Add onClick Listener to holder in order to be reused
        holder.button.setTag(position);
        holder.button.setOnClickListener(ExampleListener);

        // Return the view
        return row;
    }

    View.OnClickListener ExampleListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int position = (int) view.getTag();
            PgListViewButtonMenuItem item = mData[position];

            new PgSimpleExplicitIntentFactory(mContext, item.gotoClass).generateIntent();
        }
    };

    private static class PgListViewButtonMenuItemHolder {
        Button button;

    }
}
