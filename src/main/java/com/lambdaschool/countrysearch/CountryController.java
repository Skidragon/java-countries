package com.lambdaschool.countrysearch;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class CountryController {

    @RequestMapping("/all")
    public ArrayList<Country> getAllCountries() {
        CountrySearchApplication.myCountryList.countryList.sort((c1,c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return CountrySearchApplication.myCountryList.countryList;
    }
}
