package com.NetlabUT;

/** interface for {@link UnitTest} to run a method that also handles a throwable
 * @author Ramadhan Kalih Sewu
 * @version 1.0
 */
@FunctionalInterface
public interface Executable { Object execute() throws Throwable; }