package kpi.db;

public class BandAtFestival {
    private int band_id;
    private int festival_id;

    public BandAtFestival(int band_id, int festival_id) {
        this.band_id = band_id;
        this.festival_id = festival_id;
    }

    public int getBand_id() {
        return band_id;
    }

    public void setBand_id(int band_id) {
        this.band_id = band_id;
    }

    public int getFestival_id() {
        return festival_id;
    }

    public void setFestival_id(int festival_id) {
        this.festival_id = festival_id;
    }
}
