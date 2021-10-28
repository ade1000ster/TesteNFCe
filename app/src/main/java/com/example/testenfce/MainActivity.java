package com.example.testenfce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.testenfce.retrofit.DadosVenda;
import com.example.testenfce.retrofit.NfceRetrofit;
import com.example.testenfce.retrofit.ProdutoService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity  {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.68:8080/" )
               // .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ProdutoService service = retrofit.create(ProdutoService.class);
        DadosVenda dadosVenda = new DadosVenda();

      Call<DadosVenda> requestCatalog =   service.salva(dadosVenda);

      requestCatalog.enqueue(new Callback<DadosVenda>() {
          @Override
          public void onResponse(Call<DadosVenda> call, Response<DadosVenda> response) {

          }

          @Override
          public void onFailure(Call<DadosVenda> call, Throwable t) {

          }
      });
    }

    public void testenfce(View view) throws IOException {
        DadosVenda dadosVenda = new DadosVenda();
System.out.println("adsadas");
          new NfceRetrofit().getProdutoService().buscaTodos();
          ProdutoService produtoService = new ProdutoService() {
              @Override
              public Call<List<DadosVenda>> buscaTodos() {
                  return null;
              }

              @Override
              public Call<DadosVenda> salva(DadosVenda dadosVenda) {
                  return null;
              }

              @Override
              public Call<DadosVenda> edita(long id, DadosVenda dadosVenda) {
                  return null;
              }

              @Override
              public Call<Void> remove(long id) {
                  return null;
              }
          };
          Call<List<DadosVenda>> call = produtoService.buscaTodos();
//service.buscaTodos();
//service.remove(2);
       // Response<DadosVenda> execute = call.execute();

    }
}