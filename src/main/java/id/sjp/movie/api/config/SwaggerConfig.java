package id.sjp.movie.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.*;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    protected static final Set<String> ALLOWED_PROTOCOLS = new HashSet<>(new ArrayList<>(Arrays.asList("http", "https")));

    @Value("${swagger.vendor.name}")
    private String swaggerVendorName;

    @Value("${swagger.vendor.value}")
    private String swaggerVendorValue;

    @Value("${swagger.metadata.title}")
    private String metadataTitle;

    @Value("${swagger.metadata.description}")
    private String metadataDescription;

    @Value("${swagger.metadata.version}")
    private String metadataVersion;

    @Value("${swagger.metadata.tos}")
    private String metadataTos;

    @Value("${swagger.metadata.contact.name}")
    private String contactName;

    @Value("${swagger.metadata.contact.url}")
    private String contactUrl;

    @Value("${swagger.metadata.contact.email}")
    private String contactEmail;

    @Value("${swagger.metadata.license}")
    private String metadataLicence;

    @Value("${swagger.metadata.license-url}")
    private String metadataLicenceUrl;


    protected Docket defaultDocketConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .produces(Collections.singleton(MediaType.APPLICATION_JSON_VALUE))
                .consumes(Collections.singleton(MediaType.APPLICATION_JSON_VALUE))
                .groupName("/v1/sjp-movie-api")
                .select()
                .apis(RequestHandlerSelectors.any())
                .build().directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .apiInfo(apiInfo())
                .protocols(ALLOWED_PROTOCOLS);
    }

    @Bean
    public Docket defaultDocket() {
        return defaultDocketConfig()
                .groupName("DEFAULT")
                .select()
                .paths(PathSelectors.regex("/v1.*"))
                .build();
    }

    protected ApiInfo apiInfo() {
        List<VendorExtension> vendorExtensions = new ArrayList<>();
        vendorExtensions.add(new AppVendorExtension());
        return new ApiInfo(
                metadataTitle,
                metadataDescription,
                metadataVersion,
                metadataTos,
                new Contact(contactName, contactUrl, contactEmail),
                metadataLicence,
                metadataLicenceUrl,
                vendorExtensions);
    }

    @Bean
    public SecurityConfiguration security() {
        return SecurityConfigurationBuilder
                .builder()
                .scopeSeparator(",")
                .additionalQueryStringParams(null)
                .useBasicAuthenticationWithAccessCodeGrant(false)
                .build();
    }

    private class AppVendorExtension implements VendorExtension<String> {

        @Override
        public String getName() {
            return swaggerVendorName;
        }

        @Override
        public String getValue() {
            return swaggerVendorValue;
        }

    }
}
