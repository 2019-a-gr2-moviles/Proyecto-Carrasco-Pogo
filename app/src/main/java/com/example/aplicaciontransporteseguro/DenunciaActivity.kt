package com.example.aplicaciontransporteseguro


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_denuncia.*

class DenunciaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_denuncia)

        btn_nuevaDenuncia.setOnClickListener {
            val intentExplicito = Intent(
                this,
                NuevaDenunciaActivity::class.java
            )
            startActivity(intentExplicito)
        }
    }
}
