package bilulo.mc1androidtest.data;

import android.os.Parcel;
import android.os.Parcelable;

public class RepositoryOwner implements Parcelable {
    String login;
    String avatar_url;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.login);
        dest.writeString(this.avatar_url);
    }

    public RepositoryOwner() {
    }

    protected RepositoryOwner(Parcel in) {
        this.login = in.readString();
        this.avatar_url = in.readString();
    }

    public static final Creator<RepositoryOwner> CREATOR = new Creator<RepositoryOwner>() {
        @Override
        public RepositoryOwner createFromParcel(Parcel source) {
            return new RepositoryOwner(source);
        }

        @Override
        public RepositoryOwner[] newArray(int size) {
            return new RepositoryOwner[size];
        }
    };
}
