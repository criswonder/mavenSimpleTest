package com.hongyun.genericType;

public class CommandB implements Command<Integer> {

    @Override
    public Integer execute(CommandContext commandContext) {
        System.out.println("it's in CommandB");
        return 100;
    }

}
