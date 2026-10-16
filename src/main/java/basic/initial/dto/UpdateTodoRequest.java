package basic.initial.dto;

public record UpdateTodoRequest(
        String title,
        Boolean completed
) {
}
