package xyz.boer.produce.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.boer.produce.mapper.UserMapper;
import xyz.boer.produce.domain.User;

import java.util.*;

/**
 * @author boer
 */
@Slf4j
@RestController
public class TheController {

    /**
     * index控制器
     *
     * @param msg 传递消息，默认值="World"
     * @return Hello World/msg
     */
    @GetMapping("/")
    public String index(@RequestParam(name = "msg", required = false, defaultValue = "World") String msg) {
        log.info(msg);
        return "Hello, " + msg + "! 2020.09.11";
    }

    /**
     * hello控制器
     *
     * @return "Hello World!"
     */
    @GetMapping("/hello")
    public String hello() {
        log.info("hello");
        return "Hello World!";
    }

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/reg")
    User Reg(@RequestBody User user) {
        // userMapper.insert("AAA", 20);
        log.info(user.toString());
        return user;
    }

    @GetMapping("/mapsort")
    public String sortMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 6);
        map.put("banane", 2);
        map.put("orange", 4);

        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue() - o1.getValue());
            }
        });

        Map<String, Integer> tmpMap = new HashMap<>();
        for (Map.Entry<String, Integer> e : list) {
            tmpMap.put(e.getKey(), e.getValue());
        }

        return tmpMap.toString();
    }
}