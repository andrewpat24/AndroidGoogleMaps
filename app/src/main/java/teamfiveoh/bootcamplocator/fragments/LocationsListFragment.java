package teamfiveoh.bootcamplocator.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import teamfiveoh.bootcamplocator.R;
import teamfiveoh.bootcamplocator.adapters.LocationsAdapter;
import teamfiveoh.bootcamplocator.services.DataService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LocationsListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LocationsListFragment extends Fragment {
	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String ARG_PARAM1 = "param1";
	private static final String ARG_PARAM2 = "param2";

	// TODO: Rename and change types of parameters
	private String mParam1;
	private String mParam2;


	public LocationsListFragment() {
		// Required empty public constructor
	}

	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @param param1 Parameter 1.
	 * @param param2 Parameter 2.
	 * @return A new instance of fragment LocationsListFragment.
	 */
	// TODO: Rename and change types and number of parameters
	public static LocationsListFragment newInstance() {
		LocationsListFragment fragment = new LocationsListFragment();
		Bundle args = new Bundle();

		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			mParam1 = getArguments().getString(ARG_PARAM1);
			mParam2 = getArguments().getString(ARG_PARAM2);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_locations_list, container, false);
		RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_locations);
		recyclerView.setHasFixedSize(true);

		LocationsAdapter adapter = new LocationsAdapter(DataService.getInstance().getBootcampLocationWithin10MilesOfZipe(94903));
		recyclerView.setAdapter(adapter);

		LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
		layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

		recyclerView.setLayoutManager(layoutManager);
		// Inflate the layout for this fragment
		return view;
	}

}
