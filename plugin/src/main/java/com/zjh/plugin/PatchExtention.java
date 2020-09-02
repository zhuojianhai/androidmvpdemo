package com.zjh.plugin;

public class PatchExtention {
    boolean debugOn;
    String output;
    String applicationName;

    public boolean isDebugOn() {
        return debugOn;
    }

    public void setDebugOn(boolean debugOn) {
        this.debugOn = debugOn;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    @Override
    public String toString() {
        return "PatchExtention{" +
                "debugOn=" + debugOn +
                ", output='" + output + '\'' +
                ", applicationName='" + applicationName + '\'' +
                '}';
    }
}
