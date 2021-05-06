package com.hbl.sBoot.component;

import org.springframework.boot.autoconfigure.web.servlet.error.DefaultErrorViewResolver;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

public class MyErrorAttribute extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String,Object> map = super.getErrorAttributes(webRequest,includeStackTrace);
        map.put("sss","hbl");
        Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("add",0);
        map.put("ext",ext);
        return map;
    }
}
