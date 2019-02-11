package com.lambdaschool.countrysearch;

import java.util.ArrayList;

public class CountryList {
    public ArrayList<Country> countryList = new ArrayList<>();

    public CountryList() {
        countryList.add(new Country("China",1420062022,9388211,39));
        countryList.add(new Country("India",1368737513,2973190,28));
        countryList.add(new Country("U.S.",329093110,9147420,38));
        countryList.add(new Country("Indonesia",269536482,1811570,29));
        countryList.add(new Country("Brazil",212392717,8358140,33));
        countryList.add(new Country("Pakistan",204596442,770880,23));

    }

    public Country findCountry(CheckCountry tester) {
        for(Country c : countryList) {
            if (tester.test(c)) {
                return c;
            }
        }
        return null;
    }
}
