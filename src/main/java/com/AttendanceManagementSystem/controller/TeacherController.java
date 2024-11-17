package com.AttendanceManagementSystem.controller;
import com.AttendanceManagementSystem.entity.Teacher;
import com.AttendanceManagementSystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @GetMapping("/teachers")
    public String getAllTeachers(Model model){
        model.addAttribute("teachers",teacherService.getAllTeachers());
        return "teachers";
    }
    @GetMapping("teachers/new")
    public String createTeacherForm(Model model) {
        Teacher teacher = new Teacher(); // To hold the teacher object
        model.addAttribute("teacher", teacher);
        return "create-teacher";
    }
    @PostMapping("/teachers")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:/teachers";
    }
    @GetMapping("/teachers/edit/{id}")
    public String editTeacherForm(@PathVariable int id, Model model) {
        model.addAttribute("teacher", teacherService.getTeacherById(id));
        return "edit_teacher";
    }
    @PostMapping("/teachers/edit/{id}")
    public String updateTeacher(@PathVariable int id, @ModelAttribute("teacher") Teacher teacher) {
        Teacher existingTeacher = teacherService.getTeacherById(id);
        existingTeacher.setFirstName(teacher.getFirstName());
        existingTeacher.setLastName(teacher.getLastName());
        existingTeacher.setEmail(teacher.getEmail());

        teacherService.saveTeacher(existingTeacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/{id}")
    public String deleteById(@PathVariable int id) {
        teacherService.deleteById(id);
        return "redirect:/teachers";
    }

}
