package com.wn.carrentalplatform.controller;

import com.wn.carrentalplatform.model.vo.CarVo;
import com.wn.carrentalplatform.service.CarService;
import com.wn.carrentalplatform.util.DataGridView;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/24 16:00
 * @version: 1.0
 */
@Slf4j
@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;


    /**
     * 查询所有车辆
     */
    @RequestMapping("/queryCars")
    @ResponseBody
    public DataGridView queryAllCars(CarVo carVo) {
        //log.info("分页参数: page={}, limit={}", carVo.getPage(), carVo.getLimit());
        DataGridView result = carService.queryCars(carVo);
        /*log.info("查询结果: code={}, msg={}, count={}, data={}",
            result.getCode(), result.getMsg(), result.getCount(), result.getData());
        return result;*/
        // 打印接收到的参数
        System.out.println("查询参数：" + carVo);
        // 调用服务层查询数据
        return carService.queryCars(carVo);
    }

    /**
     * 文件上传
     */
    @RequestMapping("/uploadFile")
    @ResponseBody
    public DataGridView uploadFile(MultipartFile file) {
        Map<String, String> map = new HashMap<>();
        try {
            // 定义文件存放的基本目录
            String base = "/Users/chinhae/Documents/upload ";
            // 获取文件名
            String originalFilename = file.getOriginalFilename();
            // 获取文件后缀
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            // 生成新的文件名 随机一个新文件名
            String prefix = new Date().getTime() + "";
            // 创建文件 
            File f = new File(base, prefix + suffix);
            // 保存文件
            file.transferTo(f);
            // 返回结果
            map.put("src", "/upload/" + prefix + suffix);
            
        } catch (IOException e) {
            // 上传失败,响应默认图片
            map.put("src", "http://localhost:8080/upload/default.jpg");
            e.printStackTrace();
        }
        // 返回结果
        return new DataGridView(map);
    }


}