package com.hongyun.genericType;

public class TestRunner {

    /**
     * @param args
     */
    public static void main(String[] args) {
        CommandContext context = new CommandContext();
        CommandA<String,Integer> ca = new CommandA<String,Integer>();
        Object obj = ca.execute(context);
        
        CommandB cb = new CommandB();
        context.command = ca;
        
        try {
            context.giveMeWhatIGiveYou(String.class);
            context.command = cb;
            context.giveMeWhatIGiveYou(CommandContext.class);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
