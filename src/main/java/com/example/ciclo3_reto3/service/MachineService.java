package com.example.ciclo3_reto3.service;

import com.example.ciclo3_reto3.entities.Machine;
import com.example.ciclo3_reto3.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> getAll(){
        return machineRepository.getAll();
    }
    public Optional<Machine> getMachine(int id){
        return machineRepository.getMachine(id);
    }

    public Machine save(Machine m){
        if(m.getId()==null){
            return machineRepository.save(m);
        }else{
            Optional <Machine> e =machineRepository.getMachine(m.getId());
            if(e.isPresent()){
                return m;
            }else{
                return machineRepository.save(m);
            }
        }
    }
    public Machine update(Machine m){
        if(m.getId()!=null){
            Optional<Machine> f = machineRepository.getMachine(m.getId());
            if(f.isPresent()){
                if(m.getName()!=null){
                    f.get().setName(m.getName());
                }
                if(m.getBrand()!=null){
                    f.get().setBrand(m.getBrand());
                }
                if(m.getYear()!=null){
                    f.get().setYear(m.getYear());
                }
                if(m.getDescription()!=null){
                    f.get().setDescription(m.getDescription());
                }
                if(m.getCategory()!=null){
                    f.get().setCategory(m.getCategory());
                }
                machineRepository.save(f.get());
                return f.get();
            }else{
                return m;
            }
        }else{
            return m;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Machine> m =machineRepository.getMachine(id);
        if(m.isPresent()){
            machineRepository.delete(m.get());
            flag=true;
        }
        return flag;
    }
}
