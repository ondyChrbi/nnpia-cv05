package cz.upce.fe.cv02.graphql;

import cz.upce.fe.cv02.dto.AppUserResponseDtoV1;
import cz.upce.fe.cv02.dto.TaskResponseDtoV1;
import cz.upce.fe.cv02.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class TaskQLController {
    private final TaskService taskService;

    @SchemaMapping(typeName = "AppUser")
    public List<TaskResponseDtoV1> tasks(AppUserResponseDtoV1 appUser) {
        return taskService.findAllByAuthorId(appUser.getId())
                .stream()
                .map(t -> t.toDto())
                .collect(Collectors.toList());
    }
}
