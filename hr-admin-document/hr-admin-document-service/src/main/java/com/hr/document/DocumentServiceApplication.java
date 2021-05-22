package com.hr.document;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author junjie
 * @version 1.0.0
 */
@SpringBootApplication
@MapperScan("com.hr.document.mapper")
public class DocumentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DocumentServiceApplication.class,args);
    }
}
