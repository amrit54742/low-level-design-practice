package lld.decoratorpattern.decorator;


import lld.decoratorpattern.component.CharacterInterface;

public class HeightUp extends CharacterDecorator {

    public HeightUp(CharacterInterface c) {
        super(c);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + " with HeightUp";
    }
}