package org.cheercode.new_version.factories;

public abstract class AbstractBetFactory implements BetFactory {
    public boolean isValid(String key) {
        try {
            get(key);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
