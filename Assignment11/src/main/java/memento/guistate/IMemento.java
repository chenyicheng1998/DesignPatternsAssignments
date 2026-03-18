package memento.guistate;

import java.time.LocalDateTime;

public interface IMemento {
    // Metadata methods
    LocalDateTime getTimestamp();
    String getDescription();
}

