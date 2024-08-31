package com.joey.DSHC.model.enums;

public enum SubjectEnum {
    EBOOK("E-Book", 0),
    RELATO("Relato", 1);

    private final String name;
    private final int value;

    SubjectEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public static SubjectEnum fromValue(int value) {
        for (SubjectEnum subject : SubjectEnum.values()) {
            if (subject.getValue() == value) {
                return subject;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}
