package vaksys.in.volleyjsondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import butterknife.Bind;
import butterknife.ButterKnife;
import vaksys.in.volleyjsondemo.pojo.Details;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.rv)
    RecyclerView rv;
    RecyclerView.LayoutManager mLayoutManager;
    public static final String TAG = "MainActivity";

    String url = "http://microblogging.wingnity.com/JSONParsingTutorial/jsonActors";
    List<Details> details;
    InfoAdapter infoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(mLayoutManager);
        //rv.setItemAnimator(new DefaultItemAnimator());
        rv.setHasFixedSize(true);

        StringRequest jsonArrayRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(TAG, response.toString());
                try {

                    JSONObject jsonObj = new JSONObject(response);
                    JSONArray jsonArry = jsonObj.getJSONArray("actors");
                    details = new ArrayList<>();

                    for (int i = 0; i < jsonArry.length(); i++) {
                        JSONObject obj = jsonArry.getJSONObject(i);
                        Details detail = new Details();
                        detail.setImage(obj.getString("image"));
                        detail.setName(obj.getString("name"));
                        detail.setCountry(obj.getString("country"));
                        detail.setSpouse(obj.getString("spouse"));

                        details.add(detail);

                    }
                    infoAdapter = new InfoAdapter(MainActivity.this, details);


                    rv.setAdapter(infoAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        });
        AppSingleton.getInstance().addToRequestQueue(jsonArrayRequest);
    }
}
