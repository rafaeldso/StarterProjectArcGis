package rafael.com.starterprojectarcgis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.esri.arcgisruntime.ArcGISRuntimeEnvironment;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;
import com.esri.arcgisruntime.mapping.view.SceneView;

public class MainActivity extends AppCompatActivity {

    private MapView mMapView;
    private SceneView mSceneView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMapView = findViewById(R.id.mapView);
        setupMap();
    }

    private void setupMap(){
        if(mMapView != null) {
            ArcGISRuntimeEnvironment.setLicense(getResources().getString(R.string.arcgis_license_key));
            Basemap.Type baseType = Basemap.Type.STREETS_NIGHT_VECTOR;
            double latitude = 34.0270;
            double longitude = -118.8050;

            int levelOfDetail = 13;
            ArcGISMap map = new ArcGISMap(baseType, latitude, longitude,levelOfDetail);
            mMapView.setMap(map);
        }
    }

    @Override
    protected void onPause() {
        if(mMapView != null){
            mMapView.pause();
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mMapView != null){
            mMapView.resume();
        }
    }

    @Override
    protected void onDestroy() {
        if (mMapView != null) {
            mMapView.dispose();
        }
        super.onDestroy();
    }
}
