package cn.caohangwei.es.repository;

import cn.caohangwei.es.pojo.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ElasticsearchCrudRepository<Product,String> {

}
