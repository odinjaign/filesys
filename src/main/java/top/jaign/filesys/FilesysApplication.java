package top.jaign.filesys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.jaign.filesys.mapper")
public class FilesysApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilesysApplication.class, args);
    }

}
