package com.example.aplicaciontransporteseguro

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity

class MenuPrincipalActivity : AppCompatActivity() {

    public val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                Toast.makeText(this,"Denuncias", Toast.LENGTH_SHORT).show();
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                Toast.makeText(this,"Perfil", Toast.LENGTH_SHORT).show();
                val intentExplicito = Intent(
                    this,
                    DenunciaActivity::class.java
                )
                startActivity(intentExplicito)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                Toast.makeText(this,"Cerrando Sesión", Toast.LENGTH_SHORT).show();
                val intentExplicito = Intent(
                    this,
                    MainActivity::class.java
                    )
                startActivity(intentExplicito)
                return@OnNavigationItemSelectedListener true

            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
