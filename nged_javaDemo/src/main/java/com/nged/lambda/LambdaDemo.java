package com.nged.lambda;


import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * lambda list 转map ，当key重复合并值时操作
 */
public class LambdaDemo {



    public static void main(String[] args){
        List<ProductInfo> productInfos = new ArrayList<>();

        productInfos.add(new ProductInfo("1","1","油品","油品111"));
        productInfos.add(new ProductInfo("2","1","轮胎","轮胎222"));
        productInfos.add(new ProductInfo("3","2","轮胎","轮胎333"));

        Map<String,List<ProductInfo>> map = productInfos.stream().collect(Collectors.groupingBy(ProductInfo::getId));
        //重复key 保留一个value
        Map<String,ProductInfo> map1 = productInfos.stream().collect(Collectors.toMap(ProductInfo::getProductId,value ->value,(oldObj,newObj) -> oldObj));

        Map<String,List<ProductInfo>> map2 = productInfos.stream().collect(
                Collectors.toMap(ProductInfo::getProductId,
                        Lists::newArrayList,
                        (List<ProductInfo> old,List<ProductInfo> n)->{old.addAll(n);return old;}));


    }

    public static ProductInfo toEntity(String id,String productId,String attributeName,String attributeValue){

        return new ProductInfo(id,productId,attributeName,attributeValue);
    }
    public static class ProductInfo {
        /**
         * 商品 对应 多个属性
         */
        private String id;
        private String productId;
        private String attributeName;
        private String attributeValue;

        private ProductInfo(String id, String productId, String attributeName, String attributeValue) {
            this.id = id;
            this.productId = productId;
            this.attributeName = attributeName;
            this.attributeValue = attributeValue;
        }

        private String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        private String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getAttributeName() {
            return attributeName;
        }

        public void setAttributeName(String attributeName) {
            this.attributeName = attributeName;
        }

        public String getAttributeValue() {
            return attributeValue;
        }

        public void setAttributeValue(String attributeValue) {
            this.attributeValue = attributeValue;
        }
    }
}
