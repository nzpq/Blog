package com.nzpq.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

@Controller
public class LoginController {

    /**
     * 发送login请求，跳转到login页面
     * @return
     */
    @RequestMapping("/login")
    public String toAdminLogin(){
        return "login";
    }


    /**
     * 生成页面的验证码
     * @param response
     * @param session
     */
    @RequestMapping("/verifyCode")
    public void getVerifyCode(HttpServletResponse response, HttpSession session){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String verifyCodeValue = drawImg(output);
        // 将校验码保存到session中
        session.setAttribute("verifyCodeValue", verifyCodeValue);

        try {
            ServletOutputStream out = response.getOutputStream();
            output.writeTo(out);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    /* 绘制验证码 */
    private String drawImg(ByteArrayOutputStream output) {
        String code = "";
        // 随机产生4个字符
        for (int i = 0; i < 4; i++) {
            code += randomChar();
        }
        int width = 70;
        int height = 25;
        BufferedImage bi = new BufferedImage(width, height,BufferedImage.TYPE_3BYTE_BGR);
//        Font font = new Font("Times New Roman", Font.PLAIN, 20);
        Font font = new Font("Times New Roman", Font.BOLD, 20);
        // 调用Graphics2D绘画验证码
        Graphics2D g = bi.createGraphics();
        g.setFont(font);
//        Color color = new Color(66, 2, 82);
//        g.setColor(color);
        //设置画笔颜色为黄色，也就是验证码内容的颜色
        g.setColor(Color.YELLOW);
//        g.setBackground(new Color(226, 226, 240));
        //设置背景颜色为灰色
        g.setBackground(new Color(128, 128, 128));
        g.clearRect(0, 0, width, height);
        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        g.drawString(code, (int) x, (int) baseY);
        g.dispose();
        try {
            ImageIO.write(bi, "jpg", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code;
    }

    /* 获取随机参数 */
    private char randomChar() {
        Random r = new Random();
        String s = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
        return s.charAt(r.nextInt(s.length()));
    }
}