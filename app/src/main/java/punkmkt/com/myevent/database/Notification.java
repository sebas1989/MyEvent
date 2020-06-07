package punkmkt.com.myevent.database

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel

/**
 * Created by sebastianmendezgiron on 13/04/17.
 */

@Table(database = AppDatabase::class)
class Notification : BaseModel() {
    @Column
    @PrimaryKey(autoincrement = true)
    internal var id: Long = 0

    @Column
    var name: String? = null

    @Column
    var type: String? = null

    @Column
    var active: Int = 0
}
