package hu.bme.aut.jegyzokonyv;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import hu.bme.aut.jegyzokonyv.data.DataManager;

public class GameActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        DataManager dtm = DataManager.getInstance();

    }

}
