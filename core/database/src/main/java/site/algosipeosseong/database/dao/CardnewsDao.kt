package site.algosipeosseong.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import site.algosipeosseong.database.entity.Cardnews

@Dao
interface CardnewsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCardnews(cardnews: Cardnews)

    @Query("select title, thumbnail, writer from local_cardnews where :category order by id desc limit 5")
    fun getLatestCardnews(category: String): Flow<List<Cardnews>>

    @Query("select title, thumbnail, writer from local_cardnews where :category")
    fun getCardnewsByCategory(category: String): Flow<List<Cardnews>>

    @Query("select * from local_cardnews where :id")
    fun getCardnewsDetail(id: String): Flow<Cardnews>

    @Delete
    fun 
}