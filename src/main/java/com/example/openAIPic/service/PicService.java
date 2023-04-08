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
     * 图片服务类
     * @param prompt 图片关键词
     * @param num 生成数量
     * @param size 图片大小 如1024×1024
     * @return 图片
     */
    String generations(String prompt, int num, String size);
}
