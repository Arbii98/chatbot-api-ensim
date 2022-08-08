package fr.ensim.interop.introrest.model.telegram;

import java.util.Date;
import java.util.List;

public class Meteo{
    public City city;
    public Date update;
    public List<Forecast> forecast;
    
    
    
    
    @Override
	public String toString() {
		return "Meteo [city=" + city + ", update=" + update + ", forecast=" + forecast + "]";
	}

	public static class City{
        public String insee;
        public int cp;
        public String name;
        public double latitude;
        public double longitude;
        public int altitude;
		@Override
		public String toString() {
			return "City [insee=" + insee + ", cp=" + cp + ", name=" + name + ", latitude=" + latitude + ", longitude="
					+ longitude + ", altitude=" + altitude + "]";
		}
        
    }

    public static class Forecast{
        public String insee;
        public int cp;
        public double latitude;
        public double longitude;
        public int day;
        public Date datetime;
        public int wind10m;
        public int gust10m;
        public int dirwind10m;
        public double rr10;
        public double rr1;
        public int probarain;
        public int weather;
        public int tmin;
        public int tmax;
        public int sun_hours;
        public int etp;
        public int probafrost;
        public int probafog;
        public int probawind70;
        public int probawind100;
        public int gustx;
		@Override
		public String toString() {
			return "Forecast [insee=" + insee + ", cp=" + cp + ", latitude=" + latitude + ", longitude=" + longitude
					+ ", day=" + day + ", datetime=" + datetime + ", wind10m=" + wind10m + ", gust10m=" + gust10m
					+ ", dirwind10m=" + dirwind10m + ", rr10=" + rr10 + ", rr1=" + rr1 + ", probarain=" + probarain
					+ ", weather=" + weather + ", tmin=" + tmin + ", tmax=" + tmax + ", sun_hours=" + sun_hours
					+ ", etp=" + etp + ", probafrost=" + probafrost + ", probafog=" + probafog + ", probawind70="
					+ probawind70 + ", probawind100=" + probawind100 + ", gustx=" + gustx + "]";
		}
        
        
    }
}