package spring.ioc.overview.bean;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import spring.ioc.overview.dependency.dimain.User;

public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {

        //1. 构建者模式BeanDefinitionBuilder创建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);

        // 设置属性
        beanDefinitionBuilder.addPropertyValue("name","cww")
                .addPropertyValue("age",32);
        //获取beanDefinition示例
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();


        //2. 通过AbstractBeanDefinition以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        //设置bean类型
        genericBeanDefinition.setBeanClass(User.class);

        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("age",11)
                .add("name","cwa");

        genericBeanDefinition.setPropertyValues(propertyValues);

    }
}
