package guimodule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;

import processing.core.PApplet;

public class LifeExpectancy extends PApplet {
	UnfoldingMap map;
	Map<String, Float> lifeExpByCountry;
	List<Feature> countries;
	List<Marker> countryMarkers;

	private void shadeCountries() {
		for( Marker marker : countryMarkers ){
			String countryId = marker.getId();
			System.out.println("id of the marker is: " + countryId);

			if(lifeExpByCountry.containsKey(countryId)){
				float lifeExp = lifeExpByCountry.get(countryId);
				int colorLevel = (int) map(lifeExp, 40, 90, 10, 255);
				marker.setColor(color(255-colorLevel, 100, colorLevel));
			}
			else {
				marker.setColor(color(150, 150, 150));
			}
		}
	}

	private Map<String, Float> loadLifeExpFromCSV(String filename) {
		Map<String, Float> lifeExpMap = new HashMap<String, Float>();

		String[] rows = loadStrings(filename);

		//System.out.println("length of rows: " + rows.length);

		for(String row : rows) {
			//",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"
			String[] columns = row.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			//System.out.println("columns[4]: " + columns[4] + "  columns[3]: " + columns[3]);

			//&& (columns[5].charAt(0) > '0' && columns[5].charAt(0) < '9') && columns[4] != null
			if( !columns[4].equals("..") && !columns[3].equals("..") ) {
				float value = Float.parseFloat(columns[4]);
				lifeExpMap.put(columns[3], value);
			}
		}

		//System.out.println("size of lifeExpMap: " + lifeExpMap.size());
		return lifeExpMap;
	}

	public void setup() {
		size(800, 600, OPENGL);
		map = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
		lifeExpByCountry = loadLifeExpFromCSV("../../data/LifeExpectancyWorldBank.csv");
		countries = GeoJSONReader.loadData(this, "countries.geo.json");
		countryMarkers = MapUtils.createSimpleMarkers(countries);

		map.addMarkers(countryMarkers);
		shadeCountries();
		MapUtils.createDefaultEventDispatcher(this, map);
	}

	public void draw() {
		map.draw();
	}
}
