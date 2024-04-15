package com.ing.performancetuning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class MemoryLeakController {

    // Bellek sızıntısını simüle etmek için kullanılacak liste
    private List<String> leakyList = new ArrayList<>();

    @GetMapping("/leak")
    public String causeLeak() {
        // Her çağrıda listeye yeni bir UUID ekleniyor.
        String newElement = UUID.randomUUID().toString();
        leakyList.add(newElement);

        // Basit bir geri dönüş mesajı
        return "New element added: " + newElement;
    }





}