package org.example.exception;

public class ExpiredProductException extends Exception {
    public ExpiredProductException(String message) { super(message); }
}