package bilulo.mc1androidtest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public class MainFragment extends Fragment {

    private ArrayList<Repository> mReposList;
    private Data mData;
    private RecyclerView mRecyclerView;
    private RepositoriesAdapter mAdapter;
    private static final String LOG_TAG = MainFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main,container,false);

        mRecyclerView = rootView.findViewById(R.id.rv_repos);
        mAdapter = new RepositoriesAdapter();


        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        final RepositoriesInterface repositoriesInterface = RetrofitBuilder.buildRepositoriesInterface();
        final Call<Data> fetchRepositoriesTask = repositoriesInterface.listRepositories("Kotlin", "stars", "1");

        fetchRepositoriesTask.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                mData = response.body();
                if (mData!=null) {
                    mReposList = mData.getItems();
                    mAdapter.setReposData(mReposList);
                    mRecyclerView.setAdapter(mAdapter);
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d(LOG_TAG,t.toString());
            }
        });

        super.onActivityCreated(savedInstanceState);
    }
}
