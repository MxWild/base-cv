package com.gmail.basecv.model;

import lombok.Getter;

@Getter
public enum ContactType {

    PHONE("Тел."),
    MOBILE_PHONE("Мобильный тел."),
    HOME_PHONE("Домашний тел."),
    SKYPE("Skype"),
    EMAIL("email"),
    LINKEDIN("Профиль LinkedIn"),
    GITHUB("Профиль GitHub"),
    STACKOVERFLOW("Профиль StackoverFlow"),
    HOME_AGE("Домашняя страница");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }
}
