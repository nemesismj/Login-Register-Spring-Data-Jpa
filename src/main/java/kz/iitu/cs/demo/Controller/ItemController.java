package kz.iitu.cs.demo.Controller;
import kz.iitu.cs.demo.Model.Item;
import kz.iitu.cs.demo.Model.User;
import kz.iitu.cs.demo.Service.ItemService;
import kz.iitu.cs.demo.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ItemController {
    Logger logger = LoggerFactory.getLogger(ItemController.class);
    @Autowired
    private ItemService service;
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Item> listItems = service.listAll();
        List<User> listUser = userService.getAllUsers();
        model.addAttribute("listUser", listUser);
        model.addAttribute("listItems", listItems);
        logger.debug("HomePage accessed");
        return "index";
    }

    @RequestMapping("/new")
    public String showNewItemPage(Model model) {
        Item Item = new Item();
        model.addAttribute("item", Item);
        logger.debug("NewItemPage accessed");
        return "new_item";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveItem(@ModelAttribute("item") Item Item) {
        service.save(Item);
        logger.debug("Item successfully saved " + Item.getName());
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditItemPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_item");
        Item Item = service.get(id);
        mav.addObject("item", Item);
        logger.debug("Edit done " + Item.getName());
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteItem(@PathVariable(name = "id") int id) {
        Item Item = service.get(id);
        service.delete(id);
        logger.debug("delete done " + Item.getName());
        return "redirect:/";
    }
}
