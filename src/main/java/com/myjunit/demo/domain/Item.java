package com.myjunit.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "goods",shards = 1,replicas = 0)
public class Item implements Serializable {
    @Id
    Long id;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    String title;
    @Field(type = FieldType.Keyword)
    String category;
    @Field(type = FieldType.Keyword)
    String brand;
    @Field(type = FieldType.Double)
    Double price;
    @Field(type = FieldType.Keyword,index = false)//不会对图片地址查询,指定为false
    String images;
}
