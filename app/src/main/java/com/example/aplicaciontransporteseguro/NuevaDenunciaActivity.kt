package com.example.aplicaciontransporteseguro

import android.content.Intent
import android.content.pm.PackageManager

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_registrar_usuario.*

class NuevaDenunciaActivity : AppCompatActivity(),
    OnMapReadyCallback
    {
        private lateinit var mMap: GoogleMap
        private var tienePermisosLocalizacion = false

        override fun onMapReady(p0: GoogleMap?) {
            establecerConfiguracionMapa(mMap)
            val foch = LatLng(-0.202760, -78.490813)
            val titulo = "Plaza Foch"
            anadirMarcador(foch,titulo)

        }

        fun establecerConfiguracionMapa(mapa:GoogleMap){
            val contexto = this.applicationContext

            with(mapa){
                val permisoFineLocation = ContextCompat
                    .checkSelfPermission(
                        contexto,
                        android.Manifest.permission.ACCESS_FINE_LOCATION
                    )
                val tienePermiso = permisoFineLocation == PackageManager.PERMISSION_GRANTED
                if(tienePermiso){
                    mapa.isMyLocationEnabled = true
                }
                this.uiSettings.isZoomControlsEnabled = true
                uiSettings.isMyLocationButtonEnabled = true
            }
        }

        fun solicitarPermisosLocalizacion(){
            val permisoFineLocation = ContextCompat
                .checkSelfPermission(
                    this.applicationContext,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                )
            val tienePermiso = permisoFineLocation == PackageManager.PERMISSION_GRANTED

            if(tienePermiso){
                Log.i("mapa","Tiene permisos de FINE_LOCATION")
                this.tienePermisosLocalizacion = true
            }else{
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(
                        android.Manifest.permission.ACCESS_FINE_LOCATION
                    ),
                    1// Codigo que vamos a esperar
                )
            }

        }


        fun anadirMarcador(latLng:LatLng,title:String){
            mMap.addMarker(
                MarkerOptions()
                    .position(latLng)
                    .title(title)
            )
        }

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_denuncia)




    }


}
