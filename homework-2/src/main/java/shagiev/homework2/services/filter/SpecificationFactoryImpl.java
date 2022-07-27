package shagiev.homework2.services.filter;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.model.task.TaskStatus;
import shagiev.homework2.model.task.Task_;
import shagiev.homework2.model.user.User;
import shagiev.homework2.model.user.User_;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecificationFactoryImpl implements SpecificationFactory {

    private final SessionFactory sessionFactory;

    @Override
    public Specification<User> createSpecification(FilterRequest filterRequest) {
        return (root, query, criteriaBuilder) -> {
            Session session = sessionFactory.openSession();
            CriteriaQuery<Tuple> taskQuery = criteriaBuilder.createTupleQuery();
            Root<Task> taskRoot = taskQuery.from(Task.class);
            Predicate[] predicates = getPredicates(filterRequest, taskRoot, criteriaBuilder);
            taskQuery.multiselect(taskRoot.get(Task_.user).get(User_.id), criteriaBuilder.count(taskRoot))
                    .where(predicates)
                    .groupBy(taskRoot.get(Task_.user).get(User_.id))
                    .orderBy(criteriaBuilder.desc(criteriaBuilder.count(taskRoot)));
            List<Tuple> tupleList = session.createQuery(taskQuery).setMaxResults(1).getResultList();

            if (!tupleList.isEmpty()) {
                Tuple result = tupleList.get(0);
                int userId = result.get(taskRoot.get(Task_.user).get(User_.id));
                return criteriaBuilder.equal(root.get(User_.id), userId);
            } else {
                return criteriaBuilder.and();
            }
        };
    }

    private Predicate[] getPredicates(FilterRequest filterRequest, Root<Task> root, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (filterRequest.getStatus() != null) {
            predicates.add(filterByTaskStatus(filterRequest.getStatus(), root, criteriaBuilder));
        }
        if (filterRequest.getFrom() != null) {
            predicates.add(filterByDateFrom(filterRequest.getFrom(), root, criteriaBuilder));
        }
        if (filterRequest.getUntil() != null) {
            predicates.add(filterByDateUntil(filterRequest.getUntil(), root, criteriaBuilder));
        }
        return predicates.toArray(Predicate[]::new);
    }

    private Predicate filterByTaskStatus(TaskStatus status, Root<Task> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get(Task_.status), status);
    }

    private Predicate filterByDateFrom(Date from, Root<Task> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.greaterThanOrEqualTo(root.get(Task_.date), from);
    }

    private Predicate filterByDateUntil(Date until, Root<Task> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.lessThanOrEqualTo(root.get(Task_.date), until);
    }

}
