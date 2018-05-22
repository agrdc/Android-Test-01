package bilulo.mc1androidtest.utils;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    
    static RepositoriesInterface reposInterface;
    static OkHttpClient httpClient = new OkHttpClient.Builder().build();

    public static RepositoriesInterface buildRepositoriesInterface() {
        reposInterface = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .client(httpClient)
                .build().create(RepositoriesInterface.class);
        return reposInterface;
    }

}
