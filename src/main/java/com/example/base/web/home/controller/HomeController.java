package com.example.base.web.home.controller;

import com.example.base.utils.BaseController;
import com.example.base.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HomeController
 * @Despriction TODO
 * @Author Zenos
 * @Date 2018/11/27 10:59
 */
@RestController
@RequestMapping(value = "HomeController")
@Api(description = "首页")
public class HomeController extends BaseController {

    @ApiOperation(value = "文章列表", httpMethod = "GET", produces = "application/json")
    @GetMapping("/articleList")
    public JSONResult ArticleList(@RequestParam(value = "title", required = true) String title, @RequestParam(value = "Pindex", required = true) Integer Pindex, @RequestParam(value = "Psize", required = true) Integer Psize) {
        try {
            Integer resule=1;
            return new JSONResult(200,"成功",null);
        }catch (Exception e){
            return new JSONResult(404,e.getMessage(),null);
        }

    }
}
