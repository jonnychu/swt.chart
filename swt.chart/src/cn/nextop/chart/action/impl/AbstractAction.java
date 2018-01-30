package cn.nextop.chart.action.impl;

import cn.nextop.chart.action.IAction;

public abstract class AbstractAction implements IAction {
	//
	protected final Type type;
	
	/**
	 * 
	 */
	public AbstractAction(Type type) {
		this.type = type;
	}
	
	@Override
	public Type getType() {
		return this.type;
	}
}
