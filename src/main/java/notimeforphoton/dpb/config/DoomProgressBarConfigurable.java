package notimeforphoton.dpb.config;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class DoomProgressBarConfigurable implements Configurable {

  private DoomProgressBarSettingsComponent mySettingsComponent;

  // A default constructor with no arguments is required because this implementation
  // is registered as an applicationConfigurable EP

  @Nls(capitalization = Nls.Capitalization.Title)
  @Override
  public String getDisplayName() {
    return "Doom Progress Bar";
  }

  @Override
  public JComponent getPreferredFocusedComponent() {
    return mySettingsComponent.getPreferredFocusedComponent();
  }

  @Nullable
  @Override
  public JComponent createComponent() {
    mySettingsComponent = new DoomProgressBarSettingsComponent();
    return mySettingsComponent.getPanel();
  }

  @Override
  public boolean isModified() {
    DoomProgressBarSettingsState settings = DoomProgressBarSettingsState.getInstance();
    boolean modified = !mySettingsComponent.getChosenCharacter().equals(settings.selectedCharacter);
    modified |= mySettingsComponent.getChosenCharacter() != settings.selectedCharacter;
    return modified;
  }

  @Override
  public void apply() {
    DoomProgressBarSettingsState settings = DoomProgressBarSettingsState.getInstance();
    settings.selectedCharacter = mySettingsComponent.getChosenCharacter();
  }

  @Override
  public void reset() {
    DoomProgressBarSettingsState settings = DoomProgressBarSettingsState.getInstance();
    mySettingsComponent.setChosenCharacter(settings.selectedCharacter);
  }

  @Override
  public void disposeUIResources() {
    mySettingsComponent = null;
  }

}