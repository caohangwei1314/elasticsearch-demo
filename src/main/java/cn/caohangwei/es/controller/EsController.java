package cn.caohangwei.es.controller;

import cn.caohangwei.es.base.BaseResponse;
import cn.caohangwei.es.pojo.Product;
import cn.caohangwei.es.request.ElasticSearchParamsRequest;
import cn.caohangwei.es.service.EsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/es")
public class EsController {

    @Autowired
    private EsService esService;

    @PostMapping("/insert")
    public BaseResponse insert(@RequestBody Product product){
        esService.insert(product);
        return BaseResponse.createSuccessBaseResponse();
    }

    @GetMapping("/find/{id}")
    public BaseResponse findById(@PathVariable("id") String id){
        return BaseResponse.createSuccessBaseResponse(esService.findById(id));
    }

    @PostMapping("/find/key")
    public BaseResponse findByKey(@RequestBody ElasticSearchParamsRequest request){
        return BaseResponse.createSuccessBaseResponse(esService.findByName(request));
    }
}
