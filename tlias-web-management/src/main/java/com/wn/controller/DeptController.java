package com.wn.controller;

import com.wn.pojo.Dept;
import com.wn.pojo.Result;
import com.wn.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/12/3 10:53
 * @version: 1.0
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    //private static final Logger log = LoggerFactory.getLogger(DeptController.class); // 固定的

    @Autowired
    private DeptService deptService;

    //@RequestMapping(value = "/depts",method = RequestMethod.GET) // method:指定请求方式
    @GetMapping
    public Result list() {
        //System.out.println("查询全部部门的数据");
        log.info("查询全部部门的数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /**
     * 根据id删除部门 - 方式一:
     * HttpServletRequest request
     * 需要转换类型
     */
    /*@DeleteMapping
    public Result delete(HttpServletRequest request){
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        System.out.println("根据id删除部门的数据" + id);
        deptService.delete(id);
        return Result.success();
    }*/


    /**
     * 根据id删除部门 - 方式二:
     *
     * @RequestParam 注意:一旦声明了@RequestParam,该参数在请求时必须携带参数名,否则会报错
     */
    /*@DeleteMapping
    public Result delete(@RequestParam(value = "id",required = false) Integer deptId) {
        System.out.println("根据id删除部门的数据" + deptId);
        deptService.delete(deptId);
        return Result.success();
    }*/

    /**
     * 方式三：如果请求参数名与形参变量名相同，直接定义方法形参即可接收
     * 省略@RequestParam
     */
    @DeleteMapping
    public Result delete(Integer id) {
        //System.out.println("根据id删除部门的数据" + id);
        log.info("根据id删除部门: {}", id);
        try {
            deptService.deleteById(id);
            return Result.success("部门删除成功");
        } catch (RuntimeException e) {
            return Result.success();
        }
    }

    /**
     * 新增部门
     */
    @PostMapping
    public Result addDept(@RequestBody Dept dept){
        //System.out.println("新增部门的数据" + dept);
        log.info("新增部门的数据: {}", dept);
        deptService.addDept(dept);
        return Result.success();
    }

    /**
     * 根据id查询部门信息
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        //System.out.println("根据id查询部门信息");
        log.info("根据id查询部门信息");
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    /**
     * 根据id修改部门信息
     */
    @PutMapping
    public Result update(@RequestBody Dept dept){
        //System.out.println("修改部门" + dept);
        log.info("修改部门: {}", dept);
        deptService.updateById(dept);
        return Result.success();

    }
}
