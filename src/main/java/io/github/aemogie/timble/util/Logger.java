package io.github.aemogie.timble.util;

import static java.lang.System.exit;

public class Logger {
	static{try{if(System.getProperty("os.name").startsWith("Windows"))Runtime.getRuntime().exec("reg add HKCU\\Console /v VirtualTerminalLevel /t REG_DWORD /d 1");}catch(Exception ignored){}}
	
	public static void logFatalError(String error) {printToConsole(31, "FATAL", error); exit(-1);}
	public static void logFatalError(Object error) {logFatalError(String.valueOf(error));}
	
	public static void logInfo(String info) {printToConsole(32, "INFO", info);}
	public static void logInfo(Object info) {logInfo(String.valueOf(info));}
	
	public static void logDebug(String log) {printToConsole(36, "DEBUG", log);}
	public static void logDebug(Object log) {logDebug(String.valueOf(log));}
	
	private static void printToConsole(int color, String type, String msg) {
		String clazz = Thread.currentThread().getStackTrace()[3].getClassName();
		if (msg.contains("\n")) msg = "\n" + msg;
		System.out.println("\u001b[" + color + "m[" + type +"] [" + clazz + "] " + msg + "\u001b[0m");
	}
}