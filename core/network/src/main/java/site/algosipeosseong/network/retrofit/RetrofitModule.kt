package site.algosipeosseong.network.retrofit

import dagger.Lazy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query
import site.algosipeosseong.model.Banner
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
    @GET("card")
    suspend fun getCardnews(): List<Cardnews>

    @GET("card")
    suspend fun getCardnewsDetail(@Query("cardId") cardId: Long): CardnewsDetail

    @GET("card")
    suspend fun getCardnewsByCategory(@Query("category") category: String): List<CardnewsDetail>

    @GET("banner")
    suspend fun getBanner(): List<Banner>

    @GET("clinic")
    suspend fun getClinic(
        @Query("radius") radius: Int,
        @Body clinicRequest: ClinicRequest
    ): List<Clinic>

}

@Singleton
internal class KnowledgenderRetrofit @Inject constructor(
    okhttpCallFactory: Lazy<Call.Factory>,
) : KnowledgenderNetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .callFactory { okhttpCallFactory.get().newCall(it) }
        .addConverterFactory(
            GsonConverterFactory.create(),
        )
        .build()
        .create(RetrofitKnowledgenderNetworkApi::class.java)


    override suspend fun getCardnews(): Flow<List<Cardnews>> = flow { emit(networkApi.getCardnews()) }


    override suspend fun getCardnewsDetail(cardId: Long): Flow<CardnewsDetail> =
        flow { networkApi.getCardnewsDetail(cardId = cardId) }

    override suspend fun getCardnewsByCategory(category: Category): Flow<List<CardnewsDetail>> =
        flow { networkApi.getCardnewsByCategory(category = category.str) }

    override suspend fun getBanner(): Flow<List<Banner>> = flow { emit(networkApi.getBanner()) }

    override suspend fun getClinic(
        clinicRequest: ClinicRequest,
        radius: Int
    ): Flow<List<Clinic>> =
        flow { networkApi.getClinic(radius = radius, clinicRequest = clinicRequest) }
}