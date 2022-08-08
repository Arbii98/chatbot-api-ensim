package fr.ensim.interop.introrest.model.telegram;

import java.util.ArrayList;
import java.util.List;





public class Geo{
    public String type;
    public String version;
    public List<Feature> features;
    public String attribution;
    public String licence;
    public String query;
    public int limit;
    
    
    
    @Override
	public String toString() {
		return "Geo [type=" + type + ", version=" + version + ", features=" + features + ", attribution=" + attribution
				+ ", licence=" + licence + ", query=" + query + ", limit=" + limit + "]";
	}



	public Geo()
    {
    	this.features = new ArrayList<Feature>();
    }
    
    
    
    public Geo(String type, String version, List<Feature> features, String attribution, String licence, String query,
			int limit) {
		super();
		this.type = type;
		this.version = version;
		this.features = features;
		this.attribution = attribution;
		this.licence = licence;
		this.query = query;
		this.limit = limit;
	}



	public static class Feature{
        public String type;
        public Geometry geometry;
        public Properties properties;
        
        
        
        @Override
		public String toString() {
			return "Feature [type=" + type + ", geometry=" + geometry + ", properties=" + properties + "]";
		}
		public Feature()
        {
        	
        }
		public Feature(String type, Geometry geometry, Properties properties) {
			super();
			this.type = type;
			this.geometry = geometry;
			this.properties = properties;
		}
        
        
    }

    public static class Properties{
    public String label;
    public double score;
    public String housenumber;
    public String id;
    public String name;
    public String postcode;
    public String citycode;
    public double x;
    public double y;
    public String city;
    public String context;
    public String type;
    public double importance;
    public String street;
    public String district;
    
    
    
    @Override
	public String toString() {
		return "Properties [label=" + label + ", score=" + score + ", housenumber=" + housenumber + ", id=" + id
				+ ", name=" + name + ", postcode=" + postcode + ", citycode=" + citycode + ", x=" + x + ", y=" + y
				+ ", city=" + city + ", context=" + context + ", type=" + type + ", importance=" + importance
				+ ", street=" + street + ", district=" + district + "]";
	}

	public Properties()
    {
    	
    }

	public Properties(String label, double score, String housenumber, String id, String name, String postcode,
			String citycode, double x, double y, String city, String context, String type, double importance,
			String street, String district) {
		super();
		this.label = label;
		this.score = score;
		this.housenumber = housenumber;
		this.id = id;
		this.name = name;
		this.postcode = postcode;
		this.citycode = citycode;
		this.x = x;
		this.y = y;
		this.city = city;
		this.context = context;
		this.type = type;
		this.importance = importance;
		this.street = street;
		this.district = district;
	}
    
}
    public static class Geometry{
        public String type;
        public List<String> coordinates;
        
        
        
        
        @Override
		public String toString() {
			return "Geometry [type=" + type + ", coordinates=" + coordinates + "]";
		}
		public Geometry()
        {
        	coordinates = new ArrayList<String>();
        }
		public Geometry(String type) {
			super();
			this.type = type;
		}
        
        
    }
}

