package com.pratyaksh.ramcabs.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class APIController {
    private static final String url = "https://discoverdrinks.in/ramchiller/auth-api/";
    private static APIController clientobject;
    private static Retrofit retrofit;
    OkHttpClient client;


    public APIController() {


        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES);
        // Should be used only in Debug Mode.


        if (true) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(true ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE); //// TODO: 21-07-2016
            builder.addInterceptor(interceptor);
        }
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        client = builder.build();
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


    }

    public static synchronized APIController getInstance() {
        if (clientobject == null)
            clientobject = new APIController();
        return clientobject;
    }

    public APIInterface getapi() {

        return retrofit.create(APIInterface.class);
    }
}
