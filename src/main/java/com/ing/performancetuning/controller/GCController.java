package com.ing.performancetuning.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/gc")
public class GCController {

    private static final List<Object> leakyList = new ArrayList<>();

    @GetMapping("/leak")
    public String createLeak(@RequestParam int size) {
        for (int i = 0; i < size; i++) {
            Object obj = new Object();
            leakyList.add(obj);
        }
        return "Added " + size + " objects to the static list";
    }
}
