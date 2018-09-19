package com.ideas2it.hospitalmanagement.exception;

/**
 * ApplicationException is a custom user-defined Exception class.
 * It can be used to handle multiple exceptions at the same time and avoid
 * application being terminated. Provides Multiple constructors to throw
 * exceptions along with errorCode and customized error messages.
 *
 * @author Rahul Ravi
 * @version 1.0
 */
public class ApplicationException extends Throwable {

    private int errorCode;
    private String message;

    public ApplicationException(final int errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public ApplicationException(final Throwable cause) {
        super(cause);
    }

    public ApplicationException(final String message, final Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public ApplicationException(final String message, final int errorCode, final Throwable cause) {
        super(message, cause);
        this.message = message;
        this.errorCode = errorCode;
    }

    public ApplicationException(final String message) {
        super(message);
    }

    public ApplicationException(final Throwable cause, final int errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public int geterrorCode() {
        return this.errorCode;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
