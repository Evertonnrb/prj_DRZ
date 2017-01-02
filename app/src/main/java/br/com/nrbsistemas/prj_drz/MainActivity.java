package br.com.nrbsistemas.prj_drz;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = "ciclo";
    private Button botao;
    private Button botao2;
    private Button botao3;
    private ImageView image;
    private TextView _nextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, getClassName() + " .onCreate() chamado ");

        botao = (Button) findViewById(R.id.button);
        botao.setOnClickListener(this);

        botao2 = (Button) findViewById(R.id.button2);
        botao2.setOnClickListener(this);

        botao3 = (Button) findViewById(R.id.button3);
        botao3.setOnClickListener(meuOnClickListener());

        image = (ImageView) findViewById(R.id.imageview);

        _nextView = (TextView) findViewById(R.id.txt_next);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, getClassName() + " .onStart() chamado ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, getClassName() + " .onResume() chamado ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, getClassName() + " .onStop() chamado ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, getClassName() + " .onRestart() chamado ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, getClassName() + " .onDrestroy() chamado ");
    }

    private String getClassName() {
        String s = getClass().getName();
        return s.substring(s.lastIndexOf("."));
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            Toast.makeText(this, "redirecting .... ", Toast.LENGTH_SHORT).show();
            //intent Explicita
            Intent intent = new Intent(this, NomeActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.button2) {
            Toast.makeText(this, "Discando para o número.... ", Toast.LENGTH_SHORT).show();
            //intent implicita
            Uri uri = Uri.parse("tel: 123457");

            Intent intent2 = new Intent(Intent.ACTION_CALL, uri);
            startActivity(intent2);

        }else if(view.getId() == R.id.txt_next){
            Toast.makeText(this,"Redirecionando",Toast.LENGTH_SHORT).show();
        }

    }

    private View.OnClickListener meuOnClickListener(){
        return new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Testando botao 3 .... ",Toast.LENGTH_SHORT).show();
                image.setImageResource(R.mipmap.ic_launcher);
            }
        };
    }
    //public void meuMetodo(View view){
    //    Toast.makeText(this,"Toast test",Toast.LENGTH_LONG).show();
    //}

}
