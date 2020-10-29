package pl.emb.myapplication2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button secondActivityBtn = findViewById(R.id.secondActivityBtn);
        Button googleBtn = findViewById(R.id.googleBtn);
        Button mapBtn = findViewById(R.id.mapBtn);
        Button phoneBtn = findViewById(R.id.phoneBtn);
        Button computeBtn = findViewById(R.id.computeBtn);

        secondActivityBtn.setOnClickListener(getOpenSecondActivityListener());
        googleBtn.setOnClickListener(getOpenActivityListener(
                Intent.ACTION_VIEW, "http://www.google.com"));
        mapBtn.setOnClickListener(getOpenActivityListener(
                Intent.ACTION_VIEW, "geo:37.422219,-122.08364?z=14"));
        phoneBtn.setOnClickListener(getOpenActivityListener(
                Intent.ACTION_DIAL, "tel:5551234"));
        computeBtn.setOnClickListener(getOpenComputeDeltaActivityListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public View.OnClickListener getOpenActivityListener(final String intentAction,
                                                        final String uri) {
        return  new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Uri number = Uri.parse(uri);
                Intent callIntent = new Intent(intentAction, number);
                if (callIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(callIntent);
                }
            }
        };
    }

    public View.OnClickListener getOpenSecondActivityListener() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(startIntent);
            }
        };
    }

    public View.OnClickListener getOpenComputeDeltaActivityListener() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(),
                        ComputeDeltaActivity.class);
                startActivity(startIntent);
            }
        };
    }


}