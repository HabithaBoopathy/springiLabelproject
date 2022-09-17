// package com.indsys.SpringBootBackEnd.configurations;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.JavaMailSenderImpl;
// import org.thymeleaf.spring5.SpringTemplateEngine;
// import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
// import org.thymeleaf.templatemode.TemplateMode;

// import java.nio.charset.StandardCharsets;
// import java.util.Properties;

// @Configuration
// public class EmailThymeleafConfigurationGmail {


//     @Bean
//     public SpringTemplateEngine springTemplateEngine() {
//         SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//         templateEngine.addTemplateResolver(htmlTemplateResolver());
//         return templateEngine;
//     }

//     @Bean
//     public SpringResourceTemplateResolver htmlTemplateResolver(){
//         SpringResourceTemplateResolver emailTemplateResolver = new SpringResourceTemplateResolver();
//         emailTemplateResolver.setPrefix("classpath:/templates/");
//         emailTemplateResolver.setSuffix(".html");
//         emailTemplateResolver.setTemplateMode(TemplateMode.HTML);
//         emailTemplateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
//         return emailTemplateResolver;
//     }

//     @Bean
//     public JavaMailSender getJavaMailSender() {
//     JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//     mailSender.setHost("smtp.gmail.com");
//     mailSender.setPort(587);

//     // mailSender.setUsername("ilabeltesting");
//     // mailSender.setPassword("iLabel123");

//     mailSender.setUsername("ilabel@sainmarks.com");
//     mailSender.setPassword("S@1n#2021");

    
//     Properties props = mailSender.getJavaMailProperties();
//     props.put("mail.transport.protocol", "smtp");
//     props.put("mail.smtp.auth", "true");
//     props.put("mail.smtp.starttls.enable", "true");
//     props.put("mail.debug", "true");
    
//     return mailSender;
// }

// }

