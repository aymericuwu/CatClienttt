package me.muffin.catclient.settings;

import java.util.ArrayList;
import java.util.function.Predicate;

import me.muffin.catclient.module.Module;

/**
 *  Made by HeroCode
 *  it's free to use
 *  but you have to credit him
 *
 *  @author HeroCode
 */
public abstract class Setting<T> {
	public String name;
	public Module mod;
	public Type type;

	protected Module parent;
	public boolean enabled;
	private String mode;
	private T value;
	
	private String sval;
	private ArrayList<String> options;
	
	private boolean bval;
	
	private double dval;
	private double min;
	private double max;
	private boolean onlyint = false;
	

	public Setting(String name, Module parent, String sval, ArrayList<String> options){
		this.name = name;
		this.parent = parent;
		this.sval = sval;
		this.options = options;
		this.mode = "Combo";
	}
	
	public Setting(String name, Module parent, boolean bval){
		this.name = name;
		this.parent = parent;
		this.bval = bval;
		this.mode = "Check";

	}
	
	public Setting(String name, Module parent, double dval, double min, double max, boolean onlyint){
		this.name = name;
		this.parent = parent;
		this.dval = dval;
		this.min = min;
		this.max = max;
		this.onlyint = onlyint;
		this.mode = "Slider";
	}

	public Setting(String name, boolean b, Module parent) {
	}

	public Setting(String name) {
	}

	public Setting(String name, String value, Module parent) {
	}

	public Setting(String name, Double value, Module parent, Predicate shown) {
	}

	public Setting(String name, Module parent) {
	}

	protected Setting() {
	}

	public String getName(){
		return name;
	}

	public Module getParent() {
		return parent;
	}
	
	public Module getParentMod(){
		return parent;
	}

	public String getValString(){
		return this.sval;
	}
	
	public void setValString(String in){
		this.sval = in;
	}
	
	public ArrayList<String> getOptions(){
		return this.options;
	}
	
	public boolean getValBoolean(){
		return this.bval;
	}
	
	public void setValBoolean(boolean in){
		this.bval = in;
	}
	
	public double getValDouble(){
		if(this.onlyint){
			this.dval = (int)dval;
		}
		return this.dval;
	}

	public void setValDouble(double in){
		this.dval = in;
	}
	
	public Double getMin(){
		return this.min;
	}
	
	public Double getMax(){
		return this.max;
	}
	
	public boolean isCombo(){
		return this.mode.equalsIgnoreCase("Combo") ? true : false;
	}
	
	public boolean isCheck(){
		return this.mode.equalsIgnoreCase("Check") ? true : false;
	}
	
	public boolean isSlider(){
		return this.mode.equalsIgnoreCase("Slider") ? true : false;
	}
	
	public boolean onlyInt(){
		return this.onlyint;
	}

	public abstract String getType();

	public void setEnabled() {
		this.enabled = enabled;
	}

    public T getValue() {
    	return value;
    }

    public enum Type {
		DOUBLE,
		PARENT,
		INTEGER,
		MODE;
	}
}
