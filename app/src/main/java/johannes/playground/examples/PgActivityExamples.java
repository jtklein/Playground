package johannes.playground.examples;

import android.os.Bundle;

import johannes.playground.PgActivityButtonMenu;
import johannes.playground.PgListViewButtonMenuItem;
import johannes.playground.R;
import johannes.playground.examples.celebrityguess.PgActivityCelebrityGuess;
import johannes.playground.examples.eggtimer.PgActivityEggTimer;
import johannes.playground.examples.higherlower.PgActivityHigherLower;
import johannes.playground.examples.numbershapes.PgActivityNumberShapes;
import johannes.playground.examples.phrasebook.PgActivityPhraseBook;
import johannes.playground.examples.sumtrainer.PgActivitySumTrainer;
import johannes.playground.examples.tictactoe.PgActivityTicTacToe;
import johannes.playground.examples.timestables.PgActivityTimesTables;
import johannes.playground.examples.weatherjson.PgActivityWeatherJSON;

/**
 * Created by johannesklein on 19.11.16.
 */
public class PgActivityExamples extends PgActivityButtonMenu {

    private PgListViewButtonMenuItem[] mData = new PgListViewButtonMenuItem[]{
            new PgListViewButtonMenuItem(R.string.ui_weather_json, PgActivityWeatherJSON.class),
            new PgListViewButtonMenuItem(R.string.ui_celebrity_guess, PgActivityCelebrityGuess.class),
            new PgListViewButtonMenuItem(R.string.ui_higher_or_lower, PgActivityHigherLower.class),
            new PgListViewButtonMenuItem(R.string.ui_number_shapes, PgActivityNumberShapes.class),
            new PgListViewButtonMenuItem(R.string.ui_tic_tac_toe, PgActivityTicTacToe.class),
            new PgListViewButtonMenuItem(R.string.ui_phrase_book, PgActivityPhraseBook.class),
            new PgListViewButtonMenuItem(R.string.ui_times_tables, PgActivityTimesTables.class),
            new PgListViewButtonMenuItem(R.string.ui_egg_timer, PgActivityEggTimer.class),
            new PgListViewButtonMenuItem(R.string.ui_sum_trainer, PgActivitySumTrainer.class),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        super.setTheAdapter(mData);
    }
}
