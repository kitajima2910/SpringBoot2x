package com.hoaipx.learn2021.common;

import org.springframework.beans.factory.annotation.Value;

import javax.swing.*;
import java.util.UUID;

public interface Constant {

    /**
     * Executions
     */
    String EXECUTIONS = "execution(* com.hoaipx.learn2021.*.*.*(..))";

    /**
     * Status normal
     */
    Integer STATUS_NORMAL = 0;

    /**
     * Matchers auth
     */
    String MATCHERS_AUTH = "/api/auth/**";

    /**
     * Matchers urs
     */
    String[] MATCHERS_URL = {
            "/api/**"
    };

    /**
     * Add
     */
    String ADD_SUCCESSFULLY = "Added successfully.";

    /**
     * Save
     */
    String SAVE_SUCCESSFULLY = "Save successfully.";

    /**
     * Edit
     */
    String EDIT_SUCCESSFULLY = "Edit successfully.";

    /**
     * Delete
     */
    String DEL_SUCCESSFULLY = "Delete successfully.";

    /**
     * Secret key
     */
    // String SECRET_KEY = UUID.randomUUID().toString();
    String SECRET_KEY = "PHAM XUAN HOAI";

    /**
     * Times 10 days
     */
    long TIMES = 864_000_000;

    /**
     * Url sign in
     */
    String URL_SIGN_IN = "/api/auth/signIn";

}
