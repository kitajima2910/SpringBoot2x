package com.hoaipx.learn2021.common;

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

}
