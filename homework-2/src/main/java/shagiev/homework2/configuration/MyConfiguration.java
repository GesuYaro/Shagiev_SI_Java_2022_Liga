package shagiev.homework2.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

@Configuration
public class MyConfiguration {

    @Bean
    public ByteArrayOutputStream getByteArrayOutputStream() {
        return new ByteArrayOutputStream();
    }

    @Bean
    public Writer getWriter(@Autowired ByteArrayOutputStream byteArrayOutputStream) {
        return new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream));
    }

}
