import controller.Controller;
import model.Model;
import view.LastMinuteFrame;

public class Main {

	public static void main(String[] args) {
		LastMinuteFrame view = new LastMinuteFrame(true);
		Model model = new Model(view);
		Controller controller = new Controller(model);
		view.setController(controller);
	}

}
