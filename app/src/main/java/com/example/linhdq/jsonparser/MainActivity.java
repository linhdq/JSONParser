package com.example.linhdq.jsonparser;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.linhdq.jsonparser.json_model.WeatherInfo;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    //api
    private static final String API_KEY = "201b3849bd1975ca152b20fb7f3d1346";
    private static final String ZIP_CODE = "100000";//ha noi
    private static final String COUNTRY_CODE = "vi";
    private static final String MAIN_API = "http://api.openweathermap.org/data/2.5/weather?q=" + ZIP_CODE
            + "," + COUNTRY_CODE + "&appid=" + API_KEY;
    //view
    private TextView txtDescription;
    private TextView txtTemp;
    private TextView txtPressure;
    private TextView txtHumidity;
    private TextView txtWindSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //get json from api
        new GetJSON().execute(MAIN_API);
    }

    private void init() {
        //view
        txtDescription = (TextView) findViewById(R.id.txt_description_value);
        txtTemp = (TextView) findViewById(R.id.txt_temp_value);
        txtPressure = (TextView) findViewById(R.id.txt_pressure_value);
        txtHumidity = (TextView) findViewById(R.id.txt_humidity_value);
        txtWindSpeed = (TextView) findViewById(R.id.txt_wind_speed);
    }

    private void parserJSON(String json) {
        try {
            Gson gson = new Gson();
            WeatherInfo weatherInfo = gson.fromJson(json, WeatherInfo.class);
            //fill data
            if (weatherInfo != null) {
                txtDescription.setText(weatherInfo.getWeatherItemList().get(0).getDescription());
                txtTemp.setText(String.format("%.2f \u00B0C", weatherInfo.getMainModel().getTemp() / 17.22f));
                txtPressure.setText(String.format("%.2f %s",
                        weatherInfo.getMainModel().getPressure() * 0.0098692326, "atm"));
                txtHumidity.setText(String.format("%d %s", weatherInfo.getMainModel().getHumidity(), "%"));
                txtWindSpeed.setText(String.format("%.2f %s", weatherInfo.getWindModel().getSpeed(), "m/s"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private class GetJSON extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String json = "";
            try {
                json = getJSON(params[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return json;
        }

        @Override
        protected void onPostExecute(String s) {
            if (s != null) {
                parserJSON(s);
            }
        }

        private String getJSON(String urls) throws Exception {
            BufferedReader reader = null;
            URLConnection uc = null;
            String json = "";

            try {
                URL url = new URL(urls);
                uc = url.openConnection();
                uc.connect();
                reader = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                StringBuffer buffer = new StringBuffer();
                int read;
                char[] chars = new char[1024];
                while ((read = reader.read(chars)) != -1)
                    buffer.append(chars, 0, read);

                json = buffer.toString();
            } finally {
                if (reader != null)
                    reader.close();
            }
            return json;
        }
    }
}
