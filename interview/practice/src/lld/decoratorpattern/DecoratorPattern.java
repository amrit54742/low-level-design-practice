package lld.decoratorpattern;

import lld.decoratorpattern.component.CharacterInterface;
import lld.decoratorpattern.component.Mario;
import lld.decoratorpattern.decorator.*;
public class DecoratorPattern {

    public static void main(String[] args) {

        CharacterInterface mario = new Mario();
        System.out.println("Basic Character: " + mario.getAbilities());

        mario = new HeightUp(mario);
        System.out.println("After HeightUp: " + mario.getAbilities());

        mario = new GunPowerUp(mario);
        System.out.println("After GunPowerUp: " + mario.getAbilities());

        mario = new StarPowerUp(mario);
        System.out.println("After StarPowerUp: " + mario.getAbilities());

        mario = new GunPowerUp(mario);
        System.out.println("After GunPowerUp: " + mario.getAbilities());
//        CharacterDecorator characterDecorator = new Mario();
//        System.out.println("Basic Character: " + mario.getAbilities());


    }
}