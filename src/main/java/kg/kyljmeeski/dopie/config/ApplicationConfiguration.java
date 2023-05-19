package kg.kyljmeeski.dopie.config;

import kg.kyljmeeski.dopie.mapper.AdminPredictionMapper;
import kg.kyljmeeski.dopie.mapper.MatchMapper;
import kg.kyljmeeski.dopie.mapper.TeamMapper;
import kg.kyljmeeski.dopie.mapper.impl.AdminPredictionMapperImpl;
import kg.kyljmeeski.dopie.mapper.impl.MatchMapperImpl;
import kg.kyljmeeski.dopie.mapper.impl.TeamMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public TeamMapper teamMapper() {
        return new TeamMapperImpl();
    }

    @Bean
    public MatchMapper matchMapper() {
        return new MatchMapperImpl(teamMapper());
    }

    @Bean
    public AdminPredictionMapper adminPredictionMapper(){
        return new AdminPredictionMapperImpl();
    }
}
