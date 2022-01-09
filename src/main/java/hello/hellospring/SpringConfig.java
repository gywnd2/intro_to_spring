package hello.hellospring;

import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/*
 * Spring Bean에 등록
 * 1. @Component(@Service, @Repository, @Controller 등) 어노테이션 사용하여 등록
 * 2. 하위 코드(자바 코드)로 등록
 *
 */

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource){
        this.dataSource=dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
