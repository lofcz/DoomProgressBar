package lofcz.tbp.config;// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBRadioButton;
import com.intellij.util.ui.FormBuilder;
import com.intellij.util.ui.UIUtil;

import lofcz.tbp.MBCharacter;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class TerryProgressBarSettingsComponent {

    private final JPanel configMainPanel;

    private final List<JBRadioButton> charactersRadioButtons = new ArrayList<>();

    public TerryProgressBarSettingsComponent() {
        JBLabel title = new JBLabel("Choose your character :", UIUtil.ComponentStyle.REGULAR);
        ButtonGroup characterSelectGroup = new ButtonGroup();
        FormBuilder formBuilder = FormBuilder.createFormBuilder().addComponent(title);
        for (MBCharacter character : MBCharacter.values()) {
            JBRadioButton radioButton = new JBRadioButton(character.getDisplayName());
            characterSelectGroup.add(radioButton);
            charactersRadioButtons.add(radioButton);
            formBuilder.addLabeledComponent(new JLabel(character.getIcon()), radioButton);
        }
        configMainPanel = formBuilder.addComponentFillVertically(new JPanel(), 0).getPanel();
    }

    public JComponent getPreferredFocusedComponent() {
        try {
            return charactersRadioButtons.get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public JPanel getPanel() {
        return configMainPanel;
    }

    @NotNull
    public MBCharacter getChosenCharacter() {
        return charactersRadioButtons.stream()
                .filter(AbstractButton::isSelected).findFirst()
                .map(radioButton -> MBCharacter.valueOf(radioButton.getText().toUpperCase()))
                .orElse(MBCharacter.TERRY);
    }

    public void setChosenCharacter(@NotNull MBCharacter newBros) {
        for (JBRadioButton charactersRadioButton : charactersRadioButtons) {
            charactersRadioButton.setSelected(newBros.name().equals(charactersRadioButton.getText().toUpperCase()));
        }
    }

}