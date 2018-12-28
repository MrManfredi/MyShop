package kpi.db;

public class BandAtFestival {
    private int band_id;
    private String band_name;
    private int festival_id;
    private String festival_name;

    public BandAtFestival(int band_id, String band_name, int festival_id, String festival_name) {
        this.band_id = band_id;
        this.band_name = band_name;
        this.festival_id = festival_id;
        this.festival_name = festival_name;
    }

    public int getBand_id() {
        return band_id;
    }

    public String getBand_name() {
        return band_name;
    }

    public int getFestival_id() {
        return festival_id;
    }

    public String getFestival_name() {
        return festival_name;
    }
}
