package com.example.carrotmarket.config

import com.example.carrotmarket.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.carrotmarket.config.ApplicationClass.Companion.sSharedPreferences
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

// 코드 건들지 말기
// 클라: 최초 로그인시에 서버에서 발급해주는 jwt를 SP에 잘 저장해 놓기만 하기
// 이것을 활용해서 자동로그인을 구현할 수 있다. jwt가 이미 존재하면 바로 메인 페이지로 넘겨주는 방식으로
class XAccessTokenInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()
        val jwtToken: String? = sSharedPreferences.getString(X_ACCESS_TOKEN, null)
        if (jwtToken != null) {
            builder.addHeader("X-ACCESS-TOKEN", jwtToken)
        }
        return chain.proceed(builder.build())
    }
}