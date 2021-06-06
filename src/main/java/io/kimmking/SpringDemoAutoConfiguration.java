package io.kimmking;

import io.kimmking.spring01.Student;
import io.kimmking.spring02.Klass;
import io.kimmking.spring02.School;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Author: zhoujian
 * Description:自动配置类
 * Date: 2021/6/6 17:19
 */
@Configuration
@ConditionalOnProperty(name = "io.kimmking.demo.autoConfiguration.enable", havingValue = "true")
public class SpringDemoAutoConfiguration {

    @Bean(name = "student123")
    @ConfigurationProperties(prefix = "student123")
    public Student student123() {
        return new Student();
    }

    @Bean(name = "student100")
    @ConfigurationProperties(prefix = "student100")
    @Primary
    public Student student100() {
        return new Student();
    }

    @Bean
    @ConditionalOnBean(name = {"student100", "student123"})
    public List<Student> students(Student student123, Student student100) {
        List<Student> list = new ArrayList<>();
        if (Objects.nonNull(student123)) {
            list.add(student123);
        }
        if (Objects.nonNull(student100)) {
            list.add(student100);
        }
        return list;
    }

    @Bean
    public Klass klass() {
        return new Klass();
    }

    @Bean
    @ConditionalOnBean(name = {"student100", "klass"})
    public School school() {
        return new School();
    }
}