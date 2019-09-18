package com.professorangoti.correoprova1tipo1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {

    @GET("notas")
    Call<List<Nota>> obterNotas();

}
