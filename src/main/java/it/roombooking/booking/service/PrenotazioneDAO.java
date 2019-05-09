package it.roombooking.booking.service;

import it.roombooking.booking.model.Prenotazione;
import it.roombooking.booking.repository.PrenotazioneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class PrenotazioneDAO {

    @Autowired
    PrenotazioneRepo prenotazioneRepo;

    /* Save prenotazione */

    public Prenotazione save(Prenotazione pt){
        return prenotazioneRepo.save(pt);
    }

    /* Search prenotazione */

    public List<Prenotazione> findAll(){
        return prenotazioneRepo.findAll();
    }

    /* Get prenotazione by Id */

    public Prenotazione findOne(Long pt){
        return prenotazioneRepo.getOne(pt);
    }

    /* Delete single prenotazione */

    public void Delete(Prenotazione pt){
        prenotazioneRepo.delete(pt);
        return;
    }

    /* Get Prenotazione By month */
    public List<Prenotazione> findByMonth(int i){

        List<Prenotazione> pts= prenotazioneRepo.findAll();
        List<Prenotazione> ptMonth= new ArrayList<>();
        String patternMese = "MM";
        DateFormat pM = new SimpleDateFormat(patternMese);
        int j=0;

        for(j=0;j<pts.size();j++){
            if(Long.parseLong(pM.format(pts.get(j).getDataI())) == i)
            {
                ptMonth.add(pts.get(j));

            }
        }
        for (j=0;j<ptMonth.size();j++)
        {
            System.out.println(" ptMo-->"+ptMonth.get(j).getData());
        }
        if(ptMonth == null)return null;
        return ptMonth;
    }

/* Check data record for updating a new Room Booking */
    public int checkUpRecord (Prenotazione ptDtl){
        int flag=0;
        int i=0;
        List<Prenotazione> Pts= prenotazioneRepo.findAll();
        for(Prenotazione pt : Pts) {
            if(pt.getDataI()==null || ptDtl.getDataI()==null){return flag;}
            if(ptDtl.getDataI().after(pt.getDataI()) && ptDtl.getDataI().before(pt.getDataF()) || ptDtl.getDataI().equals(pt.getDataI()) && ptDtl.getDataF().equals(pt.getDataF())){
                flag=666;
            }
            if(ptDtl.getDataF().after(pt.getDataI()) && ptDtl.getDataF().before(pt.getDataF()) || ptDtl.getDataI().equals(pt.getDataI()) && ptDtl.getDataF().equals(pt.getDataF())){
                flag=666;
            }
        }
        if(flag!=666)flag=111;
        return  flag;
    }
}
