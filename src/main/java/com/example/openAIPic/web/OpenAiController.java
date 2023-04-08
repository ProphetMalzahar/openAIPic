package com.example.openAIPic.web;

import com.example.openAIPic.service.PicService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Frenkie De Jong
 *
 * @projectName: openAIPic
 * @package: com.example.openAIPic.web
 * @className: OpenAiController
 * @author: frenkie
 * @description: TODO
 * @date: 2023/3/31 23:18
 * @version: 1.0
 */
@RestController
public class OpenAiController {
    @Resource
    private PicService picService;

    @PostMapping("/generations")
    public String generations(@RequestParam("prompt") String prompt,
                              @RequestParam("num") int num,
                              @RequestParam("size") String size) {
        return picService.generateImages(prompt, num, size);
    }


}
