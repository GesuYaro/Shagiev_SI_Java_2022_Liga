package shagiev.homework2.services.filter;

import org.springframework.data.jpa.domain.Specification;
import shagiev.homework2.model.task.Task;

public interface SpecificationFactory {

    Specification<Task> createSpecification(FilterRequest filterRequest);

}
