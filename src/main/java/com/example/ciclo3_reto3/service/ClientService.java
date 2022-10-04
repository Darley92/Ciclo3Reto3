package com.example.ciclo3_reto3.service;


import com.example.ciclo3_reto3.entities.Client;
import com.example.ciclo3_reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    public Client save(Client p){
        if(p.getIdClient()==null){
            return clientRepository.save(p);
        }else{
            Optional<Client> e = clientRepository.getClient(p.getIdClient());
            if(e.isPresent()){

                return p;
            }else{
                return clientRepository.save(p);
            }
        }
    }
    public Client update(Client c){
        if(c.getIdClient()!=null){
            Optional<Client> f = clientRepository.getClient(c.getIdClient());
            if(f.isPresent()){
                if(c.getName()!=null){
                    f.get().setName(c.getName());
                }
                clientRepository.save(f.get());
                return f.get();
            }else{
                return c;
            }
        }else{
            return c;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Client>p= clientRepository.getClient(id);
        if(p.isPresent()){
            clientRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }


}
