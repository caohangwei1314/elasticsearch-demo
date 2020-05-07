package cn.caohangwei.es.service;

import cn.caohangwei.es.pojo.Product;
import cn.caohangwei.es.request.ElasticSearchParamsRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHits;

import java.util.List;

public interface EsService {

    void insert(Product product);

    Product findById(String id);

    List<Product> findByName(ElasticSearchParamsRequest request);
}
