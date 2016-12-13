package teamfiveoh.bootcamplocator.services;

import java.util.ArrayList;

import teamfiveoh.bootcamplocator.model.Devslopes;

/**
 * Created by andrewpat24 on 12/7/16.
 */
public class DataService {
	private static DataService instance = new DataService();

	public static DataService getInstance() {
		return instance;
	}

	private DataService() {
	}

	public ArrayList<Devslopes> getBootcampLocationWithin10MilesOfZipe(int zipcode){
		ArrayList<Devslopes> list = new ArrayList<>();
		list.add(new Devslopes(35.279f, -120.663f, "Downtown", "762 Higuera St.", "slo"));
		list.add(new Devslopes(35.302f, -120.658f, "On campus", "1 grand ave", "slo"));
		list.add(new Devslopes(35.267f, -120.652f, "East Side Tower", "2494 Victoria Ave.", "slo"));

		return list;
	}
}
