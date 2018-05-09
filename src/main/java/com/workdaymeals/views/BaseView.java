package com.workdaymeals.views;

import io.dropwizard.views.View;

import javax.annotation.Nullable;
import java.nio.charset.Charset;

public abstract class BaseView extends View {
    protected BaseView(String templateName) {
        super(templateName);
    }

    protected BaseView(String templateName, @Nullable Charset charset) {
        super(templateName, charset);
    }
}
