package bilulo.mc1androidtest.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataInteractor {
        @GET("search/repositories?q=language&sort&page")
        Call<Data> listRepositories(@Query("language") String language,
                                    @Query("sort") String sort,
                                    @Query("page") String page);
}
