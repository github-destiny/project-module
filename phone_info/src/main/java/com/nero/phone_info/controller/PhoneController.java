package com.nero.phone_info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author NeRo Claudius
 * @version 1.0.0
 * @date 13/10/2021 下午8:29
 * @company https://nero-cx.ltd
 */
@RestController
public class PhoneController {

    @GetMapping("/phone/search/{phone}")
    public ModelAndView getRequest(@PathVariable("phone") String phone){
        Map<String, String> map = new HashMap<>();
        map.put("12345678910", "黑龙江");
        map.put("12345678911", "北京");
        map.put("12345678912", "上海");
        map.put("12345678913", "深圳");
        map.put("12345678914", "广州");
        ModelAndView mv = new ModelAndView();
        mv.addObject("data", map.get(phone));
        return mv;
    }

}
