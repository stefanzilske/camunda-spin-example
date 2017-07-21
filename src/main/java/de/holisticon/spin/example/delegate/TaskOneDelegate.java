package de.holisticon.spin.example.delegate;

import de.holisticon.spin.example.domain.AnotherDomainObject;
import de.holisticon.spin.example.domain.OneDomainObject;
import jersey.repackaged.com.google.common.collect.Sets;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.javamoney.moneta.Money;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by stefanzilske on 28.04.17.
 */
@Service
public class TaskOneDelegate implements JavaDelegate {

    public void execute(DelegateExecution delegateExecution) throws Exception {

        OneDomainObject oneDomainObject = OneDomainObject.builder().id(1L).name("first object").children(
                Sets.newHashSet(AnotherDomainObject.builder().id(2L).name("first child").cost(Money.of(200.50, "EUR")).build(), AnotherDomainObject.builder().id(3L).name("second child").cost(Money.of(19.99, "EUR")).build())
        ).build();

        OneDomainObject anotherDomainObject = OneDomainObject.builder().id(4L).name("secong object").children(
                Sets.newHashSet(AnotherDomainObject.builder().id(5L).name("first child").cost(Money.of(19.99, "EUR")).build(), AnotherDomainObject.builder().id(6L).name("second child").cost(Money.of(100, "EUR")).build())
        ).build();

//        OneDomainObject oneDomainObject = OneDomainObject.builder().id(1L).name("first object").children(
//                Sets.newHashSet(AnotherDomainObject.builder().id(2L).name("first child").build(), AnotherDomainObject.builder().id(3L).name("second child").build())
//        ).build();
//
//        OneDomainObject anotherDomainObject = OneDomainObject.builder().id(4L).name("second object").children(
//                Sets.newHashSet(AnotherDomainObject.builder().id(5L).name("first child").build(), AnotherDomainObject.builder().id(6L).name("second child").build())
//        ).build();

        Set<OneDomainObject> objects = Sets.newHashSet(oneDomainObject, anotherDomainObject);

        delegateExecution.setVariable("myAwesomeDomainObjects", objects);
    }
}
