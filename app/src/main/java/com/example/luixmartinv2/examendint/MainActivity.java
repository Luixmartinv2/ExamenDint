package com.example.luixmartinv2.examendint;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    public Spinner SprVehi= (Spinner) findViewById(R.id.SprVehi);

    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
            R.layout.arrays, R.layout.arrays);
// Specify the layout to use when the list of choices appears
    adapter.setDropDownViewResource(layout);
// Apply the adapter to the spinner
    SprVehi.setAdapter(adapter);





    public Spinner SprColor= (Spinner) findViewById(R.id.SprColor);
    public EditText editText3= (EditText) findViewById(R.id.editText3);
    public Button btnA= (Button) findViewById(R.id.btnA);
    public LinearLayout garaje;


    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void onClick(View view) {
        btnA.callOnClick();
        //comparamos el elemento del array del Spinner con las opciones y filtramos con un array "vehiculo"
        String a,e,i;
        a=SprVehi.toString();
        e=SprColor.toString();
        i=editText3.toString();


        String vehiculo[] = {a,e,i};
        }


    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
