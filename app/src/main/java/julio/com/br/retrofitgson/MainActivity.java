package julio.com.br.retrofitgson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import julio.com.br.retrofitgson.api.Controller;
import julio.com.br.retrofitgson.api.RestCountriesAPI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Controller c = new Controller();
        c.start();
        Log.e("MAIN ACTIVITY", "-------------------------------");
        RestCountriesAPI restCountriesAPI = new RestCountriesAPI();
       // restCountriesAPI.getAllCountries();
    }
}
