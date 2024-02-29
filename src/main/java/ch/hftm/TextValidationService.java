package ch.hftm;

import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

@ApplicationScoped
public class TextValidationService {

    @Incoming("text-validator-request")
    @Outgoing("text-validator-response")
//    @Blocking
    public Multi<TextValidatorResponseDto> validateText(Multi<TextValidatorResponseDto> textValidatorResponseDto) {
        return textValidatorResponseDto.onItem().transform(item -> {
            item.setValid(item.getText().toLowerCase().contains("bangladesch"));
            System.out.println(item);
            System.out.println(item.getText());
            System.out.println(item.getValid());
            return item;
        });
    }
}