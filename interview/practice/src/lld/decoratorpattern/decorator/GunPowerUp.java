package lld.decoratorpattern.decorator;

import lld.decoratorpattern.component.CharacterInterface;

public class GunPowerUp extends CharacterDecorator {

    public GunPowerUp(CharacterInterface c) {
        super(c);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + " with Gun";
    }
}