package johannes.playground.examples.celebrityguess;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import johannes.playground.L;
import johannes.playground.PgActivity;
import johannes.playground.R;

/**
 * Created by johannesklein on 21.11.16.
 */
public class PgActivityCelebrityGuess extends PgActivity {

    private ProgressBar mProgressBar = null;

    private LinearLayout mContainerGame = null;

    private GridLayout mContainerAnswers = null;
    private Button[] mAnswerButtons = null;

    private ImageView mImageView = null;

    private static String mResult = null;

    private ArrayList<String> celebURLs = new ArrayList<String>();
    private ArrayList<String> celebNames = new ArrayList<String>();

    private Bitmap mBitmap = null;

    private int chosenCeleb = 0;
    private static String[] answers = null;
    private static int theCorrectAnswer = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pg_activity_celebrity_guess);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBarCelebGuess);

        mContainerGame = (LinearLayout) findViewById(R.id.containerCelebGuess);

        mImageView = (ImageView) findViewById(R.id.imageViewCelebGuess);

        mContainerAnswers = (GridLayout) findViewById(R.id.containerAnswersCelebGuess);

        // Build an array of the answer buttons
        mAnswerButtons = new Button[4];
        for (int i = 0; i < mAnswerButtons.length; i++){
            Button button = (Button) mContainerAnswers.getChildAt(i);
            mAnswerButtons[i] = button;

        }

        StringDownloader task = new StringDownloader();

        task.execute("http://www.posh24.com/celebrities");

    }

    private void updateButtons() {

        // Show answers in buttons
        for (int i = 0; i < answers.length; i++){
            mAnswerButtons[i].setText(String.valueOf(answers[i]));
            final int position = i;
            mAnswerButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Correct answer
                    if (position == theCorrectAnswer){
                        L.t(getApplicationContext(),"Correct");

                    } else {
                        L.t(getApplicationContext(), "Wrong it was: " + celebNames.get(chosenCeleb));
                    }
                    startNewRound();
                    generateAnswers();
                    updateButtons();
                }
            });
        }

    }

    private void startNewRound() {
        Random random = new Random();
        chosenCeleb = random.nextInt(celebURLs.size());

        ImageDownloader imageTask = new ImageDownloader();

        imageTask.execute(celebURLs.get(chosenCeleb));

    }

    private void generateAnswers() {
        // Generate an array with random celeb names from the list
        answers = new String[4];
        for (int i = 0; i < answers.length; i++){

            Random random = new Random();
            answers[i] = celebNames.get(random.nextInt(celebNames.size()));
        }

        // Generate a random index for answers array
        theCorrectAnswer = (int) (Math.random() * answers.length);

        // Put correct answer in array at index
        answers[theCorrectAnswer] = celebNames.get(chosenCeleb);
    }

    private void processString(){

        String[] splitResult = mResult.split("<div class=\"sidebarContainer\">");

        // Regex
        Pattern p = Pattern.compile("img src=\"(.*?)\"");
        Matcher m = p.matcher(splitResult[0]);

        while (m.find()) {
            celebURLs.add(m.group(1));

        }

        // Regex
        p = Pattern.compile("alt=\"(.*?)\"");
        m = p.matcher(splitResult[0]);

        while (m.find()) {
            celebNames.add(m.group(1));

        }

    }

    public class StringDownloader extends AsyncTask<String, Void, String>{

        @Override
        protected void onPreExecute() {
            // Change to loading layout
            mContainerGame.setVisibility(View.INVISIBLE);
            mProgressBar.setVisibility(View.VISIBLE);

        }

        @Override
        protected String doInBackground(String... strings) {
            // Get String param as URL

            String result = "";
            URL url = null;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);

                int data = reader.read();
                while (data != -1){
                    char currentChar = (char) data;
                    result += currentChar;
                    data = reader.read();

                }

                return result;

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String aString) {
            // Change to game layout
            mProgressBar.setVisibility(View.INVISIBLE);
            mContainerGame.setVisibility(View.VISIBLE);

            mResult = aString;
            processString();
            startNewRound();
            generateAnswers();
            updateButtons();

        }
    }

    public class ImageDownloader extends AsyncTask<String, Void, Bitmap>{
        @Override
        protected Bitmap doInBackground(String... strings) {

            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.connect();

                InputStream inputStream = connection.getInputStream();

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                return bitmap;

            } catch (MalformedURLException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();

            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {

            mBitmap = bitmap;

            mImageView.setImageBitmap(mBitmap);

        }
    }

}
