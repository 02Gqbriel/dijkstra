package ch.gabriel_egli.window;

public class MainFrameController {
    private MainFrameModel model;
    private MainFrameView view;

    public MainFrameController(MainFrameModel model, MainFrameView view) {
        this.model = model;
        this.view = view;

        view.setSize(model.getSize());
        view.setTitle(model.getTitle());
    }
}
