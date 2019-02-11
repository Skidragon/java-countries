package com.lambdaschool.countrysearch;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class CountryAgeController {

    @RequestMapping("/age")
    public ArrayList<Country> getCountriesWithMedianAge(@RequestParam(value="age") int givenAge) {
        ArrayList<Country> newCountries = new ArrayList<>();
        CountrySearchApplication.myCountryList.countryList.forEach(c -> {
            if(givenAge <= c.getMedianAge()) {
                newCountries.add(c);
            }
        });
        return newCountries;
    }
    @RequestMapping("/min")
    public Country getCountryWithSmallestAge() {
        int smallestIndex = 0;
        ArrayList<Country> countries = CountrySearchApplication.myCountryList.countryList;
        for(int i = 0; i < countries.size(); i++) {
            if(countries.get(i).getMedianAge() < countries.get(smallestIndex).getMedianAge()) {
                smallestIndex = i;
            }
        }
        return countries.get(smallestIndex);
    }
    @RequestMapping("/max")
    public Country getCountryWithLargestAge() {
        int biggestIndex = 0;
        ArrayList<Country> countries = CountrySearchApplication.myCountryList.countryList;
        for(int i = 0; i < countries.size(); i++) {
            if(countries.get(i).getMedianAge() > countries.get(biggestIndex).getMedianAge()) {
                biggestIndex = i;
            }
        }
        return countries.get(biggestIndex);
    }
}
