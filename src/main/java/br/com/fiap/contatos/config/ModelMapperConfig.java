package br.com.fiap.contatos.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for setting up the ModelMapper bean.
 * <p>
 * This class defines a Spring configuration for the ModelMapper, 
 * which is used to map between different object models in the application.
 * The ModelMapper is configured to use the STRICT matching strategy,
 * ensuring that only matching properties between the source and destination
 * objects are considered during the mapping process.
 * </p>
 * 
 * @see ModelMapper
 * @see MatchingStrategies
 */
@Configuration
public class ModelMapperConfig {

    /**
     * Creates and configures a ModelMapper bean.
     *
     * @return a configured instance of ModelMapper with STRICT matching strategy.
     */
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(
            MatchingStrategies.STRICT
        );
        return modelMapper;
    }
}
