package de.holisticon.spin.example.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import org.camunda.spin.impl.json.jackson.format.JacksonJsonDataFormat;
import org.camunda.spin.spi.DataFormatConfigurator;
import org.zalando.jackson.datatype.money.DefaultMonetaryAmountFormatFactory;
import org.zalando.jackson.datatype.money.MoneyModule;

/**
 * Created by stefanzilske on 05.05.17.
 */
public class JacksonDataFormatConfigurator implements DataFormatConfigurator<JacksonJsonDataFormat> {
    @Override
    public Class<JacksonJsonDataFormat> getDataFormatClass() {
        return JacksonJsonDataFormat.class;
    }

    @Override
    public void configure(JacksonJsonDataFormat jacksonJsonDataFormat) {
        ObjectMapper mapper = jacksonJsonDataFormat.getObjectMapper();
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        // register money module
        mapper.registerModule(new MoneyModule());
    }
}
