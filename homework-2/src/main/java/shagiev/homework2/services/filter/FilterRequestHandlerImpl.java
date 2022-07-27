package shagiev.homework2.services.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import shagiev.homework2.model.user.User;
import shagiev.homework2.repos.UserRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterRequestHandlerImpl implements FilterRequestHandler {

    private final UserRepo userRepo;
    private final SpecificationFactory specificationFactory;

    @Override
    public String handle(FilterRequest request) {
        Specification<User> specification = specificationFactory.createSpecification(request);
        List<User> users = userRepo.findAll(specification);
        if (!users.isEmpty()) {
            return users.get(0).toString();
        } else {
            return "user not found";
        }
    }

}
