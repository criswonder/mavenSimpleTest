package com.hongyun.genericType;

public class CommandA<K,T> implements Command<T> {

    @Override
    public T execute(CommandContext commandContext) {
        System.out.println("it's in CommandA");
        Object obj = new Object();
        
        return (T) obj;
    }

}
