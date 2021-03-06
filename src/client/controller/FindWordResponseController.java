package client.controller;

import client.view.Application;
import client.model.Model;
import xml.Message;
/**
 * responsible to handle the findWord response from server
 *
 *@author Zijun Xu
 */
public class FindWordResponseController extends ControllerChain{

    public Application app;
    public Model model;

    public FindWordResponseController(Application a, Model m) {
        super();
        this.app = a;
        this.model = m;
    }

    /** after getting response from server, let those selected cells repaint */
    public boolean process(Message response){
        String type = response.contents.getFirstChild().getLocalName();
        if (!type.equals("findWordResponse")) {
            return next.process(response);
        }
        if (response.contents.getAttributes().getNamedItem("success").getNodeValue().equals("false")){
            model.getWord().resetWord();
            PaintCellController paint = new PaintCellController(model);
            paint.repaint();
            return false;
        }

        PaintCellController paint = new PaintCellController(model);
        paint.repaint();
        return true;
    }
}
