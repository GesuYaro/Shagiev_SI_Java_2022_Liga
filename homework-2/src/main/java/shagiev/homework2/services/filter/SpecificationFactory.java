package shagiev.homework2.services.filter;

import org.springframework.data.jpa.domain.Specification;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.user.User;

public interface SpecificationFactory {

    Specification<User> createSpecification(FilterRequest filterRequest);

}
