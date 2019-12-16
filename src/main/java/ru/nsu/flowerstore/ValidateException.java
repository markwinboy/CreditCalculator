package ru.nsu.flowerstore;

public class ValidateException extends Exception{
    public ValidateException(){
        super("Данные группы уже загружены");
    }

}