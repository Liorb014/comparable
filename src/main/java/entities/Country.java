package entities;

import enums.Continent;

import java.util.List;

public class Country {
   private String name;

    public Continent getContinent() {
        return continent;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", gDP=" + gDP +
                ", continent=" + continent +
                ", economicRating=" + economicRating +
                ", populationRating=" + populationRating +
                ", contentRating=" + contentRating +
                '}';
    }

    public String getName() {
        return name;
    }

    private int population;
   private int gDP;
   private Continent continent;
   private double economicRating;
   private double populationRating;
   private double contentRating;

    public Country(String country) {
        String[] temp = country.split(",");
        this.name = temp[0];
        this.population = Integer.valueOf(temp[1]);
        this.gDP = Integer.valueOf(temp[2]);
        this.continent = Continent.valueOf(temp[3]);
        this.economicRating = Double.valueOf(temp[4]);
        this.populationRating = Double.valueOf(temp[5]);
        this.contentRating = Double.valueOf(temp[6]);
    }


}
