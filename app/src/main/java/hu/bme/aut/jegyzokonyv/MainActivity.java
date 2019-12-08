package hu.bme.aut.jegyzokonyv;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import hu.bme.aut.jegyzokonyv.data.DataManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnStart = findViewById(R.id.start_button);
        Button btnSettings = findViewById(R.id.setting_button);
        final Button btnExit = findViewById(R.id.exit_button);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gameIntent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(gameIntent);
            }
        });
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settingsIntent);
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialogButtonClicked(view);
            }
        });

        DataManager.destroyData();
        DataManager dtm = DataManager.getInstance();

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Kilépés")
                .setMessage("Biztosan bezárod az alkalmazást?")
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Nem", null)
                .show();
    }

    public void showAlertDialogButtonClicked(View view) {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Kilépés")
                .setMessage("Biztosan bezárod az alkalmazást?")
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Nem", null)
                .show();
    }
}
