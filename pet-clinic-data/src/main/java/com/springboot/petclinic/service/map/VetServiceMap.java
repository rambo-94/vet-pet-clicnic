package com.springboot.petclinic.service.map;
import com.springboot.petclinic.model.Vet;
import com.springboot.petclinic.service.VetService;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {


    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {

        return  super.save(object.getId(),object);
    }

    @Override
    public List<Vet> findAll() {
        return (List<Vet>) super.findAll();
    }

    @Override
    public void deleteByID(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {

        super.delete(object);

    }

}
