public abstract class Handler {
    private Handler nextHandler;

    public void handleMessage(Message message) {
        if (nextHandler != null) {
            nextHandler.handleMessage(message);
        }
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

