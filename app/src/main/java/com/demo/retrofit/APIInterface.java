package com.demo.retrofit;




import com.demo.model.Login;
import com.demo.model.Registration;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface APIInterface {
    public static final String LOGIN="login";
    public static final String REGISTRATION="register";

    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @FormUrlEncoded
    @POST(REGISTRATION )
    Call<Registration> registerPojoCall(@Field("username") String username,
                                        @Field("email") String email,
                                        @Field("password") String password,
                                        @Field("phone") String phone,
                                        @Field("device_token") String device_token,
                                        @Field("device_type") String device_type,
                                        @Field("status") int status);

    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @FormUrlEncoded
    @POST(LOGIN)
    Call<Login> loginPojoCall(@Field("username") String username,
                              @Field("password") String password,
                              @Field("device_id") String device_id,
                              @Field("device_type") String device_type);
}
