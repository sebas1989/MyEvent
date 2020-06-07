package punkmkt.com.myevent.database

import com.raizlabs.android.dbflow.annotation.Database

/**
 * Created by sebastianmendezgiron on 13/04/17.
 */
@Database(name = "Notifications", version = 1, generatedClassSeparator = "_")
object AppDatabase {

    val NAME = "AppDatabase"
    val VERSION = 2 //Actualizar version al agregar nuevas cabllas o actualizacciones a alguna.

}
