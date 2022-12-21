package com.example.proyectofinal1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng chatarreros1 = new LatLng(-16.419614615642917, -71.53713159711481);
            LatLng viveroMunicipal = new LatLng(-16.39083191650906, -71.53353511087516);
            LatLng independencia = new LatLng(-16.407079745210716, -71.53337666650566);
            LatLng centroAcopioSegregacion = new LatLng(-16.33696971668539, -71.5398828186847);
            LatLng recicladoraMundoVivo = new LatLng(-16.481910442483883, -71.49175266248548);
            LatLng ecoplastAqp = new LatLng(-16.348613829822007, -71.58088364230123);
            LatLng mujeresEcosolidarias = new LatLng(-16.401961269702706, -71.46794955056114);
            LatLng tenet = new LatLng(-16.330165429257438, -71.5531005743068);
            LatLng plantaReciclaje = new LatLng(-16.246904459133123, -71.68333456505891);
            LatLng reciclaPapel = new LatLng(-16.404202923303213, -71.53180090503673);
            LatLng alfrecidaSAC = new LatLng(-16.340336799081367, -71.58927895142699);
            LatLng resigraleSRL = new LatLng(-16.402953352265204, -71.58024856427467);
            LatLng recicladoraSanAntonio = new LatLng(-16.403739572395697, -71.61496358701002);
            LatLng inversionesMerma = new LatLng(-16.411736677209902, -71.55015447316529);
            LatLng recicladoraAquino = new LatLng(-16.151885873522563, -72.33128732228994);
            LatLng scomarSRL = new LatLng(-16.409218712711386, -71.54323627320075);


            googleMap.addMarker(new MarkerOptions().position(chatarreros1).title("Chatarreros 1"));
            googleMap.addMarker(new MarkerOptions().position(viveroMunicipal).title("Vivero Municipal"));
            googleMap.addMarker(new MarkerOptions().position(independencia).title("Av. Independencia Arequipa"));
            googleMap.addMarker(new MarkerOptions().position(centroAcopioSegregacion).title("Centro de Acopio y Segregación Cayma"));
            googleMap.addMarker(new MarkerOptions().position(recicladoraMundoVivo).title("Recicladora Mundo Vivo"));
            googleMap.addMarker(new MarkerOptions().position(ecoplastAqp).title("Ecoplast.AQP"));
            googleMap.addMarker(new MarkerOptions().position(mujeresEcosolidarias).title("Mujeres Ecosolidarias"));
            googleMap.addMarker(new MarkerOptions().position(tenet).title("TENET Compañia de Reciclaje"));
            googleMap.addMarker(new MarkerOptions().position(plantaReciclaje).title("Planta de Reciclaje"));
            googleMap.addMarker(new MarkerOptions().position(reciclaPapel).title("Recicla Papel"));
            googleMap.addMarker(new MarkerOptions().position(alfrecidaSAC).title("Alfrecicla SAC"));
            googleMap.addMarker(new MarkerOptions().position(resigraleSRL).title("RESIGRALE S.R.L"));
            googleMap.addMarker(new MarkerOptions().position(recicladoraSanAntonio).title("RECICLADORA SAN ANTONIO E.I.R.L."));
            googleMap.addMarker(new MarkerOptions().position(inversionesMerma).title("Inversiones Merma S.A.C."));
            googleMap.addMarker(new MarkerOptions().position(recicladoraAquino).title("Recicladora Aquino"));
            googleMap.addMarker(new MarkerOptions().position(scomarSRL).title("SCOMAR SRL"));



            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(chatarreros1, 16));

            googleMap.getUiSettings().setZoomControlsEnabled(true);
            googleMap.getUiSettings().setCompassEnabled(true);
            googleMap.getUiSettings().setRotateGesturesEnabled(true);
            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            googleMap.setMyLocationEnabled(true);


        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}