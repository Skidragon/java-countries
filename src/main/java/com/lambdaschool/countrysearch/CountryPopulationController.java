package com.lambdaschool.countrysearch;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class CountryPopulationController {

    @RequestMapping("/size")
    public ArrayList<Country> getCountriesWithPopulationSize(@RequestParam(value="people") int population) {
        ArrayList<Country> newCountries = new ArrayList<>();
        CountrySearchApplication.myCountryList.countryList.forEach(c -> {
            if(population <= c.getPopulation()) {
                newCountries.add(c);
            }
        });
        return newCountries;
    }
    @RequestMapping("/min")
    public Country getCountryWithSmallestPopulation() {
        int smallestIndex = 0;
        ArrayList<Country> countries = CountrySearchApplication.myCountryList.countryList;
        for(int i = 0; i < countries.size(); i++) {
            if(countries.get(i).getPopulation() < countries.get(smallestIndex).getPopulation()) {
                smallestIndex = i;
            }
        }
        return countries.get(smallestIndex);

    }
    @RequestMapping("/max")
    public Country getCountryWithLargestPopulation() {
        int biggestIndex = 0;
        ArrayList<Country> countries = CountrySearchApplication.myCountryList.countryList;
        for(int i = 0; i < countries.size(); i++) {
            if(countries.get(i).getPopulation() > countries.get(biggestIndex).getPopulation()) {
                biggestIndex = i;
            }
        }
        return countries.get(biggestIndex);
    }
}
