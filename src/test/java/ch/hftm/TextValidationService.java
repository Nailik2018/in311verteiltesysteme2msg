package ch.hftm;

import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import io.smallrye.reactive.messaging.annotations.Blocking;

@ApplicationScoped
public class TextValidationService {

    @Inject
    @Channel("text-validator-request")
    Emitter<Blog> blogEmitter;

    @Incoming("text-validator-request")
    @Outgoing("text-validator-response")
    @Blocking
    public Multi<Blog> validateText(Blog blog) {
        boolean containsHFTM = blog.getContent().toLowerCase().contains("hftm");
        blog.setIsValid(!containsHFTM);
        blogEmitter.send(blog);
        return Multi.createFrom().item(blog);
    }
}