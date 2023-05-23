package controller;

import entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.json.stream.JsonCollectors;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HomePageController {
    List<Student> list = new ArrayList<>();
    List<Student> list2 = new ArrayList<>();
    public void setList(List<Student> list) {
        this.list = list;
        list.add(new Student(1,"a","b"));
        list.add(new Student(2,"c","b"));
        list.add(new Student(3,"b","b"));
    }

    public Student getStudentById1(int id){
        for(Student s:list){
            if (s.getId() == id){
                return s;
            }
        }
        return null;
    }
    public void deleteStudentById(int id){
        list.removeIf(s -> s.getId() == id);
    }
    @GetMapping("HomePage")
    public Object HomePage(){
        if (list.isEmpty()){
            setList(list2);
        }
        return list;
    }
    @PostMapping("getStudentByID")
    public Object getStudentById(@RequestParam("id") int id){
        return getStudentById1(id);
    }
    @PostMapping("getStudentByID/{id}")
    public Object getStudentByIdPath(@PathVariable("id") int id){
        return getStudentById1(id);
    }
    @RequestMapping(value = "addStudent/newStudent",method = RequestMethod.GET)
    public Object getData(@RequestBody Student student){
        list.add(new Student(student.getId(),student.getName(),student.getClassName()));
        return list;
    }
    @GetMapping("deleteStudent/{id}")
    public Object delete(@PathVariable Integer id){
        deleteStudentById(id);
        return "success";
    }
}
