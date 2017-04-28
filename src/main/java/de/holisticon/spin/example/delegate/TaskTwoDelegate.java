package de.holisticon.spin.example.delegate;

import de.holisticon.spin.example.domain.OneDomainObject;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

/**
 * Created by stefanzilske on 28.04.17.
 */
@Service
@Slf4j
public class TaskTwoDelegate implements JavaDelegate {

    public void execute(DelegateExecution delegateExecution) throws Exception {

        OneDomainObject oneDomainObject = (OneDomainObject) delegateExecution.getVariable("myAwesomeDomainObject");
    }
}
