package site.algosipeosseong.model

data class Cardnews(
    val category: String,
    val cards: List<Cards>
)
data class Cards(
    val thumbnail: String,
    val category: String,
    val title: String
)

data class CardnewsDetail(
    val thumbnail: String,
    val category: String,
    val title: String,
    val expert: String,
    val content: String
)