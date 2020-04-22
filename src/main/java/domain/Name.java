package domain;

public class Name implements Cloneable {
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String CAR_NAME_LENGTH_LIMIT_NOTICE = "자동차 이름은 최소 1 ~ 5글자까지 가능합니다.";
    private static final String CONTAIN_GAP_CHAR_NOTICE = "공백문자는 포함할 수 없습니다.";

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateNameLength(name);
        validateNameContainGapChar(name);
    }

    private void validateNameLength(String name) {
        int length = name.length();
        if (length > MAX_CAR_NAME_LENGTH || length < MIN_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_LIMIT_NOTICE);
        }
    }

    private void validateNameContainGapChar(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException(CONTAIN_GAP_CHAR_NOTICE);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    protected Name clone() throws CloneNotSupportedException {
        return (Name) super.clone();
    }
}
