package com.example.offlinecontent.offlineContent

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.offlinecontent.generateDirectorforsubtopic.modal.tokenModal.UAMResponse
import com.google.gson.Gson
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * @param getSelfLearnApiResponse It is used to get Response from API as a String Format.
 * @param requestUrl api endpoint with base url.
 * @param token Access Token.
 * @param tenantName Tenant name of the Student.
 * @param tenantId Tenant Id.
 * @param subTenant Sub-Tenant means program.
 */
@Throws(IOException::class)
@RequiresApi(Build.VERSION_CODES.N)
fun getSelfLearnApiResponse(requestUrl: String, token:String, tenantName:String?, tenantId:Int?, subTenant:Int?): String {

    val client = OkHttpClient()

    client.setConnectTimeout(30, TimeUnit.SECONDS)

    client.setReadTimeout(30, TimeUnit.SECONDS)

    val request: Request = Request.Builder()
        .header("Authorization","Bearer $token")
        .header("X-Tenant","$tenantName")
        .header("tenantId","$tenantId")
        .header("subTenantId","$subTenant")
        .url(requestUrl).build()

    val response = client.newCall(request).execute()

    return if (response.isSuccessful) {
        response.body().string()
    } else {
        // TODO: Work on here later
        return response.isSuccessful.toString() + " : " + response.code().toString()
    }

}



/**
 * GET UAM authentication Response by Posting request body of [uid], [password] and [xTenant] to [getUAMToken].
 */
fun getUAMToken(uid:String, password:String = "test123", xTenant:String = "srichaitanya"): UAMResponse? {

    val client: okhttp3.OkHttpClient = okhttp3.OkHttpClient().newBuilder().build()

    val mediaType: MediaType = "application/json".toMediaTypeOrNull()!!

    val body: RequestBody = "{\"uid\": \"${uid}\", \"password\":\"${password}\"}".toRequestBody(mediaType)

    val request: okhttp3.Request = okhttp3.Request.Builder()
        .url("https://api.infinitylearn.com/api/authentication/login")
        .method("POST", body)
        .addHeader("accept", "application/json")
        .addHeader("Authorization", "Bearer")
        .addHeader("X-Tenant", xTenant)
        .addHeader("isMultiSessionRequired", "false")
        .addHeader("Content-Type", "application/json")
        .build()

    val response: Response = client.newCall(request).execute()

    val string = response.body?.string()

    return Gson().fromJson(string, UAMResponse::class.java)

}