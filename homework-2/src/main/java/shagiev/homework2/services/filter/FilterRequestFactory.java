package shagiev.homework2.services.filter;

import shagiev.homework2.model.task.TaskStatus;

public interface FilterRequestFactory {

    FilterRequest create(String taskStatus, String from, String until);

}
