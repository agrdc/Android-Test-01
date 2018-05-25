package bilulo.mc1androidtest.presenter;

import java.util.ArrayList;

import bilulo.mc1androidtest.data.Data;
import bilulo.mc1androidtest.data.DataInteractor;
import bilulo.mc1androidtest.data.Repository;
import bilulo.mc1androidtest.ui.RepositoriesView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoriesPresenter {
    RepositoriesView repositoriesView;
    private Data mData;
    private ArrayList<Repository> mReposList;
    private DataInteractor dataInteractor;

    public RepositoriesPresenter(DataInteractor interactor) {
        dataInteractor = interactor;
    }

    public void bind(RepositoriesView view) {
        repositoriesView = view;
    }

    public void unbind() {
        repositoriesView = null;
    }

    public void fetchRepositoriesTask(String language, String sortBy, String page) {
        dataInteractor.listRepositories(language,sortBy,page).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (repositoriesView!=null) {
                    mData = response.body();
                    mReposList = mData.getItems();
                    repositoriesView.updateUI(mReposList);
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });
    }
}
