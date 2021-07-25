package com.example.Services;

import com.example.Entities.Quest;
import com.example.Entities.Quest_Pro;
import com.example.Entities.Response;
import com.example.Entities.User;
import com.example.Repository.QuestRepository;
import com.example.Repository.ResponseRepository;
import com.example.Repository.UserRepository;
import com.example.utils.ErrorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class QuestService {
    @Autowired
    QuestRepository questRepository;
    @Autowired
    ResponseRepository responseRepository;
    @Autowired
    UserRepository userRepository;


    public ResponseEntity<?> addQuestion(Quest quest){
        Quest_Pro quest_pro_DataBase=new Quest_Pro();

        if(quest.getTitle().length()<3)
            return new ResponseEntity<>(new ErrorModel("Title Invalid"), HttpStatus.BAD_REQUEST);
        quest_pro_DataBase.setTitle(quest.getTitle());

        quest_pro_DataBase.setQuestion(quest.getQuestion());
        Response response=new Response();
        response.setId(quest_pro_DataBase.getId_Quest());
        response.setTitle(quest.getTitle());
        responseRepository.save(response);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUserName(username).get();
        quest_pro_DataBase.setResponse(response);
        quest_pro_DataBase.setUser(user);
        questRepository.save(quest_pro_DataBase);
        return new ResponseEntity<>(quest_pro_DataBase,HttpStatus.OK);
    }
    public ResponseEntity<?> getQuestById(int id){
        Quest_Pro quest_pro=new Quest_Pro();

        if (!questRepository.findById(id).isPresent())
            return new ResponseEntity<>(new ErrorModel("Question Not found"), HttpStatus.BAD_REQUEST);
        quest_pro=questRepository.findById(id).get();
        return new ResponseEntity<>(quest_pro, HttpStatus.OK);

    }
    public  ResponseEntity<?> updateQuestion(int id,Quest quest_pro,String desc){
        Quest_Pro quest_pro_DataBase=new Quest_Pro();
        quest_pro_DataBase=questRepository.findById(id).get();

        quest_pro_DataBase.setQuestion(quest_pro.getQuestion());
        quest_pro_DataBase.setTitle(quest_pro.getTitle());
       Response response=quest_pro_DataBase.getResponse();
        response.setResponse(desc);
        response.setTitle(quest_pro_DataBase.getTitle());

        quest_pro_DataBase.setResponse(response);
        questRepository.save(quest_pro_DataBase);
        return new ResponseEntity<>( HttpStatus.OK);

    }
    public ResponseEntity<?> deleteById(int id){
        if (!questRepository.findById(id).isPresent())
            return new ResponseEntity<>(new ErrorModel("Question Not found"), HttpStatus.BAD_REQUEST);
        questRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
