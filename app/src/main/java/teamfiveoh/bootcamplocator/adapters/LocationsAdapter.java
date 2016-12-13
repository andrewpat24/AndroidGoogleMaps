package teamfiveoh.bootcamplocator.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import teamfiveoh.bootcamplocator.R;
import teamfiveoh.bootcamplocator.holders.LocationsViewHolder;
import teamfiveoh.bootcamplocator.model.Devslopes;

/**
 * Created by andrewpat24 on 12/7/16.
 */

public class LocationsAdapter extends RecyclerView.Adapter<LocationsViewHolder>{

	private ArrayList<Devslopes> locations;

	public LocationsAdapter(ArrayList<Devslopes> locations) {

	}

	@Override
	public void onBindViewHolder(LocationsViewHolder holder, int position) {
		final Devslopes location = locations.get(position);
		holder.updateUI(location);

		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
//				load details
			}
		});
	}

	@Override
	public int getItemCount() {
		return locations.size();
	}

	@Override
	public LocationsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_location, parent, false);
		return new LocationsViewHolder(card);
	}
}
