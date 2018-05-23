package bilulo.mc1androidtest.utils;

import bilulo.mc1androidtest.data.Data;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RepositoriesInterface {
    @GET("search/repositories?q=language&sort&page")
    Call<Data> listRepositories(@Query("language") String language,
                                @Query("sort") String sort,
                                @Query("page") String page);
}
