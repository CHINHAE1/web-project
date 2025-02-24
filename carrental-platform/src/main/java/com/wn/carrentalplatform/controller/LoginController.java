package com.wn.carrentalplatform.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.wn.carrentalplatform.model.entity.User;
import com.wn.carrentalplatform.model.vo.UserVo;
import com.wn.carrentalplatform.service.LogInfoService;
import com.wn.carrentalplatform.service.UserService;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2025/2/22 12:40
 * @version: 1.0
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private LogInfoService loginfoService;

    /**
     * 跳转登录页面
     *
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 跳转到注册页面
     */
    @GetMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    // 直接访问根路径
    @GetMapping("/")
    public String index() {
        return "index";  // 转发到入口页
    }

    /**
     * 生成并返回图形验证码
     *
     * @param response HTTP响应对象，用于输出图片
     * @param session  HTTP会话对象，用于存储验证码
     * @throws IOException 当输出流写入异常时抛出
     */
    @RequestMapping("/getCode")  // 修改验证码路径
    @ResponseBody
    public void getCode(HttpServletResponse response, HttpSession session) throws IOException {
        try {
            // 设置响应内容类型为图片
            response.setContentType("image/jpeg");
            // 设置响应头，防止浏览器缓存
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);

            // 创建线条干扰的验证码图片，宽116像素，高36像素
            LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 36);
            // 将验证码字符串保存到session中，用于后续验证
            session.setAttribute("code", lineCaptcha.getCode());
            // 将验证码图片写入响应输出流
            lineCaptcha.write(response.getOutputStream());
            // 刷新输出流，确保图片数据被发送到客户端
            response.getOutputStream().flush();
        } catch (Exception e) {
            // 捕获并打印异常堆栈信息
            e.printStackTrace();
        }
    }


    /**
     * 进行登录验证
     */
    @RequestMapping("/login")
    public String login(UserVo userVo, String code, HttpSession session, Model model) {
        /*// 获取session中的验证码
        String codeSession = session.getAttribute("code").toString();
        // 判断验证码是否正确
        if (!userVo.getCode().equals(codeSession)) {
            // 根据用户名和密码查询用户
            User user = userService.login(userVo);
            // 如果用户存在，则将用户信息存入session
            if (user != null) {
                // 保存用户信息到session域中
                session.setAttribute("user", user);

                // 保存登录日志信息
                LogInfo logInfo = new LogInfo();
                logInfo.setLoginname(user.getRealname() + "-" + user.getLoginname());
                logInfo.setLoginip(WebUtils.getHttpServletRequest().getRemoteAddr());
                logInfo.setLogintime(LocalDateTime.now());
                loginfoService.addUserLogInfo(logInfo);

                return "index";
            } else {
                // 表示用户名或密码错误
                model.addAttribute("error", SysStatusMsg.USER_LOGIN_ERROR_MSG);
                return "login";
            }
        } else {
            // 保存错误信息到域中session
            model.addAttribute("error", SysStatusMsg.USER_LOGIN_CODE_ERROR_MSG);
            return "login";
        }*/

        try {
            // 1. 详细的参数打印
            System.out.println("=== 登录请求开始 ===");
            System.out.println("用户名: " + userVo.getLoginname());
            System.out.println("密码: " + userVo.getPwd());
            System.out.println("验证码: " + code);

            // 2. 参数校验
            if (userVo == null || StringUtils.isEmpty(userVo.getLoginname())
                    || StringUtils.isEmpty(userVo.getPwd())) {
                System.out.println("参数校验失败：用户名或密码为空");
                model.addAttribute("error", "用户名或密码不能为空");
                return "login";
            }

            // 3. 验证码校验
            String sessionCode = (String) session.getAttribute("code");
            System.out.println("Session中的验证码: " + sessionCode);

            // 4. 调用服务层处理登录
            User user = userService.login(userVo);
            System.out.println("登录结果: " + user);

            // 5. 处理结果
            if (user != null) {
                session.setAttribute("user", user);
                System.out.println("登录成功，用户信息已存入session");
                return "index";
            } else {
                System.out.println("登录失败：用户名或密码错误");
                model.addAttribute("error", "用户名或密码错误");
                return "login";
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("登录异常：" + e.getMessage());
            model.addAttribute("error", "登录失败：" + e.getMessage());
            return "login";
        }
    }

    /**
     * 用户注册
     */
    /*@RequestMapping("/toRegister")
    public String register(UserVo userVo, String password, Model model) {
        System.out.println(userVo);
        // 查询注册用户是否存在
        userVo.setPwd(password);
        User user = userService.login(userVo);
        if (user == null) {
            try {
                // 添加新用户
                userVo.setPwd(password);
                userService.insertUser(userVo);
                userVo.setPwd(password);
                user = userService.login(userVo);
            } catch (RuntimeException e) {
                model.addAttribute("error", SysStatusMsg.USER_REFISTER_CODE_ERROR_MSG);
                return "login";
            }
            // 保存用户信息到session域中
            userService.insertUserRole(user);
            return "login";
        }
        // 表示用户已存在，返回登录页面进行登录
        return "login";
    }*/

    /**
     * 处理用户注册请求
     *
     * @param userVo 用户注册信息的数据传输对象，包含用户名、密码、身份证等信息
     * @return 注册成功重定向到登录页面，失败则返回注册页面并显示错误信息
     */
    @PostMapping("/register")
    public String register(UserVo userVo, HttpServletRequest request) {
        try {
            // 从请求中获取参数
            String username = request.getParameter("realname");  // 前端的用户名字段是 realname
            String password = request.getParameter("password");  // 前端的密码字段是 password
            String identity = request.getParameter("identity");  // 身份证号保持不变

            System.out.println("从请求中获取的参数：");
            System.out.println("username: " + username);
            System.out.println("password: " + password);
            System.out.println("identity: " + identity);

            // 手动设置 UserVo 的字段
            userVo.setLoginname(username);      // 设置登录名
            userVo.setPwd(password);           // 设置密码
            userVo.setRealname(username);      // 同时设置真实姓名
            userVo.setIdentity(identity);      // 设置身份证号

            // 设置默认值
            userVo.setType(2);        // 设置用户类型为2，表示普通用户
            userVo.setAvailable(1);   // 设置用户状态为1，表示账号可用

            System.out.println("处理后的注册参数：" + userVo);

            // 参数校验
            if (StringUtils.isEmpty(username)) {
                throw new RuntimeException("用户名不能为空");
            }
            if (StringUtils.isEmpty(password)) {
                throw new RuntimeException("密码不能为空");
            }
            if (StringUtils.isEmpty(identity)) {
                throw new RuntimeException("身份证号不能为空");
            }

            // 调用注册服务
            userService.register(userVo);

            // 注册成功，重定向到登录页面
            return "redirect:/login/toLogin";

        } catch (Exception e) {
            e.printStackTrace();
            // 将错误信息添加到 request 中
            request.setAttribute("error", "注册失败：" + e.getMessage());
            // 返回注册页面
            return "register";
        }
    }

}
