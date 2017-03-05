package julio.com.br.retrofitgson.api;

import java.util.List;

import julio.com.br.retrofitgson.model.Change;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Shido on 05/03/2017.
 */

public interface GerritAPI {

    @GET("changes/")
    Call<List<Change>> loadChangeList(@Query("q") String status);

}
