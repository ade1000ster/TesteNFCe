package com.example.testenfce.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NfceRetrofit {
  private final  ProdutoService produtoService;
    //private final  Retrofit retrofit;


    public NfceRetrofit() {


        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.68:8080/" )
               .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
      produtoService = retrofit.create(ProdutoService.class);


    }

    public ProdutoService getProdutoService() {
        return produtoService;
    }
}





