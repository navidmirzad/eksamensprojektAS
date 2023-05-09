

package com.example.projektkalkuleringsprojekt2semexam.controller;

import com.example.projektkalkuleringsprojekt2semexam.model.Project;
import com.example.projektkalkuleringsprojekt2semexam.model.User;
import com.example.projektkalkuleringsprojekt2semexam.service.ProjectService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    private boolean isLoggedIn(HttpSession session) {
        return session.getAttribute("user") != null;
    }

    @GetMapping("/frontpage")
    public String createProject(Model model, HttpSession session) {
        Project project = new Project();
        User user = (User) session.getAttribute("user");
        model.addAttribute("project", project);

        model.addAttribute("usersProjects", projectService.getUserById(user.getUserID()));
        return isLoggedIn(session) ? "frontpage" : "index";
    }

    @PostMapping("/frontpage")
    public String createdProject(@ModelAttribute("project") Project project) {
        projectService.createProject(project);
        return "redirect:/frontpage";
    }

    @GetMapping("/getProjects/{projectID}")
    public String getProjects(Model model, HttpSession session, @PathVariable int projectID) {
        model.addAttribute("projects", projectService.getProject(projectID));
        return isLoggedIn(session) ? "frontpage" : "index";
    }

    @GetMapping("/editProject/{id}")
    public String editProject(@PathVariable int id, Model model, HttpSession session) {
        Project project = projectService.findProjectByID(id);
        User user = (User) session.getAttribute("user");
        model.addAttribute("project", project);
        model.addAttribute("usersProjects", projectService.getProject(user.getUserID()));
        return isLoggedIn(session) ? "frontpage" : "index";
    }

    @PostMapping("/edit/wish/{id}")
    public String editedProject(@PathVariable int id, @ModelAttribute Project editedProject) {
        projectService.editProject(id, editedProject);
        return "redirect:/wishlist/seewishes";
    }

    @PostMapping("/deleteProject")
    public String deleteProject(@RequestParam("id") int id) {
        projectService.deleteProject(id);
        return "redirect:/frontpage";
    }









/*@GetMapping("/createproject")
    public String createProject(Model model, HttpSession session) {
        Project project = new Project();
        model.addAttribute("project", project);

        return isLoggedIn(session) ? "frontpage" : "index";
    }

    @PostMapping("/createProject")
    public String createdProject(@ModelAttribute("project") Project project,
                                  HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            projectService.createProject(user.getUserID(), project);
            return "redirect:/project";
        } else {
            return "redirect:/frontpage";
        }
    }

    @GetMapping("/seeProjects")
    public String seeProjects(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("projects", projectService.getProjects(user.getUserID()));
        } return isLoggedIn(session) ? "frontpage" : "index";
    }

    @GetMapping("/edit/{projectID}")
    public String editProject(@PathVariable int projectID, Model model) {
        Project project = projectService.findProjectByID(projectID);
        model.addAttribute("project", project);
        return "editProject";
    }

    @PostMapping("/edit/{projectID}")
    public String editProject(@PathVariable int projectID, @ModelAttribute Project editedProject) {
        projectService.editProject(projectID, editedProject);
        return "redirect:/frontpage";
    }

    @PostMapping("/deleteProject")
    public String deleteProject(@RequestParam("id") int id) {
        projectService.deleteProject(id);
        return "redirect:/frontpage";
    }*/


    @GetMapping("/aboutUs")
    public String aboutUs() {
        return "aboutUs";
    }

}


