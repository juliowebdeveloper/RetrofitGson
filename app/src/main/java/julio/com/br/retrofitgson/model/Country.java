package julio.com.br.retrofitgson.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Shido on 05/03/2017.
 */

public class Country {

    private String name;

    @SerializedName("alpha2Code")
    private String alphaCode;


    private String capital;

    private String region;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlphaCode() {
        return alphaCode;
    }

    public void setAlphaCode(String alphaCode) {
        this.alphaCode = alphaCode;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
