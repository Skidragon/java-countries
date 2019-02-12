package com.lambdaschool.countrysearch;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class CountryNameController {

    @RequestMapping("/all")
    public ArrayList<Country> getAllCountries() {
        CountrySearchApplication.myCountryList.countryList.sort((c1,c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return CountrySearchApplication.myCountryList.countryList;
    }

    @RequestMapping("/begin")
    public ArrayList<Country> getCountriesWithStartingLetter(@RequestParam(value="letter") char letter) {
        ArrayList<Country> newCountries = new ArrayList<>();
        CountrySearchApplication.myCountryList.countryList.forEach(c -> {
            if(Character.toUpperCase(letter) == c.getName().charAt(0)) {
                newCountries.add(c);
            }
        });
        return newCountries;
    }
    @RequestMapping("/size")
    public ArrayList<Country> getCountriesWithStartingLetter(@RequestParam(value="letter") int charactersAmount) {
        ArrayList<Country> newCountries = new ArrayList<>();
        CountrySearchApplication.myCountryList.countryList.forEach(c -> {
            if(charactersAmount == c.getName().length()) {
                newCountries.add(c);
            }
        });
        return newCountries;
    }
}
