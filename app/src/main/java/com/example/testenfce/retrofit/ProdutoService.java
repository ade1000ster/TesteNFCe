package com.example.testenfce.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProdutoService {
    @GET("listodos")
    Call <List<DadosVenda>> buscaTodos();
    @POST("nferemarca")
    Call<DadosVenda> salva(@Body DadosVenda dadosVenda);
    @PUT("produto/{id}")
    Call<DadosVenda> edita(@Path("id") long id,
                           @Body DadosVenda dadosVenda);
    @DELETE("produto/{id}")
    Call<Void> remove(@Path("id") long id);
}
