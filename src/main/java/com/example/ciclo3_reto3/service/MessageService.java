package com.example.ciclo3_reto3.service;




import com.example.ciclo3_reto3.entities.Message;
import com.example.ciclo3_reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    public Optional<Message> getMessage(int id){return messageRepository.getMessage(id);
    }
    public Message save(Message m){
        if(m.getIdMessage()==null){
            return messageRepository.save(m);
        }else{
            Optional<Message> f = messageRepository.getMessage(m.getIdMessage());
            if(f.isPresent()){
                return m;
            }else{
                return messageRepository.save(m);
            }
        }
    }
    public Message update(Message m){
        if(m.getIdMessage()!=null){
            Optional<Message> f = messageRepository.getMessage(m.getIdMessage());
            if(f.isPresent()){
                if(m.getIdMessage()!=null){
                    f.get().setIdMessage(m.getIdMessage());
                }
                if(m.getMessageText()!=null){
                    f.get().setMessageText(m.getMessageText());
                }


                messageRepository.save(f.get());
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
        Optional<Message>p= messageRepository.getMessage(id);
        if(p.isPresent()){
            messageRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }


}
