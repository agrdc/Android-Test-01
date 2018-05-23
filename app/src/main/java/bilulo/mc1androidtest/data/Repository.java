package bilulo.mc1androidtest.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Repository implements Parcelable {

    String name;
    String description;
    RepositoryOwner owner;
    int stargazers_count;
    int forks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RepositoryOwner getOwner() {
        return owner;
    }

    public void setOwner(RepositoryOwner owner) {
        this.owner = owner;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public void setStargazers_count(int stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeParcelable(this.owner, flags);
        dest.writeInt(this.stargazers_count);
        dest.writeInt(this.forks);
    }

    public Repository() {
    }

    protected Repository(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.owner = in.readParcelable(RepositoryOwner.class.getClassLoader());
        this.stargazers_count = in.readInt();
        this.forks = in.readInt();
    }

    public static final Parcelable.Creator<Repository> CREATOR = new Parcelable.Creator<Repository>() {
        @Override
        public Repository createFromParcel(Parcel source) {
            return new Repository(source);
        }

        @Override
        public Repository[] newArray(int size) {
            return new Repository[size];
        }
    };
}
