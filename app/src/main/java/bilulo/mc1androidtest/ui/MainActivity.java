package bilulo.mc1androidtest.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import bilulo.mc1androidtest.R;
import bilulo.mc1androidtest.adapter.RepositoriesAdapter;
import bilulo.mc1androidtest.data.Data;
import bilulo.mc1androidtest.data.Repository;
import bilulo.mc1androidtest.utils.RepositoriesInterface;
import bilulo.mc1androidtest.utils.RetrofitBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final String MAIN_FRAGMENT_TAG = "main-fragment";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (getSupportFragmentManager().findFragmentByTag(MAIN_FRAGMENT_TAG) == null) {
            MainFragment mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, mainFragment, MAIN_FRAGMENT_TAG)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
