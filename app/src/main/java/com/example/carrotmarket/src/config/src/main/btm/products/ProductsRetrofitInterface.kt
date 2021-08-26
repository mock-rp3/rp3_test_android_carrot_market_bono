package com.example.carrotmarket.src.config.src.main.btm.products

import com.example.carrotmarket.config.BaseResponse
import com.example.carrotmarket.src.config.src.main.btm.community.models.CommunityResponse
import com.example.carrotmarket.src.config.src.main.btm.products.category.select.models.CategorySelectResponse
import com.example.carrotmarket.src.config.src.main.btm.products.models.ResponseHome
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.edit.models.EditRequest
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.edit.models.EditResponse
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.models.RequestWish
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.models.RequestWishDel
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.models.ResponseDetail
import com.example.carrotmarket.src.config.src.main.btm.products.product.detail.models.ResponseSellerProduct
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.ing.models.IngResponse
import com.example.carrotmarket.src.config.src.main.btm.products.product.sale.models.StatusRequest
import com.example.carrotmarket.src.config.src.main.btm.products.product.search.deal.models.ResponseSearchDeal
import com.example.carrotmarket.src.config.src.main.btm.products.product.search.deal.models.ResponseSug
import com.example.carrotmarket.src.config.src.main.btm.products.product.search.user.models.UserResponse
import com.example.carrotmarket.src.config.src.main.btm.products.product.writing.models.RequestPostWriting
import com.example.carrotmarket.src.config.src.main.btm.products.product.writing.models.ResponseWriting
import retrofit2.Call
import retrofit2.http.*

interface ProductsRetrofitInterface {


    //유저로 옮기기
    //유저 검색하기
    @GET("/app/users")
    fun getSearchUser(@Query("name")name: String) : Call<UserResponse>

    //전체 게시글 조회 API
    @GET("/app/products")
    fun getProduct(): Call<ResponseHome>

    // 게시글 제목으로 검색 API
    @GET("/app/products")
    fun getSearchDeal(@Query("title")title: String) : Call<ResponseSearchDeal>

    // 카테고리 검색 API
    @GET("/app/products/category")
    fun getCate(@Query("category")category:Int):Call <CategorySelectResponse>

    // 게시글 생성 API (상품 판매글 작성)
    @POST("/app/products")
    fun postProductWriting(@Body params: RequestPostWriting): Call<ResponseWriting>

    // 특정 게시글 조회 API (상품 디테일 화면)
    @GET("/app/products/{productIdx}")
    fun getProductDetail(
        @Path("productIdx") productIdx:Int
    ): Call<ResponseDetail>

    // 특정 게시글 수정 API (판매글 수정)
    @PATCH("/app/products/{productIdx}")
    fun patchProductDetail(
        @Path("productIdx") productIdx:Int,
        @Body params : EditRequest
    ): Call<EditResponse>

    // 특정 게시글 삭제 API (판매글 삭제)
    @PATCH("/app/products/delete/{productIdx}")
    fun deleteProduct(
        @Path("productIdx") productIdx:Int
    ): Call<BaseResponse>

    // 상품 판매글 조회수 증가 API
    @PATCH("/app/products/view/{productIdx}")
    fun patchView( @Path("productIdx") productIdx:Int):Call<BaseResponse>

    // 게시자 판매 상품 조회 API
    @GET("/app/products/search")
    fun getSellerProduct(
        @Query("status") status:String,
        @Query("seller") seller:Int
    ): Call<ResponseSellerProduct>

    // 랜덤매물 조회 API
    @GET("/app/products/suggest")
    fun getSuggest():Call<ResponseSug>


    //판매내역 조회 API
    @GET("/app/products/status")
    fun getIng(
        @Header("x-access-token") X_ACCESS_TOKEN:String,
        @Query("status") status:String,
        @Query("sellerId") sellerId: Int
    ):Call<IngResponse>

    @POST("/app/products/wish")
    fun postWish(
        @Body params: RequestWish
    ):Call<BaseResponse>

//    @DELETE("/app/products/wish")
//    fun deleteWish(
//        @Body params: RequestWishDel
//    ):Call<BaseResponse>

    @HTTP(method = "DELETE", path = "/app/products/wish", hasBody = true)
    fun deleteWish(
        @Body params: RequestWishDel
    ):Call<BaseResponse>


    @PATCH("/app/products/status")
    fun patchStatus(
        @Body params: StatusRequest
    ):Call<BaseResponse>

    @GET("/app/community")
    fun getCommunity():Call<CommunityResponse>

}