package shagiev.homework2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shagiev.homework2.services.console.CommandHandler;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final CommandHandler commandHandler;

    @GetMapping("/cli")
    public String executeCommand(@RequestParam String command) {
        return commandHandler.handleCommand(command).replace("\n", "<br>");
    }

}
