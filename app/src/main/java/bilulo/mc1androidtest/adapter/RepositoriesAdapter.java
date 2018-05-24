package bilulo.mc1androidtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import bilulo.mc1androidtest.R;
import bilulo.mc1androidtest.data.Repository;
import bilulo.mc1androidtest.data.RepositoryOwner;

public class RepositoriesAdapter extends RecyclerView.Adapter<RepositoriesAdapter.RepositoriesAdapterViewHolder> {

    private static final String LOG_TAG = RepositoriesAdapter.class.getSimpleName();
    private ArrayList<Repository> mReposList;
    private Context mContext;

    public RepositoriesAdapter() {

    }

    @Override
    public RepositoriesAdapter.RepositoriesAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.repo_item, parent, false);
        return new RepositoriesAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RepositoriesAdapter.RepositoriesAdapterViewHolder holder, int position) {
        Repository repo = mReposList.get(position);
        RepositoryOwner repoOwner = repo.getOwner();
        String name = repo.getName();
        String description = repo.getDescription();
        String login = repoOwner.getLogin();
        String avatar_url_str = repoOwner.getAvatar_url();
        int stars = repo.getStargazers_count();
        int forks = repo.getForks();

        holder.textViewName.setText(name);
        holder.textViewDescription.setText(description);
        holder.textViewLogin.setText(login);
        holder.textViewStars.setText(String.valueOf(stars));
        holder.textViewForks.setText(String.valueOf(forks));

        Picasso.get().load(avatar_url_str)
                .into(holder.imageViewPhoto);
    }

    @Override
    public int getItemCount() {
        if (mReposList == null)
            return 0;
        else
            return mReposList.size();
    }

    public void setReposData(ArrayList<Repository> reposList) {
        mReposList = reposList;
        notifyDataSetChanged();
    }

    public class RepositoriesAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView textViewName;
        public final TextView textViewDescription;
        public final TextView textViewLogin;
        public final TextView textViewStars;
        public final TextView textViewForks;
        public final ImageView imageViewPhoto;

        public RepositoriesAdapterViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.tv_name);
            textViewDescription = itemView.findViewById(R.id.tv_desc);
            textViewLogin = itemView.findViewById(R.id.tv_login);
            textViewStars = itemView.findViewById(R.id.tv_stars);
            textViewForks = itemView.findViewById(R.id.tv_forks);
            imageViewPhoto = itemView.findViewById(R.id.iv_photo);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
