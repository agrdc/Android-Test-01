package bilulo.mc1androidtest.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import bilulo.mc1androidtest.R;

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
