package cn.caohangwei.es.service.impl;

import cn.caohangwei.es.pojo.Product;
import cn.caohangwei.es.repository.ProductRepository;
import cn.caohangwei.es.request.ElasticSearchParamsRequest;
import cn.caohangwei.es.service.EsService;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author PinuoC
 */
@Service
public class EsServiceImpl implements EsService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public void insert(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(String id){
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> findByName(ElasticSearchParamsRequest request) {
        CriteriaQuery query = new CriteriaQuery(new Criteria("name").fuzzy(request.getKey()));
//        QueryBuilder queryBuilder = QueryBuilders.fuzzyQuery("name",request.getKey());
        List<Product> productList = elasticsearchTemplate.queryForList(query,Product.class);
        return productList;
    }
}
