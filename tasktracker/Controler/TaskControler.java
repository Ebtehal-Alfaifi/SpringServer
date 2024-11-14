package com.example.tasktracker.Controler;

import com.example.tasktracker.Api.Api;
import com.example.tasktracker.Model.TaskModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task")
public class TaskControler {
    ArrayList<TaskModel> tasks = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<TaskModel> getTask() {
        return tasks;
    }


    @PostMapping("/add")
    public Api addTask(@RequestBody TaskModel task) {
        tasks.add(task);
        return new Api(" add success");
    }


    @PutMapping("/update/{index}")
    public Api updateTask(@PathVariable int index, @RequestBody TaskModel task) {
        tasks.set(index, task);
        return new Api("the update  seccess");
    }
//

    @DeleteMapping("/Delete/{index}")
    public Api deleteTask(@PathVariable int index) {
        tasks.remove(index);
        return new Api("the delete seccess");
    }

@PutMapping("/chang/{index}")
    public Api changstatus(@PathVariable int index) {
        if (index < tasks.size() && tasks.get(index).getStatus().equals("not done")) {

        tasks.get(index).setStatus("Done");}
        return new Api("change status seccess");
    }


    @GetMapping("/search/{title}")
    public TaskModel searchTask(@PathVariable String title) {
        for (TaskModel task : tasks) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                return task;
            }

        }
        return null;
    }


}








