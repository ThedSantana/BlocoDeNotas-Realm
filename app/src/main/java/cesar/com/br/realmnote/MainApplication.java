package cesar.com.br.realmnote;

import android.app.Application;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

/**
 * Created by Cesar on 13/11/2016.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        RealmDB realmDB = new RealmDB(this);
        realmDB.setMigration(new DataMigration());
    }

    private class DataMigration implements RealmMigration {
        @Override
        public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

            RealmSchema schema = realm.getSchema();

            if (oldVersion == 0) {
                schema.create("Note")
                        .addField("id", int.class)
                        .addField("note", String.class)
                        .addField("dateModified", String.class);
                oldVersion++;
            }

        }
    }
}
