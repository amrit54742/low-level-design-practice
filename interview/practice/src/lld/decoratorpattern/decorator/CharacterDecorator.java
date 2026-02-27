package lld.decoratorpattern.decorator;

import lld.decoratorpattern.component.CharacterInterface;

public abstract class CharacterDecorator implements CharacterInterface {

    protected CharacterInterface character;

    public CharacterDecorator(CharacterInterface c) {
        this.character = c;
    }
}