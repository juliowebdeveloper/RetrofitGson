package julio.com.br.retrofitgson.api;

import java.util.List;

import julio.com.br.retrofitgson.model.Change;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Shido on 05/03/2017.
 */

public interface GerritAPI {

    @GET("changes/")
    Call<List<Change>> loadChangeList(@Query("q") String status);

    @POST("/posts")
    @FormUrlEncoded
    Call<List<Change>> savePost(@Field("title") String title,
                        @Field("body") String body,
                        @Field("userId") long userId);

}
