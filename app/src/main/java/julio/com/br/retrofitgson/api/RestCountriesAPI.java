package julio.com.br.retrofitgson.api;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import julio.com.br.retrofitgson.model.Country;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;



/**
 * Created by Shido on 05/03/2017.
 */

public class RestCountriesAPI {

   private static final  String service_url = "https://restcountries.eu/rest/v1/";
   /* In your API classes the first thing you have to do is to define the interfaces, that mean saying Java what
    are the REST API classes that you are going to work with. In our example that would be getting the country list from the API by calling ‘/all’.*/
    public interface GetAllAPI{
        @GET("all/")
        Call<List<Country>> getCountries();
    }

    public void getAllCountries(){
        Gson gson = new GsonBuilder().create();
/*
        RestAdapter class is responsible generating the implementation of our interfaces in out case GetAllAPI interface.
*/
     /*   RestAdapter restAdapter  = new RestAdapter.Builder().setEndpoint(service_url).setConverter(new GsonConverter(gson)).build();
        GetAllAPI getAllApi = restAdapter.create(GetAllAPI.class);
        List<Country> countries = getAllApi.getCountries();
        return countries;*/
        Retrofit retrofit = new Retrofit.Builder().baseUrl(service_url).addConverterFactory(GsonConverterFactory.create(gson)).build();
        GetAllAPI getAllApi = retrofit.create(GetAllAPI.class);
        Call<List<Country>> call = getAllApi.getCountries();
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                if(response.isSuccessful()){
                    List<Country > countries = response.body();
                    for (Country c:
                         countries) {
                        Log.e("SUPERTAG",c.getName());
                        Log.e("SUPERTAG",c.getAlphaCode());
                        Log.e("SUPERTAG",c.getCapital());
                        Log.e("SUPERTAG",c.getRegion());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                    t.printStackTrace();
            }
        });

    }




}
