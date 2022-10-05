package com.example.ciclo3_reto3.controller;

import com.example.ciclo3_reto3.entities.Machine;
import com.example.ciclo3_reto3.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Machine")
public class MachineController {
    @Autowired
    private MachineService machineService;

    @PostMapping("/all")
    public List<Machine> getAll(){
        return machineService.getAll();
    }
    @PostMapping("/save")
    public Machine save(@RequestBody Machine m){
        return machineService.save(m);
    }
    //@GetMapping("/{id}")
    //public Optional<Costume>getCostume(@PathVariable("id") int costumeId){
    //    return costumeService.getCostume(costumeId);
}
