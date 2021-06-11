package io.github.anemone.anima.exception;

public class FileAccessException extends Exception{
    public FileAccessException(){
        super("The file couldn't be opened, written onto or created");
    }
}
