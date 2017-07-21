package de.holisticon.spin.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.research.ws.wadl.HTTPMethods;
import de.holisticon.spin.example.domain.AnotherDomainObject;
import de.holisticon.spin.example.domain.OneDomainObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jersey.repackaged.com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.runtime.VariableInstance;
import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zalando.jackson.datatype.money.MoneyModule;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;

/**
 * Created by stefanzilske on 28.04.17.
 */
@RestController
@Slf4j
public class DoSomethingController {

    @Autowired
    private RuntimeService runtimeService;

    @CrossOrigin
    @ApiOperation(value = "Deserializes DomainObjects from Camunda with spin", httpMethod = "GET")
    @RequestMapping("/doSomething")
    public String doSomething(@RequestParam(value = "businessKey") String businessKey) throws IOException {

        Optional<ProcessInstance> processInstance = runtimeService.createProcessInstanceQuery().processDefinitionKey("simple_process").processInstanceBusinessKey(businessKey).list().stream().findFirst();

        String returnValue = null;

        if(processInstance.isPresent()) {
            Optional<VariableInstance> myAwesomeDomainObject = runtimeService.createVariableInstanceQuery().processInstanceIdIn(processInstance.get().getProcessInstanceId()).variableName("myAwesomeDomainObjects").list().stream().findFirst();

            if(myAwesomeDomainObject.isPresent()) {
                Set<OneDomainObject> value = (Set<OneDomainObject>) myAwesomeDomainObject.get().getValue();

                if (value != null) {
                    returnValue = value.toString();
                } else {
                    returnValue = myAwesomeDomainObject.get().getErrorMessage();
                }
            }
        }

        return returnValue;
    }

}
