package com.example.catalogodefilmes;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    ImageView image_poster;
    TextView text_title;
    TextView text_voteaverage;
    TextView text_imdbid;
    TextView text_overview;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setTitle(R.string.list_details);

        image_poster = (ImageView) findViewById(R.id.image_poster);
        text_title = (TextView) findViewById(R.id.text_title);
        text_voteaverage = (TextView) findViewById(R.id.text_voteaverage);
        text_imdbid = (TextView) findViewById(R.id.text_imdbid);
        text_overview = (TextView) findViewById(R.id.text_overview);

        new DownloadImage(image_poster).execute("https://image.tmdb.org/t/p/w500/vqzNJRH4YyquRiWxCCOH0aXggHI.jpg");
        text_title.setText("Terminator: Dark Fate");
        text_voteaverage.setText("6.6" + "/10");
        text_imdbid.setText("IDMB " + "6450804");
        text_overview.setText("More than two decades have passed since Sarah Connor prevented Judgment Day, changed the future, and re-wrote the fate of the human race. Dani Ramos is living a simple life in Mexico City with her brother and father when a highly advanced and deadly new Terminator – a Rev-9 – travels back through time to hunt and kill her. Dani's survival depends on her joining forces with two warriors: Grace, an enhanced super-soldier from the future, and a battle-hardened Sarah Connor. As the Rev-9 ruthlessly destroys everything and everyone in its path on the hunt for Dani, the three are led to a T-800 from Sarah’s past that may be their last best hope.");
    }
}
