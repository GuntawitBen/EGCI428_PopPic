package com.egci428.egci428_poppic.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "http://10.0.2.2:3000/";
    private static RetrofitClient mInstance;
    private final Retrofit retrofit;

    // Private constructor for Singleton pattern
    private RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // Thread-safe Singleton instance
    public static synchronized RetrofitClient getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    // Getter for the API interface
    public API getAPI() {
        return retrofit.create(API.class);
    }
}
