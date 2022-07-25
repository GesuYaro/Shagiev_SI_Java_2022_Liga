package shagiev.homework2.services.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import shagiev.homework2.model.task.Task;
import shagiev.homework2.repos.TaskRepo;
import shagiev.homework2.repos.UserRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FilterRequestHandlerImpl implements FilterRequestHandler {

    private final UserRepo userRepo;
    private final TaskRepo taskRepo;
    private final SpecificationFactory specificationFactory;

    @Override
    public String handle(FilterRequest request) {
        Specification<Task> specification = specificationFactory.createSpecification(request);
        List<Task> tasks = taskRepo.findAll(specification);
        Map<Integer, Integer> count = new HashMap<>();
        for (Task task: tasks) {
            int userId = task.getUser().getId();
            if (!count.containsKey(task.getUser().getId())) {
                count.put(userId, 0);
            }
            count.put(userId, count.get(userId) + 1);
        }
        var optional = count.entrySet().stream()
                .max((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()));
        int biggest = -1;
        if (optional.isPresent()) {
            biggest = optional.get().getKey();
        }
        var optionalUser = userRepo.findById(biggest);
        if (optionalUser.isPresent()) {
            return optionalUser.get().toString();
        } else {
            return "can't found user";
        }
    }

}
