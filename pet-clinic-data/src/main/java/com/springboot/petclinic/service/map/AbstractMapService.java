package com.springboot.petclinic.service.map;

import com.springboot.petclinic.model.BaseEntity;

import java.util.*;

public  class AbstractMapService<T extends BaseEntity,ID extends Long> {

    protected Map<Long,T> map=new HashMap<>();

    List<T> findAll(){
        return new ArrayList<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }


    T save(T object){


        if(object!=null){
            if(object.getId() == null){

                    object.setId(getNextID());

            }
            map.put(object.getId(),object);

        }else{

            throw new NullPointerException("Empty Object");
        }

        return object;
    }

    void deleteById(ID id){

        map.remove(id);

    }

    void delete(T object){

         map.entrySet().removeIf(entry -> entry.getValue().equals(object));


    }


       public Long getNextID(){

       Long next_Id = null;
       try{

           next_Id=Collections.max(map.keySet()) +1;
       }catch (NoSuchElementException e ){
           next_Id=1L;

       }
         return  next_Id;
       }



}
