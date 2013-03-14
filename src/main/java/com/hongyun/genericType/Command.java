package com.hongyun.genericType;


public interface Command <T> {

    T execute(CommandContext commandContext);
    
  }
