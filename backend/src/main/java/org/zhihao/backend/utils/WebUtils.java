package org.zhihao.backend.utils;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author ChenZhihao
 * @Date 2024/9/26 10:34
 */
public class WebUtils {
    public static void renderString(HttpServletResponse response, String string) {
        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
