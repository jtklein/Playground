package johannes.playground.examples;

import android.os.Bundle;

import johannes.playground.PgActivityButtonMenu;
import johannes.playground.PgListViewButtonMenuItem;
import johannes.playground.R;
import johannes.playground.examples.numbershapes.PgActivityNumberShapes;

/**
 * Created by johannesklein on 19.11.16.
 */
public class PgActivityExamples extends PgActivityButtonMenu {

    private PgListViewButtonMenuItem[] mData = new PgListViewButtonMenuItem[]{
        new PgListViewButtonMenuItem(R.string.ui_higher_or_lower, PgActivityHigherLower.class),
        new PgListViewButtonMenuItem(R.string.ui_number_shapes, PgActivityNumberShapes.class),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.setTheAdapter(mData);
    }
}
