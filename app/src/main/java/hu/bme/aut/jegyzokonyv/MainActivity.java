package hu.bme.aut.jegyzokonyv;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import hu.bme.aut.jegyzokonyv.data.DataManager;
import hu.bme.aut.jegyzokonyv.data.Round;
import hu.bme.aut.jegyzokonyv.network.APIClient;
import hu.bme.aut.jegyzokonyv.network.APIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnStart = findViewById(R.id.start_button);
        Button btnSettings = findViewById(R.id.setting_button);
        final Button btnExit = findViewById(R.id.exit_button);
        Button networkTestButton = findViewById(R.id.networkTestButton);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valid()) {
                    Intent gameIntent = new Intent(MainActivity.this, GameActivity.class);
                    startActivity(gameIntent);
                } else {
                    Toast.makeText(view.getContext(), getResources().getString(R.string.settings_incompete),
                            Toast.LENGTH_LONG).show();
                }
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

        networkTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDoalog = new ProgressDialog(MainActivity.this);
                progressDoalog.setMessage("Loading....");
                progressDoalog.show();
                APIInterface service = APIClient.getRetrofitInstance().create(APIInterface.class);
                Call<List<Round>> call = service.getAllRounds();
                call.enqueue(new Callback<List<Round>>() {
                    @Override
                    public void onResponse(Call<List<Round>> call, Response<List<Round>> response) {
                        progressDoalog.dismiss();
                       // Toast.makeText(MainActivity.this, response.body().size(), Toast.LENGTH_SHORT).show();
                        DataManager dtm= DataManager.getInstance();
                        dtm.setRounds(response.body());
                        dtm.getMatch();
                    }

                    @Override
                    public void onFailure(Call<List<Round>> call, Throwable t) {
                        progressDoalog.dismiss();
                        Toast.makeText(MainActivity.this, "Something went wrong...Please try later!\n" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    private boolean valid() {
        DataManager dtm = DataManager.getInstance();
        return dtm.getMatch().readyToStart();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(getResources().getString(R.string.exit))
                .setMessage(getResources().getString(R.string.are_you_sure))
                .setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton(getResources().getString(R.string.no), null)
                .show();
    }

    public void showAlertDialogButtonClicked(View view) {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(getResources().getString(R.string.exit))
                .setMessage(getResources().getString(R.string.are_you_sure))
                .setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton(getResources().getString(R.string.no), null)
                .show();
    }
}
