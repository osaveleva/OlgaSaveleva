package com.example;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import enums.Credentials;
import enums.LeftMenuItems;
import enums.NatureElementsCheckBox;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.cucumberexpressions.Transformer;
import sun.security.krb5.internal.ccache.CCacheInputStream;

import java.util.Locale;

import static enums.Credentials.PETER_CHAILOVSKII;
import static java.util.Locale.ENGLISH;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer  {
    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {

        typeRegistry.defineParameterType(new ParameterType<>(
                "peter",
                "\"([^\"]*)\"",
                Credentials.class,
                (Transformer<Credentials>) s -> Credentials.PETER_CHAILOVSKII
        ));

        typeRegistry.defineParameterType(new ParameterType<>(
                "menu",
                "\"([^\"]*)\"",
                LeftMenuItems.class,
                (Transformer<LeftMenuItems>) s -> {
                    System.out.println(LeftMenuItems.valueOf(s));
                    return LeftMenuItems.valueOf(s);
                }
        ));

        typeRegistry.defineParameterType(new ParameterType<>(
                "element",
                "\"([^\"]*)\"",
                NatureElementsCheckBox.class,
                (Transformer<NatureElementsCheckBox>) s -> {
                    System.out.println(LeftMenuItems.valueOf(s));
                    return NatureElementsCheckBox.valueOf(s);
                }
        ));
    }

    @Override
    public Locale locale() {
        return ENGLISH;
    }
}