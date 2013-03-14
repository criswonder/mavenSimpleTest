package com.hongyun.genericType;

public class CommandContext {
    Command<?> command;
    
    public <T> T giveMeWhatIGiveYou(Class<T> clz) throws InstantiationException, IllegalAccessException{
        Object obj=clz.newInstance();
        if(command!=null)
            System.out.println(command.getClass().getSimpleName());
        return (T) obj;
    }
}
