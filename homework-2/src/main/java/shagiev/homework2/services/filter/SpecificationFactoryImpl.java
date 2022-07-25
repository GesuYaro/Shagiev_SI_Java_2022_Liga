package shagiev.homework2.services.filter;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.task.TaskStatus;
import shagiev.homework2.model.task.Task_;
import java.util.Date;

@Service
public class SpecificationFactoryImpl implements SpecificationFactory {

    @Override
    public Specification<Task> createSpecification(FilterRequest filterRequest) {
        Specification<Task> specification = (root, query, criteriaBuilder) -> criteriaBuilder.and();
        if (filterRequest.getStatus() != null) {
            specification = specification.and(filterByTaskStatus(filterRequest.getStatus()));
        }
        if (filterRequest.getFrom() != null) {
            specification = specification.and(filterByDateFrom(filterRequest.getFrom()));
        }
        if (filterRequest.getUntil() != null) {
            specification = specification.and(filterByDateUntil(filterRequest.getUntil()));
        }
        return specification;
    }

    private Specification<Task> filterByTaskStatus(TaskStatus status) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Task_.status), status);
    }

    private Specification<Task> filterByDateFrom(Date from) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(Task_.date), from);
    }

    private Specification<Task> filterByDateUntil(Date until) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(Task_.date), until);
    }

}
