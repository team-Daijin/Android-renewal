package site.algosipeosseong.network.retrofit

import androidx.core.os.trace
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query
import site.algosipeosseong.model.Banners
import site.algosipeosseong.model.Cardnews
import site.algosipeosseong.model.CardnewsDetail
import site.algosipeosseong.model.Category
import site.algosipeosseong.model.Clinic
import site.algosipeosseong.model.ClinicRequest
import site.algosipeosseong.network.BuildConfig.BASE_URL
import site.algosipeosseong.network.KnowledgenderNetworkDataSource
import javax.inject.Inject
import javax.inject.Singleton

private interface RetrofitKnowledgenderNetworkApi {
    @GET("/card")
    suspend fun getCardnews(): List<Cardnews>

    @GET("/card")
    suspend fun getCardnewsDetail(@Query("cardId") cardId: Long): CardnewsDetail

    @GET("/card")
    suspend fun getCardnewsByCategory(@Query("category") category: String): List<CardnewsDetail>

    @GET("/banner")
    suspend fun getBanner(): Banners

    @GET("/clinic")
    suspend fun getClinic(
        @Query("radius") radius: Int,
        @Body clinicRequest: ClinicRequest
    ): List<Clinic>

}

@Singleton
internal class KnowledgenderRetrofit @Inject constructor(
    networkJson: Json,
    okhttpCallFactory: dagger.Lazy<Call.Factory>,
) : KnowledgenderNetworkDataSource {

    private val networkApi = trace("RetrofitNiaNetwork") {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .callFactory { okhttpCallFactory.get().newCall(it) }
            .addConverterFactory(
                networkJson.asConverterFactory("application/json".toMediaType()),
            )
            .build()
            .create(RetrofitKnowledgenderNetworkApi::class.java)
    }

    override suspend fun getCardnews(): List<Cardnews> = networkApi.getCardnews()
    override suspend fun getCardnewsDetail(cardId: Long): CardnewsDetail =
        networkApi.getCardnewsDetail(cardId = cardId)

    override suspend fun getCardnewsByCategory(category: Category): List<CardnewsDetail> = networkApi.getCardnewsByCategory(category = category.str)

    override suspend fun getBanner(): Banners = networkApi.getBanner()
    override suspend fun getClinic(
        clinicRequest: ClinicRequest,
        radius: Int
    ): List<Clinic> = networkApi.getClinic(radius = radius, clinicRequest = clinicRequest)


}