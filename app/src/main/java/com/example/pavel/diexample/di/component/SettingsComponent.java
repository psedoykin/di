package com.example.pavel.diexample.di.component;


import com.example.pavel.diexample.di.model.SettingsModel;
import com.example.pavel.diexample.di.scope.SettingsScope;
import com.example.pavel.diexample.ui.settings.SettingsFragment;

import dagger.Component;


@Component(dependencies = AppComponent.class, modules = {SettingsModel.class})
@SettingsScope
public interface SettingsComponent {

    void inject(SettingsFragment fragment);

}
