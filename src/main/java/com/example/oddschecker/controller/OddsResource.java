package com.example.oddschecker.controller;

import com.example.oddschecker.constructor.Odds;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


@RestController
@RequestMapping("/odds")
public class OddsResource {

    ConcurrentMap<String, Odds> odds = new ConcurrentHashMap<>();

    @GetMapping("/{betId}")
    public Odds getOdds(@PathVariable String betId) {
        return odds.get(betId);
    }

    @GetMapping("/all")
    public List<Odds> getAllOdds() {
        return new ArrayList<Odds>(odds.values());
    }

    @PostMapping("/")
    public Odds addOdd(@RequestBody Odds odd) {
        odds.put(String.valueOf(odd.getBetId()), odd);
        return  odd;
    }

}
