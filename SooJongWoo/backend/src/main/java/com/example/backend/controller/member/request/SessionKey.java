package com.example.backend.controller.member.request;

public enum SessionKey {
    SESSION_USER(SessionUser.class);

    private Class<?> clazz;

    public Class<?> getClazz() {
        return clazz;
    }

    SessionKey(Class clazz) {
        this.clazz = clazz;

    }
}
