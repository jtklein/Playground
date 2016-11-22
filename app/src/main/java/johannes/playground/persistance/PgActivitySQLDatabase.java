package johannes.playground.persistance;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 22.11.16.
 */
public class PgActivitySQLDatabase extends PgActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_sql_database);

        try {
            // Open or create the database named USers
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users",MODE_PRIVATE, null);

            // Table named: users
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");

            // Add two user
            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Me', 33)");
            myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('You', 32)");

            // Query the database
            Cursor c = myDatabase.rawQuery("SELECT * FROM users", null);

            // Query these columns
            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");

            // Perform the query
            c.moveToFirst();
            while (c.moveToNext()){
                // Get content
                Log.i("name", c.getString(nameIndex));
                Log.i("age", Integer.toString(c.getInt(ageIndex)));

            }
            c.close();

            // Table named: newUsers
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS newUsers (name VARCHAR, age INTEGER(3), id INTEGER PRIMARY KEY)");

            // Add two newUser
            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('NewMe', 33)");
            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('NewYou', 32)");

            // Delete newUser with ID = 1
            myDatabase.execSQL("DELETE FROM newUsers WHERE id = 1");

            // Query the database
            c = myDatabase.rawQuery("SELECT * FROM newUsers", null);

            // Query these columns
            int newNameIndex = c.getColumnIndex("name");
            int newAgeIndex = c.getColumnIndex("age");
            int newIdIndex = c.getColumnIndex("id");

            // Perform query
            c.moveToFirst();
            while (c.moveToNext()) {
                // Get content
                Log.i("UserResults - name", c.getString(newNameIndex));
                Log.i("UserResults - age", Integer.toString(c.getInt(newAgeIndex)));
                Log.i("UserResults - id", Integer.toString(c.getInt(newIdIndex)));

            }
            c.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
