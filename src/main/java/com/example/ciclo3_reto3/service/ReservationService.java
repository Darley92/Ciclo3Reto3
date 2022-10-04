package com.example.ciclo3_reto3.service;



import com.example.ciclo3_reto3.entities.Reservation;
import com.example.ciclo3_reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation r) {
        if (r.getIdReservation() == null) {
            return reservationRepository.save(r);
        } else {
            Optional<Reservation> e = reservationRepository.getReservation(r.getIdReservation());
            if (e.isPresent()) {
                return r;
            } else {
                return reservationRepository.save(r);
            }
        }
    }

    public Reservation update (Reservation r){
        if(r.getIdReservation()!=null){
            Optional<Reservation> f = reservationRepository.getReservation(r.getIdReservation());
            if(f.isPresent()){
                if(r.getIdReservation()!=null){
                    f.get().setIdReservation(r.getIdReservation());
                }
                if(r.getStartDate()!=null){
                    f.get().setStartDate(r.getStartDate());
                }
                if(r.getDevolutionDate()!=null){
                    f.get().setDevolutionDate(r.getDevolutionDate());
                }

                reservationRepository.save(f.get());
                return f.get();
            }else{
                return r;
            }
        }else{
            return r;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Reservation>p= reservationRepository.getReservation(id);
        if(p.isPresent()){
            reservationRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }


}
