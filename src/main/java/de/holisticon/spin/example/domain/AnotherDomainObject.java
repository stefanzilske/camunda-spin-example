package de.holisticon.spin.example.domain;

import lombok.*;

/**
 * Created by stefanzilske on 28.04.17.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class AnotherDomainObject {

    private Long id;

    private String name;

    private OneDomainObject parent;

}
