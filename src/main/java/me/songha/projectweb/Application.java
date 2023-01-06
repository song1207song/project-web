package me.songha.projectweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description :: project-web 프로젝트는 웹페이지 뷰를 담당한 프로젝트로 구성한다.
 * 고로, db 커넥션 등의 역할은 타 프로젝트로 분리할 것이다.
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
