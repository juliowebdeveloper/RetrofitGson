package julio.com.br.retrofitgson.api;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import julio.com.br.retrofitgson.model.Change;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Shido on 05/03/2017.
 */

public class Controller  {
    static final String BASE_URL = "https://git.eclipse.org/r/";

    public void start(){
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        GerritAPI gerritAPI = retrofit.create(GerritAPI.class);
       // Call<List<Change>> call = gerritAPI.loadChangeList("status:open");
            Call<List<Change>> call = gerritAPI.loadChangeList(null);
        call.enqueue(new Callback<List<Change>>() {
            @Override
            public void onResponse(Call<List<Change>> call, Response<List<Change>> response) {
                if(response.isSuccessful()){
                    List<Change> changeList = response.body();
                    for (Change g: changeList
                            ) {
                        Log.e("TAG", g.getSubject());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Change>> call, Throwable t) {
                t.printStackTrace();

            }
        });





    }

    /*@Override
    public void onResponse(Call<List<Change>> call, Response<List<Change>> response) {
            if(response.isSuccessful()){
                List<Change> changeList = response.body();
                for (Change g: changeList
                     ) {
                    Log.e("TAG", g.getSubject());
                }
            }
    }

    @Override
    public void onFailure(Call<List<Change>> call, Throwable t) {
        t.printStackTrace();
    }*/
}
