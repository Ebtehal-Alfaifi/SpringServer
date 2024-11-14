package com.example.tasktracker.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskModel {
    private String id;
    private String title;
    private String description;
    private String status;


}


