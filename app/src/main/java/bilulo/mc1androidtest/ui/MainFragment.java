package bilulo.mc1androidtest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import bilulo.mc1androidtest.R;
import bilulo.mc1androidtest.adapter.RepositoriesAdapter;
import bilulo.mc1androidtest.data.Data;
import bilulo.mc1androidtest.data.DataInteractor;
import bilulo.mc1androidtest.data.DataInteractorImpl;
import bilulo.mc1androidtest.data.Repository;
import bilulo.mc1androidtest.presenter.RepositoriesPresenter;


public class MainFragment extends Fragment implements RepositoriesView{

    private ArrayList<Repository> mReposList;
    private Data mData;
    private RepositoriesPresenter presenter;
    private RecyclerView mRecyclerView;
    private RepositoriesAdapter mAdapter;
    private static final String LOG_TAG = MainFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main,container,false);

        mRecyclerView = rootView.findViewById(R.id.rv_repos);
        mAdapter = new RepositoriesAdapter();


        DataInteractor interactor = new DataInteractorImpl();
        presenter = new RepositoriesPresenter(interactor);
        presenter.bind(this);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        presenter.fetchRepositoriesTask("Kotlin","stars","1");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void updateUI(ArrayList<Repository> reposList) {
        if (reposList!=null && !reposList.isEmpty()) {
            mAdapter.setReposData(reposList);
            mRecyclerView.setAdapter(mAdapter);
        }
    }
}
