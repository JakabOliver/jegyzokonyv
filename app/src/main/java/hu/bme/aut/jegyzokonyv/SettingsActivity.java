package hu.bme.aut.jegyzokonyv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    Button btnSetHome;
    Button btnSetAway;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);


        btnSetHome = findViewById(R.id.HomeLineUpbutton);
        btnSetAway = findViewById(R.id.AwayLineUpbutton);
        btnSetHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(view.getContext(),SetLineUpActivity.class);
                i.putExtra("team", "home");
                view.getContext().startActivity(i);
            }
        });
        btnSetAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(view.getContext(), SetLineUpActivity.class);
                i.putExtra("team", "away");
                view.getContext().startActivity(i);
            }
        });
    }

}
