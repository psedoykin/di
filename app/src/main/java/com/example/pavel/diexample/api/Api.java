package com.example.pavel.diexample.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    private final static String API_KEY = "9eda5e441a8f23f9e76e64716f9eec5998d5fb4bc83fef265e9aff89";
    private static final String BASE_URL = "http://open-weather.ru/api/";

    private static volatile EndpointInterface mAPIServiceInstance;

    public Api() {
        mAPIServiceInstance = getRetrofit().create(EndpointInterface.class);
    }


    public static EndpointInterface getApiService() {
        EndpointInterface localInstance = mAPIServiceInstance;
        if (localInstance == null) {
            synchronized (EndpointInterface.class) {
                localInstance = mAPIServiceInstance;
                if (localInstance == null) {
                    Retrofit retrofit = getRetrofit();
                    mAPIServiceInstance = localInstance = retrofit.create(EndpointInterface.class);
                }
            }
        }
        return localInstance;
    }

    private static Retrofit getRetrofit() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder builder = chain.request().newBuilder();
                builder.url(chain.request().url() + "?key=" + API_KEY);
                Request request = builder.build();

                return chain.proceed(request);
            }
        });

        OkHttpClient okClient = builder.build();
        Gson gson = new GsonBuilder()
                .create();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okClient)
                .build();
    }
}
