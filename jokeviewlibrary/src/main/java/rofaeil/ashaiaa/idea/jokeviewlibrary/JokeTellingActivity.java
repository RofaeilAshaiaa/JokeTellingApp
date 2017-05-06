package rofaeil.ashaiaa.idea.jokeviewlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeTellingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_telling);

        Intent intent = getIntent() ;
        if(intent.hasExtra(getString(R.string.joke_key) )){
            String joke = intent.getStringExtra(getString(R.string.joke_key));
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(joke);
        }


    }
}
