package com.example.carrotmarket.src.config.src.users.profile

import com.example.carrotmarket.config.ApplicationClass
import com.example.carrotmarket.src.config.src.users.profile.models.RequestProfile
import com.example.carrotmarket.src.config.src.users.profile.models.ResponseProfile
import com.example.carrotmarket.src.users.UsersRetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfilePatchService(val view: ProfilePatchActivityView) {


    // 토큰과 userIdx 넘겨주기
    fun tryPatchProfile(requestProfile:RequestProfile, X_ACCESS_TOKEN:String, userInfoIdx:Int){
        val profileRetrofitInterface =
            ApplicationClass.sRetrofit.create(UsersRetrofitInterface::class.java)

        profileRetrofitInterface.patchProfile(requestProfile, X_ACCESS_TOKEN,userInfoIdx).enqueue(object:
            Callback<ResponseProfile> {
            override fun onResponse(
                call: Call<ResponseProfile>,
                response: Response<ResponseProfile>
            ) {

                view.onPatchProfileSuccess(response.body() as ResponseProfile)

            }

            override fun onFailure(call: Call<ResponseProfile>, t: Throwable) {

                view.onPatchProfileFailure(t.message ?:"통신오류")
            }
        }
        )
    }
//    fun tryGetJwt(X_ACCESS_TOKEN: String, userInfoIdx: Int){
//        val jwtIdxRetrofitInterface =
//            ApplicationClass.sRetrofit.create(UsersRetrofitInterface::class.java)
//        jwtIdxRetrofitInterface.jwtIdx(X_ACCESS_TOKEN, userInfoIdx).enqueue(object :
//        Callback<ResponseProfile>{
//            override fun onResponse(
//                call: Call<ResponseProfile>,
//                response: Response<ResponseProfile>
//            ) {
//                view.onPatchProfileSuccess(response.body() as ResponseProfile)
//            }
//            override fun onFailure(call: Call<ResponseProfile>, t: Throwable) {
//                view.onPatchProfileFailure(t.message ?:"통신오류")
//            }
//        }
//        )
//
//    }

}