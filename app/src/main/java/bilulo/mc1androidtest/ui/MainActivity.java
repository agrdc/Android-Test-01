package bilulo.mc1androidtest.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import bilulo.mc1androidtest.R;
import bilulo.mc1androidtest.data.Data;
import bilulo.mc1androidtest.data.Repository;
import bilulo.mc1androidtest.utils.RepositoriesInterface;
import bilulo.mc1androidtest.utils.RetrofitBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private ArrayList<Repository> mReposList;
    private Data mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RepositoriesInterface repositoriesInterface = RetrofitBuilder.buildRepositoriesInterface();
        final Call<Data> fetchRepositoriesTask = repositoriesInterface.listRepositories("Kotlin", "stars", "1");

        fetchRepositoriesTask.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                mData = response.body();
                if (mData!=null) {
                    mReposList = mData.getItems();
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d(LOG_TAG,t.toString());
            }
        });
    }
}
