package bilulo.mc1androidtest.utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class RetrofitBuilder {
    
    static RepositoriesInterface reposInterface;
    static OkHttpClient httpClient = new OkHttpClient.Builder().build();

    public static RepositoriesInterface buildRepositoriesInterface() {
        reposInterface = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(httpClient)
                .build().create(RepositoriesInterface.class);
        return reposInterface;
    }

}
