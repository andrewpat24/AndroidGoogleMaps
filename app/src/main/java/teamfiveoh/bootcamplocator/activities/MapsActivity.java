package teamfiveoh.bootcamplocator.activities;

import android.*;
import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;

import teamfiveoh.bootcamplocator.*;
import teamfiveoh.bootcamplocator.R;
import teamfiveoh.bootcamplocator.fragments.MainFragment;


public class MapsActivity extends FragmentActivity implements GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks, LocationListener{

	private GoogleApiClient mGoogleApiClient;
	final int PERMISSION_LOCATION = 111;
	private MainFragment mainFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(teamfiveoh.bootcamplocator.R.layout.activity_maps);

		mGoogleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this, this)
				.addConnectionCallbacks(this).addApi(LocationServices.API).build();

		mainFragment = (MainFragment) getSupportFragmentManager()
				.findFragmentById(R.id.container_main);

		if(mainFragment == null) {
			mainFragment = MainFragment.newInstance();
			getSupportFragmentManager().beginTransaction().add(R.id.container_main, mainFragment).commit();
		}



	}

	@Override
	public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

	}

	@Override
	public void onConnectionSuspended(int i) {

	}

	@Override
	public void onConnected(@Nullable Bundle bundle) {
		Boolean condition = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED;
		if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
			ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_LOCATION);
			Log.v("DONKEY", "Requesting permissions: " + PERMISSION_LOCATION );
		} else {
			startLocationServices();
		}
	}

	@Override
	public void onLocationChanged(Location location) {
		Log.v("DONKEY", "long: " + location.getLongitude() + " lat: " + location.getLatitude());
		mainFragment.setUserMarker(new LatLng(location.getLatitude(), location.getLongitude()));
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//		ActivityCompat.requestPermissions(MapsActivity.this, permissions, grantResults[0]);
		switch (requestCode) {
			case PERMISSION_LOCATION: {
				if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
					Log.v("DONKEY ", "starting services");
					startLocationServices();
				} else {
					Log.v("DONKEY", "Services denied");
				}
			}
		}
	}

	@Override
	protected void onStart() {
		mGoogleApiClient.connect();
		super.onStart();
	}

	@Override
	protected void onStop() {
		mGoogleApiClient.disconnect();
		super.onStop();
	}

	public void startLocationServices(){
		LocationRequest req = LocationRequest.create().setPriority(LocationRequest.PRIORITY_LOW_POWER);
		try{
			LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, req, this);
		} catch (SecurityException exception){
//			show dialogue to user
			Log.v("DONKEY", exception.toString());
		}

	}

}
