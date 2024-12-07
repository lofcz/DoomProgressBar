package lofcz.tbp;

import javax.swing.*;

public enum MBCharacter {
    TERRY(Icons.TERRY);

    private final Icon icon;

    MBCharacter(Icon icon) {
        this.icon = icon;
    }

    public String getDisplayName() {
        return "TERRY";
    }
    public Icon getIcon() {
        return icon;
    }

}