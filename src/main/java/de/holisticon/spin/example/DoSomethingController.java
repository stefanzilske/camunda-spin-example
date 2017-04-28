package de.holisticon.spin.example;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.runtime.VariableInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by stefanzilske on 28.04.17.
 */
@RestController
public class DoSomethingController {

    @Autowired
    private RuntimeService runtimeService;

    @CrossOrigin
    @RequestMapping("/doSomething")
    public String doSomething(@RequestParam(value = "businessKey") String businessKey) {


        Optional<ProcessInstance> processInstance = runtimeService.createProcessInstanceQuery().processDefinitionKey("simple_process").processInstanceBusinessKey(businessKey).list().stream().findFirst();

        if(processInstance.isPresent()) {
            Optional<VariableInstance> myAwesomeDomainObject = runtimeService.createVariableInstanceQuery().processInstanceIdIn(processInstance.get().getProcessInstanceId()).variableName("myAwesomeDomainObject").list().stream().findFirst();
        }

        return "awesome";
    }

}
