package view.prep;

import javax.swing.*;
import java.awt.*;

public class LecturePrepView extends JPanel {

    public LecturePrepView() {
        setup();
    }

    public void setup() {
        // create the tools

        setPreferredSize(new Dimension(250, 400));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Lecture Prep"),
                BorderFactory.createEmptyBorder(5,5,5,5)));
    }

}
