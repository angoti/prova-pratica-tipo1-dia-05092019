package com.professorangoti.correoprova1tipo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obterNotas();
    }

    private void obterNotas() {
        Log.d(TAG, "obterNotas: ");
        RetrofitService.getServico().obterNotas().enqueue(new Callback<List<Nota>>() {
            @Override
            public void onResponse(Call<List<Nota>> call, Response<List<Nota>> response) {
                Log.d(TAG, "onResponse: " + response.raw());
                List<Nota> lista = response.body();
                int nota1 = Integer.parseInt(lista.get(0).getNota());
                int nota2 = Integer.parseInt(lista.get(1).getNota());
                int nota3 = Integer.parseInt(lista.get(2).getNota());

                TextView viewNome1 = findViewById(R.id.nome1);
                TextView viewNome2 = findViewById(R.id.nome2);
                TextView viewNome3 = findViewById(R.id.nome3);

                TextView viewNota1 = findViewById(R.id.nota1);
                TextView viewNota2 = findViewById(R.id.nota2);
                TextView viewNota3 = findViewById(R.id.nota3);

                viewNome1.setText(lista.get(0).getNome());
                viewNome2.setText(lista.get(1).getNome());
                viewNome3.setText(lista.get(2).getNome());

                viewNota1.setText(lista.get(0).getNota());
                viewNota2.setText(lista.get(1).getNota());
                viewNota3.setText(lista.get(2).getNota());

                if (nota1 >= 6)
                    ((ImageView) findViewById(R.id.imageView1)).setImageResource(R.drawable.you);
                else
                    ((ImageView) findViewById(R.id.imageView1)).setImageResource(R.drawable.vermelho);
                if (nota2 >= 6)
                    ((ImageView) findViewById(R.id.imageView2)).setImageResource(R.drawable.you);
                else
                    ((ImageView) findViewById(R.id.imageView2)).setImageResource(R.drawable.vermelho);
                if (nota3 >= 6)
                    ((ImageView) findViewById(R.id.imageView3)).setImageResource(R.drawable.you);
                else
                    ((ImageView) findViewById(R.id.imageView3)).setImageResource(R.drawable.vermelho);

            }

            @Override
            public void onFailure(Call<List<Nota>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
