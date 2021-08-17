package me.muffin.catclient.settings;

import me.muffin.catclient.module.Module;

public class NumberSetting extends Setting {

    public double value;
    public double minimum;
    public double maximum;
    public double increment;

    public NumberSetting(String name, Module parent, double value, double minimum, double maximum, double increment) {
        super(name);
        this.parent = parent;
        this.value = value;
        this.minimum = minimum;
        this.maximum = maximum;
        this.increment = increment;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        double precision = 1.0D / this.increment;
        this.value = Math.round(Math.max(this.minimum, Math.min(this.maximum, value))) * precision;
    }

    public void increment(boolean positive) {
        setValue(getValue() + (positive?1:-1) * increment);
    }

    public double getMinimum() {
        return this.minimum;
    }

    public void setMinimum() {
        this.minimum = minimum;
    }

    public double getMaximum() {
        return this.maximum;
    }

    public void setMaximum() {
        this.maximum = maximum;
    }

    public double getIncrement() {
        return this.increment;
    }

    public void setIncrement() {
        this.increment = increment;
    }

    @Override
    public String getType() {
        return null;
    }
}

