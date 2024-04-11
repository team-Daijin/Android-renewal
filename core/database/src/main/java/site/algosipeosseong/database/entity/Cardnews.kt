package site.algosipeosseong.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "local_cardnews")
data class Cardnews(
    @PrimaryKey(autoGenerate = true)
    val id : String,
    val title: String,
    val writer: String,
    val category: String,
    val content: String,
    val thumbnail: String,
    val image: String
)
//"id": UUID,
//"title": String,
//"writer" : String,
//"category": String
//"content": String,
//"thumbnail": String - URL 형태
//"image" : String - URL 형태