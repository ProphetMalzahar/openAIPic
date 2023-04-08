package com.example.openAIPic.service;

/**
 * Frenkie De Jong
 *
 * @projectName: openAIPic
 * @package: com.example.openAIPic
 * @className: picService
 * @author: frenkie
 * @description: TODO
 * @date: 2023/3/31 23:30
 * @version: 1.0
 */
public interface PicService {
    /**
     * 图片结果
     * @param prompt
     * @param num
     * @param size
     * @return
     */
    String generateImages(String prompt, int num,String size);
}
