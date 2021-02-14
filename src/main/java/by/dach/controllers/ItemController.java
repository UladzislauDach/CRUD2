package by.dach.controllers;

import by.dach.dao.ItemDAO;
import by.dach.models.Item;
import by.dach.models.SecondReport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/order")
public class ItemController {
    private int personId;
    private final ItemDAO itemDAO;

    public ItemController(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    @GetMapping("/{id}")
    public String newItem(@PathVariable("id") int id, Model model) {
        personId = id;
        model.addAttribute("item", new Item());
        return "item/new";
    }

    @GetMapping("/report/{id}")
    public String report(@PathVariable("id") int id, Model model) {
        model.addAttribute("reports", itemDAO.getReport(id));
        return "item/report";
    }

    @PostMapping
    public String createItem(@ModelAttribute("item") Item item) {
        item.setPersonId(personId);
        LocalDateTime now = LocalDateTime.now();
        item.setDate(now);
        itemDAO.save(item);
        return "redirect:/people";
    }

    @GetMapping("/all")
    public String showAll(Model model) {
        model.addAttribute("orders", itemDAO.showAll());
        return "item/show";
    }
    @GetMapping("/date_report")
    public String showDateOrders(Model model) {
        model.addAttribute("orders", itemDAO.showDateOrders());
        return "item/show_date_report";
    }

    @GetMapping("/second_report")
    public String getSecondReport(Model model){
        model.addAttribute("report", new SecondReport());
        return "/item/form_for_second_report";
    }
    @PostMapping("/second_report")
    public String getSecondReport(@ModelAttribute ("report") SecondReport report, Model model){
        model.addAttribute("reports", itemDAO.getSecondReport(report));
        return "/item/show_second_report";
    }
}
