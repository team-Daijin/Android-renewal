package site.algosipeosseong.model

data class Banners(
    val bannerResponses: List<BannerResponses>
)
data class BannerResponses(
    val banner: String,
    val redirect: String
)