package newssite.entity.enums;

public enum Permission {

    ADD_USER,  //ADMIN
    EDIT_USER,  //ADMIN
    DELETE_USER,  //ADMIN
    VIEW_USER,  //ADMIN
    ADD_LAVOZIM,  //ADMIN
    EDIT_LAVOZIM,  //ADMIN
    DELETE_LAVOZIM,  //ADMIN
    VIEW_LAVOZIM,  //ADMIN
    ADD_POST,  //ADMIN . . .
    EDIT_POST,  //ADMIN . .
    DELETE_POST,  //ADMIN . .
    ADD_COMMENT,  // ALL
    EDIT_COMMENT,   //ALL
    DELETE_MY_COMMENT, // ALL
    DELETE_COMMENT, // ADMIN, ...
}
