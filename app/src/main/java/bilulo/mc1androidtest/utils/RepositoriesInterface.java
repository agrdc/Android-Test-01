package bilulo.mc1androidtest.utils;

import java.util.List;

import bilulo.mc1androidtest.models.Repository;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RepositoriesInterface {
    @GET("search/repositories?q=language:{language}&sort=stars&page=1")
    Call<List<Repository>> listRepositories(@Path("language") String language);
}
