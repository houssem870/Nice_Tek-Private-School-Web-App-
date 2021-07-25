package com.example.Services;

import com.example.Entities.Response;
import com.example.Repository.ResponseRepository;
import com.example.utils.ErrorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    @Autowired
    ResponseRepository responseRepository;


    public ResponseEntity<?> getResponsetById(int id){
        Response response=new Response();

        if (!responseRepository.findById(id).isPresent())
            return new ResponseEntity<>(new ErrorModel("response Not found"), HttpStatus.BAD_REQUEST);
        response=responseRepository.findById(id).get();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
    public  ResponseEntity<?> updateResponse(int id,String desc){
       Response response_DataBase=new Response();
        response_DataBase=responseRepository.findById(id).get();

        response_DataBase.setResponse(desc);


        responseRepository.save(response_DataBase);
        return new ResponseEntity<>( HttpStatus.OK);

    }
    public ResponseEntity<?> deleteById(int id){
        if (!responseRepository.findById(id).isPresent())
            return new ResponseEntity<>(new ErrorModel("Question Not found"), HttpStatus.BAD_REQUEST);
        responseRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
