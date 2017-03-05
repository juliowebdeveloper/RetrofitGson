package julio.com.br.retrofitgson.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import julio.com.br.retrofitgson.model.Country;
import retrofit2.http.GET;



/**
 * Created by Shido on 05/03/2017.
 */

public class RestCountriesAPI {

   private static final  String service_url = "https://restcountries.eu/rest/v1";
   /* In your API classes the first thing you have to do is to define the interfaces, that mean saying Java what
    are the REST API classes that you are going to work with. In our example that would be getting the country list from the API by calling ‘/all’.*/
    public interface GetAllAPI{
        @GET("/all")
        List<Country> getCountries();
    }

    public List<Country> getAllCountries(){
        Gson gson = new GsonBuilder().create();
/*
        RestAdapter class is responsible generating the implementation of our interfaces in out case GetAllAPI interface.
*/
     /*   RestAdapter restAdapter  = new RestAdapter.Builder().setEndpoint(service_url).setConverter(new GsonConverter(gson)).build();
        GetAllAPI getAllApi = restAdapter.create(GetAllAPI.class);
        List<Country> countries = getAllApi.getCountries();
        return countries;*/
        return null;
    }




}
