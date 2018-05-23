package bilulo.mc1androidtest.data;

import android.net.Uri;
import android.provider.BaseColumns;

public class RepositoryContract {

    public static final String CONTENT_AUTHORITY = "com.bilulo.mc1androidtest";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_KOTLIN_REPOS = "kotlin_repos";

    public static final class RepositoryEntry implements BaseColumns {

        public static final Uri KOTLIN_REPOS_CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_KOTLIN_REPOS)
                .build();

        public static final String KOTLIN_REPOS_TABLE_NAME = PATH_KOTLIN_REPOS;

        public static final String COLUMN_REPO_ID = "repo_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_LOGIN = "login";
        public static final String COLUMN_STARS = "stars";
        public static final String COLUMN_FORKS = "forks";
        public static final String COLUMN_AUTHOR_PICTURE = "author_picture";

        public static Uri buildRepoUriWithID(long id) {
            return BASE_CONTENT_URI.buildUpon()
                    .appendPath(PATH_KOTLIN_REPOS)
                    .appendPath(Long.toString(id))
                    .build();
        }
    }
}
