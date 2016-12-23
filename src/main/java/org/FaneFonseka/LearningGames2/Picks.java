package org.FaneFonseka.LearningGames2;

class Picks {
    private PrimitiveDataType firstPick;
    private PrimitiveDataType secondPick;

    Picks() {
    }

    private void setFirstPick(Picker randomPrimitivePicker) {

        this.firstPick = randomPrimitivePicker.pick();
    }

    PrimitiveDataType getFirstPick() {

        return this.firstPick;
    }

    private void setSecondPick(Picker randomPrimitivePicker) {

        PrimitiveDataType pick;

        do {
            pick = randomPrimitivePicker.pick();
        } while (pick.equals(firstPick));

        this.secondPick = pick;

    }

    PrimitiveDataType getSecondPick() {

        return secondPick;
    }

    void setPicks(Picker randomPrimitivePicker) {
        setFirstPick(randomPrimitivePicker);
        setSecondPick(randomPrimitivePicker);
    }

    boolean firstPickGreaterThanSecondPick() {

        System.out.println(getFirstPick().getMemorySizeInBits() > getSecondPick().getMemorySizeInBits());
        return getFirstPick().getMemorySizeInBits() > getSecondPick().getMemorySizeInBits();
    }

    boolean secondPickGreaterThanFirstPick() {

        System.out.println(getFirstPick().getMemorySizeInBits() < getSecondPick().getMemorySizeInBits());
        return getFirstPick().getMemorySizeInBits() < getSecondPick().getMemorySizeInBits();
    }

    boolean firstPickIsSameSizeAsSecondPick() {
        System.out.println(getFirstPick().getMemorySizeInBits() == getSecondPick().getMemorySizeInBits());
        return getFirstPick().getMemorySizeInBits() == getSecondPick().getMemorySizeInBits();
    }

}