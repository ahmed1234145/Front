package tn.esprit.ourbank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ourbank.DAO.Entities.Theme;
import tn.esprit.ourbank.Service.Implementation.ThemeServiceImpl;
import tn.esprit.ourbank.Service.Interface.ThemeService;

import java.util.HashMap;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("theme/")
public class ThemeRestController {
    @Autowired
    ThemeServiceImpl themeService;

    // http://localhost:8081/SpringMVC/add-theme
    @PostMapping("add-theme")
    @ResponseBody
    public Theme addTheme(@RequestBody Theme t)
    {
        Theme theme = themeService.addTheme(t);
        return theme;
    }

    // URLhttp://localhost:8081/SpringMVC/theme/getAllThemeNamesJPQL
    @GetMapping("getAllThemeNames")
    public List<Theme> getAllThemeNames(){
        return themeService.retrieveAllTheme();
    }

    // URLhttp://localhost:8081/SpringMVC/theme/getThemesFeedback
   /* @GetMapping("getThemesFeedback")
    public HashMap<Long, Theme> getThemesFeedback(){
        return themeService.getThemesFeedBack();
    }*/

    //urlhttp://localhost:8081/SpringMVC/add-theme
    @GetMapping("retrieve-theme/{themeId}")
    public Theme retrieveTheme(@PathVariable("themeId") int themeId) {
        return themeService.retrieveTheme(themeId);
    }
    @GetMapping("getPostsTotalFeedback/{themeId}")
        public int getPostsTotalFeedback(@PathVariable("themeId") int themeId) {
            return themeService.getPostsTotalFeedback(themeId);
        }

    // http://localhost:8081/SpringMVC/remove-theme/{theme-id}
    @DeleteMapping("remove-theme/{themeId}")
    @ResponseBody
    public void removeTheme(@PathVariable("themeId") int themeId) {
        themeService.deleteTheme(themeId);
    }

    // http://localhost:8081/SpringMVC/update-theme
    @PutMapping("update-theme")
    public Theme updateTheme(@RequestBody Theme theme) {
        return themeService.updateTheme(theme);
    }

}
