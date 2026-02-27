package lld.decoratorpattern.decorator;


import lld.decoratorpattern.component.CharacterInterface;

public class StarPowerUp extends CharacterDecorator {

    public StarPowerUp(CharacterInterface c) {
        super(c);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + " with Star Power (Limited Time)";
    }
}