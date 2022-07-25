package shagiev.homework2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shagiev.homework2.services.filter.FilterRequest;
import shagiev.homework2.services.filter.FilterRequestFactory;
import shagiev.homework2.services.filter.FilterRequestHandler;

@RestController
@RequiredArgsConstructor
public class FilterController {

    private final FilterRequestHandler filterRequestHandler;
    private final FilterRequestFactory filterRequestFactory;

    @GetMapping("/max-user")
    public String getMaxUser(@RequestParam(required = false) String status,
                             @RequestParam(required = false) String from,
                             @RequestParam(required = false) String until) {

        FilterRequest filterRequest = filterRequestFactory.create(status, from, until);
        String result = filterRequestHandler.handle(filterRequest);

        return "status: " + status + "<br>" +
                "from: " + from + "<br>" +
                "until: " + until + "<br>" +
                 result;
    }

}
