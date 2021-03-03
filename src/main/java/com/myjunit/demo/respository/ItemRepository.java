package com.myjunit.demo.respository;

import com.myjunit.demo.domain.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ItemRepository extends ElasticsearchRepository<Item,Long> {

    /**
     * 不需要实现
     */
    List<Item> findByTitle(String title);

    /**
     * 范围查item
     * @param left
     * @param right
     * @return
     */
    List<Item> findByPriceBetween(Double left,Double right);

}
