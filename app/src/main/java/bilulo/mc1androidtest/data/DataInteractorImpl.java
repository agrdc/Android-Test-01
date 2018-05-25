package bilulo.mc1androidtest.data;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataInteractorImpl implements DataInteractor {
        static DataInteractor dataInteractor;
        static OkHttpClient httpClient = new OkHttpClient.Builder().build();

        public DataInteractorImpl() {
             dataInteractor = new Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                    .client(httpClient)
                    .build().create(DataInteractor.class);
        }

    @Override
    public Call<Data> listRepositories(String language, String sort, String page) {
        return dataInteractor.listRepositories(language,sort,page);
    }
}
