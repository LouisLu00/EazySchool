package com.louis.EazySchool.controller;

import com.louis.EazySchool.Repository.HolidaysRepository;
import com.louis.EazySchool.model.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidaysController {
    @Autowired
    private HolidaysRepository holidaysRepository;

    @GetMapping("/holidays")
    public String displayHolidays(Model model, @RequestParam(required = false, defaultValue = "true") boolean  festival,
                                  @RequestParam(required = false, defaultValue = "true") boolean federal) {
        model.addAttribute("festival", festival);
        model.addAttribute("federal", federal);

        List<Holiday> holidays = holidaysRepository.findAllHolidays();
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays.html";
    }


}
