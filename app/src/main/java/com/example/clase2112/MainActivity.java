package com.example.clase2112;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResultados = findViewById(R.id.tvResultados);

    }

    public void TraerDatos(View view) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "http:/localhost/moviles/servidor.php?hash=123546";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>(){
            @Override
            public void onResponse(JSONArray response){
                tvResultados.setText(response);
            }
        },
                new Response.ErrorListener(){
                @Override
                    public void onErrorReponse(VolleyError error) {
                        Log.e("clase2112", error.getMessage());
                }
                }
        );

            }
        ;
    }
}