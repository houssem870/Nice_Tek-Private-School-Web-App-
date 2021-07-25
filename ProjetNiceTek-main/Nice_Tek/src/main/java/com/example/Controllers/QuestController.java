package com.example.Controllers;

import com.example.Entities.Quest;
import com.example.Services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuestController {
    @Autowired
    QuestService questService;

    @PostMapping("/addQuest")
    public ResponseEntity<?> addQuest(@RequestBody Quest quest_pro) {
        return questService.addQuestion(quest_pro);
    }
    @GetMapping("/getQuest")
    public ResponseEntity<?> getQuest(@RequestParam int id)
    {return questService.getQuestById(id);}
    @PutMapping("/updateQuest")
    public ResponseEntity<?> updateQuestion(@RequestParam  int id,@RequestBody Quest quest_pro,@RequestParam String desc){
        return questService.updateQuestion(id,quest_pro,desc);
    }
    @DeleteMapping("/DeleteQuest")
    public ResponseEntity<?> deleteQuest(int id){
        return questService.deleteById(id);
    }




}
