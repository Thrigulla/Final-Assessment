
package net.codejava;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {

    @Autowired
    private EmpService service;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Employee> empList = service.listAll();
        model.addAttribute("empList", empList);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "new_emp";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("employee") Employee employee) {
        service.save(employee);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_employee");
        Employee employee = service.get(id);
        mav.addObject("employee", employee);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}