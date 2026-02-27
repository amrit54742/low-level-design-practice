package lld.prototypepattern;

import lld.prototypepattern.prototype.NPC;

public class PrototypePattern {

    public static void main(String[] args) {

        NPC alien = new NPC("Alien", 30, 5, 2);

        NPC alienCopied1 = (NPC) alien.clone();
        alienCopied1.describe();

        NPC alienCopied2 = (NPC) alien.clone();
        alienCopied2.setName("Powerful Alien");
        alienCopied2.setHealth(50);
        alienCopied2.describe();

        alien = null;
        alienCopied1 = null;
        alienCopied2 = null;
    }
}