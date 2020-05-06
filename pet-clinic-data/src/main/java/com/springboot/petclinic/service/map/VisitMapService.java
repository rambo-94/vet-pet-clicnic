package com.springboot.petclinic.service.map;
import com.springboot.petclinic.model.Visit;
import com.springboot.petclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile({"default","map"})
public class VisitMapService extends AbstractMapService<Visit,Long> implements VisitService {


    @Override
    public Visit findById(Long id) {

        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {

       if(visit.getPet() ==null || visit.getPet().getOwner() == null || visit.getPet().getId() == null
                || visit.getPet().getOwner().getId() ==null){

           throw new NullPointerException("Incomplete visit Object");

       }

        return super.save(visit);
    }

    @Override
    public List<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteByID(Long id) {


         super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {


        super.delete(object);
    }
}
