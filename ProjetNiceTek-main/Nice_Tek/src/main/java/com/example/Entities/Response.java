package com.example.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    String title;
    private  String response;
    @OneToOne(mappedBy = "response")
    Quest_Pro quest_pro;

}
