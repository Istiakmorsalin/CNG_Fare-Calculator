package namelesskuet.com.cngfare;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {


    EditText distance;
    EditText waitingTime;
    TextView fare;
    Button calculate, report;
    double distanceInKm = 0, waitingTimeInMinute = 0;

    double vara = 0;

    String number = "9007574";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        distance = (EditText) findViewById(R.id.txtNumber1);
        waitingTime = (EditText) findViewById(R.id.txtNumber2);
        fare = (TextView) findViewById(R.id.txtResult);
        calculate = (Button) findViewById(R.id.btnAdd);
        report = (Button) findViewById(R.id.reportButton);

        calculate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                distanceInKm = Double.parseDouble(distance.getText().toString());
                waitingTimeInMinute = Double.parseDouble(waitingTime.getText().toString());


                fairCalculate(distanceInKm, waitingTimeInMinute);
                fare.setText("ভাড়া:" + " " + Double.toString(vara) + " " + "টাকা");
            }
        });

        report.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                reportToAuthority();
            }
        });
    }


    public double fairCalculate(double distance, double waitingTime) {
        vara = 40 + (distance - 2) * 12 + waitingTime * 2;
        return vara;
    }

    public void reportToAuthority() {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
        startActivity(intent);
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
}
