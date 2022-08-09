package hn.com.tigo.josm.common.broker.compiler.task;

import hn.com.tigo.josm.common.exceptions.AdapterException;

import java.util.List;

import javax.script.ScriptEngine;

public interface Executable {

	List<AbstractElement> execute(ScriptEngine engine) throws AdapterException;
}
