package vaksys.in.volleyjsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import vaksys.in.volleyjsondemo.pojo.Details;
import vaksys.in.volleyjsondemo.pojo.NewResponse;

public class Main2Activity extends AppCompatActivity {
    String url = "http://microblogging.wingnity.com/JSONParsingTutorial/jsonActors";
    @Bind(R.id.rv1)
    RecyclerView rv;
    StaggeredGridLayoutManager gaggeredGridLayoutManager;
    NewResponse details;
    InfoAdapter1 infoAdapter;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2,1);
        rv.setLayoutManager(gaggeredGridLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setHasFixedSize(true);


        LoadView();
    }

    private void LoadView() {
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                gson = new Gson();
                details = gson.fromJson(response, NewResponse.class);
                infoAdapter = new InfoAdapter1(Main2Activity.this, details.getActors());
                rv.setAdapter(infoAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppSingleton.getInstance().addToRequestQueue(stringRequest);
    }
}
