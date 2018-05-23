package bilulo.mc1androidtest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class RepositoriesAdapter extends RecyclerView.Adapter<RepositoriesAdapter.RepositoriesAdapterViewHolder> {
    @Override
    public RepositoriesAdapter.RepositoriesAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RepositoriesAdapter.RepositoriesAdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RepositoriesAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public RepositoriesAdapterViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View view) {
            
        }
    }
}
